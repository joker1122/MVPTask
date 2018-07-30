package com.example.a18679.mvptask.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a18679.mvptask.R;

public class UiTask extends LinearLayout {
    private Drawable mDrawableLeftImg;
    private Drawable mDrawableRightImg;
    private ImageView mImageViewLeft;
    private ImageView mImageViewRight;
    private ClickListener mClickListener;
    private Context mContext;
    private AttributeSet mAttributeSet;

    public UiTask(Context context) {
        super(context);
    }

    public UiTask(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UiTask(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mAttributeSet = attrs;
        init();
    }

    private void init() {
        TypedArray typedArray = mContext.obtainStyledAttributes(mAttributeSet, R.styleable.UiTask);
        mDrawableLeftImg = typedArray.getDrawable(R.styleable.UiTask_leftImg);
        int leftWidth = typedArray.getInt(R.styleable.UiTask_left_width, LayoutParams.MATCH_PARENT);
        int leftHeight = typedArray.getInt(R.styleable.UiTask_left_height, LayoutParams.MATCH_PARENT);
        mDrawableRightImg = typedArray.getDrawable(R.styleable.UiTask_rightImg);
        int rightWidth = typedArray.getInt(R.styleable.UiTask_right_width, LayoutParams.MATCH_PARENT);
        int rightHeight = typedArray.getInt(R.styleable.UiTask_right_height, LayoutParams.MATCH_PARENT);
        typedArray.recycle();
        mImageViewLeft = new ImageView(mContext);
        mImageViewRight = new ImageView(mContext);
        mImageViewLeft.setImageDrawable(mDrawableLeftImg);
        LayoutParams layoutParamsLeft = new LayoutParams(leftWidth, leftHeight);
        addView(mImageViewLeft, layoutParamsLeft);
        mImageViewLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.leftClick(mImageViewRight);
            }
        });
        mImageViewRight.setImageDrawable(mDrawableRightImg);
        LayoutParams layoutParamsRight = new LayoutParams(rightWidth, rightHeight);
        addView(mImageViewRight, layoutParamsRight);
        mImageViewRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.rightClick(mImageViewLeft);
            }
        });
    }

    public void addOnClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    public Drawable getImageViewLeft() {
        return mImageViewLeft.getDrawable();
    }

    public void setImageViewLeft(Drawable drawableLeftImg) {
        mImageViewLeft.setImageDrawable(drawableLeftImg);
    }

    public Drawable getImageViewRight() {
        return mImageViewRight.getDrawable();
    }

    public void setImageViewRight(Drawable drawableRightImg) {
        mImageViewRight.setImageDrawable(drawableRightImg);
    }
}
