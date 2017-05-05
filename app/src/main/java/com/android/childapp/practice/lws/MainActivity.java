package com.android.childapp.practice.lws;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_lws_main);

    }

    public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(), "사랑해요 :)", Toast.LENGTH_LONG).show();
    }
}
