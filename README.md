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
```

```
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
    
    
