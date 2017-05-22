package com.android.childapp.practice.jkm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {
    Toast mToast = null;
    int count;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_jkm_main);

        findViewById(R.id.button2).setOnClickListener(mClickListener);
        findViewById(R.id.button3).setOnClickListener(mClickListener);
        findViewById(R.id.button4).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button2:
                    Toast.makeText(MainActivity.this, "잠시 나타나는 메시지",
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button3:
                    Toast.makeText(MainActivity.this, "조금 길게 나타나는 메시지",
                            Toast.LENGTH_LONG).show();
                    break;
                case R.id.button4:
                    LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this,R.layout.activity_practice_kte_main,null);
                    Toast t2 = new Toast(MainActivity.this);
                    t2.setView(linear);
                    t2.show();
                    break;
            }
        }
    };
}