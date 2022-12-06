package com.example.andriodweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class DonationActivity extends AppCompatActivity {
RadioButton PaypalRB;
RadioButton CCRB;
EditText amountText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        PaypalRB = findViewById(R.id.ppRB);
        CCRB = findViewById(R.id.ccRB);
        amountText = findViewById(R.id.amountText);




        Button donate_button = findViewById(R.id.donatebutton);
        donate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUI()){
//
                    int Pmt_method = (CCRB.isChecked() ? 1 :0);
                    double amount = Double.parseDouble(amountText.getText().toString());

                    Donation d = new Donation(amount, Pmt_method);

                    Toast.makeText(DonationActivity.this, "Thank you for your Donation" + amount, Toast.LENGTH_SHORT).show();
                }

            }
        });
        }

        boolean validateUI(){

        boolean valid = false;
        if (amountText.getText().toString().isEmpty() &&
                ( PaypalRB.isChecked() || CCRB.isChecked()))
            valid = true;
        return valid;


        }
    }
