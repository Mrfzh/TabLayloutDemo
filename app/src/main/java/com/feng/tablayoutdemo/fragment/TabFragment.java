package com.feng.tablayoutdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feng.tabdemo.R;
import com.feng.tablayoutdemo.adapter.MyViewPagerAdapter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Feng Zhaohao
 * Created on 2020/1/5
 */
public class TabFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> mFragmentList;   //碎片集合
    private List<String> mPageTitleList;    //tab的标题

    private static final int TAB_NUM = 6;   //标签数
    private List<String> mStrs = Arrays.asList("1", "2", "3", "4",
            "5", "6");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tab, null);

        mViewPager = view.findViewById(R.id.vp_tab_view_pager);
        mViewPager.setAdapter(new MyViewPagerAdapter(getChildFragmentManager(), mFragmentList, mPageTitleList));

        mTabLayout = view.findViewById(R.id.tv_tab_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);  //将TabLayout与ViewPager关联

        return view;
    }

    private void initVariable() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < TAB_NUM; i++) {
            mFragmentList.add(TestFragment.newInstance(mStrs.get(i), i));
        }

        mPageTitleList = new ArrayList<>();
        for (int i = 0; i < TAB_NUM; i++) {
            mPageTitleList.add(mStrs.get(i));
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("TestFragment", "setUserVisibleHint: run, isVisibleToUser = " + isVisibleToUser
                + ", content = tab");
    }

}
