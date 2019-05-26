package com.example.apple.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
 * {@link EventFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Council";
    private static final String ARG_PARAM2 = "Name";
    TextView ShortDes,BigDes,ProfCharge,Strength,Dateee;
    RecyclerView memberlist,panellist;
    List<ResponsibilityModel> memberModels,panelModels;
    ResponsibilityAdapter memberAdapter,panelAdapter;
    String[] members;

    String name,council,memberarr;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public void setName(String name) {
        this.name = name;
    }

    public void setCouncil(String council) {
        this.council = council;
    }

    public EventFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFragment newInstance(String param1, String param2) {
        EventFragment fragment = new EventFragment();
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
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ProfCharge=view.findViewById(R.id.prof_text);
        ShortDes=view.findViewById(R.id.textView2);
        BigDes=view.findViewById(R.id.textViewDescr);
        panelModels=new ArrayList<>();
        memberModels=new ArrayList<>();

        Strength=view.findViewById(R.id.textView);
        Dateee=view.findViewById(R.id.textViewDate);
        ShortDes=view.findViewById(R.id.textView2);
        memberlist=view.findViewById(R.id.student_list);
        panellist=view.findViewById(R.id.contact_list);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference();
        if (!council.contains("/")) {
            reference.child("Events").child(council).child(name).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        String post = postSnapshot.getKey();
                        Log.e("TAGGGGG", post + " Hakuna " + postSnapshot.getValue().toString());
                        if (post.contains("Professor")) {
                            ProfCharge.setText(postSnapshot.getValue().toString());
                        } else if (post.contains("Description1")) {
                            ShortDes.setText(postSnapshot.getValue().toString());
                        } else if (post.contains("Description2")) {
                            BigDes.setText(postSnapshot.getValue().toString());
                        } else if (post.contains("Conven") || post.contains("Head") || post.contains("StudentRep")) {
                            panelModels.add(new ResponsibilityModel(postSnapshot.getValue().toString()));
                        } else if (post.contains("CoreTeam")) {
                            memberarr = postSnapshot.getValue().toString();
                            members = memberarr.split(",");

                            for (String s : members) {
                                memberModels.add(new ResponsibilityModel(s));
                            }
                            Strength.setText(String.valueOf(memberModels.size()));
                        } else if (post.contains("Dates")) {
                            Dateee.setText(postSnapshot.getValue().toString());


                        }



                    }
                    LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                    memberlist.setLayoutManager(llm);
                    memberAdapter = new ResponsibilityAdapter(memberModels);
                    memberlist.setAdapter(memberAdapter);


                    LinearLayoutManager llm1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                    panellist.setLayoutManager(llm1);
                    panelAdapter = new ResponsibilityAdapter(panelModels);
                    panellist.setAdapter(panelAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else
        {
            reference.child("Events").child("Departments").child(council.substring(council.indexOf("/")+1)).child(name).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        String post = postSnapshot.getKey();
                        Log.e("TAGGGGG", post + " Hakuna " + postSnapshot.getValue().toString());
                        if (post.contains("Professor")) {
                            ProfCharge.setText(postSnapshot.getValue().toString());
                        } else if (post.contains("Description1")) {
                            ShortDes.setText(postSnapshot.getValue().toString());
                        } else if (post.contains("Description2")) {
                            BigDes.setText(postSnapshot.getValue().toString());
                        } else if (post.contains("Conven") || post.contains("Head") || post.contains("StudentRep")) {
                            panelModels.add(new ResponsibilityModel(postSnapshot.getValue().toString()));
                        } else if (post.contains("CoreTeam")) {
                            memberarr = postSnapshot.getValue().toString();
                            members = memberarr.split(",");
                            Strength.setText(members.length);
                            for (String s : members) {
                                memberModels.add(new ResponsibilityModel(s));
                            }
                        } else if (post.contains("Dates")) {
                            Dateee.setText(postSnapshot.getValue().toString());


                        }



                    }
                    LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                    memberlist.setLayoutManager(llm);
                    memberAdapter = new ResponsibilityAdapter(memberModels);
                    memberlist.setAdapter(memberAdapter);


                    LinearLayoutManager llm1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                    panellist.setLayoutManager(llm1);
                    panelAdapter = new ResponsibilityAdapter(panelModels);
                    panellist.setAdapter(panelAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
        mListener=(OnFragmentInteractionListener)context;
        }else{
        throw new RuntimeException(context.toString()
        +" must implement OnFragmentInteractionListener");
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
