package com.android.childapp.project.group2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.childapp.R;

/**
 * Created by sjyoon on 2017-04-28.
 */

public class MainActivity extends AppCompatActivity {

    private static final int MAX_HEIGHT = 460;
    private static final String CORRECT_ANSWER = "3";

    private static final String MSG_CORRECT = "정답입니다.";
    private static final String MSG_WRONG = "오답입니다.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_group2_main);

        TextView problem = (TextView) findViewById(R.id.problem);
        problem.setText(CORRECT_ANSWER);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        System.out.println("screenWidth: " + screenWidth);

        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.example_layout);

        RelativeLayout.LayoutParams lParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView iv1 = new ImageView(this);
        iv1.setId(1);
        iv1.setTag("1");
        iv1.setAdjustViewBounds(true);
        iv1.setMaxHeight(MAX_HEIGHT);
        iv1.setImageResource(R.drawable.animal1_1);

        int imageWidth = iv1.getDrawable().getIntrinsicWidth();
        int imageHeight = iv1.getDrawable().getIntrinsicHeight();
        double resizedImageWidth = imageWidth * MAX_HEIGHT / imageHeight;
        System.out.println("resizedImageWidth 1: " + resizedImageWidth);
        double exampleWidth = resizedImageWidth;
        int topResId1 = 0;
        int topResId2 = 1;
        iv1.setLayoutParams(lParams1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        mainLayout.addView(iv1);

        RelativeLayout.LayoutParams lParams2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView iv2 = new ImageView(this);
        iv2.setId(2);
        iv2.setTag("2");
        iv2.setAdjustViewBounds(true);
        iv2.setMaxHeight(MAX_HEIGHT);
        iv2.setImageResource(R.drawable.animal2_1);

        imageWidth = iv1.getDrawable().getIntrinsicWidth();
        imageHeight = iv1.getDrawable().getIntrinsicHeight();
        resizedImageWidth = imageWidth * MAX_HEIGHT / imageHeight;
        System.out.println("resizedImageWidth 2: " + resizedImageWidth);
        if (exampleWidth + resizedImageWidth > screenWidth) {
            lParams2.addRule(RelativeLayout.BELOW, topResId2);
            exampleWidth = resizedImageWidth;
            topResId1 = topResId2;
            topResId2 = 2;
        } else {
            if (topResId1 > 0) {
                lParams2.addRule(RelativeLayout.BELOW, topResId1);
            }
            lParams2.addRule(RelativeLayout.RIGHT_OF, 1);
            exampleWidth += resizedImageWidth;
        }
        iv2.setLayoutParams(lParams2);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        mainLayout.addView(iv2);

        RelativeLayout.LayoutParams lParams3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView iv3 = new ImageView(this);
        iv3.setId(3);
        iv3.setTag("3");
        iv3.setAdjustViewBounds(true);
        iv3.setMaxHeight(MAX_HEIGHT);
        iv3.setImageResource(R.drawable.animal3_1);

        imageWidth = iv1.getDrawable().getIntrinsicWidth();
        imageHeight = iv1.getDrawable().getIntrinsicHeight();
        resizedImageWidth = imageWidth * MAX_HEIGHT / imageHeight;
        System.out.println("resizedImageWidth 3: " + resizedImageWidth);
        if (exampleWidth + resizedImageWidth > screenWidth) {
            lParams3.addRule(RelativeLayout.BELOW, topResId2);
            exampleWidth = resizedImageWidth;
            topResId1 = topResId2;
            topResId2 = 3;
        } else {
            if (topResId1 > 0) {
                lParams3.addRule(RelativeLayout.BELOW, topResId1);
            }
            lParams3.addRule(RelativeLayout.RIGHT_OF, 2);
            exampleWidth += resizedImageWidth;
        }
        iv3.setLayoutParams(lParams3);
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        mainLayout.addView(iv3);

        RelativeLayout.LayoutParams lParams4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView iv4 = new ImageView(this);
        iv4.setId(4);
        iv4.setTag("4");
        iv4.setAdjustViewBounds(true);
        iv4.setMaxHeight(MAX_HEIGHT);
        iv4.setImageResource(R.drawable.animal4_1);

        imageWidth = iv4.getDrawable().getIntrinsicWidth();
        imageHeight = iv4.getDrawable().getIntrinsicHeight();
        resizedImageWidth = imageWidth * MAX_HEIGHT / imageHeight;
        System.out.println("resizedImageWidth 4: " + resizedImageWidth);
        if (exampleWidth + resizedImageWidth > screenWidth) {
            lParams4.addRule(RelativeLayout.BELOW, topResId2);
            exampleWidth = resizedImageWidth;
            topResId1 = topResId2;
            topResId2 = 4;
        } else {
            System.out.println("topResId1: " + topResId1 + ", topResId2: " + topResId2);
            if (topResId1 > 0) {
                lParams4.addRule(RelativeLayout.BELOW, topResId1);
            }
            lParams4.addRule(RelativeLayout.RIGHT_OF, 3);
            exampleWidth += resizedImageWidth;
        }
        iv4.setLayoutParams(lParams4);
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(String.valueOf(v.getTag()));
            }
        });
        mainLayout.addView(iv4);
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
