package com.feng.tablayoutdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.feng.tabdemo.R;
import com.feng.tablayoutdemo.adapter.MyViewPagerAdapter;
import com.feng.tablayoutdemo.fragment.TestFragment;
import com.feng.tablayoutdemo.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StyleOneActivity extends AppCompatActivity {
    private static final String TAG = "fzh";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> mFragmentList;   //碎片集合
    private List<String> mPageTitleList;    //tab的标题

    private static final int TAB_NUM = 6;   //标签数
    private List<String> mStrs = Arrays.asList("Java", "Android", "计算机网络", "数据结构",
            "算法", "操作系统");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_one);

        initVariable();

        initView();

//        mTabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                TabLayout.SlidingTabStrip slidingTabStrip =
//                        (TabLayout.SlidingTabStrip) mTabLayout.getChildAt(0);
//                Log.d(TAG, "slidingTabStrip.getWidth() = " + slidingTabStrip.getWidth());
//                for (int i = 0; i < slidingTabStrip.getChildCount(); i++) {
//                    TabLayout.TabView tabView = (TabLayout.TabView) slidingTabStrip.getChildAt(i);
//                    Log.d(TAG, "tabView.getWidth() = " + tabView.getWidth());
//                    TextView textView = tabView.getTextView();
//                    Log.d(TAG, "textView.getWidth() = " + textView.getWidth());
//                }
//            }
//        });
    }

    private void initVariable() {
        mFragmentList = new ArrayList<>();
//        mFragmentList.add(new TabFragment());
        for (int i = 0; i < TAB_NUM; i++) {
            mFragmentList.add(TestFragment.newInstance(mStrs.get(i), i));
        }

        mPageTitleList = new ArrayList<>();
        for (int i = 0; i < TAB_NUM; i++) {
            mPageTitleList.add(mStrs.get(i));
        }
    }

    private void initView() {
        mViewPager = findViewById(R.id.vp_style_one_content);
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList, mPageTitleList));

        mTabLayout = findViewById(R.id.tl_style_one_tab);
        mTabLayout.setupWithViewPager(mViewPager);  //将TabLayout与ViewPager关联

//        mTabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                setScale(0, MyPageTransformer.MAX_SCALE);
//            }
//        });
//
//        mViewPager.setPageTransformer(false, new MyPageTransformer(mTabLayout));
    }

    /**
     * 将 Tab[index] 放大为初始的 scale 倍
     */
    private void setScale(int index, float scale) {
        LinearLayout ll = (LinearLayout) mTabLayout.getChildAt(0);
        TabLayout.TabView tb = (TabLayout.TabView) ll.getChildAt(0);
        View view  = tb.getTextView();
        view.setScaleX(scale);
        view.setScaleY(scale);
    }

}
