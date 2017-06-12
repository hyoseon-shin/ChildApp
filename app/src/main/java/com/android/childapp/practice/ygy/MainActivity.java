package com.android.childapp.practice.ygy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_ygy_main);

        Button stopWatchBtn = (Button)findViewById(R.id.stopwatch);

        View.OnClickListener stopWatchBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
                //startActivity(intent);
                //finish();
            }
        };

        stopWatchBtn.setOnClickListener(stopWatchBtnListener);

        Button startGame = (Button)findViewById(R.id.startgame);

        View.OnClickListener startGameBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameStartActivity.class);
                startActivity(intent);
                finish();
            }
        };

        startGame.setOnClickListener(startGameBtnListener);
    }
}
