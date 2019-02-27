package com.example.apple.myapplication;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ElectricProfFragment.OnFragmentInteractionListener {
    String  name="";
    TextView textView;
    TextView textView2;
    TextView textView3;
    Button edit;
    TextView textView4;
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;


    public void setName(String name) {
        this.name = name;
    }

    public ProfileFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment'

        View view;


        // textView=(TextView) this.getView().findViewById(R.id.textView34);

        view=inflater.inflate(R.layout.fragment_profile, container, false);

        mCustomPagerAdapter = new CustomPagerAdapter(getChildFragmentManager(), getContext());
        if(!name.isEmpty()) {
            TabLayout tabLayout = view.findViewById(R.id.tabs);
            mViewPager = (ViewPager) view.findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            tabLayout.setupWithViewPager(mViewPager);

        }

        return view;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class CustomPagerAdapter extends FragmentPagerAdapter {

        Context mContext;

        public CustomPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {

            // Create fragment object
            Fragment fragment = new ElectricProfFragment();

            // Attach some data to the fragment
            // that we'll use to populate our fragment layouts
            Bundle args = new Bundle();
            args.putInt("page_position", position + 1);

            // Set the arguments on the fragment
            // that will be fetched in the
            // DemoFragment@onCreateView
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {
            if (name.equals("jan") || name.equals("mar") || name.equals("may") || name.equals("july") || name.equals("aug") || name.equals("oct") || name.equals("dec"))
                return 31;
            else if (name.equals("apr") || name.equals("jun") || name.equals("sep") || name.equals("nov"))
                return 30;
            else if (name.equals("feb"))
                return 28;
            else if (name.contains("courses")) {
                return 14;
            } else if (name.contains("branches")) {
                return 3;
            }
            else return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(name.contains("courses"))
            {
                if(position<8)
                {
                    return String.valueOf("Sem "+(position+1));
                }
                else if(position<10)
                {
                    return String.valueOf("IDD Sem " +( position+1));
                }
                else
                {
                    return String.valueOf("M.Tech Sem "+ (position-9));
                }
            }
            else if(name.contains("branches"))
            {
                switch (position)
                {
                    case 0:
                        return "Mechanical";
                    case 1:
                        return "Electrical";
                    case 2:
                        return "Computer Science";

                }
            }
            return  String.valueOf(position + 1);
        }
    }

}
