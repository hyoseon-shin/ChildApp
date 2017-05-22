package com.android.childapp.practice.ygy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.childapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_practice_ygy_main);
        MyView myView = new MyView(this);
        setContentView(myView);

//        SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
//        sharedPreferences.Editor editor = sharedPreferences.edit();


    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        // View의 onDraw()메소드가 자동으로 호출됨
        public void onDraw(Canvas canvas){

            // Canvas는 View위에 그림을 그릴 수 있는 도화지
            // Paint 객체로 그림을 그린다.
            Paint paint = new Paint();

            canvas.drawColor(Color.BLACK);  // Canvas(도화지)의 색 설정
            canvas.drawPoint(10,10,paint);  // Canvas 위치 지정

            paint.setColor(Color.WHITE);
            canvas.drawLine(50,50,500,500,paint);    // 선 그리기

            // Bitmap 사용(비트맵은 고화질 그림을 load할 때 쓰인다)
            // Bitmap 은 덩치가 큰 데이터 이므로, onCreate에서 미리 읽어두면 좋다.
     //       Resources r = getResources();
     //       BitmapDrawable bitmapDrawable = (BitmapDrawable)r.getDrawable(R.drawable.overwatch);
     //       Bitmap bitmap = bitmapDrawable.getBitmap();

     //       canvas.drawBitmap(bitmap,50,50,null);

        }

    }
}
