package com.example.timingtimingtiming;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewTime, textViewPoints;
//    ImageView imageView1, imageView2;
    private int seconds = 10, points = 0;
    private boolean runner = true;

    private ArrayList<ImageView> images = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewTime = (TextView) findViewById(R.id.time1TextView);
        textViewPoints = (TextView) findViewById(R.id.pointsTextView);

        images.add(findViewById(R.id.imageView1));
        images.add(findViewById(R.id.imageView2));
        showRandomPicture();
        countSeconds();
    }

    private void countSeconds()
    {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(runner) {
                    seconds--;
                    showRandomPicture();
                    textViewTime.setText(Integer.toString(seconds));
                    if(seconds == 0)
                        runner = false;
                }
                else if(!runner)
                    textViewPoints.setText("KOOONIEC");

                handler.postDelayed(this, 1000);
            }
        });
    }

    private void showRandomPicture()
    {
        for(ImageView imageView:images)
        {
            imageView.setVisibility(View.INVISIBLE);
        }

        int randomNum = (int)(Math.random()*images.size());
        images.get(randomNum).setVisibility(View.VISIBLE);
        images.get(randomNum).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        points++;
                        textViewPoints.setText("Punkty: " +
                                Integer.toString(points));
                        showRandomPicture();
                    }
                }
        );
    }
}