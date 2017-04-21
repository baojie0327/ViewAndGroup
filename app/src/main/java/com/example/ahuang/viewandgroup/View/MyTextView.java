package com.example.ahuang.viewandgroup.View; /**
 * MyTextView  2017-04-20
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * class description here
 * @author Borje
 * @version 1.0.0
 * since 2017 04 20
 */
public class MyTextView extends TextView{

    private Paint mPaint1,mPaint2;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        mPaint1=new Paint();
        mPaint1.setColor(Color.RED);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2=new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //在实现原生控件之间，实现我们的逻辑
        //绘制外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        //绘制内层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        //保存画布状态
        canvas.save();
        // 绘制文字前各平移100像素
        canvas.translate(100, 100);
        //父类完成的方法，绘制文字
        super.onDraw(canvas);
        canvas.restore();
    }
}