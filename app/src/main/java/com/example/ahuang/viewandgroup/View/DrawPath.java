package com.example.ahuang.viewandgroup.view; /**
 * DrawPath  2017-03-31
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 03 31
 */
public class DrawPath extends View {

    private Paint mPaint1, mPaint2;

    public DrawPath(Context context) {
        super(context);
        initView();
    }

    public DrawPath(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DrawPath(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint1 = new Paint();
        mPaint1.setColor(Color.GRAY);
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setAntiAlias(true);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint2.setStrokeWidth(5);
        int mWidth = getWidth();
        int mHeight = getHeight();
        /**    canvas.translate(mWidth/2,mHeight/2);  //坐标移动到屏幕中心
         Path path=new Path();       //创建Path
         path.lineTo(200,200);
         path.lineTo(200,-200);
         canvas.drawPath(path,mPaint2);  //绘制Path  **/

        /** canvas.translate(mWidth / 2, mHeight / 2);
         Path path = new Path();
         path.lineTo(200,200);
         path.moveTo(200,0);
         path.lineTo(200,-200);
         canvas.drawPath(path,mPaint2);  **/

      /*  canvas.translate(mWidth/2,mHeight/2);
        Path path=new Path();
        path.lineTo(200,200);
        canvas.drawPoint(200,200,mPaint2);
        path.setLastPoint(200,100);
        path.lineTo(200,-200);
        canvas.drawPath(path,mPaint2);*/

       /* canvas.translate(mWidth/2,mHeight/2);
        Path path=new Path();
        path.lineTo(200,200);
        path.lineTo(200,-200);
        path.close();
        canvas.drawPath(path,mPaint2);*/

      /*  canvas.translate(mWidth / 2, mHeight / 2);
        Path path = new Path();
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        path.setLastPoint(-300, 300);
        canvas.drawPath(path, mPaint2);*/

      /*  canvas.translate(mWidth/2,mHeight/2);
        Path path=new Path();
        Path src=new Path();
        path.addRect(-200,-200,200,200,Path.Direction.CW);
        src.addCircle(0,0,100,Path.Direction.CW);
        path.addPath(src,0,-200);
        canvas.drawPath(path,mPaint2);*/

       /* canvas.translate(mWidth/2,mHeight/2);
        Path path=new Path();
        path.lineTo(100,100);
        RectF oval=new RectF(0,0,300,300);
        path.addArc(oval,0,270);
        canvas.drawPath(path,mPaint2);*/

       /* canvas.translate(mWidth/2,mHeight/2);
        Path path=new Path();
        path.lineTo(100,100);
        RectF oval=new RectF(0,0,300,300);
        path.arcTo(oval,0,270);
        canvas.drawPath(path,mPaint2);*/

        canvas.translate(mWidth/2,mHeight/2);
        Path path=new Path();
        path.addCircle(0,0,100,Path.Direction.CW);
        Path dst=new Path();
        path.offset(300,0,dst);
        canvas.drawPath(path,mPaint2);
        path.offset(300,0);
        canvas.drawPath(path,mPaint2);



        super.onDraw(canvas);
    }
}