package com.example.solis.fourseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mNumber;
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();

        mNumber.setText("Covered: " + mSeekBar.getProgress() + "/" + mSeekBar.getMax());

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress =0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                Toast.makeText(getApplicationContext(),"Changing Seekbar Progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Started Tracking Seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mNumber.setText("Covered: " + progress + "/" + mSeekBar.getMax());
                Toast.makeText(getApplicationContext(),"Stopped Tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeVariables() {
        mNumber = findViewById(R.id.number_TextView);
        mSeekBar = findViewById(R.id.seekbar_Seekbar);
    }
}
