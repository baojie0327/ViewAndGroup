package com.example.ahuang.viewandgroup.View; /**
 * AudioBar  2017-04-21
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 04 21
 */
public class AudioBar extends View {

    private Paint mPaint;  //定义画笔
    private int mWidth; //屏幕的宽度
    private int mRectWidth;  //音频条的宽度
    private int mRectHeight;  //音频条的高度
    private int mRectCount; //音频条的个数
    private int offset = 5; //音频条的偏移量
    private double mRandom;  //随机数
    private LinearGradient mLinearGradient;


    public AudioBar(Context context) {
        this(context, null);
    }

    public AudioBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AudioBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 12;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectWidth = mWidth / mRectCount; //音频条的宽度
        mRectHeight = getHeight();  //音频条的高度，要乘上一个随机数
        mLinearGradient=new LinearGradient(0,0,mRectWidth,mRectHeight,
                Color.BLUE,Color.GREEN, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            mRandom = Math.random();
            canvas.drawRect(mRectWidth * i + offset, (float) (mRectHeight * mRandom), mRectWidth * (i+1),
                   mRectHeight, mPaint);
        }
        postInvalidateDelayed(300);
    }
}