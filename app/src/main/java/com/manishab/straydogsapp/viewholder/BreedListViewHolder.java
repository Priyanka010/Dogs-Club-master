package com.manishab.straydogsapp.viewholder;

import android.net.sip.SipAudioCall;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.manishab.straydogsapp.R;


public class BreedListViewHolder extends RecyclerView.ViewHolder {

    public ImageView dogImage;
    public TextView dogName;
    public TextView dogDescription;

    public BreedListViewHolder(View itemView) {
        super(itemView);
        dogImage = (ImageView) itemView.findViewById(R.id.breed_img);
        dogName = (TextView) itemView.findViewById(R.id.breed_name);
        dogDescription = (TextView) itemView.findViewById(R.id.breed_info);
        
         itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());

            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });

    }
    private BreedListViewHolder.ClickListener mClickListener;

    public void setOnClickListener(ClickListener listener){
        this.mClickListener= listener;
    }

    //Interface to send callbacks...
    public interface ClickListener{
        public void onItemClick(View view, int position);
        public void onItemLongClick(View view, int position);
    }
    
}
