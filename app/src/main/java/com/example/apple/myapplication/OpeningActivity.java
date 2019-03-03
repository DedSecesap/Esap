package com.example.apple.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OpeningActivity extends AppCompatActivity {

    private TextView mTextMessage;
    List<TodayModel> classes= new ArrayList<>();
    List<EventModel> events= new ArrayList<>();
    TodayAdapter todayAdapter;
    EventAdapter eventAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_college:
                    //mTextMessage.setText("College");
                    Context wrapper = new ContextThemeWrapper(getBaseContext(), R.style.YOURSTYLE);

                    PopupMenu popup = new PopupMenu(wrapper, findViewById(R.id.navigation));
                    //Inflating the Popup using xml file
                    popup.getMenuInflater()
                            .inflate(R.menu.popup_menu_acad, popup.getMenu());

                    // Force icons to show

                        //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Toast.makeText(
                                    OpeningActivity.this,
                                    "You Clicked : " + item.getTitle(),
                                    Toast.LENGTH_SHORT
                            ).show();
                            Intent intent;
                            switch (item.getItemId())
                            {
                                case R.id.one:
                                    intent=new Intent(getApplicationContext(),InGeneralAcademicActivity.class);
                                    intent.putExtra("Type",item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.two:
                                    intent=new Intent(getApplicationContext(),InGeneralAcademicActivity.class);
                                    intent.putExtra("Type",item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.three:
                                    intent=new Intent(getApplicationContext(),InGeneralAcademicActivity.class);
                                    intent.putExtra("Type",item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.four:
                                    intent=new Intent(getApplicationContext(),InGeneralAcademicActivity.class);
                                    intent.putExtra("Type",item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.five:
                                    intent=new Intent(getApplicationContext(),InGeneralAcademicActivity.class);
                                    intent.putExtra("Type",item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.six:
                                    intent=new Intent(getApplicationContext(),InGeneralAcademicActivity.class);
                                    intent.putExtra("Type",item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.seven:
                                    intent=new Intent(getApplicationContext(),InGeneralAcademicActivity.class);
                                    intent.putExtra("Type",item.getTitle());
                                    startActivity(intent);
                                    break;
                            }
                            return true;
                        }
                    });

                    popup.show(); //showing popup menu


                    return true;
                case R.id.navigation_academic:
                   // mTextMessage.setText("Academics");
                    wrapper = new ContextThemeWrapper(getBaseContext(), R.style.YOURSTYLE);

                    popup = new PopupMenu(wrapper, findViewById(R.id.navigation_college));
                    //Inflating the Popup using xml file
                    popup.getMenuInflater()
                            .inflate(R.menu.popup_menu_college, popup.getMenu());

                    // Force icons to show

                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Toast.makeText(
                                    OpeningActivity.this,
                                    "You Clicked : " + item.getTitle(),
                                    Toast.LENGTH_SHORT
                            ).show();
                            Intent intent;
                            switch (item.getItemId()) {
                                case R.id.one:
                                    intent = new Intent(getApplicationContext(), InGeneralAcademicActivity.class);
                                    intent.putExtra("Type", item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.two:
                                    intent = new Intent(getApplicationContext(), InGeneralAcademicActivity.class);
                                    intent.putExtra("Type", item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.three:
                                    intent = new Intent(getApplicationContext(), InGeneralAcademicActivity.class);
                                    intent.putExtra("Type", item.getTitle());
                                    startActivity(intent);
                                    break;
                            }


                            return true;
                        }
                    });

                    popup.show(); //showing popup menu


                    return true;
                case R.id.navigation_messages:
                    //mTextMessage.setText("Mailbox");
                    wrapper = new ContextThemeWrapper(getBaseContext(), R.style.YOURSTYLE);

                    popup = new PopupMenu(wrapper, findViewById(R.id.navigation_messages));
                    //Inflating the Popup using xml file
                    popup.getMenuInflater()
                            .inflate(R.menu.popup_menu_mailbox, popup.getMenu());

                    // Force icons to show

                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Toast.makeText(
                                    OpeningActivity.this,
                                    "You Clicked : " + item.getTitle(),
                                    Toast.LENGTH_SHORT
                            ).show();
                            Intent intent;
                            switch (item.getItemId()) {
                                case R.id.one:
                                    intent = new Intent(getApplicationContext(), InGeneralAcademicActivity.class);
                                    intent.putExtra("Type", item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.two:
                                    intent = new Intent(getApplicationContext(), InGeneralAcademicActivity.class);
                                    intent.putExtra("Type", item.getTitle());
                                    startActivity(intent);
                                    break;
                                case R.id.three:
                                    intent = new Intent(getApplicationContext(), InGeneralAcademicActivity.class);
                                    intent.putExtra("Type", item.getTitle());
                                    startActivity(intent);
                                    break;
                            }
                            return true;
                        }
                    });

                    popup.show(); //showing popup menu


                    return true;

                case R.id.navigation_users:
                    Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        Context wrapper = new ContextThemeWrapper(this, R.style.YOURSTYLE);
        findViewById(R.id.planner_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PlannerActivity.class));
            }
        });
        RecyclerView dailyRecy=findViewById(R.id.daily_recy);
        LinearLayoutManager llm= new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        dailyRecy.setLayoutManager(llm);
        classes.add(new TodayModel("LT1","9:00-10:00","MSC301"));
        classes.add(new TodayModel("ABLT4","10:00-11:00","MSC304"));
        classes.add(new TodayModel("LT2","11:00-12:00","MSC308"));
        todayAdapter=new TodayAdapter(classes);
        dailyRecy.setAdapter(todayAdapter);
        RecyclerView eventRecy=findViewById(R.id.events_recy);
        LinearLayoutManager llm1= new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        eventRecy.setLayoutManager(llm1);
        events.add(new EventModel("xyz","xyz","xyz","xyz","xzy","xyz",R.drawable.white_curved_rectangle));
        eventAdapter=new EventAdapter(events);
        eventRecy.setAdapter(eventAdapter);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
