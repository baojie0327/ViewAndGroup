package com.example.ahuang.viewandgroup.view; /**
 * XiaoMiStep  2017-04-25
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.ahuang.viewandgroup.R;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 04 25
 */
public class XiaoMiStep extends View {

    //定义颜色
    private int background_color, outer_circle_color, outer_dot_color,
            line_color, ring_color, step_num_color, othet_text_color;
    //定义画笔
    private Paint mPaint;
    private Paint arcPaint;   //圆弧
    private Paint textPaint;  //文本
    private Paint pointPaint; //点
    //背景的坐标
    private int widthBg, heightBg;
    private int ra_out_circle; //最外层圆的半径
    private int ra_inner_circle; //内层圆的半径
    private int line_length; //线的长度

    private int myFootNum; //我的步数
    private int currentFootNum; //当前步数
    private int currentFootNumPre; //当前步数进度
    private float currentDistance; //当前公里
    private int currentCal; //当前卡路里，单位千卡
    private int angle;  //角度
    private int count = 2;  //重复次数

    //动画效果的添加
    private AnimatorSet animSet;

    public int getMyFootNum() {
        return myFootNum;
    }

    public void setMyFootNum(int myFootNum) {
        this.myFootNum = myFootNum;
    }

    public XiaoMiStep(Context context) {
        this(context, null);
    }

    public XiaoMiStep(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XiaoMiStep(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获得atts.xml定义的属性值，存储在TypedArray中
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.XiaoMiStep, defStyleAttr, 0);
        int n = ta.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = ta.getIndex(i);
            switch (attr) {
                case R.styleable.XiaoMiStep_backGroundColor: //背景颜色
                    background_color = ta.getColor(attr, Color.WHITE); //默认为白色
                    break;
                case R.styleable.XiaoMiStep_outerCircleColor: //最外侧圆
                    outer_circle_color = ta.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.XiaoMiStep_outerDotColor: //最外侧圆上的小圆点
                    outer_dot_color = ta.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.XiaoMiStep_lineColor:  //最外侧线的颜色
                    line_color = ta.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.XiaoMiStep_ringColor: //圆环的颜色
                    ring_color = ta.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.XiaoMiStep_stepNumColor: //步数的颜色
                    step_num_color = ta.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.XiaoMiStep_othetTextColor: //其他文字颜色
                    othet_text_color = ta.getColor(attr, Color.WHITE);
                    break;
            }
        }
        ta.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint(); //画笔
        mPaint.setAntiAlias(true);
        arcPaint = new Paint();  //圆环画笔
        arcPaint.setAntiAlias(true);
        textPaint = new Paint();  //文字画笔
        textPaint.setAntiAlias(true);
        pointPaint = new Paint(); //点
        pointPaint.setAntiAlias(true);
        animSet = new AnimatorSet(); //动画组合
    }

    public void reSet(int footNum){
        this.myFootNum=footNum;
        startAnim();
    }

    /**
     * 重写onMeasure()方法，支持wrap_content属性
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width;
        int height;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);  //宽度的测量模式
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);  //宽度的测量值
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);  //高度的测量模式
        int heightSize = MeasureSpec.getSize(heightMeasureSpec); //高度的测量值
        //如果布局里面设置的是固定值,这里取布局里面的固定值;如果设置的是match_parent,则取父布局的大小
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            //如果布局里面没有设置固定值,这里取布局的宽度的1/2
            width = widthSize * 1 / 2;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            //如果布局里面没有设置固定值,这里取布局的高度的3/4
            height = heightSize * 3 / 4;
        }
        widthBg = width;
        heightBg = height;
        ra_out_circle = heightBg * 3 / 9;
        ra_inner_circle = heightBg * 3 / 10;
        line_length = 30;
        setMeasuredDimension(width, height);
        startAnim();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
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

    private void startAnim() {
        //小圆点动画
        final ValueAnimator dotAnimator =ValueAnimator.ofInt(-90, (myFootNum*360/8000-90));

        dotAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                angle = (int) dotAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        dotAnimator.setInterpolator(new LinearInterpolator());



        //步数动画实现
        final ValueAnimator walkAnimator = ValueAnimator.ofInt(0, myFootNum);
        walkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentFootNum = (int) walkAnimator.getAnimatedValue();
                postInvalidate();
            }
        });


        //画弧动画的实现
        final ValueAnimator arcAnimator = ValueAnimator.ofInt(0, (myFootNum * 360 / 8000));
        arcAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentFootNumPre = (int) arcAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animSet.setDuration(2000);
        animSet.playTogether(walkAnimator, arcAnimator, dotAnimator);
        animSet.start();
    }


}