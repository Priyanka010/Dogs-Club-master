package com.manishab.straydogsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.manishab.straydogsapp.model.Breed;

/**
 * Created by priyanka on 3/4/17.
 */

public class FeedinginfoActivity extends AppCompatActivity {

    TextView dog_name, information;
    Breed breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_feed_detail);

        Intent intent = getIntent();
        breed = (Breed) getIntent().getSerializableExtra("breed");


        dog_name = (TextView) findViewById(R.id.breed_name);
        information = (TextView) findViewById(R.id.breed_feed);

        information.setText(breed.getBreed_feed());
        dog_name.setText(breed.getBreed_name());


    }
}


