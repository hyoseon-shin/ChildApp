package com.android.childapp.practice.jmh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_jmh_main);
    }

    public void onClickBtnEvent(View v) {
        txtResult.setText("Good Job!");
    }
}
