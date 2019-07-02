package com.example.apple.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AcademicDetailsActivity extends AppCompatActivity {
    EditText Year,Branch,RollNo,Course,Hostel;
    Button next;
    Intent intent;
    DatabaseReference databaseReference,databaseReferenceUser;
    String roll,branch,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_details);
        intent=getIntent();
        Log.e("Activity","Dusri Activity Bani");
        roll=intent.getStringExtra("Roll No");
        Log.e("Activity", roll);

        String yearAdm=roll.substring(0,2);
        String branchcode=roll.substring(0,roll.length()-2);
        String rollno=roll.substring(roll.length()-2);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();

        Log.e("Activity", yearAdm+"   " + branchcode + "   " + rollno);
        databaseReferenceUser=databaseReference.child("Students").child("Years").child("Year20"+yearAdm).child(branchcode).child(rollno);
        databaseReference.child("Students").child("Years").child("Year20"+yearAdm).child(branchcode).child(rollno).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue().toString().contains("Branch"))
                {
                    Intent intent=new Intent(getApplicationContext(),ClubDetailsActivity.class);
                    intent.putExtra("Roll No", roll);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Year=findViewById(R.id.Year);
        Branch=findViewById(R.id.Branch);
        RollNo=findViewById(R.id.rollno);
        Course=findViewById(R.id.Degree);
        Hostel=findViewById(R.id.Hostel);
        next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReferenceUser.child("Branch").setValue(Branch.getText().toString());
                databaseReferenceUser.child("Year").setValue(Year.getText().toString());
                databaseReferenceUser.child("RollNo").setValue(RollNo.getText().toString());
                databaseReferenceUser.child("Course").setValue(Course.getText().toString());
                databaseReferenceUser.child("Hostel").setValue(Hostel.getText().toString());

                databaseReferenceUser.child("Hostel").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getValue()!=null)
                        {
                            Intent intent=new Intent(getApplicationContext(),ClubDetailsActivity.class);
                            intent.putExtra("Roll No",roll);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });





    }
}