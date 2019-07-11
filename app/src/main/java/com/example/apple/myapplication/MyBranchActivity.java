package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.inappmessaging.MessagesProto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBranchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String branchcode,Nameuser;
    List<BranchGridModel> branchGridModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_branch);
        recyclerView=findViewById(R.id.recy_mybranch);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ActionBar actionBar = getSupportActionBar();
        branchGridModels=new ArrayList<>();
        TextView textView=findViewById(R.id.title);
        textView.setVisibility(View.VISIBLE);
        textView.setText("My Branch");


        FirebaseUser mUser= FirebaseAuth.getInstance().getCurrentUser();
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
            branchcode="0450";
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
                    for(DataSnapshot snapshot: dataSnapshot.getChildren())
                    {
                        String name = null;
                        String designation= null;
                        String tagline= null;
                        String data=snapshot.getValue().toString();
                        for(DataSnapshot snapshot1: snapshot.getChildren())
                        {
                            if(snapshot1.getKey().contains("Name"))
                                name=snapshot1.getValue().toString();
                            if(snapshot1.getKey().contains("Tagline"))
                                tagline=snapshot1.getValue().toString();
                            if(snapshot1.getKey().contains("Designation"))
                                designation=snapshot1.getValue().toString();
                        }
                        branchGridModels.add(new BranchGridModel(name,tagline,designation,data,""));
                        BranchGridAdapter branchGridAdapter=new BranchGridAdapter(branchGridModels,getApplicationContext());
                        recyclerView.setAdapter(branchGridAdapter);

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

    }
}
