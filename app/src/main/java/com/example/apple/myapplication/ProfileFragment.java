package com.example.apple.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    String  name;
    TextView textView;
    TextView textView2;
    TextView textView3;
    Button edit;
    TextView textView4;




    public ProfileFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment'
        name=getArguments().getString("name");
        Log.e("TAG",name);
        View view;

       // textView=(TextView) this.getView().findViewById(R.id.textView34);

        view=inflater.inflate(R.layout.fragment_profile, container, false);
        //View view1=view.findViewById(R.id.view);
        textView=(TextView)view.findViewById(R.id.textView);
        textView2=(TextView)view.findViewById(R.id.textView2);
        textView3=(TextView)view.findViewById(R.id.textViewBranch);
        textView4=(TextView)view.findViewById(R.id.textViewYear);

        String name="Shambhav";
        String College="IIT-BHU";
        String Year="17035041";
        String Dept=" Part 2 Ceramic  Engineering";
        textView.setText(name);
        textView2.setText(College);
        textView3.setText(Year);
        textView4.setText(Dept);
        return view;

    }



}
