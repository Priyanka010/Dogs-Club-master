package com.manishab.straydogsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.manishab.straydogsapp.model.Breed;
import com.squareup.picasso.Picasso;

/**
 * Created by priyanka on 3/4/17.
 */

public class BreedinfoActivity extends AppCompatActivity {

    Breed breed;

    ImageView dogImage;
    TextView info;
    TextView feed;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding_detail);

        breed = (Breed) getIntent().getSerializableExtra("breed");
        dogImage = (ImageView) findViewById(R.id.dog_img);
        info = (TextView) findViewById(R.id.info);
        feed = (TextView) findViewById(R.id.feed);
        name = (TextView) findViewById(R.id.name);

        Picasso.with(this).load(breed.getBreed_img()).into(dogImage);
        info.setText(breed.getBreed_info());
        name.setText(breed.getBreed_name());
        feed.setText(breed.getBreed_feed());
    }
}