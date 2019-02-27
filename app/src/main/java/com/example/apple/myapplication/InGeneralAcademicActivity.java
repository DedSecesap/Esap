package com.example.apple.myapplication;

import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InGeneralAcademicActivity extends AppCompatActivity implements MechProfFragment.OnFragmentInteractionListener,
ElectricProfFragment.OnFragmentInteractionListener,ComputerScienceProf.OnFragmentInteractionListener,SendLetterFragment.OnFragmentInteractionListener,
EventsFragment.OnFragmentInteractionListener{

    private ViewPager viewPager;
    private SectionPageAdapter sectionPageAdapter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_general_academic);
        imageView=findViewById(R.id.imageview_In_general);
        findViewById(R.id.month_text).setVisibility(View.GONE);
        findViewById(R.id.button_frame).setVisibility(View.GONE);
        findViewById(R.id.add_item_frame).setVisibility(View.GONE);
        sectionPageAdapter=new SectionPageAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.viewpager_on_click);

        ActionBar actionBar = getSupportActionBar();
        TextView textView=findViewById(R.id.title);
        TabLayout tabLayout =findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        String type=getIntent().getStringExtra("Type");
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(type.toLowerCase().contains("rofs")) {
            MechProfFragment searchFragmentAll=new MechProfFragment();
          //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(searchFragmentAll,"Mechanical");
            textView.setText("Professors");
            MechProfFragment searchFragmentPeople=new MechProfFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "Electrical");


            MechProfFragment searchFragmentRestaurant=new MechProfFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant,"Computer Science");
        viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().contains("clubs")) {
            ProfileFragment searchFragmentAll=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(searchFragmentAll,"Cultural Council");
            textView.setText("Clubs");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "Sports Council");


            ProfileFragment searchFragmentRestaurant=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant,"Technical Council");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().equals("courses")){
            ProfileFragment searchFragmentAll=new ProfileFragment();
            //  searchFragmentAll.set(this);
            searchFragmentAll.setName("courses");
            sectionPageAdapter.addFragment(searchFragmentAll,"Mechanical");
            textView.setText("Courses");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            searchFragmentPeople.setName("courses");

            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "Electrical");


            ProfileFragment searchFragmentRestaurant=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant,"Computer Science");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().contains("labs")){
            ProfileFragment searchFragmentAll=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(searchFragmentAll,"Mechanical");
            textView.setText("Labs");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "Electrical");


            ProfileFragment searchFragmentRestaurant=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant,"Computer Science");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().contains("grades"))
        {
            textView.setText("Grades");
            Log.e("Academic","EventsFragment bnwaya");
            EventsFragment eventsFragment=new EventsFragment();
            eventsFragment.setType("sp");
            sectionPageAdapter.addFragment(eventsFragment,"SPI Graph");
            EventsFragment eventsFragmentSP=new EventsFragment();
            eventsFragmentSP.setType("CP");
            sectionPageAdapter.addFragment(eventsFragmentSP,"CPI Graph");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().contains("fests")){
            textView.setText("Fests");
            ProfileFragment searchFragmentAll=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(searchFragmentAll,"Spardha");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "Kashiyatra");


            ProfileFragment searchFragmentRestaurant=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant,"Technex");

            viewPager.setAdapter(sectionPageAdapter);

        }
        else if(type.toLowerCase().contains("holidays"))
        {
            textView.setText("Holidays");
            findViewById(R.id.root_view).setVisibility(View.GONE);
            findViewById(R.id.holiday_table).setVisibility(View.VISIBLE);

        }
        else if(type.toLowerCase().contains("events"))
        {
            textView.setText("Events");
            findViewById(R.id.root_view).setVisibility(View.GONE);
            findViewById(R.id.month_text).setVisibility(View.VISIBLE);
            TextView textView1 =findViewById(R.id.month_text);
            textView1.setText("This Month");
            textView1.setTextColor(Color.parseColor("#ab1014"));
        }
        else if(type.toLowerCase().contains("complaint"))
        {
            SendLetterFragment sendLetterFragment=new SendLetterFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(sendLetterFragment,"Compose");
            textView.setText("Complaint Box");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "My Complaints");



            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("letter"))
        {
            SendLetterFragment sendLetterFragment=new SendLetterFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(sendLetterFragment,"Compose");
            textView.setText("Letter Box");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "Inbox");
            ProfileFragment searchFragmentRestaurant=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant, "Sent");
            ProfileFragment searchFragmenttreat=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmenttreat, "Draft");
            ProfileFragment searchFragmentpole=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentpole, "☆");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("lost"))
        {
            ProfileFragment sendLetterFragment=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(sendLetterFragment,"LOST");
            textView.setText("LOST and FOUND");
            ProfileFragment FoundLetter=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(FoundLetter,"FOUND");
            viewPager.setAdapter(sectionPageAdapter);
            findViewById(R.id.button_frame).setVisibility(View.VISIBLE);
            findViewById(R.id.additem1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.add_item_frame).setVisibility(View.VISIBLE);
                    findViewById(R.id.additem2).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            findViewById(R.id.add_item_frame).setVisibility(View.GONE);
                            findViewById(R.id.button_frame).setVisibility(View.VISIBLE);
                        }
                    });
                    findViewById(R.id.button_frame).setVisibility(View.GONE);
                }
            });
        }
        else if (type.toLowerCase().contains("my students"))
        {
            ProfileFragment sendLetterFragment=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(sendLetterFragment,"V");
            textView.setText("My Students");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "IV");
            ProfileFragment searchFragmentRestaurant=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant, "III");
            ProfileFragment searchFragmenttreat=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmenttreat, "II");
            ProfileFragment searchFragmentpole=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentpole, "I");
            ProfileFragment searchFragmentphd=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentphd, "Ph.D.");

            ProfileFragment searchFragmentMtech1=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentMtech1, "MTECH I");
            ProfileFragment searchFragmentMtech2=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentMtech2, "MTECH II");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("all students"))
        {
            ProfileFragment sendLetterFragment=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sendLetterFragment.setName("branches");
            sectionPageAdapter.addFragment(sendLetterFragment,"V");
            textView.setText("All Students");
            ProfileFragment searchFragmentPeople=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentPeople.setName("branches");
            sectionPageAdapter.addFragment(searchFragmentPeople, "IV");
            ProfileFragment searchFragmentRestaurant=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentRestaurant.setName("branches");
            sectionPageAdapter.addFragment(searchFragmentRestaurant, "III");
            ProfileFragment searchFragmenttreat=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmenttreat.setName("branches");
            sectionPageAdapter.addFragment(searchFragmenttreat, "II");
            ProfileFragment searchFragmentpole=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentpole.setName("branches");
            sectionPageAdapter.addFragment(searchFragmentpole, "I");
            ProfileFragment searchFragmentphd=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentphd.setName("branches");
            sectionPageAdapter.addFragment(searchFragmentphd, "Ph.D.");

            ProfileFragment searchFragmentMtech1=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentMtech1.setName("branches");
            sectionPageAdapter.addFragment(searchFragmentMtech1, "MTECH I");
            ProfileFragment searchFragmentMtech2=new ProfileFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentMtech2.setName("branches");
            sectionPageAdapter.addFragment(searchFragmentMtech2, "MTECH II");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("my courses"))
        {
            ProfileFragment sendLetterFragment=new ProfileFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(sendLetterFragment,"Current Courses");
            textView.setText("My Courses");
            viewPager.setAdapter(sectionPageAdapter);
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

    @Override
    public void onBackPressed()
    {
        if(findViewById(R.id.add_item_frame).getVisibility()==View.VISIBLE)
        {
            findViewById(R.id.add_item_frame).setVisibility(View.GONE);
            findViewById(R.id.button_frame).setVisibility(View.VISIBLE);
        }
        else {
            finish();
        }
    }
}
