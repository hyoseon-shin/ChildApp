package com.android.childapp.practice.shs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_HEIGHT = 460;
    private static final String CORRECT_ANSWER = "3";

    private static final String MSG_CORRECT = "정답입니다.";
    private static final String MSG_WRONG = "오답입니다.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_shs_main);

        TextView example = (TextView) findViewById(R.id.example);
        example.setText(CORRECT_ANSWER);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;

        LinearLayout imageLayout = (LinearLayout) findViewById(R.id.image_layout);
        imageLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        imageLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout imageRow = new LinearLayout(this);
        imageRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        imageRow.setOrientation(LinearLayout.HORIZONTAL);

        double left = 0;
        SparseIntArray imageResArr = getImageResList();
        for(int i = 1; i <= imageResArr.size(); i++) {
            int resId = imageResArr.get(i);
            ImageView image = new ImageView(this);
            image.setTag(i);
            image.setAdjustViewBounds(true);
            image.setMaxHeight(MAX_HEIGHT);
            image.setImageResource(resId);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlert(String.valueOf(v.getTag()));
                }
            });
            int imageWidth = image.getDrawable().getIntrinsicWidth();
            int imageHeight = image.getDrawable().getIntrinsicHeight();
            double resizeWidth = imageWidth * MAX_HEIGHT / imageHeight;
            System.out.println("************ resizeWidth: " + resizeWidth);
            imageLayout.addView(image);
//            if (left + resizeWidth > screenWidth) {
//                imageLayout.addView(imageRow);
//                imageRow = new LinearLayout(this);
//                imageRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                imageRow.setOrientation(LinearLayout.HORIZONTAL);
//                imageRow.addView(image);
//                left = resizeWidth;
//            } else {
//                imageRow.addView(image);
//                left += resizeWidth;
//            }
        }
    }

    // TODO: Retrieve resource data from DB
    public SparseIntArray getImageResList() {
        SparseIntArray rsltArr = new SparseIntArray();
        rsltArr.put(1, R.drawable.animal1_1);
        rsltArr.put(2, R.drawable.animal2_1);
        rsltArr.put(3, R.drawable.animal3_1);
        rsltArr.put(4, R.drawable.animal4_1);
        return rsltArr;
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
