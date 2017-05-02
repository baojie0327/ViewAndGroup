package com.example.ahuang.viewandgroup.view; /**
 * BezierTwo  2017-04-16
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 04 16
 */
public class BezierTwo extends View {

    private Paint mPaint;
    private int centerX, centerY;
    private PointF start, end, control; //起点，结束点，控制点

    public BezierTwo(Context context) {
        super(context);
        init();
    }

    public BezierTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);
        //初始化起点，结束点，控制点
        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control = new PointF(0, 0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2;
        //重新设置起点，结束点和控制点的位置
        start.x = centerX - 200;
        start.y = centerY;
        end.x = centerY + 200;
        end.y = centerY;
        control.x = centerX;
        control.y = centerY - 100;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //根据触摸点更新控制点，并重绘
        control.x = event.getX();
        control.y = event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制数据点和控制点
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.x, start.y, mPaint);
        canvas.drawPoint(end.x, end.y, mPaint);
        canvas.drawPoint(control.x, control.y, mPaint);

        //绘制辅助线
        mPaint.setStrokeWidth(4);
        canvas.drawLine(start.x,start.y,control.x,control.y,mPaint);
        canvas.drawLine(end.x,end.y,control.x,control.y,mPaint);

        //绘制贝赛尔曲线
        mPaint.setStrokeWidth(8);
        mPaint.setColor(Color.RED);
        Path path=new Path();
        path.moveTo(start.x,start.y);
        path.quadTo(control.x,control.y,end.x,end.y);
        canvas.drawPath(path,mPaint);
    }
}