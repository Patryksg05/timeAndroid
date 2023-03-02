package com.example.timingtimingtiming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTime;
    private Button startBtn, stopBtn;
    int second = 0;
    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTime = (TextView) findViewById(R.id.textViewTimerUp);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        // time => klasa handler
        final Handler handler = new Handler(); // czas
        handler.post(new Runnable() { // .post(obiekt runnable)
            @Override
            public void run() {
                if(running) {
                    second++;
                    textViewTime.setText(Integer.toString(second));
                    // wywowalnie metody samej w sobie
                }
                handler.postDelayed(this, 1000); // ten handler, co ile
            }
        });

        stopBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(running)
                        {
                            running = false;
                            stopBtn.setText(("dalej"));
                        }
                        else
                        {
                            running = true;
                            stopBtn.setText("stop");
                        }
                    }
                }
        );

    }
}