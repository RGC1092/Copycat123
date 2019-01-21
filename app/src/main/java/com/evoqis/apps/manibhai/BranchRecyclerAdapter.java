package com.evoqis.apps.manibhai;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Evoqis on 16/12/2017.
 */

public class BranchRecyclerAdapter extends RecyclerView.Adapter<BranchRecyclerAdapter.MyViewHolder>  {
    private ArrayList<MandalPojo> dataSet;
    public BranchRecyclerAdapter(ArrayList<MandalPojo> dataSet) {
        this.dataSet = dataSet;
    }
    @Override
    public BranchRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.branches, parent, false);
        BranchRecyclerAdapter.MyViewHolder myViewHolder = new BranchRecyclerAdapter.MyViewHolder(view);

        return myViewHolder;

    }
    @Override
    public void onBindViewHolder(BranchRecyclerAdapter.MyViewHolder holder, int position) {
        ImageView image=holder.imageView;
        TextView name=holder.textViewname;
        TextView post=holder.textViewpost;
        name.setText(dataSet.get(position).getName());
        post.setText(dataSet.get(position).getPost());
        image.setImageResource(dataSet.get(position).getImages());

    }@Override
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
            this.textViewname=itemView.findViewById(R.id.branch_name);
            this.textViewpost=itemView.findViewById(R.id.branch_address);
        }
    }
}
