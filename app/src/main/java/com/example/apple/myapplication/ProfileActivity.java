package com.example.apple.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView textView=(TextView)findViewById(R.id.textView);
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        TextView textView3=(TextView)findViewById(R.id.textViewBranch);


        String name="Shambhav";
        String College="IIT-BHU";
        String Year="17035041";
        String Dept=" Part 2 Ceramic  Engineering";
        textView.setText(name);
        textView2.setText(College);
        textView3.setText(Year);
        final Button contactButton,AboutBUtton,ResearchButton;
        contactButton=findViewById(R.id.contact_button);
        AboutBUtton=findViewById(R.id.about_button);
        findViewById(R.id.drawer_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ResearchButton=findViewById(R.id.research_button);
        contactButton.setBackground(getDrawable(R.drawable.profile_select));
        AboutBUtton.setBackground(getDrawable(R.drawable.profile_not_select));
        ResearchButton.setBackground(getDrawable(R.drawable.profile_not_select));
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactButton.setBackground(getDrawable(R.drawable.profile_select));
                AboutBUtton.setBackground(getDrawable(R.drawable.profile_not_select));
                ResearchButton.setBackground(getDrawable(R.drawable.profile_not_select));
            }
        });
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactButton.setBackground(getDrawable(R.drawable.profile_select));
                AboutBUtton.setBackground(getDrawable(R.drawable.profile_not_select));
                ResearchButton.setBackground(getDrawable(R.drawable.profile_not_select));
            }
        });
        AboutBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactButton.setBackground(getDrawable(R.drawable.profile_not_select));
                AboutBUtton.setBackground(getDrawable(R.drawable.profile_select));
                ResearchButton.setBackground(getDrawable(R.drawable.profile_not_select));
            }
        });
        ResearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactButton.setBackground(getDrawable(R.drawable.profile_not_select));
                AboutBUtton.setBackground(getDrawable(R.drawable.profile_not_select));
                ResearchButton.setBackground(getDrawable(R.drawable.profile_select));
            }
        });
    }
}
