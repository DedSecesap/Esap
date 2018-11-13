package com.example.apple.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Authh extends AppCompatActivity  implements EventsFragment.OnFragmentInteractionListener

{
    FrameLayout mMainFrame;
    BottomNavigationView mMainNav;
    Fragment mMPF;
    Fragment mPF;
    Fragment mEvF;
    TextView textView;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authh);
        Intent i=getIntent();
        name=i.getStringExtra("name");
        TextView textView=(TextView)findViewById(R.id.txt);



        mMainFrame = (FrameLayout) findViewById(R.id.mainframe);

        mMainNav = (BottomNavigationView) findViewById(R.id.bot_nav);

        mMPF = new MyplanerFragment();

        mPF = new ProfileFragment();
        mEvF=new EventsFragment();

        setFragment(mEvF);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.b_events:
                        setFragment(mEvF);
                    case R.id.b_mp :
                        setFragment (mMPF);
                        return true;

                    case R.id.b_pf :
                        Fragment fragment=new ProfileFragment();
                        Bundle bundle=new Bundle();
                        bundle.putString("name",name);
                        fragment.setArguments(bundle);
                        setFragment(fragment);
                        return true;

                    default:
                        return false;

                }

            }


        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager() .beginTransaction();


        fragmentTransaction.replace(R.id.mainframe, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed()
    {
        moveTaskToBack(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
