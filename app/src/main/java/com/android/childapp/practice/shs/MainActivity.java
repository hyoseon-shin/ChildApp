package com.android.childapp.practice.shs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {

    private static final String CORRECT_ANSWER = "4";

    private static final String MSG_CORRECT = "정답입니다.";
    private static final String MSG_WRONG = "오답입니다.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_shs_main);

        LinearLayout pl1 = (LinearLayout)findViewById(R.id.problem_layout1);
        Circle pv1 = new Circle(this, 200, 200, 150, Color.BLUE);
        pl1.addView(pv1);

        LinearLayout pl2 = (LinearLayout)findViewById(R.id.problem_layout2);
        Circle pv2 = new Circle(this, 200, 200, 150, Color.YELLOW);
        pl2.addView(pv2);

        RelativeLayout el1 = (RelativeLayout)findViewById(R.id.example_layout1);
        el1.setTag("1");
        el1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        TextView tv1 = new TextView(this);
        tv1.setTextSize(30);
        tv1.setText("1.");
        el1.addView(tv1);
        Circle ev1 = new Circle(this, 300, 200, 150, Color.BLACK);
        el1.addView(ev1);

        RelativeLayout el2 = (RelativeLayout)findViewById(R.id.example_layout2);
        el2.setTag("2");
        el2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        TextView tv2 = new TextView(this);
        tv2.setTextSize(30);
        tv2.setText("2.");
        el2.addView(tv2);
        Circle ev2 = new Circle(this, 300, 200, 150, Color.RED);
        el2.addView(ev2);

        RelativeLayout el3 = (RelativeLayout)findViewById(R.id.example_layout3);
        el3.setTag("3");
        el3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        TextView tv3 = new TextView(this);
        tv3.setTextSize(30);
        tv3.setText("3.");
        el3.addView(tv3);
        Circle ev3 = new Circle(this, 300, 200, 150, Color.MAGENTA);
        el3.addView(ev3);

        RelativeLayout el4 = (RelativeLayout)findViewById(R.id.example_layout4);
        el4.setTag("4");
        el4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        TextView tv4 = new TextView(this);
        tv4.setTextSize(30);
        tv4.setText("4.");
        el4.addView(tv4);
        Circle ev4 = new Circle(this, 300, 200, 150, Color.GREEN);
        el4.addView(ev4);
    }

    public void showAlert(final String val) {
        String message;
        if (CORRECT_ANSWER.equals(val)) {
            message = MSG_CORRECT;
        } else {
            message = MSG_WRONG;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(val)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (CORRECT_ANSWER.equals(val)) {
                            finish();
                        }
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
