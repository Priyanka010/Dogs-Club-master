package com.manishab.straydogsapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manishab.straydogsapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feedinginfofragment extends Fragment {
    TextView name,info;
    String nameofdog,information;


    public Feedinginfofragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed_detail, null);
        Bundle bundle1 = getArguments();
        String nameofdog = bundle1.getString("dogname");
        String information = bundle1.getString("foodinfo");

        name=(TextView)view.findViewById(R.id.breed_name);
        info=(TextView)view.findViewById(R.id.breed_info);

        name.setText(nameofdog);
        info.setText(information);


        return view;
    }

    public static Fragment newInstance(Bundle bundle) {
        Fragment fragment =  new Feedinginfofragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
