package com.example.apple.myapplication;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {

    GraphView bar_Graph;
    String type;
    private OnFragmentInteractionListener mListener;

    public EventsFragment() {
        // Required empty public constructor
    }


    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();

        return fragment;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    public void setmListener(OnFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        View view=inflater.inflate(R.layout.fragment_events, container, false);
        bar_Graph = (GraphView) view.findViewById(R.id.line_graph);
        LineGraphSeries<DataPoint> barGraph_Data = null;
        DataPoint[] dataPoint;
        int i=0;
        dataPoint = ((new DataPoint[3]));
        if(type.contains("CP"))
        {

        dataPoint[0] = new DataPoint(1, 8.2);

        dataPoint[1] = new DataPoint(2,8.06);
        dataPoint[2] = new DataPoint(3,8.01);

        }
        else
        {


            dataPoint[0] = new DataPoint(1, 8.2);

            dataPoint[1] = new DataPoint(2,7.93);
            dataPoint[2] = new DataPoint(3,7.90);
            barGraph_Data = new LineGraphSeries<>(dataPoint);
            bar_Graph.addSeries(barGraph_Data);
        }
        barGraph_Data = new LineGraphSeries<>(dataPoint);
        bar_Graph.addSeries(barGraph_Data);

        return view;
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


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
