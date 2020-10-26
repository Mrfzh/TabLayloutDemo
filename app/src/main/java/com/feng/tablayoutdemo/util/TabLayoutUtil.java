package com.feng.tablayoutdemo.util;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * @author Feng Zhaohao
 * Created on 2019/11/1
 */
public class TabLayoutUtil {
    /**
     * 通过反射的方式改变 Indicator 的宽度
     *
     * @param tabLayout 要改变的 TabLayout
     * @param width     Indicator 的宽度
     * @param margin    Tab 之间的 margin
     */
    public static void setIndicatorWidth(final TabLayout tabLayout, final int width, final int margin) {
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        // 得到当前子 View（TabView）
                        View child = mTabStrip.getChildAt(i);

                        // 得到 TextView 的宽度
                        Field textViewField = child.getClass().getDeclaredField("textView");
                        textViewField.setAccessible(true);
                        TextView mTextView = (TextView) textViewField.get(child);
                        child.setPadding(0,0,0,0);
                        int textViewWidth = mTextView.getWidth();
                        if (textViewWidth == 0) {
                            mTextView.measure(0,0);
                            textViewWidth = mTextView.getMeasuredWidth();
                        }

                        // 设置该子 View 的相关参数
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) child.getLayoutParams();
                        lp.width = textViewWidth > width ? textViewWidth : width;
                        lp.leftMargin = margin;
                        lp.rightMargin = margin;
                        child.setLayoutParams(lp);
                        child.invalidate();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
