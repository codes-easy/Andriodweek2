package com.example.andriodweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        TextView msg = findViewById(R.id.reportText);
        if (getIntent().hasExtra("msg"))
            msg.setText(getIntent().getStringExtra("msg"));
        else
        msg.setText("No donation");

//       Parcelable[] dfromA = getIntent().getParcelableArrayExtra("donationObject");
//        String pmtMethod = (dfromA.paymentMethod == 0 ? "Paypal" : "Credit Card");


    }
}