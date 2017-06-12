package com.android.childapp.project.group1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.childapp.R;

/**
 * Created by sjyoon on 2017-04-28.
 */

public class MainActivity extends AppCompatActivity {

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_group1_main);

        mBtn1 = (Button) findViewById(R.id.project_group1_btn1);
        mBtn2 = (Button) findViewById(R.id.project_group1_btn2);
        mBtn3 = (Button) findViewById(R.id.project_group1_btn3);
        mBtn4 = (Button) findViewById(R.id.project_group1_btn4);
        mBtn5 = (Button) findViewById(R.id.project_group1_btn5);

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
}
