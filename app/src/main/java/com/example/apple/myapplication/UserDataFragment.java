package com.example.apple.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserDataFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserDataFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Type";
    private static final String ARG_PARAM2 = "Data";
    String dummy,dummy2,other;
    String[] researchName,researchMentor,History;
    TextView email,phone;
    RecyclerView datarecyler;
    private String typeData;
    List<ResearchModel> researchModelList;
    private String data;

    private OnFragmentInteractionListener mListener;

    public UserDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserDataFragment newInstance(String param1, String param2) {
        UserDataFragment fragment = new UserDataFragment();
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
            typeData = getArguments().getString(ARG_PARAM1);
            data = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_user_data, container, false);
        email=view.findViewById(R.id.email_text);
        phone=view.findViewById(R.id.phone_text);
        datarecyler=view.findViewById(R.id.recycler_data);
        researchModelList=new ArrayList<>();
        if(typeData.contains("Research"))
        {
            email.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
            if(data.indexOf('=',data.lastIndexOf("Research")+2)!=-1)
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research"))+1);
                dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
                other =dummy2.substring(0,dummy2.lastIndexOf(","));
                researchName=other.split(",");
            }
            else
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research"))+1,data.indexOf('}'));
                other=dummy.concat(",");
                researchName=other.split(",");
            }
            if(data.indexOf('=',data.lastIndexOf("History_Research")+2)!=-1)
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("History_Research"))+1);
                dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
                other =dummy2.substring(0,dummy2.lastIndexOf(","));
                History=other.split(",");
            }
            else
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("History_Research"))+1,data.indexOf('}'));
                other=dummy.concat(",");
                History=other.split(",");
            }
            if(data.indexOf('=',data.lastIndexOf("Research Mentor")+2)!=-1)
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research Mentor"))+1);
                dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
                other =dummy2.substring(0,dummy2.lastIndexOf(","));
                researchMentor=other.split(",");
            }
            else
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research Mentor"))+1,data.indexOf('}'));
                other=dummy.concat(",");
                researchMentor=other.split(",");
            }
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
            datarecyler.setLayoutManager(linearLayoutManager);
            int i=0;
            researchModelList=new ArrayList<>();
            for(String s : researchName)
            {
                researchModelList.add(new ResearchModel(s,researchMentor[i],History[i]));
                i++;
            }

            ResearchAdapter researchAdapter=new ResearchAdapter(researchModelList);
            datarecyler.setAdapter(researchAdapter);

        }

        else if(typeData.contains("NewsFeed")) {
            email.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
        }
//            if(data.indexOf('=',data.lastIndexOf("Feed")+2)!=-1)
//            {
//                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research"))+1);
//                dummy2=dummy.substring(0,dummy.indexOf('='));
////                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
//                other =dummy2.substring(0,dummy2.lastIndexOf(","));
//                researchName=other.split(",");
//            }
//            else
//            {
//                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research"))+1,data.indexOf('}'));
//                other=dummy.concat(",");
//                researchName=other.split(",");
//            }
//            if(data.indexOf('=',data.lastIndexOf("History_Research")+2)!=-1)
//            {
//                dummy=data.substring(data.indexOf('=',data.lastIndexOf("History_Research"))+1);
//                dummy2=dummy.substring(0,dummy.indexOf('='));
////                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
//                other =dummy2.substring(0,dummy2.lastIndexOf(","));
//                History=other.split(",");
//            }
//            else
//            {
//                dummy=data.substring(data.indexOf('=',data.lastIndexOf("History_Research"))+1,data.indexOf('}'));
//                other=dummy.concat(",");
//                History=other.split(",");
//            }
//            if(data.indexOf('=',data.lastIndexOf("Research Mentor")+2)!=-1)
//            {
//                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research Mentor"))+1);
//                dummy2=dummy.substring(0,dummy.indexOf('='));
////                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
//                other =dummy2.substring(0,dummy2.lastIndexOf(","));
//                researchMentor=other.split(",");
//            }
//            else
//            {
//                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Research Mentor"))+1,data.indexOf('}'));
//                other=dummy.concat(",");
//                researchMentor=other.split(",");
//            }
//            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//            datarecyler.setLayoutManager(linearLayoutManager);
//            int i=0;
//
//            for(String s : researchName)
//            {
//                researchModelList.add(new ResearchModel(s,researchMentor[i],History[i]));
//                i++;
//            }
//
//            ResearchAdapter researchAdapter=new ResearchAdapter(researchModelList);
//            datarecyler.setAdapter(researchAdapter);
//
//        }
        else if(typeData.contains("WorkEx"))
        {
            email.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
            if(data.indexOf('=',data.lastIndexOf("Work Designation")+2)!=-1)
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Work Designation"))+1);
                dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
                other =dummy2.substring(0,dummy2.lastIndexOf(","));
                researchName=other.split(",");
            }
            else
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Work Designation"))+1,data.indexOf('}'));
                other=dummy.concat(",");
                researchName=other.split(",");
            }
            if(data.indexOf('=',data.lastIndexOf("In Company")+2)!=-1)
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("In Company"))+1);
                dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
                other =dummy2.substring(0,dummy2.lastIndexOf(","));
                History=other.split(",");
            }
            else
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("In Company"))+1,data.indexOf('}'));
                other=dummy.concat(",");
                History=other.split(",");
            }
            if(data.indexOf('=',data.lastIndexOf("Description of Work")+2)!=-1)
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Description of Work"))+1);
                dummy2=dummy.substring(0,dummy.indexOf('='));
//                    ,data.indexOf('=',data.lastIndexOf("Responsibility")+3));
                other =dummy2.substring(0,dummy2.lastIndexOf(","));
                researchMentor=other.split(",");
            }
            else
            {
                dummy=data.substring(data.indexOf('=',data.lastIndexOf("Description of Work"))+1,data.indexOf('}'));
                other=dummy.concat(",");
                researchMentor=other.split(",");
            }
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
            datarecyler.setLayoutManager(linearLayoutManager);
            int i=0;
            researchModelList=new ArrayList<>();
            for(String s : researchName)
            {
                researchModelList.add(new ResearchModel(s,researchMentor[i],History[i]));
                i++;
            }

            ResearchAdapter researchAdapter=new ResearchAdapter(researchModelList);
            datarecyler.setAdapter(researchAdapter);

        }
       else if(typeData.contains("Contact"))
        {
            email.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
            String Email,phoneNo;
            if(data.indexOf('=',data.lastIndexOf("Email")+2)!=-1)
            {
                Email=data.substring(data.indexOf('=',data.lastIndexOf("Email"))+1,data.indexOf(",",data.lastIndexOf("Email")));
            }
            else
            {
                Email=data.substring(data.indexOf('=',data.lastIndexOf("Email"))+1,data.indexOf('}'));
            }
            email.setText("E-Mail Id: " + Email);
            if(data.indexOf('=',data.lastIndexOf("Phone Number")+2)!=-1)
            {
                phoneNo=data.substring(data.indexOf('=',data.lastIndexOf("Phone Number"))+1,data.indexOf(",",data.lastIndexOf("Phone Number")));
            }
            else
            {
                phoneNo=data.substring(data.indexOf('=',data.lastIndexOf("Phone Number"))+1,data.indexOf('}'));
            }
            phone.setText("Contact Number " + phoneNo);
            datarecyler.setVisibility(View.GONE);
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
