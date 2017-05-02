package com.example.ahuang.viewandgroup.view; /**
 * CanvasOperationView  2017-03-25
 * Copyright (c) 2017 HYB Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * class description here
 * @author Borje
 * @version 1.0.0
 * since 2017 03 25
 */
public class CanvasOperationView extends View{

    private Paint mPaint1,mPaint2;

    public CanvasOperationView(Context context) {
        super(context);
        initView();
    }

    public CanvasOperationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CanvasOperationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        mPaint1=new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint2=new Paint();
        mPaint2.setColor(Color.RED);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint2.setStrokeWidth(10);
//        canvas.drawCircle(60,60,50,mPaint2);
//        canvas.translate(200,200);
//        canvas.drawCircle(60,60,50,mPaint2);
//        int width=getWidth();
//        int height=getHeight();
//        canvas.translate(width/2,height/2);  //将坐标移到中心
//        RectF rectF=new RectF(0,-400,400,0);
//        canvas.drawRect(rectF,mPaint1);
//        canvas.scale(0.5f,0.5f);
//        canvas.drawRect(rectF,mPaint1);
//        int width=getWidth();
//        int height=getHeight();
//        canvas.translate(width/2,height/2);  //将坐标移到中心
//        RectF rectF=new RectF(0,-400,400,0);
//        canvas.drawRect(rectF,mPaint1);
//        canvas.scale(0.5f,0.5f,200,0);
//        canvas.drawRect(rectF,mPaint1);

//        int width=getWidth();
//        int height=getHeight();
//        canvas.translate(width/2,height/2);  //将坐标移到中心
//        RectF rectF=new RectF(0,-400,400,0);
//        canvas.drawRect(rectF,mPaint1);
//        canvas.scale(-0.5f,-0.5f,200,0);
//        canvas.drawRect(rectF,mPaint1);

//        int width=getWidth();
//        int height=getHeight();
//        canvas.translate(width/2,height/2);  //将坐标移到中心
//        RectF rectF=new RectF(-400,-400,400,400);
//        canvas.drawRect(rectF,mPaint1);
//        for (int i=0;i<20;i++){
//            canvas.scale(0.9f,0.9f);
//            canvas.drawRect(rectF,mPaint1);
//        }


//        int width=getWidth();
//        int height=getHeight();
//        canvas.translate(width/2,height/2);  //将坐标移到中心
//        RectF rectF=new RectF(0,-400,400,0);
//        canvas.drawRect(rectF,mPaint1);
//        canvas.rotate(180);
//        canvas.drawRect(rectF,mPaint1);

//        int width=getWidth();
//        int height=getHeight();
//        canvas.translate(width/2,height/2);  //将坐标移到中心
//        RectF rectF=new RectF(0,-400,400,0);
//        canvas.drawRect(rectF,mPaint1);
//        canvas.rotate(180,200,0);
//        canvas.drawRect(rectF,mPaint1);

//        int width=getWidth();
//        int height=getHeight();
//        canvas.translate(width/2,height/2);  //将坐标移到中心
//        RectF rectF=new RectF(0,-400,400,0);
//        canvas.drawRect(rectF,mPaint1);
//        canvas.rotate(180);
//        canvas.rotate(50);
//        canvas.drawRect(rectF,mPaint1);

        int width=getWidth();
        int height=getHeight();
        canvas.translate(width/2,height/2);  //将坐标移到中心
        RectF rectF=new RectF(0,0,200,200);
        canvas.drawRect(rectF,mPaint1);
        canvas.skew(1,0);  //水平斜切45
        canvas.drawRect(rectF,mPaint1);

        super.onDraw(canvas);
    }
}