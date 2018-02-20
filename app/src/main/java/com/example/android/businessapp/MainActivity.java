package com.example.android.businessapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View addressView = findViewById(R.id.address);
        View phoneView = findViewById(R.id.phone);
        View emailView = findViewById(R.id.email);
        View websiteView = findViewById(R.id.website);

        addressView.setClickable(true);
        phoneView.setClickable(true);
        emailView.setClickable(true);
        websiteView.setClickable(true);

        addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri geoLocation = Uri.parse("geo:47.8060805,7.6267819?z=19");
                Intent mapsIntent = new Intent(Intent.ACTION_VIEW);//open maps)
                mapsIntent.setData(geoLocation);
                if (mapsIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapsIntent);
                }
            }
        });

        phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + "+4976312976"));
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                }
            }
        });

        emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + "info@jakob-tv.de")); // only email apps should handle this
                //emailIntent.putExtra(Intent.EXTRA_EMAIL, ); //addresses
                //emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject); //subject
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });

        websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("http://www.jakob-tv.de");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
    }
}
