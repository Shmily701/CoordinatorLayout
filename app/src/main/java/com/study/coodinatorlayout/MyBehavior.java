package com.study.coodinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Shmily on 2017/11/28.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<ImageView>{
    private int width;

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    /**
     * 判断child的布局是否依赖dependency
     * @param parent
     * @param child
     * @param dependency
     * @return true 表示依赖 false表示不依赖
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        //如果dependency是MoveView的实例，说明它就是我们所需要的Dependency
        return dependency instanceof MoveView;
    }

    /**
     * 每当dependency位置发生变化,都会执行onDependentView的Changed方法
     * 当dependency发生变化时,(位置,宽高),执行这个函数
     * @param parent
     * @param child
     * @param dependency
     * @return 返回true表示child的位置或者宽高会随着改变,否则返回false
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
        child.setX(dependency.getX() + 100);
        child.setY(dependency.getY()-20);
        return true;
    }
}
