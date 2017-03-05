package com.manishab.straydogsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by priyanka on 3/5/17.
 */

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView textView;
        textView=(TextView)findViewById(R.id.About);
        textView.setText("Dogs club is an online community for people who are compassionate about dogs.DogsClub lets you make intelligent decision when it comes to your dogs bringing you more joy by keeping your dog healthy and happy.Also a new initiative from DogsClub is providing you information about dog center so that if you saw a stray dog in a poor condition then you can directly contact to your nearby center by looking up the maps provided.We believe we can make the dogs world a better place.");
    }
}
