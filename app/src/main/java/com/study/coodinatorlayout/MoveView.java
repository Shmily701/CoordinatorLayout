package com.study.coodinatorlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Shmily on 2017/11/28.
 */

public class MoveView extends Button{

    private String TAG = "Corrdinator";
    private float mLastX, mLastY;

    public MoveView(Context context) {
        this(context,null);
    }
    public MoveView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClickable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v(TAG,"DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.v(TAG,"UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.v(TAG,"MOVE");
                this.setX(this.getX() + rawX - mLastX);
                this.setY(this.getY() + rawY - mLastY);
                break;
        }
        mLastX = event.getRawX();
        mLastY = event.getRawY();
        return true;
    }
}
