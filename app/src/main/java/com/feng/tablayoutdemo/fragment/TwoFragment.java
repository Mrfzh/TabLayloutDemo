package com.feng.tablayoutdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feng.tabdemo.R;
import com.feng.tablayoutdemo.fragment.TestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Feng Zhaohao
 * Created on 2018/9/2
 */
public class TwoFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<TestFragment> mFragmentList;   //碎片集合
    private List<String> mPageTitleList;    //tab的标题

    private static final int TAB_NUM = 4;   //标签数

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initVariable();

        initView();
    }

    private void initVariable() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < TAB_NUM; i++) {
            mFragmentList.add(TestFragment.newInstance("fragment " + (i + 1), i));
        }

        mPageTitleList = new ArrayList<>();
        for (int i = 0; i < TAB_NUM; i++) {
            mPageTitleList.add("标签" + (i + 1));
        }
    }

    private void initView() {
//        mViewPager = getActivity().findViewById(R.id.vp_fragment_two_content);
//        //通过getChildFragmentManager()获得fragment的FragmentManager
//        mViewPager.setAdapter(new MyViewPagerAdapter(getChildFragmentManager(), mFragmentList, mPageTitleList));
//
//        mTabLayout = getActivity().findViewById(R.id.tl_fragment_two_tab);
//        mTabLayout.setupWithViewPager(mViewPager);  //将TabLayout与ViewPager关联
    }
}
