package com.evoqis.apps.manibhai;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Evoqis on 15/12/2017.
 */

public class MandalRecylerAdapter extends RecyclerView.Adapter<MandalRecylerAdapter.MyViewHolder> {
    private ArrayList<MandalPojo> dataSet;

    public MandalRecylerAdapter(ArrayList<MandalPojo> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mandal_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        try {
            ImageView image = holder.imageView;
            TextView name = holder.textViewname;
            TextView post = holder.textViewpost;
            name.setText(dataSet.get(position).getName());
            post.setText(dataSet.get(position).getPost());
            image.setImageResource(dataSet.get(position).getImages());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

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
