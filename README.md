# ViewAndGroup
Android 之View测量，绘制，自定义VIew，ViewGroup的测量，绘制，自定义ViewGroup

操作类型	相关API	备注
绘制颜色	drawColor, drawRGB, drawARGB	使用单一颜色填充整个画布
绘制基本形状	drawPoint, drawPoints, drawLine, drawLines, drawRect, drawRoundRect, drawOval, drawCircle, drawArc	依次为 点、线、矩形、圆角矩形、椭圆、圆、圆弧
绘制图片	drawBitmap, drawPicture	绘制位图和图片
绘制文本	drawText, drawPosText, drawTextOnPath	依次为 绘制文字、绘制文字时指定每个文字位置、根据路径绘制文字
绘制路径	drawPath	绘制路径，绘制贝塞尔曲线时也需要用到该函数
顶点操作	drawVertices, drawBitmapMesh	通过对顶点操作可以使图像形变，drawVertices直接对画布作用、 drawBitmapMesh只对绘制的Bitmap作用
画布剪裁	clipPath, clipRect	设置画布的显示区域
画布快照	save, restore, saveLayerXxx, restoreToCount, getSaveCount	依次为 保存当前状态、 回滚到上一次保存的状态、 保存图层状态、 回滚到指定状态、 获取保存次数
画布变换	translate, scale, rotate, skew	依次为 位移、缩放、 旋转、错切
Matrix(矩阵)	getMatrix, setMatrix, concat	实际画布的位移，缩放等操作的都是图像矩阵Matrix，只不过Matrix比较难以理解和使用，故封装了一些常用的方法。
