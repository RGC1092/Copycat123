package com.evoqis.apps.manibhai;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener {

    ImageView mandal, branch, staff, calender, fdrates, emicalc, contactinfo, contactpersons, locations;
    TextView txt_link;
    Animation animFadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
        initListner();

    }

    private void initListner() {
        mandal.setOnClickListener(this);
        branch.setOnClickListener(this);
        staff.setOnClickListener(this);
        calender.setOnClickListener(this);
        fdrates.setOnClickListener(this);
        emicalc.setOnClickListener(this);
        contactinfo.setOnClickListener(this);
        contactpersons.setOnClickListener(this);
        locations.setOnClickListener(this);
        txt_link.setOnClickListener(this);

    }

    private void initUI() {


        txt_link = findViewById(R.id.txt_link);
        mandal = findViewById(R.id.img_mandal);
        branch = findViewById(R.id.img_branches);
        staff = findViewById(R.id.img_staff);
        calender = findViewById(R.id.img_calender);
        fdrates = findViewById(R.id.img_fd);
        emicalc = findViewById(R.id.img_emi_calc);
        contactinfo = findViewById(R.id.img_con_info);
        contactpersons = findViewById(R.id.img_con_person);
        locations = findViewById(R.id.img_locations);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_mandal:
                Intent a = new Intent(Home.this, Mandal.class);
                startActivity(a);

                break;
            case R.id.img_branches:
                Intent b = new Intent(Home.this, Branches.class);
                startActivity(b);

                break;
            case R.id.img_staff:
                Intent c = new Intent(Home.this, Bank_Staff.class);
                startActivity(c);
                break;
            case R.id.img_calender:
                Intent d = new Intent(Home.this, Calender.class);
                startActivity(d);
                break;
            case R.id.img_fd:
                Intent e = new Intent(Home.this, FDRates.class);
                startActivity(e);
                break;
            case R.id.img_emi_calc:
                Intent f = new Intent(Home.this, EmiCalc.class);
                startActivity(f);
                break;
            case R.id.img_con_info:
                Intent g = new Intent(Home.this, Contact_info.class);
                startActivity(g);
                break;
            case R.id.img_con_person:
                Intent h = new Intent(Home.this, Contact_persons.class);
                startActivity(h);
                break;
            case R.id.img_locations:
                Intent j = new Intent(Home.this, Others.class);
                startActivity(j);
                break;
            case R.id.txt_link:
                String url = "http://evoqis.in/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;

        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("तुम्हाला अॅप बंद करायचे आहे का ?");
        builder.setNegativeButton("नाही", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("हो ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
            }
        });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("सूचना");
        alert.show();
    }


}
