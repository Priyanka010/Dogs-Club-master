package com.manishab.straydogsapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.manishab.straydogsapp.CenterDetailActivity;
import com.manishab.straydogsapp.MapsActivity;
import com.manishab.straydogsapp.R;
import com.manishab.straydogsapp.model.Center;
import com.manishab.straydogsapp.viewholder.CenterViewHolder;
import com.squareup.picasso.Picasso;


public class CenterFragment extends Fragment{

    RecyclerView rvCenter;
    FloatingActionButton mapfab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_center_list, container, false);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("center");

        rvCenter = (RecyclerView) root.findViewById(R.id.rv_center);
        mapfab=(FloatingActionButton)root.findViewById(R.id.mapbutton);
        mapfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });

        rvCenter.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCenter.setHasFixedSize(true);
        rvCenter.setAdapter(new FirebaseRecyclerAdapter<Center, CenterViewHolder>(
                Center.class, R.layout.item_center, CenterViewHolder.class, myRef) {
                                @Override
                                public void populateViewHolder(CenterViewHolder holder, final Center center, int position) {
                                    Picasso.with(holder.itemView.getContext()).load(center.getCenter_img()).into(holder.centerImage);
                                    holder.CenterDescription.setText(center.getCenter_info());
                                    holder.CenterName.setText(center.getCenter_name());
                                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(getActivity(), CenterDetailActivity.class);
                                            intent.putExtra("center", center);
                                            startActivity(intent);
                                        }
                                    });
                                }
        });
        return root;
    }


}

    //    myRef.addChildEventListener(new ChildEventListener() {
//        @Override
//        public void onChildAdded (DataSnapshot dataSnapshot, String previousChildName){
//            Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());
//
//            // A new comment has been added, add it to the displayed list
//            Center center = dataSnapshot.getValue(Center.class);
//
//            // ...
//        }
//
//        @Override
//        public void onChildChanged (DataSnapshot dataSnapshot, String previousChildName){
//            Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());
//
//            // A comment has changed, use the key to determine if we are displaying this
//            // comment and if so displayed the changed comment.
//            Center center = dataSnapshot.getValue(Center.class);
//
//
//            // ...
//        }
//
//        @Override
//        public void onChildRemoved (DataSnapshot dataSnapshot){
//            Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());
//
//            // A comment has changed, use the key to determine if we are displaying this
//            // comment and if so remove it.
//            Center center = dataSnapshot.getValue(Center.class);
//
//            // ...
//        }
//
//        @Override
//        public void onChildMoved (DataSnapshot dataSnapshot, String previousChildName){
//            Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());
//
//            // A comment has changed position, use the key to determine if we are
//            // displaying this comment and if so move it.
//            Center center = dataSnapshot.getValue(Center.class);
//
//            // ...
//        }
//
//        @Override
//        public void onCancelled (DatabaseError databaseError){
//            Log.w(TAG, "postComments:onCancelled", databaseError.toException());
//            Toast.makeText(MainActivity.this, "Failed to load comments.",
//                    Toast.LENGTH_SHORT).show();
//        }
//    }




