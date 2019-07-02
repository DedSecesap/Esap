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

public class ClubDetailsActivity extends AppCompatActivity {
    EditText CouncilText,ClubText,Designation,ProjectNames,ProfessorName,History;
    Button save;
    Intent intent;
    DatabaseReference databaseReference,databaseReferenceUser;
    String roll,branch,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_details);
        intent=getIntent();
        roll=intent.getStringExtra("Roll No");

        String yearAdm=roll.substring(0,2);
        String branchcode=roll.substring(0,roll.length()-2);
        final String rollno=roll.substring(roll.length()-2);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();
        databaseReferenceUser=databaseReference.child("Students").child("Years").child("Year20"+yearAdm).child(branchcode).child(rollno);
        databaseReferenceUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue().toString().contains("History"))
                {
                    Intent intent1=new Intent(getApplicationContext(),OpeningActivity.class);
                    intent1.putExtra("Roll No",roll);
                    startActivity(intent1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        CouncilText=findViewById(R.id.Council);
        ClubText=findViewById(R.id.clubName);
        Designation=findViewById(R.id.designation_text);
        ProjectNames=findViewById(R.id.Project);
        ProfessorName=findViewById(R.id.prof_text);
        History=findViewById(R.id.History);
        save=findViewById(R.id.Savedata);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReferenceUser.child("Research").setValue(ProjectNames.getText().toString());
                databaseReferenceUser.child("Research Mentor").setValue(ProfessorName.getText().toString());
                databaseReferenceUser.child("History_Research").setValue(History.getText().toString());
                databaseReferenceUser.child("Councils").setValue(CouncilText.getText().toString());
                databaseReferenceUser.child("Designation").setValue(Designation.getText().toString());
                databaseReferenceUser.child("Myclubs").setValue(ClubText.getText().toString());


                databaseReferenceUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue().toString().contains("History")) {
                            Intent intent1 = new Intent(getApplicationContext(), OpeningActivity.class);
                            Log.e("Intent",rollno);
                            intent1.putExtra("Roll No", roll);
                            startActivity(intent1);
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
