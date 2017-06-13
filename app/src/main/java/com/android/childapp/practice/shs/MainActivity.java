package com.android.childapp.practice.shs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {

    private final String CORRECT_ANSWER = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_shs_main);

        TextView example = (TextView) findViewById(R.id.example);
        example.setText(CORRECT_ANSWER);

        LinearLayout imageLayout = (LinearLayout) findViewById(R.id.image_layout);

        LinearLayout imageRow1 = new LinearLayout(this);
        imageRow1.setOrientation(LinearLayout.HORIZONTAL);

        ImageView image1 = new ImageView(this);
        image1.setAdjustViewBounds(true);
        image1.setMaxHeight(500);
        image1.setImageResource(R.drawable.animal1_1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert("1");
            }
        });
        imageRow1.addView(image1);

        ImageView image2 = new ImageView(this);
        image2.setAdjustViewBounds(true);
        image2.setMaxHeight(500);
        image2.setImageResource(R.drawable.animal2_1);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert("2");
            }
        });
        imageRow1.addView(image2);

        imageLayout.addView(imageRow1);

        LinearLayout imageRow2 = new LinearLayout(this);
        imageRow1.setOrientation(LinearLayout.HORIZONTAL);

        ImageView image3 = new ImageView(this);
        image3.setAdjustViewBounds(true);
        image3.setMaxHeight(500);
        image3.setImageResource(R.drawable.animal3_1);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert("3");
            }
        });
        imageRow2.addView(image3);

        ImageView image4 = new ImageView(this);
        image4.setAdjustViewBounds(true);
        image4.setMaxHeight(500);
        image4.setImageResource(R.drawable.animal4_1);
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert("4");
            }
        });
        imageRow2.addView(image4);

        imageLayout.addView(imageRow2);
    }

    public void showAlert(final String val) {
        String message;
        if (CORRECT_ANSWER.equals(val)) {
            message = "정답입니다.";
        } else {
            message = "오답입니다.";
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
