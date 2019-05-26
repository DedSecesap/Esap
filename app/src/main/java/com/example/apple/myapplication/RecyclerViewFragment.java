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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecyclerViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String CourseCode;

    private int mParam1;
    private String mParam2;
    private String name;
    private String branchName;
    String courseName;
    private String branch;

    private OnFragmentInteractionListener mListener;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerViewFragment.
     */
    public static RecyclerViewFragment newInstance(String param1, String param2) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
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
            mParam1 = getArguments().getInt("page_position");
            name=getArguments().getString("name");
            branch=getArguments().getString("branch");


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

            View    view =inflater.inflate(R.layout.fragment_electric_prof, container, false);
        final RecyclerView dailyRecy=view.findViewById(R.id.item_recy);
        LinearLayoutManager llm= new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        dailyRecy.setLayoutManager(llm);
        final List<AcademicActivityModel> academicActivityModels=new ArrayList<>();
        if(name.contains("courses"))
        {
            if(mParam1<=5)
            {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=database.getReference();

                Log.e("REG",branch+" of year " +mParam1);
            databaseReference.child("Courses").child("Branches").child(branch).child("Year"+(mParam1)).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    Map<String, Object> objectHashMap=null;
                    objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                        if(objectHashMap!=null) {
                            ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                            for (Object obj : objectArrayList) {
                                Log.e("Fragment Data",obj.toString());
                                if(obj.toString().indexOf(',', obj.toString().indexOf("Name"))!=-1)
                                {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name"), obj.toString().indexOf(',', obj.toString().indexOf("Name"))));
                                    courseName=obj.toString().substring(obj.toString().indexOf("=",obj.toString().indexOf("Name")+4)+1, obj.toString().indexOf(',', obj.toString().indexOf("Name")));
                                }
                                else {
                                    Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name")));
                                    courseName=obj.toString().substring(obj.toString().lastIndexOf("=")+1,obj.toString().length()-1);
                                }
                                academicActivityModels.add(new AcademicActivityModel(courseName,obj.toString(),name));
                            }
                            AcademicActivityAdaptor academicActivityAdaptor=new AcademicActivityAdaptor(academicActivityModels,getActivity());
                            dailyRecy.setAdapter(academicActivityAdaptor);
                        }
                        }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            }
        }
        else if(name.contains("branches"))
        {
            if(mParam1<20)
            {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=database.getReference();
                switch (mParam1-1)
                {
                    case 0:
                         branchName="Biochemical Engineering";
                         CourseCode="0140";
                         break;
                    case 1:
                        branchName="Biomedical";
                        CourseCode="0240";
                        break;
                    case 2:
                        branchName="Ceramics";
                        CourseCode="0340";
                        break;
                    case 3:
                        branchName="Chemical";
                        CourseCode="0450";
                        break;
                    case 4:
                        branchName="Computer Science";
                        CourseCode="0540";
                        break;
                    case 5:
                        branchName="Electrical";
                        CourseCode="0640";
                        break;
                        case 6:
                        branchName="Electronics";
                            CourseCode="0740";
                            break;
                    case 7:
                        branchName="Physics";
                        CourseCode="0840";
                        break;
                    case 8:
                        branchName="Chemistry";
                        CourseCode="0940";
                        break;
                    case 9:
                        branchName="Material Science";
                        CourseCode="1040";
                        break;
                    case 10:
                        branchName="Maths and Computing";
                        CourseCode="1140";
                        break;
                    case 11:
                        branchName="Mechanical";
                        CourseCode="1240";
                        break;
                    case 12:
                        branchName="Metallurgy";
                        CourseCode="1440";
                        break;
                    case 13:
                        branchName="Mining";
                        CourseCode="1540";
                        break;
                    case 14:
                        branchName="Pharmaceutics";
                        CourseCode="1640";
                        break;

                }
                Log.e("REG",branch+" of year " +branchName);
                while (CourseCode.charAt(2)<'6')
                {

                    databaseReference.child("Students").child("Years").child("Year" + branch).child(branch.substring(2) + CourseCode).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                            };
                            Map<String, Object> objectHashMap = null;
                            objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                            if (objectHashMap != null) {
                                ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                                for (Object obj : objectArrayList) {
                                    if (!(obj.toString().contains("IDD")||obj.toString().contains("MetSoc")||obj.toString().contains("Metallurgy")||obj.toString().contains("Morvi")||obj.toString().contains("BTech"))) {
                                        Log.e("Fragment Data", obj.toString());
                                        if (obj.toString().indexOf(',', obj.toString().indexOf("Name")) != -1) {
                                            Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name"), obj.toString().indexOf(',', obj.toString().indexOf("Name"))));
                                            courseName = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Name") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Name")));
                                        } else {
                                            Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name")));
                                            courseName = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                        }
                                        academicActivityModels.add(new AcademicActivityModel(courseName,obj.toString(),"students"));
                                    }
                                    }
                                    AcademicActivityAdaptor academicActivityAdaptor = new AcademicActivityAdaptor(academicActivityModels,getActivity());
                                    dailyRecy.setAdapter(academicActivityAdaptor);

                                }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    if(CourseCode.charAt(2)!='5')
                    {
                        CourseCode=CourseCode.substring(0,2)+"50";
                        Log.e("TAG","CourseCodeChanged"+CourseCode);
                    }
                    else
                    {
                        CourseCode=CourseCode.substring(0,2)+"70";
                    }
                }
            }

        }
        else if(name.contains("profess"))
        {
            if(mParam1<=3)
                {
                    switch (mParam1-1) {
                        case 0:
                            branchName = "Professor";
                            break;
                        case 1:
                            branchName = "Assistant Professor";
                            break;
                        case 2:
                            branchName = "Associate Professor";
                            break;
                    }
                    FirebaseDatabase database=FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference=database.getReference();

                    Log.e("REG",branchName+" of dept  " +branch);
                    databaseReference.child("Professors").child("Departments").child(branch).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {
                            };
                            Map<String, Object> objectHashMap=null;
                            objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                            if(objectHashMap!=null) {
                                ArrayList<Object> objectArrayList = new ArrayList<Object>(objectHashMap.values());
                                for (Object obj : objectArrayList) {
                                    Log.e("Fragment Data", obj.toString());
                                    if(!obj.toString().endsWith("}}")) {
                                        if (branchName.equals("Professor") && !obj.toString().contains("Assistant") && !obj.toString().contains("Associate")&&!obj.toString().contains("HOD")) {
                                            if (obj.toString().indexOf(',', obj.toString().indexOf("Name")) != -1) {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name"), obj.toString().indexOf(',', obj.toString().indexOf("Name"))));
                                                courseName = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Name") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Name")));
                                            } else {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name")));
                                                courseName = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                            }
                                            academicActivityModels.add(new AcademicActivityModel(courseName,obj.toString(),"profess"));
                                        } else if (branchName.contains("Assistant") && obj.toString().contains(branchName)) {
                                            if (obj.toString().indexOf(',', obj.toString().indexOf("Name")) != -1) {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name"), obj.toString().indexOf(',', obj.toString().indexOf("Name"))));
                                                courseName = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Name") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Name")));
                                            } else {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name")));
                                                courseName = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                            }

                                            academicActivityModels.add(new AcademicActivityModel(courseName,obj.toString(),"profess"));


                                        } else if (branchName.contains("Associate") && obj.toString().contains(branchName)) {
                                            if (obj.toString().indexOf(',', obj.toString().indexOf("Name")) != -1) {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name"), obj.toString().indexOf(',', obj.toString().indexOf("Name"))));
                                                courseName = obj.toString().substring(obj.toString().indexOf("=", obj.toString().indexOf("Name") + 4) + 1, obj.toString().indexOf(',', obj.toString().indexOf("Name")));
                                            } else {
                                                Log.e("Fragment Data", obj.toString().substring(obj.toString().indexOf("Name")));
                                                courseName = obj.toString().substring(obj.toString().lastIndexOf("=") + 1, obj.toString().length() - 1);
                                            }
                                            academicActivityModels.add(new AcademicActivityModel(courseName,obj.toString(),"profess"));


                                        }
                                    }
                                    else
                                    {
                                       String[] objects= obj.toString().split("=\\{");
                                       for(String objec: objects)
                                       {
                                           if(objec.length()>30)
                                           if (branchName.equals("Professor") && !objec.contains("Assistant") && !objec.contains("Associate")) {
                                               if (objec.indexOf(',', objec.indexOf("Name")) != -1) {
                                                   Log.e("CrashingData",objec);
                                                   Log.e("Fragment Data", objec.substring(objec.indexOf("Name"), objec.indexOf(',', objec.indexOf("Name"))));
                                                   courseName = objec.substring(objec.indexOf("=", objec.indexOf("Name") + 4) + 1, objec.indexOf(',', objec.indexOf("Name"))-1);
                                               } else {
                                                   Log.e("Fragment Data", objec.substring(objec.indexOf("Name")));
                                                   courseName = objec.substring(objec.lastIndexOf("=") + 1, objec.length() - 2);
                                               }


                                               academicActivityModels.add(new AcademicActivityModel(courseName,objec,"profess"));
                                           } else if (branchName.contains("Assistant") && objec.contains(branchName)) {
                                               if (objec.indexOf(',', objec.indexOf("Name")) != -1) {
                                                   Log.e("Fragment Data", objec.substring(objec.indexOf("Name"), objec.indexOf(',', objec.indexOf("Name"))));
                                                   courseName = objec.substring(objec.indexOf("=", objec.indexOf("Name") + 4) + 1, objec.indexOf(',', objec.indexOf("Name"))-1);
                                               } else {
                                                   Log.e("Fragment Data", objec.substring(objec.indexOf("Name")));
                                                   courseName = objec.substring(objec.lastIndexOf("=") + 1, objec.length() - 2);
                                               }


                                               academicActivityModels.add(new AcademicActivityModel(courseName,objec,"profess"));

                                           } else if (branchName.contains("Associate") && objec.contains(branchName)) {
                                               if (objec.indexOf(',', objec.indexOf("Name")) != -1) {
                                                   Log.e("Fragment Data", objec.substring(objec.indexOf("Name"), objec.indexOf(',', objec.indexOf("Name"))));
                                                   courseName = objec.substring(objec.indexOf("=", objec.indexOf("Name") + 4) + 1, objec.indexOf(',', objec.indexOf("Name"))-1);
                                               } else {
                                                   Log.e("Fragment Data", objec.substring(objec.indexOf("Name")));
                                                   courseName = objec.substring(objec.lastIndexOf("=") + 1, objec.length() - 2);
                                               }

                                               academicActivityModels.add(new AcademicActivityModel(courseName,objec,"profess"));

                                           }
                                       }

                                    }



                                }
                                AcademicActivityAdaptor academicActivityAdaptor=new AcademicActivityAdaptor(academicActivityModels,getActivity());
                                dailyRecy.setAdapter(academicActivityAdaptor);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
        }

        return view;
    }

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
        void onFragmentInteraction(Uri uri);
    }
}
