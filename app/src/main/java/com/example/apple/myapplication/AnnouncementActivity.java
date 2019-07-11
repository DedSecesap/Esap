package com.example.apple.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<AnnouncementModel> announcementModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        ActionBar actionBar = getSupportActionBar();
        recyclerView=findViewById(R.id.announcement_recy);
        announcementModels=new ArrayList<>();
        announcementModels.add(new AnnouncementModel("Dummy Announcement","This announcement is for the purpose of setting layout accordingly to avoid furthur delay","Shambhav Tyagi"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        AnnouncementAdapter announcementAdapter=new AnnouncementAdapter(announcementModels);
        recyclerView.setAdapter(announcementAdapter);

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.add_frame).setVisibility(View.VISIBLE);
                findViewById(R.id.floatingActionButton).setVisibility(View.GONE);
            }
        });


        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.add_frame).setVisibility(View.GONE);
                findViewById(R.id.floatingActionButton).setVisibility(View.VISIBLE);
            }
        });



        TextView textView=findViewById(R.id.title);
        textView.setVisibility(View.VISIBLE);
        textView.setText("Announcement Box");
    }
}
