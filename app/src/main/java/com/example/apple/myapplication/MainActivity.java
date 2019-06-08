package com.example.apple.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity  {

    private static final int RC_SIGN_IN =100 ;
    Button btn_login;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private EditText username1;
    private EditText pasword1;
    private TextView mValueVeiw;
    GoogleSignInClient mGoogleSignInClient;
    private Firebase mRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();



        username1 = (EditText)findViewById(R.id.Email);
        pasword1 = (EditText) findViewById(R.id.password);
        mRef = new Firebase("https://first-app-38588.firebaseio.com/");
        btn_login = (Button) findViewById(R.id.btn_login);
//        Intent i=new Intent(MainActivity.this,Authh.class);
//        startActivity(i);
        mAuth=FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this, gso);

        mAuthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){

                    Intent i=new Intent(MainActivity.this,OpeningActivity.class);
                    i.putExtra("name",firebaseAuth.getCurrentUser().getDisplayName());
//                    if(firebaseAuth.getCurrentUser().getEmail().contains("itbhu")){
                    startActivity(i);
//                    else {
//                        Toast.makeText(getApplicationContext(),"Login Through iitbhu id", Toast.LENGTH_SHORT).show();
//                        mAuth.signOut();
//                    }



                }
            }
        };

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startsignin();

            }
        });
        findViewById(R.id.login_with_google).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);
                // ...
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        mAuth.addAuthStateListener(mAuthlistener);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.bot_nav) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startsignin() {

        String username = username1.getText().toString();
        String password = pasword1.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {

            Toast.makeText(MainActivity.this, "Feilds are Empty", Toast.LENGTH_LONG).show();

        } else {


            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        Toast.makeText(MainActivity.this, "Signed In", Toast.LENGTH_LONG).show();

                    } else {

                        Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }

    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("TAG", "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i=new Intent(MainActivity.this,OpeningActivity.class);

//                            if(user.getEmail().contains("itbhu")) {
                            i.putExtra("name", user.getDisplayName());
                            startActivity(i);
//                            }
//                            else {
//                                Toast.makeText(getApplicationContext(),"Login Through iitbhu id", Toast.LENGTH_SHORT).show();
//
//                                mAuth.signOut();
//                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.login_with_google), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

}
