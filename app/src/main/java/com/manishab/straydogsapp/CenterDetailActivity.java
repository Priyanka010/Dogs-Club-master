package com.manishab.straydogsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.manishab.straydogsapp.model.Center;
import com.squareup.picasso.Picasso;

/**
 * Created by priyanka on 3/4/17.
 */


    public class CenterDetailActivity extends AppCompatActivity {
        Center center;

        ImageView centerImage;
        TextView info;
        TextView name;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_center_detail);

            center = (Center) getIntent().getSerializableExtra("center");
            centerImage = (ImageView) findViewById(R.id.center_img);
            info = (TextView) findViewById(R.id.info);
            name = (TextView) findViewById(R.id.name);

            Picasso.with(this).load(center.getCenter_img()).into(centerImage);
            info.setText(center.getCenter_info());
            name.setText(center.getCenter_name());
        }
    }

