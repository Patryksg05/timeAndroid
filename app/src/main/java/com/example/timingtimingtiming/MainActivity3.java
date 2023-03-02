package com.example.timingtimingtiming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    // zegar czasowy
    // powiadomienia => https://www.google.com/search?q=notifications+in+android+studio&oq=notifications+in+and&aqs=chrome.1.0i19i512l2j69i57j0i19i512l6j0i19i22i30.7299j1j1&sourceid=chrome&ie=UTF-8#fpstate=ive&vld=cid:20b4b418,vid:4BuRMScaaI4

    private Button timeButton;
    private TextView user1, user2;
    Zegar watch1, watch2;

    int user1Time = 3*60, user2Time = user1Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        timeButton = (Button) findViewById(R.id.timeBtn);
        user1 = (TextView) findViewById(R.id.time1);
        user2 = (TextView) findViewById(R.id.time2);

        watch1 = new Zegar(true, user1);
        watch1.startTimer();
        watch2 = new Zegar(false, user2);

        timeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(watch1.isRunner())
                        {
                            watch1.stopTimer();
                            timeButton.setText("user2");
                            watch2.startTimer();
                        }
                        else
                        {
                            watch2.stopTimer();
                            timeButton.setText("user1");
                            watch1.startTimer();
                        }
                    }
                }
        );

        Handler handler = new Handler();

    }
}