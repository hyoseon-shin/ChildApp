package com.android.childapp.project.group1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.childapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sjyoon on 2017-04-28.
 */

public class MainActivity extends AppCompatActivity {

    private TextView mTime;
    private TextView mRightWrongCnt;

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

    private int mLevel = 0;
    private int mMinValue = 0;
    private int mMaxValue = 0;

    private int mRightCnt = 0;
    private int mWrongCnt = 0;

    private long mBaseTime = 0L;

    private final int TOTAL_QUESTION_CNT = 10;
    private int mCurrentQuestionCnt = 0;

    private int mTopValue = 0;
    private int mFirstValue = 0;
    private int mSecondValue = 0;

    private int mFirstClickEvent = 0;   // 첫번째 클릭한 곳
    private int mClickCnt = 0;           // 첫번째 클릭했는지 두번째 클릭했는지

    private InterstitialAd mInterstitialAd;
    AdView main_Banner_AdView;

    Handler myTimer = new Handler(){
        public void handleMessage(Message msg){
            mTime.setText(getTimeOut());

            //sendEmptyMessage 는 비어있는 메세지를 Handler 에게 전송하는겁니다.
            myTimer.sendEmptyMessage(0);
        }
    };

    String getTimeOut(){
        long now = SystemClock.elapsedRealtime(); //애플리케이션이 실행되고나서 실제로 경과된 시간(??)^^;
        long outTime = now - mBaseTime;
        String easy_outTime = String.format("%02d:%02d:%02d", outTime/1000 / 60, (outTime/1000)%60,(outTime%1000)/10);
        return easy_outTime;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_group1_main);

        initResource();
        initPosition();

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id2));


        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("C72B50E30C5D4B816557CD0049281869")
                    .build();
            mInterstitialAd.loadAd(adRequest);
        }

        showLevelDialog();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myTimer.removeMessages(0);
    }

    private void showLevelDialog(){

        CharSequence[] items = {"초급", "중급", "고급", "전설"};

        new AlertDialog.Builder(this)
                .setTitle("난이도를 선택하세요.")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

                        if(item == 0) {     // 초급
                            mLevel = 0;
                            mMinValue = 2;
                            mMaxValue = 9;
                        }
                        else if(item == 1){ // 중급
                            mLevel = 1;
                            mMinValue = 4;
                            mMaxValue = 14;
                        }
                        else if(item == 2){ // 고급
                            mLevel = 2;
                            mMinValue = 7;
                            mMaxValue = 25;
                        }
                        else if(item == 3){ // 전설
                            mLevel = 3;
                            mMinValue = 40;
                            mMaxValue = 88;
                        }
                        setTopData();
                        setData();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void initResource() {

        mTime = (TextView) findViewById(R.id.project_group1_time);
        mRightWrongCnt = (TextView) findViewById(R.id.project_group1_rightnum);

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
                else {
                    mTxtNumber1.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(2)) {
                    mTxtNumber2.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber2.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(3)) {
                    mTxtNumber3.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber3.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(4)) {
                    mTxtNumber4.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber4.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(5)) {
                    mTxtNumber5.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber5.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(6)) {
                    mTxtNumber6.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber6.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(7)) {
                    mTxtNumber7.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber7.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(8)) {
                    mTxtNumber8.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber8.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(9)) {
                    mTxtNumber9.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber9.setTextColor(Color.BLACK);
                }
            }
        });
        mTxtNumber10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setNumber(10)) {
                    mTxtNumber10.setTextColor(Color.CYAN);
                }
                else {
                    mTxtNumber10.setTextColor(Color.BLACK);
                }
            }
        });
    }

    private void initPosition() {
        // TODO: 위치 랜덤
    }

    private void setTopData() {
        mRightWrongCnt.setText("정답: " + mRightCnt + ", 오답: " + mWrongCnt);
    }

    private void setData() {

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

        mTxtNumber1.setTextColor(Color.BLACK);
        mTxtNumber2.setTextColor(Color.BLACK);
        mTxtNumber3.setTextColor(Color.BLACK);
        mTxtNumber4.setTextColor(Color.BLACK);
        mTxtNumber5.setTextColor(Color.BLACK);
        mTxtNumber6.setTextColor(Color.BLACK);
        mTxtNumber7.setTextColor(Color.BLACK);
        mTxtNumber8.setTextColor(Color.BLACK);
        mTxtNumber9.setTextColor(Color.BLACK);
        mTxtNumber10.setTextColor(Color.BLACK);

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
        int num2 = num1;
        do {
            num2 = random.nextInt(10);
        }
        while(num1 == num2);

        mTopValue = Integer.parseInt(mValues[num1]) * Integer.parseInt(mValues[num2]);
        mTxtTopNumber.setText("" + mTopValue);

        mBaseTime = SystemClock.elapsedRealtime();
        myTimer.sendEmptyMessage(0);


    }

    private boolean setNumber(int eventBtn) {
        boolean result = false;
        String tempText = "";

        if(mFirstClickEvent == eventBtn) {
            // 같은 것을 클릭하면 다시 초기화
            mClickCnt = 0;
            mFirstValue = 0;
            mFirstClickEvent = 0;
            return false;
        }

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
            mFirstClickEvent = eventBtn;
            mClickCnt++;
            result = true;
        }
        else if(mClickCnt == 1) {
            mSecondValue = Integer.parseInt(tempText);
            showBtn();
            result = false;
        }

        return  result;
    }

    private void showBtn() {
        if(mTopValue == mFirstValue * mSecondValue) {
            mRightCnt++;
            //showInterstitial();
            //finish();
        }
        else {
            mWrongCnt++;
            //finish();
        }
        mCurrentQuestionCnt++;

        if(mCurrentQuestionCnt == TOTAL_QUESTION_CNT) {
            myTimer.removeMessages(0);
            String message = "소요시간: " + getTimeOut() + "\n정답: " + mRightCnt + "개" + "\n오답: " + mWrongCnt + "개";
            new AlertDialog.Builder(this)
                    .setTitle("당신의 성적입니다.")
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            showInterstitial();
                            finish();
                        }
                    })
                    .show();
        }
        else {
            mClickCnt = 0;
            mFirstValue = 0;
            mFirstClickEvent = 0;
            setTopData();
            setData();
        }

    }

    private int getRandomValueInt(int min, int max) {
        Random random = new Random();
        int result = random.nextInt(max-min) + min;
        return result;
    }

    private String getRandomValue(int min, int max) {

        Random random = new Random();
        int result = 0;

        if(mLevel == 3) {
            do{
                result = random.nextInt(max-min) + min;
            }
            while (result % 10 == 1 || result % 10 == 7 || result % 10 == 9);
        }
        else {
            result = random.nextInt(max-min) + min;
        }

        int aaa = result % 10;

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
