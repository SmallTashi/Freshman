package com.mredrock.cyxbs.freshman.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import com.mredrock.cyxbs.freshman.R;

/**
 * Created by SmartTahi on 2018/3/22.
 * ViewRing
 */

public class ViewRing extends View {
    private Paint circlePaint = new Paint();
    private Paint progressRing = new Paint();
    private RectF mF = new RectF();
    private int progress = 225;
    private int ringColor;
    private float ringRadius;
    private float ringWind;


    public ViewRing(Context context) {
        this(context, null, 0);
    }

    public ViewRing(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewRing(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //自定义的resource（R.styleable.RingView）文件名要求与自定义View类名相同
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ViewRing);
        ringColor = typedArray.getColor(R.styleable.ViewRing_RingView_Color, ringColor);
        ringRadius = typedArray.getDimension(R.styleable.ViewRing_RingView_minRadius, getRingRadius());
        ringWind = typedArray.getDimension(R.styleable.ViewRing_RingView_wind, getRingWind());
        progress = typedArray.getInt(R.styleable.ViewRing_RingView_progress, getProgress());
        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        initProgressRingPaint();
        mF.set(getWidth() / 2 - getRingRadius() + getRingWind(), getHeight() / 2 + getRingWind() - getRingRadius(), getWidth() / 2 + getRingRadius() - getRingWind(), getHeight() / 2 + getRingRadius() - getRingWind());
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, ringRadius - getRingWind() / 2, circlePaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, ringRadius - getRingWind() * 3 / 2, circlePaint);
        canvas.drawArc(mF, -90, getProgress(), false, progressRing);
    }

    public void initProgressRingPaint() {
        progressRing.setStrokeCap(Paint.Cap.ROUND);
        progressRing.setStrokeWidth(getRingWind());
        progressRing.setColor(getRingColor());
        progressRing.setAntiAlias(true);
        progressRing.setStyle(Paint.Style.STROKE);
        progressRing.setDither(true);
    }

    private void initPaint() {
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(getRingWind() / 20);
        circlePaint.setColor(getRingColor());
        circlePaint.setAlpha(150);
        circlePaint.setDither(true);
    }

    private int dp2px(float dp) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics);
    }

    private float getRingRadius() {
        return ringRadius;
    }

    public void setRingRadius(float ringRadius) {

        this.ringRadius = dp2px(ringRadius);
    }

    private int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    private float getRingWind() {
        return ringWind;
    }

    public void setRingWind(float ringWind) {
        this.ringWind = dp2px(ringWind);
    }

    private int getRingColor() {
        return ringColor;
    }

    public void setRingColor(int ringColor) {
        this.ringColor = ringColor;
    }

}

