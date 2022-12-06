package com.example.andriodweek2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static int GoodCode = 100;
    static int BadCode = 0;

    ActivityResultLauncher<Intent> secondActivityLauncher;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Log.d("Week2app", "On create");
         EditText firstact = findViewById(R.id.valuefirstactivity);
         Button tosecond = findViewById(R.id.tosecondactivity);
         Button tothird = findViewById(R.id.tothirdactivity);
         this.setTitle("Week 2 App");


         secondActivityLauncher = registerForActivityResult(
                 new ActivityResultContracts.StartActivityForResult(),
                 new ActivityResultCallback<ActivityResult>() {

                     @Override
                     public void onActivityResult(ActivityResult result) {
                         if (result.getResultCode() == GoodCode) { //
                             Intent resultIntent = result.getData();
                             int value = resultIntent.getExtras().getInt("MFSTM");
                             Log.d("Week2App", "value for second activity " + value);
                         } else if (result.getResultCode() == BadCode) {
                             Log.d("Week2App", "No value from second activity");

                         }

                     }
                 }
         );
         tosecond.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                 if (!firstact.getText().toString().isEmpty()) {
                     String value = firstact.getText().toString();
                     Intent firstIntent = new Intent(MainActivity.this, SecondActivity.class);
                     startActivity(firstIntent);
                     firstIntent.putExtra("FirstValue", value);
                     firstIntent.putExtra("SecondValue", "Value from first activity : ");
                     secondActivityLauncher.launch(firstIntent);

                 }
             }
         });
         tothird.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent secondIntent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(secondIntent);

    }
    });
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean flag = true;
        switch (item.getItemId()){
            case R.id.tosecondactivity:
                Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondIntent);
                break;
            case R.id.tothirdactivity:
                Intent thirdIntent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(thirdIntent);
                break;

            case R.id.ToForthActivity:
                Intent forthIntent = new Intent(MainActivity.this, FourthActivity.class);
                startActivity(forthIntent);
                break;

            case R.id.ToDonationActivity:
                Intent fifthIntent = new Intent(MainActivity.this, DonationActivity.class);
                startActivity(fifthIntent);
                break;


            case R.id.exit:
                finish();

        }
        return flag;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Week2app","On Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Week2app","On Resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Week2app","On Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Week2app","On Restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Week2app","On Stop");
    }

}



