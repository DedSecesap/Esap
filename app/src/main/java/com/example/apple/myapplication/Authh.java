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
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Authh extends AppCompatActivity  implements EventsFragment.OnFragmentInteractionListener,
        MyplanerFragment.EventClickListener

{
    FrameLayout mMainFrame;
    BottomNavigationView mMainNav;
    MyplanerFragment mMPF;
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

        mMPF=new MyplanerFragment();
        mMPF.setEventClickListener(this);

        mPF = new ProfileFragment();
        mEvF=new EventsFragment();

        setFragment(mEvF);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.b_events:
                        setFragment(mEvF);
                        return true;
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

                    case R.id.more:
                        PopupMenu popup = new PopupMenu(Authh.this, findViewById(R.id.more));
                        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                Toast.makeText(Authh.this, "You clicked :" + item.getTitle(), Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        });
                        popup.show();
                        break;



                    default:
                        return false;

                }
                return false;
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
        if(findViewById(R.id.event_container).getVisibility()==View.VISIBLE)
        {
            findViewById(R.id.event_container).setVisibility(View.GONE);
        }
        else
            
        moveTaskToBack(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void EventClicked() {
       getSupportFragmentManager().beginTransaction()
               .replace(R.id.event_container,new EventClickedFragment())
               .commit();
       findViewById(R.id.event_container).setVisibility(View.VISIBLE);
    }
}
