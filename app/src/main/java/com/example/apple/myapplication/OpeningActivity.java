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
import android.util.EventLogTags;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
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
    private FirebaseAnalytics mFirebaseAnalytics;
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
                    final Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
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
                                            intent.putExtra("data",data);
                                            intent.putExtra("name",Nameuser);
                                            startActivity(intent);
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
        final RecyclerView dailyRecy=findViewById(R.id.daily_recy);
        LinearLayoutManager llm= new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        dailyRecy.setLayoutManager(llm);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser=firebaseAuth.getCurrentUser();
        String email=mUser.getEmail();



        final RecyclerView eventRecy=findViewById(R.id.events_recy);
        LinearLayoutManager llm1= new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        eventRecy.setLayoutManager(llm1);

        databaseReference.child("Events").child("Councils").child("FMC Weekend").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String descr = null,council = null,contact = null,time = null;
                for(DataSnapshot snapshot :dataSnapshot.getChildren())
                {
                    Log.e("TAGG","Event");
                    if(snapshot.getKey().contains("Description2"))
                    {
                        descr=snapshot.getValue().toString();
                    }
                    if(snapshot.getKey().contains("Council"))
                    {
                        council=snapshot.getValue().toString();
                    }
                    if(snapshot.getKey().equals("Convenor"))
                    {
                        contact=snapshot.getValue().toString();
                    }
                    if(snapshot.getKey().contains("Dates"))
                    {
                        time=snapshot.getValue().toString();
                    }
                }
                events.add(new EventModel("FMC Weekend",descr,council,contact,"Rajputana Ground",time));
                eventAdapter=new EventAdapter(events);
                eventRecy.setAdapter(eventAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        if(email.contains("itbhu")) {
            int year = 19 - Integer.parseInt(email.substring(email.indexOf("@") - 2, email.indexOf("@")));
            String branchcode = null;
            String dept = email.substring(email.indexOf("@") - 5, email.indexOf("@") - 2);
            if (dept.contains("bme")) {
                branchcode = "Biomedical";
            } else if (dept.contains("bce")) {
                branchcode = "Biochemical";
            } else if (dept.contains("cer")) {
                branchcode = "Ceramic";
            } else if (dept.contains("che")) {
                branchcode = "Chemical";
            } else if (dept.contains("civ")) {
                branchcode = "Civil";
            } else if (dept.contains("cse")) {
                branchcode = "Computer Science";
            } else if (dept.contains("eee")) {
                branchcode = "Electrical";
            } else if (dept.contains("ece")) {
                branchcode = "Electronics";
            } else if (dept.contains("phy")) {
                branchcode = "Physics";
            } else if (dept.contains("chy")) {
                branchcode = "Chemistry";
            } else if (dept.contains("mst")) {
                branchcode = "Material Science";
            } else if (dept.contains("mat")) {
                branchcode = "Maths and Computing";
            } else if (dept.contains("mec")) {
                branchcode = "Mechanical";
            } else if (dept.contains("met")) {
                branchcode = "Metallurgy";
            } else if (dept.contains("min")) {
                branchcode = "Mining";
            } else if (dept.contains("phe")) {
                branchcode = "Pharmaceutical Engineering";
            }


            Log.e("REG", "Monday of dept  Metallurgy ");
            assert branchcode != null;
            databaseReference.child("TimeTable").child("Branches").child(branchcode).child("Days").child("Monday").child("Year" + year).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap = null;
                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                    if (objectHashMap != null) {
                        ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                        for (Object obj : objectArrayList) {
                            Log.e("Fragment Data", obj.toString());
                            String code;
                            String hall;
                            String starttime;
                            String endtime;
                            if (obj.toString().indexOf(',', obj.toString().indexOf("code")) != -1) {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("code"), obj.toString().indexOf(',', obj.toString().indexOf("code"))));
                                code = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("code") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("code")));
                            } else {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("code")));
                                code = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                            }
                            if (obj.toString().indexOf(',', obj.toString().indexOf("venue")) != -1) {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("venue"), obj.toString().indexOf(',', obj.toString().indexOf("venue"))));
                                hall = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("venue") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("venue")));
                            } else {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("venue")));
                                hall = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                            }
                            if (obj.toString().indexOf(',', obj.toString().indexOf("start_time")) != -1) {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("start_time"), obj.toString().indexOf(',', obj.toString().indexOf("start_time"))));
                                starttime = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("start_time") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("start_time")));
                            } else {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("start_time")));
                                starttime = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                            }
                            if (obj.toString().indexOf(',', obj.toString().indexOf("end_time")) != -1) {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("end_time"), obj.toString().indexOf(',', obj.toString().indexOf("end_time"))));
                                endtime = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("end_time") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("end_time")));
                            } else {
                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("end_time")));
                                endtime = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                            }

                            classes.add(new TodayModel(hall, starttime + " - " + endtime, code));

                        }
                        List<TodayModel> arrangedclass = new ArrayList<>();
                        int i = 800;
                        int flag = 0;
                        while (i < 1800) {
                            for (TodayModel model : classes) {
                                String start = model.getTime();
                                if (start.contains(String.valueOf(i))) {
                                    arrangedclass.add(model);

                                }

                            }
                            i = i + 100;
                        }
                        TodayAdapter todayAdapter = new TodayAdapter(arrangedclass);
                        dailyRecy.setAdapter(todayAdapter);
                        dailyRecy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(getApplicationContext(),PlannerActivity.class);
                                startActivity(intent);
                            }
                        });

                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }






        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
