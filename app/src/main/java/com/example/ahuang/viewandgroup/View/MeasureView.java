package com.example.ahuang.viewandgroup.view; /**
 * MeasureView  2017-03-06
 * Copyright (c) 2017 HYB Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 03 06
 */
public class MeasureView extends View {
    public MeasureView(Context context) {
        super(context);
    }

    public MeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 重写onMeasure()方法，实现测量
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //  super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    /**
     * 获取测量的宽度
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measureWidth(int widthMeasureSpec) {
        int width = 0;
        int mode = MeasureSpec.getMode(widthMeasureSpec); //获取测量模式
        int size = MeasureSpec.getSize(widthMeasureSpec);  //获取测量值

        if (mode == MeasureSpec.EXACTLY) { //精准测量模式
            width = size;
        } else {
            width = 200;
            if (mode == MeasureSpec.AT_MOST) {
                width = Math.max(size, width);
            }
        }
        Log.d("hbj", "width=" + width);
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
        int mode = MeasureSpec.getMode(heightMeasureSpec); //测量模式
        int size = MeasureSpec.getSize(heightMeasureSpec); //测量的尺寸
        if (mode == MeasureSpec.EXACTLY) {
            height = size;
        } else {
            height = 200;
            if (mode == MeasureSpec.AT_MOST) {
                height = Math.min(height, size);
            }
        }
        Log.d("hbj", "height=" + height);
        return height;
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawColor(Color.GREEN);
//    }
}