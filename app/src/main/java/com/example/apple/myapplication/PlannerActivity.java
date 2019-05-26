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
        PagerStripFragment searchFragmentmon=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentmon.setName("jan");
        sectionPageAdapter.addFragment(searchFragmentmon,"January");
        PagerStripFragment searchFragmenttue=new PagerStripFragment();
        searchFragmenttue.setName("feb");
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmenttue,"February");
        PagerStripFragment searchFragmentwed=new PagerStripFragment();
        searchFragmentwed.setName("mar");
        //  searchFragmentAll.set(this);
        sectionPageAdapter.addFragment(searchFragmentwed,"March");
        PagerStripFragment searchFragmentthu=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentthu.setName("apr");
        sectionPageAdapter.addFragment(searchFragmentthu,"April");
        PagerStripFragment searchFragmentfri=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentfri.setName("may");
        sectionPageAdapter.addFragment(searchFragmentfri,"May");
        PagerStripFragment searchFragmentsat=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentsat.setName("jun");
        sectionPageAdapter.addFragment(searchFragmentsat,"June");
        PagerStripFragment searchFragmentsun=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentsun.setName("july");
        sectionPageAdapter.addFragment(searchFragmentsun,"July");

        PagerStripFragment searchFragmentaug=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentaug.setName("aug");
        sectionPageAdapter.addFragment(searchFragmentaug,"August");
        PagerStripFragment searchFragmentsep=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentsep.setName("sep");
        sectionPageAdapter.addFragment(searchFragmentsep,"Sept");
        PagerStripFragment searchFragmentoct=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentoct.setName("oct");
        sectionPageAdapter.addFragment(searchFragmentoct,"October");
        PagerStripFragment searchFragmentnov=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentnov.setName("nov");
        sectionPageAdapter.addFragment(searchFragmentnov,"November");
        PagerStripFragment searchFragmentdec=new PagerStripFragment();
        //  searchFragmentAll.set(this);
        searchFragmentdec.setName("dec");
        sectionPageAdapter.addFragment(searchFragmentdec,"December");
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
