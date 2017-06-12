package com.android.childapp.practice.kte;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_kte_main);

        Button tebtn = (Button) findViewById(R.id.tebtn);
        Button tebtn2 = (Button) findViewById(R.id.tebtn2);

        tebtn.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View v)
                                     {
                                         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&oquery=rgb+%EC%83%89%EC%83%81%ED%91%9C&ie=utf8&query=%EC%98%A4%EB%B2%84%EC%9B%8C%EC%B9%98"));
                                         startActivity(intent);
                                     }
                                 }
        );

        tebtn2.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View v)
                                     {
                                         if(getPackageList()==true) {
                                             Intent intent = getPackageManager().getLaunchIntentForPackage("com.dveamer.owfriends");
                                             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                             startActivity(intent);
                                         }else{
                                             String url = "market://details?id=" + "com.dveamer.owfriends";
                                             Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                             startActivity(i);
                                         }
                                     }
                                 }
        );


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("4B1E6F58F8A5EC1284F577F8C18FB3C4")
                .build();
        mAdView.loadAd(adRequest);
    }

    public boolean getPackageList() {
        boolean isExist = false;

        PackageManager pkgMgr = getPackageManager();
        List<ResolveInfo> mApps;
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mApps = pkgMgr.queryIntentActivities(mainIntent, 0);

        try {
            for (int i = 0; i < mApps.size(); i++) {
                if(mApps.get(i).activityInfo.packageName.startsWith("com.dveamer.owfriends")){
                    isExist = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            isExist = false;
        }
        return isExist;
    }

}
