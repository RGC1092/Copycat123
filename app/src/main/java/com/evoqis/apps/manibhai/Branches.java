package com.evoqis.apps.manibhai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class Branches extends AppCompatActivity {
    private BranchRecyclerAdapter recylerAdapter;
    private RecyclerView recyclerView;
    private static ArrayList<MandalPojo> data;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches);
        recyclerView =findViewById(R.id.branchRecycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.startAnimation(animation);
        data = new ArrayList<MandalPojo>();
        for (int i = 0; i < BranchData.nameArray.length; i++) {
            data.add(new MandalPojo(
                    BranchData.photoArray[i],
                    BranchData.nameArray[i],
                    BranchData.postArray[i]

            ));
        }
        recylerAdapter = new BranchRecyclerAdapter(data);
        recyclerView.setAdapter(recylerAdapter);
    }
}
