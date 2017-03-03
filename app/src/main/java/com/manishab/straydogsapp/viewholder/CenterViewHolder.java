package com.manishab.straydogsapp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.manishab.straydogsapp.R;

public class CenterViewHolder extends RecyclerView.ViewHolder {
    public ImageView centerImage;
    public TextView CenterName;
    public TextView CenterDescription;

    public CenterViewHolder(View itemView) {
        super(itemView);
        centerImage = (ImageView) itemView.findViewById(R.id.center_img);
        CenterName = (TextView) itemView.findViewById(R.id.center_name);
        CenterDescription = (TextView) itemView.findViewById(R.id.center_info);
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
    private CenterViewHolder.ClickListener mClickListener;

    public void setOnClickListener(ClickListener listener){
        this.mClickListener=listener;
    }

    //Interface to send callbacks...
    public interface ClickListener{
        public void onItemClick(View view, int position);
        public void onItemLongClick(View view, int position);
    }
    
}
