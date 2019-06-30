package com.example.apple.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlannerActivity extends AppCompatActivity implements RecyclerViewFragment.OnFragmentInteractionListener  {
    private ViewPager viewPager;
    private SectionPageAdapter sectionPageAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);
        ActionBar actionBar = getSupportActionBar();
        sectionPageAdapter=new SectionPageAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.viewpager_on_click);
        TextView textView=findViewById(R.id.title);
        textView.setText("Planner");
        TabLayout tabLayout =findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RecyclerViewFragment searchFragmentmon=new RecyclerViewFragment();
        //  searchFragmentAll.set(this);
        Bundle args = new Bundle();
        args.putString("name","Monday");
        searchFragmentmon.setArguments(args);
        sectionPageAdapter.addFragment(searchFragmentmon,"Monday");
        RecyclerViewFragment searchFragmenttue=new RecyclerViewFragment();
        args = new Bundle();
        args.putString("name","Tuesday");
        searchFragmenttue.setArguments(args);
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmenttue,"Tuesday");
        RecyclerViewFragment searchFragmentwed=new RecyclerViewFragment();
        args = new Bundle();
        args.putString("name","Wednesday");
        searchFragmentwed.setArguments(args);
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmentwed,"Wednesday");
        RecyclerViewFragment searchFragmentthu=new RecyclerViewFragment();
        args = new Bundle();
        args.putString("name","Thursday");
        searchFragmentthu.setArguments(args);
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmentthu,"Thursday");
        RecyclerViewFragment searchFragmentfri=new RecyclerViewFragment();
        args = new Bundle();
        args.putString("name","Friday");
        searchFragmentfri.setArguments(args);
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmentfri,"Friday");
        RecyclerViewFragment searchFragmentsat=new RecyclerViewFragment();
        args = new Bundle();
        args.putString("name","Saturday");
        searchFragmentsat.setArguments(args);
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmentsat,"Saturday");
        RecyclerViewFragment searchFragmentsun=new RecyclerViewFragment();
        args = new Bundle();
        args.putString("name","Sunday");
        searchFragmentsun.setArguments(args);
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmentsun,"Sunday");


        findViewById(R.id.pager_title_strip).setVisibility(View.GONE);
        viewPager.setAdapter(sectionPageAdapter);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.add_event_frame).setVisibility(View.VISIBLE);

                fab.hide();
                findViewById(R.id.add_event_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        findViewById(R.id.add_event_frame).setVisibility(View.GONE);
                        fab.show();
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        if(findViewById(R.id.add_event_frame).getVisibility()==View.VISIBLE)
        {
            findViewById(R.id.add_event_frame).setVisibility(View.GONE);
            fab.show();
        }
        else
        {
            finish();


        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static class SectionPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList=new ArrayList<>();
        private final List<String> mFragmentTitleList=new ArrayList<>();

        public void addFragment(Fragment fragment,String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}
