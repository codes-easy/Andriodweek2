package com.example.andriodweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        TextView selectWowText = findViewById(R.id.selected_wow);

        Spinner wow_spinner = findViewById(R.id.wow);
        String[] wow_names = {"TajMahal", "The Colosseum", "The Great Wall of China", "Machu Picchu", "Petra"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_row,
                R.id.row_wow_name,
                wow_names);

        wow_spinner.setAdapter(adapter);
        wow_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectWowText.setText(wow_names[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                selectWowText.setText(wow_names[i]);
//
//            }
        });

        ListView wowList = findViewById(R.id.list);
        String[] list_wow_names = {"TajMahal", "The Colosseum",
                "The Great Wall of China", "Machu Picchu", "Petra",
                "Christ the Redeemer", "Chichén Itzá"};
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,
                R.layout.list_raw,
                R.id.row_list_wow_name,
                list_wow_names);

        wowList.setAdapter(listAdapter);
         wowList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(FourthActivity.this,
                        "The selected wonder of world is " + list_wow_names[i],
                        Toast.LENGTH_LONG).show();

            }
        });


    }
}
