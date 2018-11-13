package com.example.apple.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity {

    Button btn_login;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private EditText username1;
    private EditText pasword1;
    private TextView mValueVeiw;

    private Firebase mRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        username1 = (EditText)findViewById(R.id.Email);
        pasword1 = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        mRef = new Firebase("https://first-app-38588.firebaseio.com/");
        btn_login = (Button) findViewById(R.id.btn_login);


        mAuthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){

                    Intent i=new Intent(MainActivity.this,Authh.class);
                    i.putExtra("name",firebaseAuth.getCurrentUser().getDisplayName());

                    startActivity(i);

                }
            }
        };

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startsignin();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

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
}
