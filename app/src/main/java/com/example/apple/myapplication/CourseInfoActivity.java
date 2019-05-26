package com.example.apple.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CourseInfoActivity extends AppCompatActivity {

    String data,name,coursecode,courseCredits,courseurl,courseType;
    TextView code,about,credits;
    Button content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        String[] professors;
        List<ResponsibilityModel> responsibilityModels=new ArrayList<>();
        ResponsibilityAdapter responsibilityAdapter;

        String dummy,dummy2,other;
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        data=intent.getStringExtra("data");
        name=intent.getStringExtra("name");
        if(data.indexOf('=',data.lastIndexOf("CourseCode")+2)!=-1)
        {
            coursecode=data.substring(data.indexOf('=',data.lastIndexOf("CourseCode"))+1,data.indexOf(",",data.lastIndexOf("CourseCode")));
        }
        else
        {
            coursecode=data.substring(data.indexOf('=',data.lastIndexOf("CourseCode"))+1,data.indexOf('}'));
        }
        if(data.indexOf('=',data.lastIndexOf("CourseCredits")+2)!=-1)
        {
            courseCredits=data.substring(data.indexOf('=',data.lastIndexOf("CourseCredits"))+1,data.indexOf(",",data.lastIndexOf("CourseCredits")));
        }
        else
        {
            courseCredits=data.substring(data.indexOf('=',data.lastIndexOf("CourseCredits"))+1,data.indexOf('}'));
        }
        if(data.indexOf('=',data.lastIndexOf("CourseCredits")+2)!=-1)
        {
            courseCredits=data.substring(data.indexOf('=',data.lastIndexOf("CourseCredits"))+1,data.indexOf(",",data.lastIndexOf("CourseCredits")));
        }
        else
        {
            courseCredits=data.substring(data.indexOf('=',data.lastIndexOf("CourseCredits"))+1,data.indexOf('}'));
        }

        if(data.indexOf('=',data.lastIndexOf("CourseContent")+2)!=-1)
        {
            courseurl=data.substring(data.indexOf('=',data.lastIndexOf("CourseContent"))+1,data.indexOf(",",data.lastIndexOf("CourseContent")));
        }
        else
        {
            courseurl=data.substring(data.indexOf('=',data.lastIndexOf("CourseContent"))+1,data.indexOf('}'));
        }
        if(data.indexOf('=',data.lastIndexOf("CourseType")+2)!=-1)
        {
            courseType=data.substring(data.indexOf('=',data.lastIndexOf("CourseType"))+1,data.indexOf(",",data.lastIndexOf("CourseType")));
        }
        else
        {
            courseType=data.substring(data.indexOf('=',data.lastIndexOf("CourseType"))+1,data.indexOf('}'));
        }

        if(data.indexOf('=',data.lastIndexOf("Professor")+2)!=-1)
        {
            dummy=data.substring(data.indexOf('=',data.indexOf("Professor"))+1);
            Log.e("CourseInfo",dummy);
            dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
            other =dummy2.substring(0,dummy2.lastIndexOf(","));
            professors=other.split(",");
        }
        else
        {
            dummy=data.substring(data.indexOf('=',data.lastIndexOf("Professors"))+1,data.indexOf('}'));
            other=dummy.concat(",");
            professors=other.split(",");
        }

        for(String s: professors)
        {
            responsibilityModels.add(new ResponsibilityModel(s));
        }

        responsibilityAdapter=new ResponsibilityAdapter(responsibilityModels);
        RecyclerView professorsList=findViewById(R.id.proffs_recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        professorsList.setLayoutManager(linearLayoutManager);
        professorsList.setAdapter(responsibilityAdapter);
        code=findViewById(R.id.course_code);
        about=findViewById(R.id.syllabus_textview);
        credits=findViewById(R.id.credits_textview);
        content=findViewById(R.id.show_attachment_button);


        code.setText(coursecode);
        about.setText("About : \n Name: "+name+"\n Course Type: "+courseType);
        credits.setText(courseCredits);

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(courseurl));
                startActivity(browserIntent);
            }
        });



    }
}
