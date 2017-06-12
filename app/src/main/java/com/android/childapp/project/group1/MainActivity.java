package com.android.childapp.project.group1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.childapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sjyoon on 2017-04-28.
 */

public class MainActivity extends AppCompatActivity {

    private TextView mTxtTopNumber;

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

    private String[] mValues;

    private int mMinValue = 0;
    private int mMaxValue = 0;

    private int mTopValue = 0;
    private int mFirstValue = 0;
    private int mSecondValue = 0;

    private int mClickCnt = 0;

    private int mMinValue = 0;
    private int mMaxValue = 0;

    private InterstitialAd mInterstitialAd;
    AdView main_Banner_AdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_group1_main);

        initResource();
        initPosition();

        setData();

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id2));


        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("4B1E6F58F8A5EC1284F577F8C18FB3C4")
                    .build();
            mInterstitialAd.loadAd(adRequest);
        }
    }

    private void initResource() {
        mTxtTopNumber = (TextView) findViewById(R.id.project_group1_topnumber);

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

        mTxtNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(1)) {
                    mTxtNumber1.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(2)) {
                    mTxtNumber2.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(3)) {
                    mTxtNumber3.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(4)) {
                    mTxtNumber4.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(5)) {
                    mTxtNumber5.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(6)) {
                    mTxtNumber6.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(7)) {
                    mTxtNumber7.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(8)) {
                    mTxtNumber8.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(9)) {
                    mTxtNumber9.setTextColor(Color.CYAN);
                }
            }
        });
        mTxtNumber10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(10)) {
                    mTxtNumber10.setTextColor(Color.CYAN);
                }
            }
        });
    }

    private void initPosition() {
        // TODO: 위치 랜덤
    }

    private void setData() {

        //TODO: 난이도에 따라 min, max 세팅
        // 초급 2~9
        // 중급 8~19
        // 고급 21~99
        mMinValue = 2;
        mMaxValue = 9;

        mValues = null;
        mValues = new String[10];
        mValues[0] = getRandomValue(mMinValue, mMaxValue);
        mValues[1] = getRandomValue(mMinValue, mMaxValue);
        mValues[2] = getRandomValue(mMinValue, mMaxValue);
        mValues[3] = getRandomValue(mMinValue, mMaxValue);
        mValues[4] = getRandomValue(mMinValue, mMaxValue);
        mValues[5] = getRandomValue(mMinValue, mMaxValue);
        mValues[6] = getRandomValue(mMinValue, mMaxValue);
        mValues[7] = getRandomValue(mMinValue, mMaxValue);
        mValues[8] = getRandomValue(mMinValue, mMaxValue);
        mValues[9] = getRandomValue(mMinValue, mMaxValue);

        mTxtNumber1.setText(mValues[0]);
        mTxtNumber2.setText(mValues[1]);
        mTxtNumber3.setText(mValues[2]);
        mTxtNumber4.setText(mValues[3]);
        mTxtNumber5.setText(mValues[4]);
        mTxtNumber6.setText(mValues[5]);
        mTxtNumber7.setText(mValues[6]);
        mTxtNumber8.setText(mValues[7]);
        mTxtNumber9.setText(mValues[8]);
        mTxtNumber10.setText(mValues[9]);

        Random random = new Random();
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);

        mTopValue = Integer.parseInt(mValues[num1]) * Integer.parseInt(mValues[num2]);
        mTxtTopNumber.setText("" + mTopValue);

    }

    private boolean setNumber(int eventBtn) {
        boolean result = false;
        String tempText = "";

        if(eventBtn == 1) {
            tempText = mTxtNumber1.getText().toString();
        }
        else if(eventBtn == 2) {
            tempText = mTxtNumber2.getText().toString();
        }
        else if(eventBtn == 3) {
            tempText = mTxtNumber3.getText().toString();
        }
        else if(eventBtn == 4) {
            tempText = mTxtNumber4.getText().toString();
        }
        else if(eventBtn == 5) {
            tempText = mTxtNumber5.getText().toString();
        }
        else if(eventBtn == 6) {
            tempText = mTxtNumber6.getText().toString();
        }
        else if(eventBtn == 7) {
            tempText = mTxtNumber7.getText().toString();
        }
        else if(eventBtn == 8) {
            tempText = mTxtNumber8.getText().toString();
        }
        else if(eventBtn == 9) {
            tempText = mTxtNumber9.getText().toString();
        }
        else if(eventBtn == 10) {
            tempText = mTxtNumber10.getText().toString();
        }

        if(mClickCnt == 0) {
            mFirstValue = Integer.parseInt(tempText) ;
            result = true;
        }
        else if(mClickCnt == 1) {
            mSecondValue = Integer.parseInt(tempText);
            showBtn();
            result = true;
        }
        mClickCnt++;
        return  result;
    }

    private void showBtn() {
        // TODO: 답을 저장하여 버튼을 보여줌
        if(mTopValue == mFirstValue * mSecondValue) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, com.android.childapp.project.group1.ScoreActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "정답입니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(MainActivity.this, "오답입니다.", Toast.LENGTH_SHORT).show();
            finish();
        }

/*        String rightAnswer = "" + (mFirstValue * mSecondValue);

        String wrongAnswer1 = "" + (Integer.parseInt(mTxtNumber3.getText().toString()) * Integer.parseInt(mTxtNumber2.getText().toString()));
        String wrongAnswer2 = "" + (Integer.parseInt(mTxtNumber6.getText().toString()) * Integer.parseInt(mTxtNumber4.getText().toString()));
        String wrongAnswer3 = "" + (Integer.parseInt(mTxtNumber9.getText().toString()) * Integer.parseInt(mTxtNumber8.getText().toString()));

        List answer = new ArrayList<String>();
        answer.add(rightAnswer);
        answer.add(wrongAnswer1);
        answer.add(wrongAnswer2);
        answer.add(wrongAnswer3);

        ArrayList answerRandom = new ArrayList<Integer>();

        Random random = new Random();
        int size = answer.size();
        for(int i = 0; i < size; i++) {
            int rv = random.nextInt(answer.size());
            answerRandom.add(answer.get(rv));
            answer.remove(rv);
        }

        mBtn1.setText((String)answerRandom.get(0));
        mBtn2.setText((String)answerRandom.get(1));
        mBtn3.setText((String)answerRandom.get(2));
        mBtn4.setText((String)answerRandom.get(3));

        mBtnLayout.setVisibility(View.VISIBLE);*/
    }

    private void checkAnswer(int clickAnswer) {
        if(clickAnswer == mFirstValue * mSecondValue) {
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, com.android.childapp.project.group1.ScoreActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
            Toast.makeText(MainActivity.this, "정답입니다.", Toast.LENGTH_SHORT).show();
            showInterstitial();
            finish();
        }
        else {
            Toast.makeText(MainActivity.this, "틀렸습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private int getRandomValueInt(int min, int max) {
        Random random = new Random();
        int result = random.nextInt(max-min) + min;
        return result;
    }

    private String getRandomValue(int min, int max) {

        Random random = new Random();
        int result = random.nextInt(max-min) + min;
        return "" + result;
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
//            startGame();
        }
    }

}
