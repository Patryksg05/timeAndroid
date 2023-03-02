package com.example.timingtimingtiming;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Zegar {
    private boolean runner;
    private int seconds = 3*60;
    private TextView timeTextView;
    private CountDownTimer timer;

    public Zegar(boolean runner, TextView timeTextView) {
        this.runner = runner;
        this.seconds = 180;
        this.timeTextView = timeTextView;
    }

    public boolean isRunner() {
        return runner;
    }

    public void setRunner(boolean runner) {
        this.runner = runner;
    }

    private void timeToFinish(int sec) {
        int minutes = sec/60;
        int second = sec - (minutes*60); // || sec%60
//        timeTextView.setText(Integer.toString(minutes));
        timeTextView.setText(String.format("%02d : %02d", minutes, second));
    }


    public void startTimer()
    {
        // startuje timer, ...., co ile sekund
        timer = new CountDownTimer(seconds*1000, 1000) {
            @Override
            public void onTick(long l) {
                // po kazdej zmianie ++ || -- || etc
                seconds = (int)l/1000;
                timeToFinish(seconds);
            }

            @Override
            public void onFinish() {
                // jak skonczysz
                timeTextView.setText("koniec!");
                //toDo: wylacz guzik etc nic nie da sie zrobic
            }
        };
        timer.start();
        runner = true;
    }

    public void stopTimer()
    {
        timer.cancel();
        runner = false;
    }
}
