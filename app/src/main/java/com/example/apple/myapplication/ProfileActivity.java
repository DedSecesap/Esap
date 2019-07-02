package com.example.apple.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.auth.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements UserDataFragment.OnFragmentInteractionListener {
    RecyclerView typeRecyclerView;
    ClubGridAdapter adapter;
    String name,rollno,data,dummy,dummy2,other,Branch;
    String[] achivements,researches,club,council,designation;
    List<ResponsibilityModel> achievements,projects;
    List<ClubGridModel> clubs=new ArrayList<>();
    ResponsibilityAdapter achievementsAdapter,researchAdapter;
    ImageView researchButton,contactButton,workExButton,NewsFeedButtton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        achievements=new ArrayList<>();
        projects=new ArrayList<>();
        Intent intent=getIntent();
        data=intent.getStringExtra("data");
        Log.e("Profieeeeee",data);
        name=intent.getStringExtra("name");
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView Name,rollo,branch;
        Name=findViewById(R.id.NameText);
        rollo=findViewById(R.id.RollText);
        branch=findViewById(R.id.Branchtext);
        researchButton=findViewById(R.id.research_button);
        contactButton=findViewById(R.id.contact_button);
        workExButton=findViewById(R.id.workex_button);
        NewsFeedButtton=findViewById(R.id.newsfeedButton);

        researchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchButton.setImageDrawable(getDrawable(R.drawable.active_research_button));
                NewsFeedButtton.setImageDrawable(getDrawable(R.drawable.dormant_newsfeed_button));
                contactButton.setImageDrawable(getDrawable(R.drawable.dormant_contact_button));
                workExButton.setImageDrawable(getDrawable(R.drawable.dormant_workex_button));
                UserDataFragment userDataFragment=new UserDataFragment();
                Bundle args=new Bundle();
                args.putString("Type","Research");
                args.putString("Data",data);
                userDataFragment.setArguments(args);
                findViewById(R.id.dataframe).setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.dataframe,userDataFragment)
                        .commit();
            }
        });
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchButton.setImageDrawable(getDrawable(R.drawable.dormant_research_button));
                NewsFeedButtton.setImageDrawable(getDrawable(R.drawable.dormant_newsfeed_button));
                contactButton.setImageDrawable(getDrawable(R.drawable.active_contact_button));
                workExButton.setImageDrawable(getDrawable(R.drawable.dormant_workex_button));
                UserDataFragment userDataFragment=new UserDataFragment();
                Bundle args=new Bundle();
                args.putString("Type","Contact");
                args.putString("Data",data);
                userDataFragment.setArguments(args);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.dataframe,userDataFragment)
                        .commit();
            }
        });
        workExButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchButton.setImageDrawable(getDrawable(R.drawable.dormant_research_button));
                NewsFeedButtton.setImageDrawable(getDrawable(R.drawable.dormant_newsfeed_button));
                contactButton.setImageDrawable(getDrawable(R.drawable.dormant_contact_button));
                workExButton.setImageDrawable(getDrawable(R.drawable.active_workex_button));
                UserDataFragment userDataFragment=new UserDataFragment();
                Bundle args=new Bundle();
                args.putString("Type","WorkEx");
                args.putString("Data",data);
                userDataFragment.setArguments(args);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.dataframe,userDataFragment)
                        .commit();
            }
        });
        NewsFeedButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                researchButton.setImageDrawable(getDrawable(R.drawable.dormant_research_button));
                NewsFeedButtton.setImageDrawable(getDrawable(R.drawable.active_newsfeed_button));
                contactButton.setImageDrawable(getDrawable(R.drawable.dormant_contact_button));
                workExButton.setImageDrawable(getDrawable(R.drawable.dormant_workex_button));
                UserDataFragment userDataFragment=new UserDataFragment();
                Bundle args=new Bundle();
                args.putString("Type","NewsFeed");
                args.putString("Data",data);
                userDataFragment.setArguments(args);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.dataframe,userDataFragment)
                        .commit();
            }
        });



        if(data.indexOf('=',data.lastIndexOf("RollNo")+2)!=-1)
        {
            rollno=data.substring(data.indexOf('=',data.lastIndexOf("RollNo"))+1,data.indexOf(",",data.lastIndexOf("RollNo")));
        }
        else
        {
            rollno=data.substring(data.indexOf('=',data.lastIndexOf("RollNo"))+1,data.indexOf('}'));
        }
        if(data.indexOf('=',data.lastIndexOf("Branch")+2)!=-1)
        {
            Branch=data.substring(data.indexOf('=',data.lastIndexOf("Branch"))+1,data.indexOf(",",data.lastIndexOf("Branch")));
        }
        else
        {
            Branch=data.substring(data.indexOf('=',data.lastIndexOf("Branch"))+1,data.indexOf('}'));
        }

        if(data.indexOf('=',data.lastIndexOf("Myclubs")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Myclubs"))+1);
            dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
           other =dummy2.substring(0,dummy2.lastIndexOf(","));
           club=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Myclubs"))+1,data.indexOf('}'));
            other=dummy.concat(",");
            club=other.split(",");
        }
        if(data.indexOf('=',data.lastIndexOf("Councils")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Councils"))+1);
            dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
            other =dummy2.substring(0,dummy2.lastIndexOf(","));
            council=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Councils"))+1,data.indexOf('}'));
            other=dummy.concat(",");
            council=other.split(",");
        }
        if(data.indexOf('=',data.lastIndexOf("Designation")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Designation"))+1);
            dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
            other =dummy2.substring(0,dummy2.lastIndexOf(","));
            designation=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Designation"))+1,data.indexOf('}'));
            other=dummy.concat(",");
            designation=other.split(",");
        }



        if(data.indexOf('=',data.lastIndexOf("Achievements")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Achievements"))+1);
            String dummy2=dummy.substring(0,dummy.indexOf('='));
//                    data.indexOf("=",data.lastIndexOf("curricular")+4)-1);
            other=dummy2.substring(0,dummy2.lastIndexOf(",")+1);
            achivements=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Achievements"))+1,data.indexOf('}'));
            other=dummy.concat(",");
            achivements=other.split(",");
        }
        if(data.indexOf('=',data.lastIndexOf("Research=")+1)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research="))+1);
            String dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf("=",data.lastIndexOf("OfInterest")+4)-1);
            other=dummy2.substring(0,dummy2.lastIndexOf(",")+1);
            researches=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research="))+1,data.indexOf('}'));
            other=dummy.concat(",");
            researches=other.split(",");
        }

        Name.setText(name);
        rollo.setText(rollno);
        branch.setText(Branch);
      for(String s: researches)
      {
          projects.add(new ResponsibilityModel(s));
      }
        for(String s: achivements)
        {
            achievements.add(new ResponsibilityModel(s));
        }
        for(String s: club)
        {
            clubs.add(new ClubGridModel("",s));
        }
        for(String s: council)
        {
            clubs.add(new ClubGridModel("",s));
        }
        for(String s: designation)
        {
            clubs.add(new ClubGridModel("",s));
        }

        typeRecyclerView = (RecyclerView) findViewById(R.id.club_recy);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        typeRecyclerView.setLayoutManager(layoutManager);



        // specify an adapter (see also next example)
        adapter = new ClubGridAdapter(clubs);
        typeRecyclerView.setAdapter(adapter);







    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
