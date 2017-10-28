# ViewAndGroup
基本图形的绘制

![](https://github.com/baojie0327/ViewAndGroup/blob/master/images/basic.jpg)

二阶贝塞尔曲线
```
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
  ```
![](https://github.com/baojie0327/ViewAndGroup/blob/master/images/baizer_two.gif)

三阶贝赛尔曲线
```
@Override
  protected void onDraw(Canvas canvas) {
      super.onDraw(canvas);
      //绘制数据点和控制点
      mPaint.setColor(Color.GRAY);
      mPaint.setStrokeWidth(20);
      canvas.drawPoint(start.x,start.y,mPaint);
      canvas.drawPoint(end.x,end.y,mPaint);
      canvas.drawPoint(control1.x,control1.y,mPaint);
      canvas.drawPoint(control2.x,control2.y,mPaint);

      //绘制辅助线
      mPaint.setStrokeWidth(4);
      canvas.drawLine(start.x,start.y,control1.x,control1.y,mPaint);
      canvas.drawLine(control1.x,control1.y,control2.x,control2.y,mPaint);
      canvas.drawLine(control2.x,control2.y,end.x,end.y,mPaint);

      // 绘制贝塞尔曲线
      mPaint.setColor(Color.RED);
      mPaint.setStrokeWidth(8);

      Path path=new Path();
      path.moveTo(start.x,start.y);
      path.cubicTo(control1.x,control1.y,control2.x,control2.y,end.x,end.y);
      canvas.drawPath(path,mPaint);
  }
  ```

![](https://github.com/baojie0327/ViewAndGroup/blob/master/images/baizer_three.gif)


自定义View

```
<resources>
    <declare-styleable name="TopBar">
        <!--中间title的自定义属性-->
        <attr name="mTitle" format="string"></attr>
        <attr name="mTitleSize" format="dimension"></attr>
        <attr name="mTitleColor" format="color"></attr>
        <!--左边图片的自发定义属性-->
        <attr name="mLeftBackGround" format="reference"></attr>
        <!--右边TextView的自定义属性-->
        <attr name="rightTitle" format="string"></attr>
        <attr name="rightTitleSize" format="dimension"></attr>
        <attr name="rightTextColor" format="color"></attr>
    </declare-styleable>
</resources>

<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1">
        <com.example.ahuang.viewandgroup.View.TopBar
            android:layout_width="match_parent"
            android:layout_height="45dp"
            custom:mLeftBackGround="@mipmap/back_icon"
            custom:mTitle="购物车"
            custom:mTitleColor="@android:color/white"
            custom:mTitleSize="5sp"
            custom:rightTextColor="@android:color/white"
            custom:rightTitle="编辑"
            custom:rightTitleSize="5sp"/>
    </LinearLayout>
 ```
    
![](https://github.com/baojie0327/ViewAndGroup/blob/master/images/custom_one.gif) 

自定义View
```
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
    
  ```
    
![](https://github.com/baojie0327/ViewAndGroup/blob/master/images/newcustom.gif)

仿小米运动

```
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制底层背景
        mPaint.setColor(background_color);
        mPaint.setStyle(Paint.Style.FILL);
        RectF rectF_back = new RectF(0, 0, widthBg, heightBg);
        canvas.drawRect(rectF_back, mPaint);
        //绘制最外层的圆
        mPaint.setColor(outer_circle_color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        canvas.drawCircle(widthBg / 2, heightBg / 2, ra_out_circle, mPaint);
        //绘制圆上的小圆点
        pointPaint.setColor(outer_dot_color);
        pointPaint.setStrokeWidth(10);
        canvas.drawCircle((float) (widthBg / 2 + ra_out_circle * Math.cos(angle * 3.14 / 180)), (float) (heightBg / 2 + ra_out_circle * Math.sin(angle * 3.14 / 180)), 10, pointPaint);
        //画line
        drawLines(canvas);
        //画圆弧
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(30);
        arcPaint.setColor(ring_color);
        RectF arcRect = new RectF((widthBg / 2 - ra_inner_circle + line_length / 2), (heightBg / 2 - ra_inner_circle + line_length / 2), (widthBg / 2 + ra_inner_circle - line_length / 2), (heightBg / 2 + ra_inner_circle - line_length / 2));
        canvas.drawArc(arcRect, -90, currentFootNumPre, false, arcPaint);

        //绘制步数
        textPaint.setColor(step_num_color);
        textPaint.setStrokeWidth(25);
        textPaint.setTextSize(widthBg / 6);
        canvas.drawText(String.valueOf(currentFootNum), (widthBg / 3 - 50), heightBg / 2 + 50, textPaint);
        textPaint.setStrokeWidth(10);
        textPaint.setColor(othet_text_color);
        textPaint.setTextSize(widthBg / 20);
        canvas.drawText("步", (widthBg / 2 + 200), heightBg / 2 + 50, textPaint);
        //绘制公里
        currentDistance = (float) (myFootNum * 6.4 / 8000);
        //小数点后一位
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
        String currentDis = df.format(currentDistance);
        canvas.drawText(currentDis + "公里", (widthBg / 3 - 30), heightBg / 2 + 150, textPaint);
        //中间竖线
        mPaint.setStrokeWidth(8);
        canvas.drawLine(widthBg / 2 + 10, heightBg / 2 + 110, widthBg / 2 + 10, heightBg / 2 + 155, mPaint);
        //绘制卡路里
        currentCal = myFootNum * 230 / 8000;
        canvas.drawText(String.valueOf(currentCal) + "千卡", (widthBg / 2 + 40), heightBg / 2 + 150, textPaint);


    }

    private void drawLines(Canvas canvas) {
        mPaint.setColor(line_color);
        mPaint.setStrokeWidth(4);
        for (int i = 0; i < 360; i++) {
            canvas.drawLine(widthBg / 2, (heightBg / 2 - ra_inner_circle), widthBg / 2, (heightBg / 2 - ra_inner_circle + line_length), mPaint);
            canvas.rotate(1, widthBg / 2, heightBg / 2);
        }
    }
```

![](https://github.com/baojie0327/ViewAndGroup/blob/master/images/xiaomisport.gif)


画CircleProgress

```
  //画圆弧
        ringProgressPaint.setStyle(Paint.Style.STROKE);
        ringProgressPaint.setStrokeWidth(ringSize);

        //  ringProgressPaint.setColor(ring_progress_color);
        RectF oval = new RectF(centre - radius, centre - radius, centre
                + radius, centre + radius);  //用于定义的圆弧的形状和大小的界限

        //创建一个渲染器
        SweepGradient mSweepGradient=new SweepGradient(canvas.getWidth()/2
                ,canvas.getHeight()/2,new int[]{Color.rgb(130,213,131),Color.rgb(150,251,196),Color.rgb(130,213,131)},null);
        Matrix matrix=new Matrix();
        matrix.setRotate(-90f,canvas.getWidth()/2,canvas.getHeight()/2);
        mSweepGradient.setLocalMatrix(matrix);
        ringProgressPaint.setShader(mSweepGradient);
        canvas.drawArc(oval, 90, 360 * tempProgress / maxProgress, false, ringProgressPaint);

        //画圆点
        // 画进度点   30°角度 的弧度 = 2 * PI / 360 * 30
        int rangle = 0;
        if (tempProgress == 0) {
            rangle = 360 / maxProgress;
        } else {
            rangle = 360 * (int) tempProgress / maxProgress;
        }

        double a = 0.0;//角度
        int pointX = 0;
        int pointY = 0;


        if (rangle > 0 && rangle <= 90) {
            a = 2 * Math.PI / 360 * (270 - rangle);
            pointX = centre + (int) (radius * Math.cos(a));
            pointY = centre - (int) (radius * Math.sin(a));
        } else if (rangle > 90 && rangle <= 180) {
            a = 2 * Math.PI / 360 * (rangle + 90);
            pointX = centre + (int) (radius * Math.cos(a));
            pointY = centre + (int) (radius * Math.sin(a));
        } else if (rangle > 180 && rangle <= 270) {
            a = 2 * Math.PI / 360 * (rangle);
            pointX = centre - (int) (radius * Math.sin(a));
            pointY = centre + (int) (radius * Math.cos(a));
        } else if (rangle > 270 && rangle <= 360) {
            a = 2 * Math.PI / 360 * (rangle - 90);
            pointX = centre - (int) (radius * Math.cos(a));
            pointY = centre - (int) (radius * Math.sin(a));
        }

     

        pointPaint.setColor(dot_color);
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setAntiAlias(true);  //消除锯齿
        pointPaint.setShadowLayer(10, 0, 0, Color.GRAY);
        //  Log.d("TAG", "pointX = " + pointX + "||pointY = " + pointY);
        canvas.drawCircle(pointX, pointY, dotSize, pointPaint);
        ```

      ![](https://github.com/baojie0327/ViewAndGroup/blob/master/images/circleprogress.gif)

