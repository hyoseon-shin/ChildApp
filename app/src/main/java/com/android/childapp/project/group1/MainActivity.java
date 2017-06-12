package com.android.childapp.project.group1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.childapp.R;

/**
 * Created by sjyoon on 2017-04-28.
 */

public class MainActivity extends AppCompatActivity {

    private TextView mTxtNumber1;
    private TextView mTxtNumber2;
    private TextView mTxtNumber3;
    private TextView mTxtNumber4;
    private TextView mTxtNumber5;
    private TextView mTxtNumber6;
    private TextView mTxtNumber7;
    private TextView mTxtNumber8;
    private TextView mTxtNumber9;
    private TextView mTxtNumber10;

    private int mFirstValue = 0;
    private int mSecondValue = 0;

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;

    private int mMinValue = 0;
    private int mMaxValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_group1_main);

        initResource();
        initPosition();

        setData();
    }

    private void initResource() {
        mTxtNumber1 = (TextView) findViewById(R.id.project_group1_num1);
        mTxtNumber2 = (TextView) findViewById(R.id.project_group1_num2);
        mTxtNumber3 = (TextView) findViewById(R.id.project_group1_num3);
        mTxtNumber4 = (TextView) findViewById(R.id.project_group1_num4);
        mTxtNumber5 = (TextView) findViewById(R.id.project_group1_num5);
        mTxtNumber6 = (TextView) findViewById(R.id.project_group1_num6);
        mTxtNumber7 = (TextView) findViewById(R.id.project_group1_num7);
        mTxtNumber8 = (TextView) findViewById(R.id.project_group1_num8);
        mTxtNumber9 = (TextView) findViewById(R.id.project_group1_num9);
        mTxtNumber10 = (TextView) findViewById(R.id.project_group1_num10);

        mBtn1 = (Button) findViewById(R.id.project_group1_btn1);
        mBtn2 = (Button) findViewById(R.id.project_group1_btn2);
        mBtn3 = (Button) findViewById(R.id.project_group1_btn3);
        mBtn4 = (Button) findViewById(R.id.project_group1_btn4);
        mBtn5 = (Button) findViewById(R.id.project_group1_btn5);

        mTxtNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempText = mTxtNumber1.getText().toString();
                Toast.makeText(MainActivity.this, tempText, Toast.LENGTH_SHORT).show();
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.android.childapp.project.group1.ScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.android.childapp.project.group1.ScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initPosition() {
        // TODO: 위치 랜덤
    }

    private void setData() {

        //TODO: 난이도에 따라 min, max 세팅
        mMinValue = 1;
        mMaxValue = 9;

        mTxtNumber1.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber2.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber3.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber4.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber5.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber6.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber7.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber8.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber9.setText("" + getRandomValue(mMinValue, mMaxValue));
        mTxtNumber10.setText("" + getRandomValue(mMinValue, mMaxValue));
    }

    private int getRandomValue(int min, int max) {
        double randomValue = Math.random();
        return (int)(randomValue * max) + min;
    }
}
