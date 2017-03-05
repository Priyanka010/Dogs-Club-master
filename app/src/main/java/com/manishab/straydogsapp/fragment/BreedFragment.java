package com.manishab.straydogsapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.manishab.straydogsapp.BreedinfoActivity;
import com.manishab.straydogsapp.MapsActivity;
import com.manishab.straydogsapp.R;
import com.manishab.straydogsapp.model.Breed;
import com.manishab.straydogsapp.viewholder.BreedListViewHolder;
import com.squareup.picasso.Picasso;

public class BreedFragment extends Fragment {
    RecyclerView rvBreed;
    FloatingActionButton mapfab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_breed_list, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("breed");

        rvBreed = (RecyclerView) root.findViewById(R.id.rv_breed);
        mapfab=(FloatingActionButton)root.findViewById(R.id.mapbutton);
        mapfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });
        rvBreed.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBreed.setHasFixedSize(true);
        rvBreed.setAdapter(new FirebaseRecyclerAdapter<Breed, BreedListViewHolder>(
                Breed.class, R.layout.item_breed, BreedListViewHolder.class, myRef) {
            @Override
            public void populateViewHolder(BreedListViewHolder holder, final Breed breed, int position) {
                Picasso.with(holder.itemView.getContext()).load(breed.getBreed_img()).into(holder.dogImage);
                holder.dogDescription.setText(breed.getBreed_info());
                holder.dogName.setText(breed.getBreed_name());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), BreedinfoActivity.class);
                        intent.putExtra("breed", breed);
                        startActivity(intent);
                    }
                });

            }
        });

        return root;
    }
}