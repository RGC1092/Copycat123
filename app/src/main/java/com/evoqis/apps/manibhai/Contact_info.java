package com.evoqis.apps.manibhai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Contact_info extends AppCompatActivity {
    ImageView office;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        office=findViewById(R.id.office);
        animation=AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        office.startAnimation(animation);
    }
}
