package com.example.numberdraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mDisplayText;
    private Button mPlay;
    private EditText mMax, mMin;
    private int max = 10, min = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayText = findViewById(R.id.mDisplayInfo);
        mPlay = findViewById(R.id.mPlay);
        mMax = findViewById(R.id.mMax);
        mMin = findViewById(R.id.mMin);
        Button mRangeBtn = findViewById(R.id.mRangeBtn);

        mDisplayText.setVisibility(View.INVISIBLE);
        play(min, max);

        mRangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maxText = mMax.getText().toString();
                String minText = mMin.getText().toString();
                mDisplayText.setVisibility(View.INVISIBLE);

                if (maxText.matches("") || minText.matches("")) {
                    max = 10;
                    min = 0;
                    Toast.makeText(getApplicationContext(), "No input value means default results!", Toast.LENGTH_SHORT).show();
                }else if (Integer.parseInt(maxText) <= Integer.parseInt(minText)){
                    Toast.makeText(getApplicationContext(), "Max number is lower or equal to min number!", Toast.LENGTH_SHORT).show();
                    max = 10;
                    min = 0;
                    mMax.getText().clear();
                    mMin.getText().clear();
                }else{
                    max = Integer.parseInt(maxText);
                    min = Integer.parseInt(minText);
                    Toast.makeText(getApplicationContext(), "Range set to " + min + " - " + max + ".", Toast.LENGTH_SHORT).show();
                }
                play(min, max);
            }
        });
    }

    private void play(final int min, final int max) {
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = new Random().nextInt((max - min)+ 1) + min;
                String displayText = "Your number is: " + randomInt;
                mDisplayText.setText(displayText);
                mDisplayText.setVisibility(View.VISIBLE);
            }
        });
    }
}
