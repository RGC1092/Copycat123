package com.evoqis.apps.manibhai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Switch;
import android.widget.TextView;

public class Bank_Staff extends AppCompatActivity  {
    TextView txtvst, txtsuv, txt1, txt2;
    Animation animation;
    View v1, v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank__staff);
        txtvst = findViewById(R.id.txtvst);
        // animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        txtsuv = findViewById(R.id.txtsuv);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
      /*  txtvst.startAnimation(animation);
        txtsuv.startAnimation(animation);*/
        String sHTML =
                "&nbsp;&#8226;पुणे जिल्ह्यातील अग्रेसर पतसंस्था <br><br>" +
                        "&nbsp;&#8226;ग्राहकांची विश्वासपात्र पतसंस्था<br><br>" +
                        "&nbsp;&#8226;२५ वर्षापासून पुणे जिल्ह्यात कार्यरत<br><br>" +
                        "&nbsp;&#8226;२५ वर्षे सातत्याने ऑडीट वर्ग 'अ'<br><br>" +
                        "&nbsp;&#8226;पहिल्या वर्षापासून सभासदांना लाभांश वाटप<br><br>" +
                        "&nbsp;&#8226;२७० कोटींचा संमिश्र व्यवसाय<br><br>" +
                        "&nbsp;&#8226;मुख्य कार्यालयासह स्वमालकीच्या तीन शाखा<br><br>" +
                        "&nbsp;&#8226;सर्व शाखा संगणकीकृत<br><br>" +
                        "&nbsp;&#8226;विनम्र व तत्पर सेवा<br><br>" +
                        "&nbsp;&#8226;सामाजिक बांधिलकीची जाणीव<br>" +
                        "</string>";
        String sshtml = "&nbsp;&#8226;वैयक्तिक कर्ज <br><br>" +
                "&nbsp;&#8226;वाहन खरेदी कर्ज<br><br>" +
                "&nbsp;&#8226;घरबांधणी व फ्लॅट खरेदी कर्ज <br><br>" +
                "&nbsp;&#8226;व्यवसाय वाढ कर्ज<br><br>" +
                "&nbsp;&#8226;मालतारण कर्ज<br><br>" +
                "&nbsp;&#8226;सोनेतारण कर्ज<br><br>" +
                "&nbsp;&#8226;अधिकृत वीज बिल भरणा केंद्र (महाराष्ट्र राज्य वीज वितरण कंपनीचे)<br><br>" +
                "&nbsp;&#8226;लॉकर्स <br><br>" +
                "&nbsp;&#8226;वपॅनकार्ड सुविधा<br><br>" +
                "&nbsp;&#8226;अॅट पार चेक<br><br>" +
                "&nbsp;&#8226;आर टी जी एस<br><br>" +
                "&nbsp;&#8226;एन ई एफ टी<br><br>" +
                "&nbsp;&#8226;ई-पेमेंट<br><br>" +
                "&nbsp;&#8226;एस एम एस सुविधा<br>" +
                "</string>";

        txtvst.setText(Html.fromHtml(sHTML, null, null));
        txtsuv.setText(Html.fromHtml(sshtml, null, null));


      txt1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              v1.setVisibility(View.VISIBLE);
              v2.setVisibility(View.INVISIBLE);
              txtvst.setVisibility(View.VISIBLE);
              txtsuv.setVisibility(View.GONE);
          }
      });

      txt2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              v2.setVisibility(View.VISIBLE);
              v1.setVisibility(View.INVISIBLE);
              txtvst.setVisibility(View.GONE);
              txtsuv.setVisibility(View.VISIBLE);
          }
      });


    }

}
