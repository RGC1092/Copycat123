package com.evoqis.apps.manibhai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class Mandal extends AppCompatActivity {
 private MandalRecylerAdapter recylerAdapter;
 private RecyclerView recyclerView;
    private static ArrayList<MandalPojo> data;
    Animation animFadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandal);
        recyclerView =findViewById(R.id.mandalRecycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setHasFixedSize(true);
        recyclerView.setClickable(true);
        recyclerView.startAnimation(animFadein);
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<MandalPojo>();
        for (int i = 0; i < MandalData.nameArray.length; i++) {
            data.add(new MandalPojo(
                    MandalData.photoArray[i],
                    MandalData.nameArray[i],
                    MandalData.postArray[i]

            ));
        }
        recylerAdapter = new MandalRecylerAdapter(data);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recylerAdapter);
    }
}
