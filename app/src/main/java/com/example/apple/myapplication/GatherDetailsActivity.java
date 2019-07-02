package com.example.apple.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GatherDetailsActivity extends AppCompatActivity {
    EditText namee,Email,PhoneNo,DOB,Gender;
    String Nameuser,branchcode,year,dept,Roll;
    DatabaseReference databaseReferenceUser;
    Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gather_details);


        namee=findViewById(R.id.Name);
        Email=findViewById(R.id.Email);
        PhoneNo=findViewById(R.id.Phone_No);
        DOB=findViewById(R.id.DoB);
        Gender=findViewById(R.id.Gender);
        Next=findViewById(R.id.next);

        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser=firebaseAuth.getCurrentUser();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference=firebaseDatabase.getReference();
        Next.setVisibility(View.GONE);

        final String email=mUser.getEmail();
        Nameuser=mUser.getDisplayName();
        if(email.contains("itbhu")) {
            year = "Year20" + email.substring(email.indexOf("@") - 2, email.indexOf("@"));
            dept = email.substring(email.indexOf("@") - 5, email.indexOf("@") - 2);
            if (dept.contains("bme")) {
                branchcode = "0140";
            } else if (dept.contains("bce")) {
                branchcode = "0240";
            } else if (dept.contains("cer")) {
                branchcode = "0340";
            } else if (dept.contains("che")) {
                branchcode = "0440";
            } else if (dept.contains("civ")) {
                branchcode = "0640";
            } else if (dept.contains("cse")) {
                branchcode = "0740";
            } else if (dept.contains("eee")) {
                branchcode = "0840";
            } else if (dept.contains("ece")) {
                branchcode = "0940";
            } else if (dept.contains("phy")) {
                branchcode = "1740";
            } else if (dept.contains("chy")) {
                branchcode = "1040";
            } else if (dept.contains("mst")) {
                branchcode = "1140";
            } else if (dept.contains("mat")) {
                branchcode = "1240";
            } else if (dept.contains("mec")) {
                branchcode = "1340";
            } else if (dept.contains("met")) {
                branchcode = "1440";
            } else if (dept.contains("min")) {
                branchcode = "1540";
            } else if (dept.contains("phe")) {
                branchcode = "1640";
            }
            while (branchcode.charAt(2) < '6') {

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
                                if (!(obj.toString().contains("IDD") || obj.toString().contains("MetSoc") || obj.toString().contains("Metallurgy") || obj.toString().contains("Morvi") || obj.toString().contains("BTech"))) {
                                    Log.e("Fragment Data", obj.toString());
                                    if (obj.toString().indexOf(',', obj.toString().indexOf("Name")) != -1) {
                                        Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name"), obj.toString().indexOf(',', obj.toString().indexOf("Name"))));
                                        Name = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Name") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Name")));
                                    } else {
                                        Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name")));
                                        Name = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                    }
                                }
                                if (Nameuser.contains(Name)) {
                                    if (obj.toString().indexOf(',', obj.toString().indexOf("RollNo")) != -1) {
                                        Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("RollNo"), obj.toString().indexOf(',', obj.toString().indexOf("RollNo"))));
                                        Roll = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("RollNo") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("RollNo")));
                                    } else {
                                        Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("RollNo")));
                                        Roll = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                    }
                                    String rolllastdigits = Roll.substring(Roll.length() - 2);
                                    branchcode=Roll.substring(2,Roll.length()-2);
                                    databaseReferenceUser = databaseReference.child("Students").child("Years").child(year).child(year.substring(6) + branchcode).child(rolllastdigits);
                                    databaseReferenceUser.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            Log.e("Tag",dataSnapshot.toString());
                                            for(DataSnapshot snapshot :dataSnapshot.getChildren())
                                            {

                                                if(snapshot.getKey().equals("Name"))
                                                    namee.setText(snapshot.getValue().toString());
                                                if(snapshot.getKey().equals("Email"))
                                                    Email.setText(snapshot.getValue().toString());
                                                if(snapshot.getKey().equals("Phone Number"))
                                                    PhoneNo.setText(snapshot.getValue().toString());
                                                if(snapshot.getKey().equals("Gender"))
                                                    Gender.setText(snapshot.getValue().toString());
                                                if(snapshot.getKey().equals("Date Of Birth")) {
                                                    Intent intent = new Intent(getApplicationContext(), AcademicDetailsActivity.class);
                                                    intent.putExtra("Roll No",Roll);
                                                    startActivity(intent);
                                                } }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });

                                    Next.setVisibility(View.VISIBLE);
                                    Next.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            databaseReferenceUser.child("Name").setValue(namee.getText().toString());
                                            databaseReferenceUser.child("Email").setValue(Email.getText().toString());
                                            databaseReferenceUser.child("Phone Number").setValue(PhoneNo.getText().toString());
                                            databaseReferenceUser.child("Gender").setValue(Gender.getText().toString());
                                            databaseReferenceUser.child("Date Of Birth").setValue(DOB.getText().toString());


                                            databaseReferenceUser.child("Date Of Birth").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    if(dataSnapshot.getValue()!=null)
                                                    {
                                                        Intent intent=new Intent(getApplicationContext(), AcademicDetailsActivity.class);
                                                        intent.putExtra("Roll No",Roll);
                                                        startActivity(intent);

                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                        }
                                    });

                                    break;
                                }
                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                if (branchcode.charAt(2) != '5') {
                    branchcode = branchcode.substring(0, 2) + "50";
                    Log.e("TAG", "CourseCodeChanged" + branchcode);
                } else {
                    branchcode = branchcode.substring(0, 2) + "70";


                }


            }
            }












    }
}
