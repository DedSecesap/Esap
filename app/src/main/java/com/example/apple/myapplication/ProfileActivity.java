package com.example.apple.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    RecyclerView typeRecyclerView;
    ClubGridAdapter adapter;
    String name,rollno,data,dummy,dummy2,other;
    String[] achivements,researches,club;
    List<ResponsibilityModel> achievements,projects;
    List<ClubGridModel> clubs=new ArrayList<>();
    ResponsibilityAdapter achievementsAdapter,researchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        achievements=new ArrayList<>();
        projects=new ArrayList<>();
        Intent intent=getIntent();
        data=intent.getStringExtra("data");
        name=intent.getStringExtra("name");
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView Name,rollo;
        Name=findViewById(R.id.textView2);
        rollo=findViewById(R.id.textView);
        if(data.indexOf('=',data.lastIndexOf("RollNo")+2)!=-1)
        {
            rollno=data.substring(data.indexOf('=',data.lastIndexOf("RollNo"))+1,data.indexOf(",",data.lastIndexOf("RollNo")));
        }
        else
        {
            rollno=data.substring(data.indexOf('=',data.lastIndexOf("RollNo"))+1,data.indexOf('}'));
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


        RecyclerView achievmentss,projectss;
      achievmentss=findViewById(R.id.achievements_list);
      LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
      achievmentss.setLayoutManager(llm);
        achievementsAdapter=new ResponsibilityAdapter(achievements);
        achievmentss.setAdapter(achievementsAdapter);




        projectss=findViewById(R.id.involvemts_list);
        LinearLayoutManager llm2=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        projectss.setLayoutManager(llm2);
        researchAdapter=new ResponsibilityAdapter(projects);
        projectss.setAdapter(researchAdapter);

        typeRecyclerView = (RecyclerView) findViewById(R.id.recyclerTypegrid);
        typeRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);


        typeRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new ClubGridAdapter(clubs);
        typeRecyclerView.setAdapter(adapter);







    }
}
