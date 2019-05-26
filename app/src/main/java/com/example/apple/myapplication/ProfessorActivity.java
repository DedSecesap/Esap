package com.example.apple.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfessorActivity extends AppCompatActivity {
    TextView Name,Branch,Designation,Courses;
    ResponsibilityAdapter clubAdapter,adapter;
    String name,branch,designation,courses,dummy,other,branchShort;
    String[] responibilities,research;
    RecyclerView responsi,researchhh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        Intent intent=getIntent();
        List<ResponsibilityModel> dataresp = new ArrayList<>(),researches=new ArrayList<>();
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String data=intent.getStringExtra("data");
        name=intent.getStringExtra("name");
        Log.e("ProfessorActivity","Activity khul gyi... "+data);
        if(data.indexOf('=',data.lastIndexOf("Designation")+2)!=-1)
        {
            designation=data.substring(data.indexOf('=',data.lastIndexOf("Designation"))+1,data.indexOf(",",data.lastIndexOf("Designation")));
        }
        else
        {
            designation=data.substring(data.indexOf('=',data.lastIndexOf("Designation"))+1,data.indexOf('}'));
        }

        if(data.indexOf('=',data.lastIndexOf("Responsibility")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Responsibility"))+1);
            String dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
            courses=dummy2.substring(0,dummy2.lastIndexOf(","));
        }
        else
        {
            courses=data.substring(data.indexOf('=',data.lastIndexOf("Responsibility"))+1,data.indexOf('}'));
        }
        if(data.indexOf('=',data.lastIndexOf("curricular")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("curricular"))+1);
            String dummy2=dummy.substring(0,dummy.indexOf('='));
//                    data.indexOf("=",data.lastIndexOf("curricular")+4)-1);
            other=dummy2.substring(0,dummy2.lastIndexOf(",")+1);
            responibilities=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("curricular"))+1,data.indexOf('}'));
            other=dummy.concat(",");
            responibilities=other.split(",");
        }
        if(data.indexOf('=',data.lastIndexOf("OfInterest")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("OfInterest"))+1);
            String dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf("=",data.lastIndexOf("OfInterest")+4)-1);
            other=dummy2.substring(0,dummy2.lastIndexOf(",")+1);
            research=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Designation"))+1,data.indexOf('}'));
            other=dummy.concat(",");
            research=other.split(",");
        }


        Name=findViewById(R.id.textView);
        Branch=findViewById(R.id.textView2);
        Designation=findViewById(R.id.designation_text);
        Courses=findViewById(R.id.courses_list);

        Name.setText(name);
        Designation.setText(designation);
        Courses.setText(courses);
        responsi=findViewById(R.id.involvemts_list);
        researchhh=findViewById(R.id.research_list);
        branchShort=data.substring(data.indexOf("@")-3,data.indexOf("@"));
        if(branchShort.contains("bme"))
        {
            branch="Biomedical";
        }
        else if(branchShort.contains("bce"))
        {
            branch="Biochemical";
        }
        else if(branchShort.contains("cer"))
        {
            branch="Ceramic";
        }
        else if(branchShort.contains("che"))
        {
            branch="Chemical";
        }
        else if(branchShort.contains("civ"))
        {
            branch="Civil";
        }
        else if(branchShort.contains("cse"))
        {
            branch="Computer Science";
        }else if(branchShort.contains("eee"))
        {
            branch="Electrical";
        }else if(branchShort.contains("ece"))
        {
            branch="Electronics";
        }else if(branchShort.contains("hss"))
        {
            branch="Humanistic Social Studies";
        }
        else if(branchShort.contains("chy"))
        {
            branch="Industrial Chemistry";
        }
        else if(branchShort.contains("mst"))
        {
            branch="Material Science and ";
        }
        else if(branchShort.contains("mat"))
        {
            branch="Mathematics and Computing";
        }
        else if(branchShort.contains("mec"))
        {
            branch="Mechanical";
        }
        else if(branchShort.contains("met"))
        {
            branch="Metallurgy";
        }
        else if(branchShort.contains("min"))
        {
            branch="Mining ";
        }
        else if(branchShort.contains("phe"))
        {
            branch="Pharmaceutical";
        }
        else if(branchShort.contains("phy"))
        {
            branch="Engineering Physics";
        }

        if(branch.contains("Chemist")||branch.contains("Phys")||branch.contains("Mathe"))
        {
           Branch.setText(branch);
        }
        else
        {
            Branch.setText(branch+" Engineering");
        }

        for(String s: responibilities)
        {
            dataresp.add(new ResponsibilityModel(s));
        }

        for(String s: research)
        {
            researches.add(new ResponsibilityModel(s));
        }


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
        responsi.setLayoutManager(linearLayoutManager);
        clubAdapter=new ResponsibilityAdapter(dataresp);
        responsi.setAdapter(clubAdapter);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
        researchhh.setLayoutManager(linearLayoutManager2);
        adapter=new ResponsibilityAdapter(researches);
        researchhh.setAdapter(adapter);






    }
}
