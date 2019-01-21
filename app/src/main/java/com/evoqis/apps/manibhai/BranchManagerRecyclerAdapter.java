package com.evoqis.apps.manibhai;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BranchManagerRecyclerAdapter {
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewname,textViewpost;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.rec_img);
            this.textViewname=itemView.findViewById(R.id.rec_name);
            this.textViewpost=itemView.findViewById(R.id.rec_post);
        }
    }

}
