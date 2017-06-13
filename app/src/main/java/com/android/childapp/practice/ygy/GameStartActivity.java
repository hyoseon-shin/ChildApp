package com.android.childapp.practice.ygy;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import com.android.childapp.R;

import static com.google.android.gms.internal.a.R;

public class GameStartActivity extends AppCompatActivity {

    Chronometer chronometer;
    static int status = 0;                     // 0:stop, 1:running, 2:pause
    long PausedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_ygy_startgame);

        // 기본 변수 초기화
        init();

    }

    public void init(){
        initChronometer();              // chronometer
    }

    public void initChronometer(){
        chronometer = (Chronometer)findViewById(R.id.chronometer);
    }

    public void startChronometer(){
        chronometer.setBase(SystemClock.elapsedRealtime() + PausedTime);
        chronometer.start();
        status = 1;
    }

    public void stopChronometer(){
        chronometer.setBase(SystemClock.elapsedRealtime());
        status = 0;
        PausedTime = 0;
    }

    public void pauseChronometer(){
        chronometer.stop();
        PausedTime = chronometer.getBase() - SystemClock.elapsedRealtime();
        status = 2;
    }

}
