package com.manishab.straydogsapp;

import android.content.Intent;
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
    ImageView dogImage;
    TextView dog_name, information;
    TextView info;
    Breed breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_breed_detail);

        Intent intent = getIntent();
        breed = (Breed) getIntent().getSerializableExtra("breed");

        dogImage = (ImageView) findViewById(R.id.breed_img);
        dog_name = (TextView) findViewById(R.id.breed_name);
        information = (TextView) findViewById(R.id.breed_info);

        Picasso.with(this).load(breed.getBreed_img()).into(dogImage);
        info.setText(breed.getBreed_info());
        dog_name.setText(breed.getBreed_name());


    }
}


