package com.feng.tablayoutdemo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feng.tabdemo.R;
import com.feng.tablayoutdemo.fragment.TestFragment;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "TestFragment";

    private Button mOneBtn;
    private Button mTwoBtn;
    private Button mThreeBtn;

    private Fragment mCurrFragment = null;
    private Fragment mFragmentOne;
    private Fragment mFragmentTwo;
    private Fragment mFragmentThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
//        changeFragment(0);

        Log.d(TAG, "TestActivity, onCreate: run");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "TestActivity, onStart: run");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "TestActivity, onResume: run");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "TestActivity, onPause: run");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "TestActivity, onStop: run");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "TestActivity, onDestroy: run");
    }

    private void initView() {
        mOneBtn = findViewById(R.id.btn_test_one);
        mOneBtn.setOnClickListener(this);
        mTwoBtn = findViewById(R.id.btn_test_two);
        mTwoBtn.setOnClickListener(this);
        mThreeBtn = findViewById(R.id.btn_test_three);
        mThreeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_one:
//                if (mCurrFragment == mFragmentOne) {
//                    break;
//                }
                changeFragment(0);
                break;
            case R.id.btn_test_two:
//                if (mCurrFragment == mFragmentTwo) {
//                    break;
//                }
                changeFragment(1);
                break;
            case R.id.btn_test_three:
                if (mCurrFragment == mFragmentThree) {
                    break;
                }
                changeFragment(2);
                break;
            default:
                break;
        }
    }

    private void changeFragment(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment showFragment = null;
        switch (i) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne = TestFragment.newInstance("one", i);
                    ft.add(R.id.fv_test_container, mFragmentOne);
                }
                showFragment = mFragmentOne;
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = TestFragment.newInstance("two", i);
                    ft.add(R.id.fv_test_container, mFragmentTwo);
                }
                showFragment = mFragmentTwo;
                break;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = TestFragment.newInstance("three", i);
                    ft.add(R.id.fv_test_container, mFragmentThree);
                }
                showFragment = mFragmentThree;
                break;
        }
        // mCurrFragment 存储当前显示的 Fragment
        if (mCurrFragment != null) {
            ft.hide(mCurrFragment);
        }
        ft.show(showFragment);
        mCurrFragment = showFragment;
//        ft.replace(R.id.fv_test_container, showFragment);
        ft.commit();
    }

    private void removeFragment(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment removeFragment = null;
        switch (i) {
            case 0:
                removeFragment = mFragmentOne;
                break;
            case 1:
                removeFragment = mFragmentTwo;
                break;
            case 2:
                removeFragment = mFragmentThree;
                break;
        }
        ft.remove(removeFragment);
        ft.commit();
    }
}
