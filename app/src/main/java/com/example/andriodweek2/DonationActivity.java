package com.example.andriodweek2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class DonationActivity extends AppCompatActivity {
RadioButton PaypalRB;
RadioButton CCRB;
EditText amountText;
Donation currentDonation = new Donation(0,0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        PaypalRB = findViewById(R.id.ppRB);
        CCRB = findViewById(R.id.ccRB);
        //amountText = findViewById(R.id.amountText);
               Log.d("Andriodweek2", currentDonation.getDonationInfo());

        Button donate_button = findViewById(R.id.donatebutton);
        donate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUI()){
                    int Pmt_method = (CCRB.isChecked() ? 1 :0);
                    double amount = Double.parseDouble(amountText.getText().toString());
                    Donation d = new Donation(amount, Pmt_method);

                    Donation currentDonation = new Donation(0,0);
                    Log.d("Andriodweek2", currentDonation.getDonationInfo());

                    showAlert(currentDonation);

                // Toast.makeText(DonationActivity.this, "Thank you for your Donation" + amount, Toast.LENGTH_SHORT).show();
                }

            }
        });
        }

        boolean validateUI(){

        boolean valid = false;
        if (!amountText.getText().toString().isEmpty() &&
                ( PaypalRB.isChecked() || CCRB.isChecked()))
            valid = true;
        return valid;


        }
        void showAlert (Donation d){
            // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
            AlertDialog.Builder builder = new AlertDialog.Builder(this );

// 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage("Thank you for your donation" + d.amount + "donation.")
                    .setTitle("All done");

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
            builder.setNegativeButton("Ok", null);
            builder.setPositiveButton("Show a report", (new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Opening a report
                            Intent toReport = new Intent(DonationActivity.this, ReportActivity.class);
                            toReport.putExtra("donationObject", d);
                            String pmtMethod = (d.paymentMethod ==0 ? "Paypal" : "Credit Card");
                            toReport.putExtra("msg", "Your donation amount is  $ " + d.amount + " via " + pmtMethod  );
                            startActivity(toReport);

                        }
                    }));
            builder.create().show();
        }

    }
