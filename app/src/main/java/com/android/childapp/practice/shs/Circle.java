package com.android.childapp.practice.shs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Hyoseon Shin on 2017-06-25.
 */

public class Circle extends View {
    private final float x;
    private final float y;
    private final int r;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Circle(Context context, float x, float y, int r, int color) {
        super(context);
        this.x = x;
        this.y = y;
        this.r = r;
        mPaint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, r, mPaint);
    }
}
