package com.example.ahuang.viewandgroup.view; /**
 * DrawView  2017-03-17
 * Copyright (c) 2017 HYB Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 03 17
 */
public class DrawView extends View {

    private Paint mPaint1, mPaint2;

    public DrawView(Context context) {
        super(context);
        initView();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化画笔
     */
    private void initView() {
        mPaint1 = new Paint();
        mPaint1.setColor(Color.GRAY);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setAntiAlias(true);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint2.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //程序调用super.onDraw(canvas)方法来实现原生控件的功能，但是在调用super.onDraw(canvas)方法之前和
        //之后，我们可以实现自己的逻辑
        //画点
        mPaint2.setStrokeWidth(10);
        canvas.drawPoint(100, 100, mPaint2);
        canvas.drawPoints(new float[]{100, 120, 120, 120, 140, 120},mPaint2);
        //绘制直线
        canvas.drawLine(100,150,200,150,mPaint2);
        canvas.drawLines(new float[]{100,170,220,170,100,190,300,190},mPaint2);
        //绘制矩形
        canvas.drawRect(100,210,300,300,mPaint2);  //第一种，两点确定一个矩形
        Rect rect=new Rect(400,210,600,300);   //将矩形封装为rect
        canvas.drawRect(rect,mPaint2);
        RectF rectF=new RectF(700,210,900,300);
        canvas.drawRect(rectF,mPaint2);
        canvas.save();
        //绘制圆角矩形
        RectF rectF1=new RectF(100,350,500,400);
        canvas.drawRoundRect(rectF1,30,30,mPaint2);
      //  canvas.drawRoundRect(60,350,800,400,mPaint2);   //API>=21
        //绘制椭圆
        RectF rectF2=new RectF(100,450,500,550);
        canvas.drawOval(rectF2,mPaint2);
       // canvas.drawOval(600,500,800,600,mPaint2);  //API>=21
        //绘制圆
        canvas.drawCircle(700,700,100,mPaint2);
        //绘制圆弧
        RectF rectF3=new RectF(100,850,300,900);
        canvas.drawRect(rectF3,mPaint1);
        canvas.drawArc(rectF3,0,90,false,mPaint2);
        RectF rectF4=new RectF(400,850,600,900);
        canvas.drawRect(rectF4,mPaint1);
        canvas.drawArc(rectF4,0,90,true,mPaint2);
        super.onDraw(canvas);
    }
}