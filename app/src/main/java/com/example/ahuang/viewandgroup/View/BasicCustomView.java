package com.example.ahuang.viewandgroup.view; /**
 * BasicCustomView  2017-04-19
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.width;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 04 19
 */
public class BasicCustomView extends View {

    private Paint mPaint;

    public BasicCustomView(Context context) {
        super(context);
        initView();
    }

    public BasicCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BasicCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //  super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }


    /**
     * 获得测量的宽度
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measureWidth(int widthMeasureSpec) {
        int width = 0;
        int mode = MeasureSpec.getMode(widthMeasureSpec); //获得测量模式
        int size = MeasureSpec.getSize(widthMeasureSpec); //获得测量值
        if (mode == MeasureSpec.EXACTLY) { //精准测量模式
            width = size;
        } else {
            width = 300;
            if (mode == MeasureSpec.AT_MOST) {
                width = Math.min(width, size);
            }
        }
        return width;
    }


    /**
     * 获得测量的高度
     *
     * @param heightMeasureSpec
     * @return
     */
    private int measureHeight(int heightMeasureSpec) {
        int height = 0;
        int mode = MeasureSpec.getMode(heightMeasureSpec); //获得测量模式
        int size = MeasureSpec.getSize(heightMeasureSpec); //获得测量值
        if (mode == MeasureSpec.EXACTLY) { //精准测量模式
            height = size;
        } else {
            height = 300;
            if (mode == MeasureSpec.AT_MOST) {
                height = Math.min(width, size);
            }
        }
        return height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        int width = getWidth() - (paddingLeft + paddingRight);
        int height = getHeight() - (paddingTop + paddingBottom);
        canvas.translate(width / 2, height / 2);
        canvas.drawCircle(0, 0, 100, mPaint);
    }
}