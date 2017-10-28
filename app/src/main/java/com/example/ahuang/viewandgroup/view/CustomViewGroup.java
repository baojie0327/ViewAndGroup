package com.example.ahuang.viewandgroup.view; /**
 * CustomViewGroup  2017-05-05
 * Copyright (c) 2017 SSRJ Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 05 05
 */
public class CustomViewGroup extends ViewGroup {

    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //直接使用系统的MarginLayoutParams,只需要ViewGroup能够支持margin即可
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取此ViewGroup的上级容器推荐的宽和高的测量模式，测量值
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //此ViewGroup的measure过程,主要用于自定义ViewGroup设置成了wrap_content

        //子View的个数
        int mCount = getChildCount();

        int width = 0;
        int height = 0;
        //子View的宽度和高度，测量值
        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParams = null;


        // 计算上边两个childView的宽度
        int tWidth = 0;
        //计算下面两个childView的宽度，最终宽度取二者之间大值
        int bWidth = 0;

        //计算左边两个childView的高度
        int lHeight = 0;
        //计算右边两个childView的高度
        int rHeight = 0;

        for (int i = 0; i < mCount; i++) {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams) childView.getLayoutParams();
            //最上面两个View的宽度
            if (i == 0 || i == 1) {
                tWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }
            //最下面两个View的宽度
            if (i == 2 || i == 3) {
                bWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }
            //最左边两个View的高度
            if (i == 0 || i == 2) {
                lHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }
            //最右边两个View的高度
            if (i == 1 || i == 3) {
                rHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }
        }

        width = Math.max(tWidth, bWidth);
        height = Math.max(lHeight, rHeight);

        //让控制支持wrap_content属性
        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY ? widthSize : width),
                (heightMode == MeasureSpec.EXACTLY ? heightSize : height));

        //  super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int cCount = getChildCount();
        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParms = null;
        //遍历所有childView,根据其宽和高，以及margin进行布局
        for (int i = 0; i < cCount; i++) {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParms = (MarginLayoutParams) childView.getLayoutParams();

            int cl = 0, ct = 0, cr = 0, cb = 0;
            switch (i) {
                case 0:
                    cl = cParms.leftMargin;
                    ct = cParms.topMargin;
                    break;
                case 1:
                    cl = getWidth() - cParms.leftMargin - cWidth - cParms.rightMargin;
                    ct = cParms.topMargin;
                    break;
                case 2:
                    cl = cParms.leftMargin;
                    ct = getHeight() - cParms.topMargin - cHeight - cParms.bottomMargin;
                    break;
                case 3:
                    cl = getWidth() - cParms.leftMargin - cWidth - cParms.rightMargin;
                    ct = getHeight() - cParms.topMargin - cHeight - cParms.bottomMargin;
                    break;
            }
            cr = cl + cWidth;
            cb = ct + cHeight;
            childView.layout(cl, ct, cr, cb);

        }


    }
}