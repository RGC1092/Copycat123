package com.evoqis.apps.manibhai;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.Properties;

public class Contact_persons extends AppCompatActivity {
    EditText edt_clientName,edt_mobileNumber,edt_description,edt_email;
    Spinner spi_clientType,spi_enqryType;
    Button btn_submit;
    String clientName,mobileNumber,email,descriptions,clienttype,enqrytype;
    java.util.ArrayList<String> clientlist = new java.util.ArrayList<>();
    java.util.ArrayList<String> typelist = new java.util.ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_persons);
        edt_clientName=findViewById(R.id.clientname);
        edt_mobileNumber=findViewById(R.id.clientmobile);
        edt_description=findViewById(R.id.description);
        edt_email=findViewById(R.id.clientemail);
        spi_clientType=findViewById(R.id.clienttype);
        spi_enqryType=findViewById(R.id.enqrytype);
        btn_submit=findViewById(R.id.submit);


        clientlist.add("New Client") ;
        clientlist.add("Already Client");
        ArrayAdapter<String> clientadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,clientlist);
        spi_clientType.setAdapter(clientadapter);

        typelist.add("Saving");
        typelist.add("Laon");
        typelist.add("Fix Deposit");
        typelist.add("Recuring Deposit");

        ArrayAdapter<String> typeadapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,typelist);
        spi_enqryType.setAdapter(typeadapter);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clientName=edt_clientName.getText().toString().trim();
                mobileNumber=edt_mobileNumber.getText().toString().trim();
                email=edt_email.getText().toString().trim();
                descriptions=edt_description.getText().toString().trim();
                clienttype=spi_clientType.getSelectedItem().toString().trim();
                enqrytype=spi_enqryType.getSelectedItem().toString().trim();
                sendEmail();
            }
        });

    }
    protected void sendEmail() {

        String TO ="drmdpatsanstha@gmail.com";
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enquity");
        emailIntent.putExtra(Intent.EXTRA_TEXT, descriptions);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();

        } catch (android.content.ActivityNotFoundException ex) {

        }
    }
}
