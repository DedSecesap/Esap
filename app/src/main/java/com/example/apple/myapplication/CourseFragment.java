package com.example.apple.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CourseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Course Code";
    private static final String ARG_PARAM2 = "Course Name";

    TextView courseCode,courseName,courseCredits;
    RecyclerView Branch;
    List<AcademicActivityModel> academicActivityModels;
    Button seeDistriibution;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_course, container, false);
         courseCode=view.findViewById(R.id.course_code);
        courseName=view.findViewById(R.id.course_name);
        courseCredits=view.findViewById(R.id.credits_textview);
        Branch=view.findViewById(R.id.branch_recy);
        seeDistriibution=view.findViewById(R.id.see_distri);

        courseCode.setText(mParam1);

        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Courses").child("Branches").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) // gets to branches name
                {
                    if(!dataSnapshot1.getValue().toString().contains(mParam1))
                        continue;
                    for(DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren()) // gets to year
                    {
                        if(!dataSnapshot2.getValue().toString().contains(mParam1))
                            continue;
                        for(DataSnapshot snapshot: dataSnapshot2.getChildren()) // gets to each course
                        {
                            if(snapshot.getKey().contains(mParam1))
                            {
                                for(DataSnapshot snapshot1 : snapshot.getChildren())
                                {
                                    if(snapshot1.getKey().contains("CourseName"))
                                        courseName.setText(snapshot1.getValue().toString());
                                    else if(snapshot1.getKey().contains("CourseCredits"))
                                        courseCredits.setText(snapshot1.getValue().toString());
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Branch.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        academicActivityModels=new ArrayList<>();
        databaseReference.child("Time Table").child("Branches").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    if(dataSnapshot1.getValue().toString().contains(mParam1)) {
                        academicActivityModels.add(new AcademicActivityModel(dataSnapshot1.getKey().toString(), dataSnapshot1.getValue().toString(), "Branches"));
                       AcademicActivityAdaptor academicActivityAdaptor=new AcademicActivityAdaptor(academicActivityModels,getContext());
                       Branch.setAdapter(academicActivityAdaptor);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        seeDistriibution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),InGeneralAcademicActivity.class);
                intent.putExtra("Type","marks distribution");
                startActivity(intent);
            }
        });


         return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
