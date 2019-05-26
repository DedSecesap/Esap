package com.example.apple.myapplication;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PagerStripFragment extends Fragment implements RecyclerViewFragment.OnFragmentInteractionListener {
    String  name="";
    String branch="";
    TextView textView;
    RecyclerView dailyRecy;
    TextView textView2;
    ClubAdapter academicActivityAdaptor;
    TextView textView3;
    List<ClubModel> academicActivityModels=new ArrayList<>();
    List<AcademicActivityModel> details=new ArrayList<>();
    Button edit;
    TextView textView4;
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;


    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public PagerStripFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment'

        View view;


        // textView=(TextView) this.getView().findViewById(R.id.textView34);

        view=inflater.inflate(R.layout.fragment_profile, container, false);
        dailyRecy = view.findViewById(R.id.item_recy_profile);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        dailyRecy.setLayoutManager(llm);
        Log.e("view","Haan maine view bnaya");
        mCustomPagerAdapter = new CustomPagerAdapter(getChildFragmentManager(), getContext());
        if(name.contains("Counc")||name.contains("Bodies"))
        {

            Log.e("Kya koi","Idhar aaya tha?");
            FirebaseDatabase database=FirebaseDatabase.getInstance();

            DatabaseReference databaseReference=database.getReference();
            if(name.contains("Bodies"))
            {
                academicActivityModels.add(new ClubModel("Cultural Council",""));
                academicActivityModels.add(new ClubModel("Film and Media Council",""));
                academicActivityModels.add(new ClubModel("Games and Sports Council",""));
                academicActivityModels.add(new ClubModel("Science and Tech Council",""));
                academicActivityModels.add(new ClubModel("Social Service Council",""));
                academicActivityModels.add(new ClubModel("SOChem","Departmental Bodies/Chemical"));
                academicActivityModels.add(new ClubModel("MetSoc","Departmental Bodies/Metallurgy"));
                academicActivityModels.add(new ClubModel("Entrepreneurship Cell",""));
                academicActivityModels.add(new ClubModel("Student Alumni Interaction Cell",""));
                academicActivityModels.add(new ClubModel("Student Parliament",""));
                academicActivityModels.add(new ClubModel("Training and Placement Cell",""));
                academicActivityAdaptor=new ClubAdapter(academicActivityModels,getActivity());
                ;
                dailyRecy.setAdapter(academicActivityAdaptor);

            }
            else {
                databaseReference.child("Student Bodies").child(name).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            String post = postSnapshot.getKey();
                            if(post.contains("Desc")||post.contains("Sec")||post.contains("Log")||post.contains("Panel")||post.contains("Strength"))
                            {}
                            else
                            {
                                Log.e("Tagg", "onDataChange: ");
                                academicActivityModels.add(new ClubModel(post,name));
                            }
                            Log.e("Get Data", post);
                        }
                        academicActivityAdaptor=new ClubAdapter(academicActivityModels,getActivity());

                        dailyRecy.setAdapter(academicActivityAdaptor);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }

        }
        else if(name.contains("profess"))
        {
            TabLayout tabLayout = view.findViewById(R.id.tabs);
            mViewPager = (ViewPager) view.findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            tabLayout.setupWithViewPager(mViewPager);


        }
        else if(!name.contains("Council")||name.contains("Bodies")||name.contains("courses")||name.contains("branches")||name.contains("jan")||name.contains("feb")||name.contains("mar")||name.contains("apr")||name.contains("may")||name.contains("jun")||name.contains("jul")||name.contains("aug")||name.contains("sep")||name.contains("oct")||name.contains("nov")||name.contains("dec")) {

            TabLayout tabLayout = view.findViewById(R.id.tabs);
            mViewPager = (ViewPager) view.findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            tabLayout.setupWithViewPager(mViewPager);
            Log.e("Mai idhar hun","First if"+name);
        }
        else if( name.contains("courses"))
        {
            TabLayout tabLayout = view.findViewById(R.id.tabs);
            mViewPager = (ViewPager) view.findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            tabLayout.setupWithViewPager(mViewPager);
            FirebaseDatabase database=FirebaseDatabase.getInstance();
            DatabaseReference databaseReference=database.getReference();

//            databaseReference.child("Courses").child("Branches").child(name).child("Year2").addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {};
//                    Map<String, Object> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                    ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
//                    for(Object obj: objectArrayList){
//                        Log.e("Fragment Data",obj.toString().substring(obj.toString().indexOf("Code"),obj.toString().indexOf(',',obj.toString().indexOf("Code"))));
//                    }
//                }
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
        }


        return view;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class CustomPagerAdapter extends FragmentPagerAdapter {

        Context mContext;

        public CustomPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {

            // Create fragment object
            Fragment fragment = new RecyclerViewFragment();

            // Attach some data to the fragment
            // that we'll use to populate our fragment layouts
            Bundle args = new Bundle();
            args.putInt("page_position", position + 1);
            args.putString("name",name);
            args.putString("branch",branch);

            // Set the arguments on the fragment
            // that will be fetched in the
            // DemoFragment@onCreateView
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {
            if (name.equals("jan") || name.equals("mar") || name.equals("may") || name.equals("july") || name.equals("aug") || name.equals("oct") || name.equals("dec"))
                return 31;
            else if (name.equals("apr") || name.equals("jun") || name.equals("sep") || name.equals("nov"))
                return 30;
            else if (name.equals("feb"))
                return 28;
            else if (name.contains("courses")) {
                return 7;
            } else if (name.contains("branches")) {
                return 15;
            }
            else if(name.contains("profess")){
                return 3;
            }
            else return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(name.contains("courses"))
            {
                if(position<5)
                {
                    return String.valueOf("Year "+(position+1));
                }
//                else if(position<10)
//                {
//                    return String.valueOf("IDD Sem " +( position+1));
//                }
                else
                {
                    return String.valueOf("M.Tech Year "+ (position-4));
                }
            }
            else if(name.contains("branches"))
            {
                switch (position)
                {
                    case 0:
                        return "Biochemical";
                    case 1:
                        return "Biomedical";
                    case 2:
                        return "Ceramics";
                    case 3:
                        return "Chemical";
                    case 4:
                        return "Computer Science";
                    case 5:
                        return "Electrical";
                    case 6:
                        return "Electronics";
                    case 7:
                        return "Physics";
                    case 8:
                        return "Chemistry";
                    case 9:
                        return "Material Science";
                    case 10:
                        return "Maths and Computing";
                    case 11:
                        return "Mechanical";
                    case 12:
                        return "Metallurgy";
                    case 13:
                        return "Mining";
                    case 14:
                        return "Pharmaceutics";

                }
            }
            else if(name.contains("profess"))
            {
                switch (position)
                {
                    case 0:
                        return "Professors";
                    case 1:
                        return "Assistant Professors";
                    case 2:
                        return "Associate Professors";

                }
            }
            return  String.valueOf(position + 1);
        }
    }

}
