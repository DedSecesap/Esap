package com.example.apple.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MarksDistributionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MarksDistributionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarksDistributionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    List<MarksModel> marksModels;
    private OnFragmentInteractionListener mListener;

    public MarksDistributionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarksDistributionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarksDistributionFragment newInstance(String param1, String param2) {
        MarksDistributionFragment fragment = new MarksDistributionFragment();
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
        View view= inflater.inflate(R.layout.fragment_marks_distribution, container, false);
        recyclerView=view.findViewById(R.id.grade_d_list);
        marksModels=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        marksModels.add(new MarksModel("1","A*","100","92","5",false));
        marksModels.add(new MarksModel("2","A","91","82","10",false));
        marksModels.add(new MarksModel("3","A-","81","72","15",true));
        marksModels.add(new MarksModel("4","B","71","62","25",false));
        marksModels.add(new MarksModel("5","B-","61","52","15",false));
        marksModels.add(new MarksModel("6","C","51","42","12",false));
        marksModels.add(new MarksModel("7","C-","41","31","8",false));
        marksModels.add(new MarksModel("8","F","30","0","10",false));
        MarksAdapter marksAdapter=new MarksAdapter(marksModels);
        recyclerView.setAdapter(marksAdapter);



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
