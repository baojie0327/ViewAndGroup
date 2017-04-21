package com.example.ahuang.viewandgroup.View; /**
 * TopBar   2017-04-20
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ahuang.viewandgroup.R;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 04 20
 */
public class TopBar extends RelativeLayout {
    //控件
    private ImageView img_left;
    private TextView tv_title;
    private TextView tv_right;
    // 布局属性，用来控制组件元素在ViewGroup中的位置
    private LayoutParams mLeftParams, mTitlepParams, mRightParams;

    // 左控件的属性值，即我们在atts.xml文件中定义的属性
    private Drawable mBackGround; //左侧图片的背景图
    //中间title的属性值
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;
    //右边TextView的属性值
    private int mRightTextColor;
    private float mRightTextSize;
    private String mRightText;

    // 映射传入的接口对象
    private topbarClickListener mListener;


    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //设置背景色
        setBackgroundColor(0xFF190D31);
        //获得atts.xml定义的属性值，存储在TypedArray中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        //左侧图片
        mBackGround = ta.getDrawable(R.styleable.TopBar_mLeftBackGround);
        //中间title
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_mTitleSize, 10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_mTitleColor, 0);
        mTitle = ta.getString(R.styleable.TopBar_mTitle);
        //右边Title
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightTextSize = ta.getDimension(R.styleable.TopBar_rightTitleSize, 1);
        mRightText = ta.getString(R.styleable.TopBar_rightTitle);
        // 获取完TypedArray的值后，一般要调用
        // recyle方法来避免重新创建的时候的错误
        ta.recycle();

        //创建控件
        img_left=new ImageView(context);
        tv_title=new TextView(context);
        tv_right=new TextView(context);

        // 为创建的组件元素赋值
        img_left.setBackground(mBackGround);

        tv_title.setText(mTitle);
        tv_title.setTextColor(mTitleTextColor);
        tv_title.setTextSize(mTitleTextSize);

        tv_right.setText(mRightText);
        tv_right.setTextColor(mRightTextColor);
        tv_right.setTextSize(mRightTextSize);

        //设置组件的位置
        mLeftParams=new LayoutParams(60, 60);
        mLeftParams.addRule(ALIGN_PARENT_LEFT,TRUE);
        mLeftParams.addRule(CENTER_VERTICAL,TRUE);
        addView(img_left,mLeftParams);
        mTitlepParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTitlepParams.addRule(CENTER_IN_PARENT,TRUE);
        addView(tv_title,mTitlepParams);
        mRightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        mRightParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        addView(tv_right, mRightParams);

        img_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });

        tv_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });

    }

    // 暴露一个方法给调用者来注册接口回调
    public void setOnTopbarClickListener(topbarClickListener mListener) {
        this.mListener = mListener;
    }

    //定义接口，响应点击事件
    public interface topbarClickListener {
        //左按钮点击事件
        void leftClick();

        //右按钮点击事件
        void rightClick();
    }

}