package com.evoqis.apps.manibhai;


import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmiCalc extends ListActivity {
    EditText et_amount, et_period, et_rate;
    double principal, rate, emi;
    double intrest, balance, intramt, rate1;
    Button btn_calculate;

    int i = 1, time;

    ArrayList<HashMap<String, String>> prolist = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

    //TextView txt_emi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calc);
        et_amount = findViewById(R.id.et_amount);
        et_period = findViewById(R.id.et_period);
        et_rate = findViewById(R.id.et_rate);
       /* txt_emi=findViewById(R.id.txt_emi);
        txt_emi.setVisibility(View.GONE);*/
        btn_calculate = findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    principal = Double.parseDouble(et_amount.getText().toString().trim());
                    time = Integer.parseInt(et_period.getText().toString().trim());
                    rate = Double.parseDouble(et_rate.getText().toString().trim());
                    rate1 = rate;
                    balance = principal;
                    rate = (rate / 12) / 100;
                    emi = (principal * rate * (Math.pow((1 + rate), time)) / ((Math.pow((1 + rate), time)) - 1));
                    String result = new DecimalFormat("##.##").format(emi);
                   /*txt_emi.setVisibility(View.VISIBLE);
                   txt_emi.setText("दरमहा हफ्ता "+result+" रुपये");*/
                    String bal = new DecimalFormat("##.##").format(principal);
                    while (i < time) {


                        HashMap<String, String> map = new HashMap<String, String>();
                        String srno = new DecimalFormat("##.##").format(i);
                        map.put("srno",srno);



                        intramt = (balance * rate1) / 1200;//intrestamt
                        String intr = new DecimalFormat("##.##").format(intramt);
                        map.put("intrest", intr);

                        intrest = emi - intramt;//principle
                        String intrs = new DecimalFormat("##.##").format(intrest);
                        map.put("principle", intrs);


                        bal = new DecimalFormat("##.##").format(balance);
                        map.put("balance", bal);
                        balance = balance - intrest;//remambalace

                        map.put("emi", result);
                        mylist.add(map);
                        i++;
                    }
                    prolist=mylist;

                    if (prolist.size() != 0) {
                        ListAdapter adapter = new SimpleAdapter(EmiCalc.this, prolist, R.layout.emi_list,
                                new String[]{"srno", "balance", "principle", "intrest", "emi"},
                                new int[]{R.id.srno, R.id.balance, R.id.principle, R.id.intrest, R.id.emi}
                        );
                        setListAdapter(adapter);
                    }
                    View views = getCurrentFocus();
                    if (views != null) {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }

                } catch (Exception e) {
                    Toast.makeText(EmiCalc.this, "संपूर्ण माहिती भरा ", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
