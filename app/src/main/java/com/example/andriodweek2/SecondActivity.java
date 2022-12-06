package com.example.andriodweek2;
import static com.example.andriodweek2.R.id.returnToMain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
    static int GoodCode = 100;
    static int BadCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        TextView secact = findViewById(R.id.SecActivity);
        EditText valueTF = findViewById(R.id.value);

        if (getIntent().hasExtra("FirstValue")) {
            String v = getIntent().getExtras().getString("FirstValue");
            String S2 = getIntent().getExtras().getString("SecondValue");
            secact.setText(S2 + v);

        }

        Button backtoMain = findViewById(R.id.returnToMain);
        backtoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valueTF.getText().toString().isEmpty()){
                    Intent resultIntent = new Intent();
                    setResult(BadCode,resultIntent);
                    finish();

                } else {
                 Intent resultIntent = new Intent();
                    // function to check if the string is integer before parsing
                    resultIntent.putExtra("MFSTM", Integer.parseInt( valueTF.getText().toString()));
                    setResult(GoodCode,resultIntent);

                    finish();// dismiss
                }


            }
        });
    }
}
