package com.example.apple.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ClubActivity extends AppCompatActivity {
    String name,council,strength,Descrip1,Descrip2;
    String member;
    String[] members,panel;
    List<ResponsibilityModel> memberModels,panelModels;
    ResponsibilityAdapter memberAdapter,panelAdapter;
    TextView Name,Strength,ShortDes,BigDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        Intent intent=getIntent();
        council="";
        panelModels=new ArrayList<>();
        memberModels=new ArrayList<>();
        Name=findViewById(R.id.clubName);
        Strength=findViewById(R.id.textView);
        ShortDes=findViewById(R.id.textView2);
        BigDes=findViewById(R.id.textViewDescr);
        name=intent.getStringExtra("Name");
        council=intent.getStringExtra("Council");
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference reference=firebaseDatabase.getReference();

        if(council.length()==0)
        {
            Name.setText(name);
            reference.child("Student Bodies").child(name).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        String post = postSnapshot.getKey();
                        Log.e("TAGGGGG",post+" Hakuna "+ postSnapshot.getValue().toString());
                        if(post.contains("Description1")){
                            ShortDes.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Description2")){
                            BigDes.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Strength")){
                            Strength.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Sec")){
                            panelModels.add(new ResponsibilityModel(postSnapshot.getValue().toString()));
                        }
                        else if(post.contains("PanelMembers"))
                        {
                            member=postSnapshot.getValue().toString().concat(",");
                            members=member.split(",");
                            for(String s: members)
                            {
                                memberModels.add(new ResponsibilityModel(s));
                            }
                        }


                }
                    RecyclerView membersofCouncil,panelMembers;
                    membersofCouncil=findViewById(R.id.student_list);
                    LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
                    membersofCouncil.setLayoutManager(llm);
                    memberAdapter=new ResponsibilityAdapter(memberModels);
                    membersofCouncil.setAdapter(memberAdapter);


                    panelMembers=findViewById(R.id.contact_list);
                    LinearLayoutManager llm1=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
                    panelMembers.setLayoutManager(llm1);
                    panelAdapter=new ResponsibilityAdapter(panelModels);
                    panelMembers.setAdapter(panelAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        else if(!council.contains("/"))
        {
            Name.setText(name);
            reference.child("Student Bodies").child(council).child(name).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        String post = postSnapshot.getKey();
                        Log.e("TAGGGGG",post+" Hakuna "+ postSnapshot.getValue().toString());
                        if(post.contains("Description1")){
                            ShortDes.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Description2")){
                            BigDes.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Strength")){
                            Strength.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Sec")){
                            panelModels.add(new ResponsibilityModel(postSnapshot.getValue().toString()));
                        }
                        else if(post.contains("Member"))
                        {
                            member=postSnapshot.getValue().toString();
                            members=member.split(",");
                            for(String s: members)
                            {
                                memberModels.add(new ResponsibilityModel(s));
                            }
                        }

                    }
                    RecyclerView membersofCouncil,panelMembers;
                    membersofCouncil=findViewById(R.id.student_list);
                    LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
                    membersofCouncil.setLayoutManager(llm);
                    memberAdapter=new ResponsibilityAdapter(memberModels);
                    membersofCouncil.setAdapter(memberAdapter);


                    panelMembers=findViewById(R.id.contact_list);
                    LinearLayoutManager llm1=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
                    panelMembers.setLayoutManager(llm1);
                    panelAdapter=new ResponsibilityAdapter(panelModels);
                    panelMembers.setAdapter(panelAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if(council.contains("/"))
        {
            Name.setText(name);
            reference.child("Student Bodies").child("Departmental Bodies").child(council.substring(council.indexOf("/")+1)).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        String post = postSnapshot.getKey();
                        Log.e("TAGGGGG",post+" Hakuna "+ postSnapshot.getValue().toString());
                        if(post.contains("Description1")){
                            ShortDes.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Description2")){
                            BigDes.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Strength")){
                            Strength.setText(postSnapshot.getValue().toString());
                        }
                        else if(post.contains("Sec")){
                            panelModels.add(new ResponsibilityModel(postSnapshot.getValue().toString()));
                        }
                        else if(post.contains("Member"))
                        {
                            member=postSnapshot.getValue().toString();
                            members=member.split(",");
                            for(String s: members)
                            {
                                memberModels.add(new ResponsibilityModel(s));
                            }
                        }

                    }
                    RecyclerView membersofCouncil,panelMembers;
                    membersofCouncil=findViewById(R.id.student_list);
                    LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
                    membersofCouncil.setLayoutManager(llm);
                    memberAdapter=new ResponsibilityAdapter(memberModels);
                    membersofCouncil.setAdapter(memberAdapter);


                    panelMembers=findViewById(R.id.contact_list);
                    LinearLayoutManager llm1=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
                    panelMembers.setLayoutManager(llm1);
                    panelAdapter=new ResponsibilityAdapter(panelModels);
                    panelMembers.setAdapter(panelAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }



    }
}
