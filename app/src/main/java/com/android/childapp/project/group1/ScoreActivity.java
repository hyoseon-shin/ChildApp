package com.android.childapp.project.group1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.childapp.*;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by sjyoon on 2017-06-12.
 */

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener{

    private InterstitialAd mInterstitialAd;
    private InterstitialAd interstitialAd;
    InterstitialAd main_inter;
    AdRequest adRequest1;
    AdView main_Banner_AdView;

    Button btn_test;
    AdRequest adRequest;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_group1_score);

        main_inter = new InterstitialAd(this);
        main_inter.setAdUnitId("Admob - 전면광고 ID");
        adRequest1 = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("기기 ID")
                .build();

        main_inter.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                main_inter.show();  // Load 된 광고를 출력
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }
        });
        main_Banner_AdView = (AdView)findViewById(R.id.adView2);
        AdRequest adRequest1 = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("4B1E6F58F8A5EC1284F577F8C18FB3C4")
                .build();
        main_Banner_AdView.loadAd(adRequest1);


        btn_test = (Button)findViewById(R.id.test);
        btn_test.setOnClickListener(this);
    }
    public boolean displayInterstitial() {
        main_inter.loadAd(adRequest);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);

        displayInterstitial();
        startActivity(intent);

    }
        /*
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5782667810750787/8232768353");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();
        setFullAd();
        displayAD();
        */

    /*
    private void requestNewInterstitial() {

        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("4B1E6F58F8A5EC1284F577F8C18FB3C4")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
    private void setFullAd(){
        interstitialAd = new InterstitialAd(this); //새 광고를 만듭니다.
        interstitialAd.setAdUnitId(getResources().getString(R.string.banner_ad_unit_id2)); //이전에 String에 저장해 두었던 광고 ID를 전면 광고에 설정합니다.
        AdRequest adRequest1 = new AdRequest.Builder().build(); //새 광고요청
        interstitialAd.loadAd(adRequest1); //요청한 광고를 load 합니다.
        interstitialAd.setAdListener(new AdListener() { //전면 광고의 상태를 확인하는 리스너 등록

            @Override
            public void onAdClosed() { //전면 광고가 열린 뒤에 닫혔을 때
                AdRequest adRequest1 = new AdRequest.Builder().build();  //새 광고요청
                interstitialAd.loadAd(adRequest1); //요청한 광고를 load 합니다.
            }
        });
    }
    public void displayAD(){
        count++;
        if(count>10)
            if(interstitialAd.isLoaded()) { //광고가 로드 되었을 시
                interstitialAd.show(); //보여준다
                count=0;
            }
    }
*/
}
