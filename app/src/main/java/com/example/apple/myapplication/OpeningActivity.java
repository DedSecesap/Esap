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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpeningActivity extends AppCompatActivity {

    private TextView mTextMessage;
    List<TodayModel> classes= new ArrayList<>();
    List<EventModel> events= new ArrayList<>();
    TodayAdapter todayAdapter;
    EventAdapter eventAdapter;
    String Nameuser;
    String data;

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
                                case R.id.four:
                                    intent = new Intent(getApplicationContext(), ChatActivityDefault.class);
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
                    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
                    String branchcode = null;

                    FirebaseUser mUser=firebaseAuth.getCurrentUser();
                    String email=mUser.getEmail();
                    Nameuser=mUser.getDisplayName();

                    String year="Year20"+email.substring(email.indexOf("@")-2,email.indexOf("@"));
                    String dept=email.substring(email.indexOf("@")-5,email.indexOf("@")-2);
                    if(dept.contains("bme"))
                    {
                        branchcode="0140";
                    }
                    else if(dept.contains("bce"))
                    {
                        branchcode="0240";
                    }
                    else if(dept.contains("cer"))
                    {
                        branchcode="0340";
                    }
                    else if(dept.contains("che"))
                    {
                        branchcode="0440";
                    }
                    else if(dept.contains("civ"))
                    {
                        branchcode="0640";
                    }
                    else if(dept.contains("cse"))
                    {
                        branchcode="0740";
                    }
                    else if(dept.contains("eee"))
                    {
                        branchcode="0840";
                    }
                    else  if(dept.contains("ece"))
                    {
                        branchcode="0940";
                    }else
                    if(dept.contains("phy"))
                    {
                        branchcode="1740";
                    }else
                    if(dept.contains("chy"))
                    {
                        branchcode="1040";
                    }else
                    if(dept.contains("mst"))
                    {
                        branchcode="1140";
                    }else
                    if(dept.contains("mat"))
                    {
                        branchcode="1240";
                    }else
                    if(dept.contains("mec"))
                    {
                        branchcode="1340";
                    }else
                    if(dept.contains("met"))
                    {
                        branchcode="1440";
                    }else
                    if(dept.contains("min"))
                    {
                        branchcode="1540";
                    }else
                    if(dept.contains("phe"))
                    {
                        branchcode="1640";
                    }
                    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference=firebaseDatabase.getReference();
                    while (branchcode.charAt(2)<'6')
                    {

                        databaseReference.child("Students").child("Years").child(year).child(year.substring(6) + branchcode).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                                };
                                Map<String, Object> objectHashMap = null;
                                objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                                if (objectHashMap != null) {
                                    String Name = null;
                                    ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                                    for (Object obj : objectArrayList) {
                                        if (!(obj.toString().contains("IDD")||obj.toString().contains("MetSoc")||obj.toString().contains("Metallurgy")||obj.toString().contains("Morvi")||obj.toString().contains("BTech"))) {
                                            Log.e("Fragment Data", obj.toString());
                                            if (obj.toString().indexOf(',', obj.toString().indexOf("Name")) != -1) {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name"), obj.toString().indexOf(',', obj.toString().indexOf("Name"))));
                                                Name = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Name") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Name")));
                                            } else {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name")));
                                                Name = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                            }
                                        }
                                        if(Nameuser.contains(Name))
                                        {
                                            Nameuser=Name;
                                            data=obj.toString();
                                            break;
                                        }
                                    }

                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        if(branchcode.charAt(2)!='5')
                        {
                            branchcode=branchcode.substring(0,2)+"50";
                            Log.e("TAG","CourseCodeChanged"+branchcode);
                        }
                        else
                        {
                            branchcode=branchcode.substring(0,2)+"70";
                        }
                    }

                    intent.putExtra("data",data);
                    intent.putExtra("name",Nameuser);
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
//        RecyclerView eventRecy=findViewById(R.id.events_recy);
//        LinearLayoutManager llm1= new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
//        eventRecy.setLayoutManager(llm1);
//        events.add(new EventModel("xyz","xyz","xyz","xyz","xzy","xyz",R.drawable.white_curved_rectangle));
//        eventAdapter=new EventAdapter(events);
//        eventRecy.setAdapter(eventAdapter);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
