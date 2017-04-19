# ViewAndGroup
Android 之View测量，绘制，自定义VIew，ViewGroup的测量，绘制，自定义ViewGroup

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
