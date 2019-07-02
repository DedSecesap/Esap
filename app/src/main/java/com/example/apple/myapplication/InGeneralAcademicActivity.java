package com.example.apple.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InGeneralAcademicActivity extends AppCompatActivity implements MechProfFragment.OnFragmentInteractionListener,
RecyclerViewFragment.OnFragmentInteractionListener,ComputerScienceProf.OnFragmentInteractionListener,SendLetterFragment.OnFragmentInteractionListener,
GradesFragment.OnFragmentInteractionListener,EventFragment.OnFragmentInteractionListener{

    private ViewPager viewPager;
    private SectionPageAdapter sectionPageAdapter;
    List<HolidayModel> holidayModels,finalModels=new ArrayList<>();
    HolidayAdapter holidayAdapter;
    RecyclerView holiday;
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
        textView.setVisibility(View.VISIBLE);
        TabLayout tabLayout =findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        String type=getIntent().getStringExtra("Type");
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(type.contains("rof")) {
            PagerStripFragment searchFragmentbce=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentbce.setName("profess");
            searchFragmentbce.setBranch("Biochemical");
            sectionPageAdapter.addFragment(searchFragmentbce,"Biochemical");
            textView.setText("Professors");
            PagerStripFragment searchFragmentbme=new PagerStripFragment();
            searchFragmentbme.setName("profess");
            searchFragmentbme.setBranch("Biomedical");

            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentbme, "Biomedical");


            PagerStripFragment searchFragmentcer=new PagerStripFragment();
            searchFragmentcer.setName("profess");
            searchFragmentcer.setBranch("Ceramics");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentcer,"Ceramics");
            PagerStripFragment searchFragmentche=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentche.setName("profess");
            searchFragmentche.setBranch("Chemical");
            sectionPageAdapter.addFragment(searchFragmentche,"Chemical");
            PagerStripFragment searchFragmentcse=new PagerStripFragment();
            searchFragmentcse.setName("profess");
            searchFragmentcse.setBranch("ComputerScience");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentcse, "Computer Science");


            PagerStripFragment searchFragmenteee=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmenteee.setName("profess");
            searchFragmenteee.setBranch("Electrical");
            sectionPageAdapter.addFragment(searchFragmenteee,"Electrical");
            PagerStripFragment searchFragmentece=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentece.setName("profess");
            searchFragmentece.setBranch("Electronics");
            sectionPageAdapter.addFragment(searchFragmentece,"Electronics");
            PagerStripFragment searchFragmentphy=new PagerStripFragment();
            searchFragmentphy.setName("profess");
            searchFragmentphy.setBranch("Physics");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentphy, "Physics");


            PagerStripFragment searchFragmentchy=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentchy.setName("profess");
            searchFragmentchy.setBranch("Industrial Chemistry");
            sectionPageAdapter.addFragment(searchFragmentchy,"Chemistry");
            PagerStripFragment searchFragmentins=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentins.setName("profess");
            searchFragmentins.setBranch("Humanistic Social Studies");
            sectionPageAdapter.addFragment(searchFragmentins,"Humanistic Social Studies");

            PagerStripFragment searchFragmentmst=new PagerStripFragment();
            searchFragmentmst.setName("profess");
            searchFragmentmst.setBranch("Material Sciences");

            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentmst, "Material Science");


            PagerStripFragment searchFragmentmnc=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentmnc.setName("profess");
            searchFragmentmnc.setBranch("Mathematics & Computing");
            sectionPageAdapter.addFragment(searchFragmentmnc,"Maths and Computing");
            PagerStripFragment searchFragmentmec=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentmec.setName("profess");
            searchFragmentmec.setBranch("Mechanical");
            sectionPageAdapter.addFragment(searchFragmentmec,"Mechanical");
            PagerStripFragment searchFragmentmet=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentmet.setName("profess");
            searchFragmentmet.setBranch("Metallurgy");
            sectionPageAdapter.addFragment(searchFragmentmet,"Metallurgy");

            PagerStripFragment searchFragmentmin=new PagerStripFragment();
            searchFragmentmin.setName("profess");
            searchFragmentmin.setBranch("Mining");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentmin, "Mining");


            PagerStripFragment searchFragmentphe=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentphe.setName("profess");
            searchFragmentphe.setBranch("Pharmaceutics");
            sectionPageAdapter.addFragment(searchFragmentphe,"Pharmaceutics");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.contains("ouncil")) {
            PagerStripFragment searchFragmentadmin=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentadmin.setName("Major Bodies");
            sectionPageAdapter.addFragment(searchFragmentadmin,"Major Bodies");
            textView.setText("Clubs");
            PagerStripFragment searchFragmentcult=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentcult.setName("Cultural Council");
            sectionPageAdapter.addFragment(searchFragmentcult, "Cultural Council");


//            PagerStripFragment searchFragmententre=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            searchFragmententre.setName("Entrepreneurship Cell");
//            sectionPageAdapter.addFragment(searchFragmententre,"E-Cell");
            PagerStripFragment searchFragmentfmc=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentfmc.setName("Film & Media Council");
            sectionPageAdapter.addFragment(searchFragmentfmc,"Film and Media Council");


            PagerStripFragment searchFragmentgnsc=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentgnsc.setName("General Sports Council");

            sectionPageAdapter.addFragment(searchFragmentgnsc,"Games and Sports Council");
            PagerStripFragment searchFragmentsntc=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentsntc.setName("Science & Technological Council");
            sectionPageAdapter.addFragment(searchFragmentsntc, "Science and Technology Council");

            PagerStripFragment searchFragmentssc=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentssc.setName("Social Service Council");
            sectionPageAdapter.addFragment(searchFragmentssc,"Social Service Council");

//            PagerStripFragment searchFragmentsaic=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            searchFragmentsaic.setName("Student Alumni Interaction Cell");
//            sectionPageAdapter.addFragment(searchFragmentsaic, "Student Alumni Interaction Cell");

//            PagerStripFragment searchFragmentsp=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            searchFragmentsp.setName("Student Parliament");
//            sectionPageAdapter.addFragment(searchFragmentsp,"Student Parliament");

//            PagerStripFragment searchFragmenttpc=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            searchFragmenttpc.setName("Training & Placement Cell");
//            sectionPageAdapter.addFragment(searchFragmenttpc,"Training and Placement Cell");
//
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().equals("courses")){
            PagerStripFragment searchFragmentbce=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentbce.setName("courses");
            searchFragmentbce.setBranch("Biochemical Engineering");
            sectionPageAdapter.addFragment(searchFragmentbce,"Biochemical");
            textView.setText("Courses");
            PagerStripFragment searchFragmentbme=new PagerStripFragment();
            searchFragmentbme.setName("courses");
            searchFragmentbme.setBranch("Biomedical Engineering");

            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentbme, "Biomedical");


            PagerStripFragment searchFragmentcer=new PagerStripFragment();
            searchFragmentcer.setName("courses");
            searchFragmentcer.setBranch("Ceramics");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentcer,"Ceramics");
            PagerStripFragment searchFragmentche=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentche.setName("courses");
            searchFragmentche.setBranch("Chemical Engineering");
            sectionPageAdapter.addFragment(searchFragmentche,"Chemical");
            PagerStripFragment searchFragmentcse=new PagerStripFragment();
            searchFragmentcse.setName("courses");
            searchFragmentcse.setBranch("Computer Science & Engineering");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentcse, "Computer Science");


            PagerStripFragment searchFragmenteee=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmenteee.setName("courses");
            searchFragmenteee.setBranch("Electrical");
            sectionPageAdapter.addFragment(searchFragmenteee,"Electrical");
            PagerStripFragment searchFragmentece=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentece.setName("courses");
            searchFragmentece.setBranch("Electronics Engineering");
            sectionPageAdapter.addFragment(searchFragmentece,"Electronics");
            PagerStripFragment searchFragmentphy=new PagerStripFragment();
            searchFragmentphy.setName("courses");
            searchFragmentphy.setBranch("Engineering Physics");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentphy, "Physics");


            PagerStripFragment searchFragmentchy=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentchy.setName("courses");
            searchFragmentchy.setBranch("Industrial Chemistry");
            sectionPageAdapter.addFragment(searchFragmentchy,"Chemistry");
            PagerStripFragment searchFragmentins=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentins.setName("courses");
            searchFragmentins.setBranch("Institute Courses");
            sectionPageAdapter.addFragment(searchFragmentins,"Institute Courses");

            PagerStripFragment searchFragmentmst=new PagerStripFragment();
            searchFragmentmst.setName("courses");
            searchFragmentmst.setBranch("Materials Science");

            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentmst, "Material Science");


            PagerStripFragment searchFragmentmnc=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentmnc.setName("courses");
            searchFragmentmnc.setBranch("Mathematics & Computing");
            sectionPageAdapter.addFragment(searchFragmentmnc,"Maths and Computing");
            PagerStripFragment searchFragmentmec=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentmec.setName("courses");
            searchFragmentmec.setBranch("Mechanical Engineering");
            sectionPageAdapter.addFragment(searchFragmentmec,"Mechanical");
            PagerStripFragment searchFragmentmet=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragmentmet.setName("courses");
            searchFragmentmet.setBranch("Metallurgy");
            sectionPageAdapter.addFragment(searchFragmentmet,"Metallurgy");

            PagerStripFragment searchFragmentmin=new PagerStripFragment();
            searchFragmentmin.setName("courses");
            searchFragmentmin.setBranch("Mining");
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentmin, "Mining");


            PagerStripFragment searchFragmentphe=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentphe.setName("courses");
            searchFragmentphe.setBranch("Pharmaceutical Engineering");
            sectionPageAdapter.addFragment(searchFragmentphe,"Pharmaceutics");
            viewPager.setAdapter(sectionPageAdapter);
        }

        else if(type.toLowerCase().contains("Pointer"))
        {
            textView.setText("Grades");
            GradesFragment gradesFragment =new GradesFragment();
            gradesFragment.setType("sp");
            sectionPageAdapter.addFragment(gradesFragment,"SPI Graph");
            GradesFragment gradesFragmentSP =new GradesFragment();
            gradesFragmentSP.setType("CP");
            sectionPageAdapter.addFragment(gradesFragmentSP,"CPI Graph");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().contains("Grades"))
        {
            textView.setText("Grades");
            RecyclerViewFragment gradesFragment1 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment1,"SEM 1");
            RecyclerViewFragment gradesFragment2 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment2,"SEM 2");

            RecyclerViewFragment gradesFragment3 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment3,"SEM 3");
            RecyclerViewFragment gradesFragment4 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment4,"SEM 4");
            RecyclerViewFragment gradesFragment5 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment5,"SEM 5");
            RecyclerViewFragment gradesFragment6 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment6,"SEM 6");
            RecyclerViewFragment gradesFragment7 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment7,"SEM 7");
            RecyclerViewFragment gradesFragment8 =new RecyclerViewFragment();
            sectionPageAdapter.addFragment(gradesFragment8,"SEM 8");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if(type.toLowerCase().contains("event")){
            textView.setText("Events");
            EventFragment searchFragmentspar=new EventFragment();
            //  searchFragmentAll.set(this);
            searchFragmentspar.setName("Spardha");
            searchFragmentspar.setCouncil("Councils");
            sectionPageAdapter.addFragment(searchFragmentspar,"Spardha");
            EventFragment searchFragmentKY=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentKY.setName("Kashiyatra");
            searchFragmentKY.setCouncil("Councils");
            sectionPageAdapter.addFragment(searchFragmentKY, "Kashiyatra");


            EventFragment searchFragmentTechnex=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentTechnex.setName("Technex");
            searchFragmentTechnex.setCouncil("Councils");
            sectionPageAdapter.addFragment(searchFragmentTechnex,"Technex");


            EventFragment searchFragmentFMC=new EventFragment();
            //  searchFragmentAll.set(this);
            searchFragmentFMC.setName("FMC Weekend");
            searchFragmentFMC.setCouncil("Councils");
            sectionPageAdapter.addFragment(searchFragmentFMC,"FMC Weekend");
            EventFragment searchFragmentAlum=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentAlum.setName("Alumni Meet");
            searchFragmentAlum.setCouncil("Cells");
            sectionPageAdapter.addFragment(searchFragmentAlum, "Alumni Meet");


            EventFragment searchFragmentHult=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentHult.setName("Hult Prize");
            searchFragmentHult.setCouncil("Cells");
            sectionPageAdapter.addFragment(searchFragmentHult,"Hult Prize");


            EventFragment searchFragmentsPlac1=new EventFragment();
            //  searchFragmentAll.set(this);
            searchFragmentsPlac1.setName("Placement Season");
            searchFragmentsPlac1.setCouncil("Cells");
            sectionPageAdapter.addFragment(searchFragmentsPlac1,"Placement Season");


            EventFragment searchFragmentPlac2=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentPlac2.setName("Placement Round Two");
            searchFragmentPlac2.setCouncil("Cells");
            sectionPageAdapter.addFragment(searchFragmentPlac2, "Placement Round 2");


            EventFragment searchFragmentPras=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentPras.setName("Prastuti");
            searchFragmentPras.setCouncil("Departments/Electrical Engineering");
            sectionPageAdapter.addFragment(searchFragmentPras,"Prastuti");

            EventFragment searchFragmentJigy=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentJigy.setName("Jigyasa");
            searchFragmentJigy.setCouncil("Departments/Engineering Physics");
            sectionPageAdapter.addFragment(searchFragmentJigy, "Jigyasa");


            EventFragment searchFragmentAnve=new EventFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentAnve.setName("Anveshan");
            searchFragmentAnve.setCouncil("Departments/Metallurgy");
            sectionPageAdapter.addFragment(searchFragmentAnve,"Anveshan");

            viewPager.setAdapter(sectionPageAdapter);

        }
        else if(type.toLowerCase().contains("holidays")) {
            textView.setText("Holidays");
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            holidayModels = new ArrayList<>();

            holiday = findViewById(R.id.holiday_table);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
            holiday.setLayoutManager(linearLayoutManager);

            holidayModels.add(new HolidayModel("Date", "Occasion"));
            holidayAdapter = new HolidayAdapter(holidayModels);
            holiday.setAdapter(holidayAdapter);
            DatabaseReference reference = database.getReference();
            reference.child("Holidays").child("Months").child("January").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);

                            }
                        }
                    }

                    for(int i=1;i<13;i++)
                    {
                        for(HolidayModel hm : holidayModels)
                        {
                            Log.e("TAG","Sort krne aaya apun");
                            if(hm.getDate().contains("/"))
                                if(Integer.parseInt(hm.getDate().substring(hm.getDate().indexOf('/')+1))==i)
                                    finalModels.add(hm);
                        }

                    }
                    finalModels.add(new HolidayModel("25/12","Christmas"));
                    holidayAdapter=new HolidayAdapter(finalModels);
                    holiday.setAdapter(holidayAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("February").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("March").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("April").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                Log.e("Fragment Data", obj.toString());
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("May").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;
                    finalModels.add(new HolidayModel("Date","Occasion"));
                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("June").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("July").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("August").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("September").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("October").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("November").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {

                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            reference.child("Holidays").child("Months").child("December").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    String date, occasion;

                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());

                            if (!obj.toString().contains("Holiday =No") || obj.toString().contains("Holiday=No")) {
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Date")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date"), obj.toString().indexOf(',', obj.toString().indexOf("Date"))));
                                    date = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Date") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Date")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Date")));
                                    date = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                if (obj.toString().indexOf(',', obj.toString().indexOf("Occasion")) != -1) {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion"), obj.toString().indexOf(',', obj.toString().indexOf("Occasion"))));
                                    occasion = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Occasion") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Occasion")));
                                } else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Occasion")));
                                    occasion = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                }
                                holidayModels.add(new HolidayModel(date, occasion));
                                holidayAdapter = new HolidayAdapter(holidayModels);
                                holiday.setAdapter(holidayAdapter);
                            }
                        }
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            findViewById(R.id.root_view).setVisibility(View.GONE);

            findViewById(R.id.holiday_table).setVisibility(View.VISIBLE);

        }

        else if(type.toLowerCase().contains("complaint"))
        {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"));
            startActivity(browserIntent);
//            Intent mailClient = new Intent(Intent.ACTION_VIEW);
//            mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
//            startActivity(mailClient);
//            SendLetterFragment sendLetterFragment=new SendLetterFragment();
//            //  searchFragmentAll.set(this);
//            sectionPageAdapter.addFragment(sendLetterFragment,"Compose");
//            textView.setText("Complaint Box");
//            PagerStripFragment searchFragmentPeople=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            sectionPageAdapter.addFragment(searchFragmentPeople, "My Complaints");
//
//
//
//            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("letter"))
        {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"));
            startActivity(browserIntent);
//            Intent mailClient = new Intent(Intent.ACTION_VIEW);
//            mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
//            startActivity(mailClient);
////            SendLetterFragment sendLetterFragment=new SendLetterFragment();
//            //  searchFragmentAll.set(this);
//            sectionPageAdapter.addFragment(sendLetterFragment,"Compose");
//            textView.setText("Letter Box");
//            PagerStripFragment searchFragmentPeople=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            sectionPageAdapter.addFragment(searchFragmentPeople, "Inbox");
//            PagerStripFragment searchFragmentRestaurant=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            sectionPageAdapter.addFragment(searchFragmentRestaurant, "Sent");
//            PagerStripFragment searchFragmenttreat=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            sectionPageAdapter.addFragment(searchFragmenttreat, "Draft");
//            PagerStripFragment searchFragmentpole=new PagerStripFragment();
//            //searchFragmentPeople.setResultInteraction(this);
//            sectionPageAdapter.addFragment(searchFragmentpole, "☆");
//            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("lost"))
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/forms/0VcSBapsiAU7sNbm1"));
            startActivity(browserIntent);
//            PagerStripFragment sendLetterFragment=new PagerStripFragment();
//            //  searchFragmentAll.set(this);
//            sectionPageAdapter.addFragment(sendLetterFragment,"LOST");
//            textView.setText("LOST and FOUND");
//            PagerStripFragment FoundLetter=new PagerStripFragment();
//            //  searchFragmentAll.set(this);
//            sectionPageAdapter.addFragment(FoundLetter,"FOUND");
//            viewPager.setAdapter(sectionPageAdapter);
//            findViewById(R.id.button_frame).setVisibility(View.VISIBLE);
//            findViewById(R.id.additem1).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    findViewById(R.id.add_item_frame).setVisibility(View.VISIBLE);
//                    findViewById(R.id.additem2).setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            findViewById(R.id.add_item_frame).setVisibility(View.GONE);
//                            findViewById(R.id.button_frame).setVisibility(View.VISIBLE);
//                        }
//                    });
//                    findViewById(R.id.button_frame).setVisibility(View.GONE);
//                }
//            });
        }
        else if (type.toLowerCase().contains("my students"))
        {
            PagerStripFragment sendLetterFragment=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            sectionPageAdapter.addFragment(sendLetterFragment,"V");
            textView.setText("My Students");
            PagerStripFragment searchFragmentPeople=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentPeople, "IV");
            PagerStripFragment searchFragmentRestaurant=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentRestaurant, "III");
            PagerStripFragment searchFragmenttreat=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmenttreat, "II");
            PagerStripFragment searchFragmentpole=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentpole, "I");
            PagerStripFragment searchFragmentphd=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentphd, "Ph.D.");

            PagerStripFragment searchFragmentMtech1=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentMtech1, "MTECH I");
            PagerStripFragment searchFragmentMtech2=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            sectionPageAdapter.addFragment(searchFragmentMtech2, "MTECH II");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("all students"))
        {
            PagerStripFragment searchFragment5=new PagerStripFragment();
            //  searchFragmentAll.set(this);
            searchFragment5.setName("branches");
            searchFragment5.setBranch("2014");
            sectionPageAdapter.addFragment(searchFragment5,"V");
            textView.setText("All Students");
            PagerStripFragment searchFragment4=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragment4.setName("branches");
            searchFragment4.setBranch("2015");
            sectionPageAdapter.addFragment(searchFragment4, "IV");
            PagerStripFragment searchFragment3=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragment3.setName("branches");
            searchFragment3.setBranch("2016");
            sectionPageAdapter.addFragment(searchFragment3, "III");
            PagerStripFragment searchFragment2=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragment2.setName("branches");
            searchFragment2.setBranch("2017");
            sectionPageAdapter.addFragment(searchFragment2, "II");
            PagerStripFragment searchFragment1=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragment1.setName("branches");
            searchFragment1.setBranch("2018");
            sectionPageAdapter.addFragment(searchFragment1, "I");
            PagerStripFragment searchFragmentphd=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentphd.setName("branches");
            searchFragmentphd.setBranch("PhD");
            sectionPageAdapter.addFragment(searchFragmentphd, "Ph.D.");

            PagerStripFragment searchFragmentMtech1=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentMtech1.setName("branches");
            searchFragmentMtech1.setBranch("MTech 2018");
            sectionPageAdapter.addFragment(searchFragmentMtech1, "MTECH I");
            PagerStripFragment searchFragmentMtech2=new PagerStripFragment();
            //searchFragmentPeople.setResultInteraction(this);
            searchFragmentMtech2.setName("branches");
            searchFragmentMtech2.setBranch("MTech 2017");
            sectionPageAdapter.addFragment(searchFragmentMtech2, "MTECH II");
            viewPager.setAdapter(sectionPageAdapter);
        }
        else if (type.toLowerCase().contains("my courses"))
        {
            PagerStripFragment sendLetterFragment=new PagerStripFragment();
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
