package com.feng.tablayoutdemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.feng.tabdemo.R;
import com.feng.tablayoutdemo.fragment.TestFragment;
import com.feng.tablayoutdemo.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class StyleTwoActivity extends AppCompatActivity implements View.OnClickListener{

    private List<TestFragment> mFragmentList;

    private RelativeLayout mTabOneLayout;
    private RelativeLayout mTabTwoLayout;
    private RelativeLayout mTabThreeLayout;
    private RelativeLayout mTabFourLayout;
    private TextView mTabOneTextView;
    private TextView mTabTwoTextView;
    private TextView mTabThreeTextView;
    private TextView mTabFourTextView;
    private ImageView mTabOneImageView;
    private ImageView mTabTwoImageView;
    private ImageView mTabThreeImageView;
    private ImageView mTabFourImageView;
    private ImageView mMenuImageView;
    private RelativeLayout mTitleLayout;

    public static int TAB_STATE = 0;  //0为未添加碎片，1为已添加碎片

    private FragmentTransaction fragmentTransaction;

    private TwoFragment mTwoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_style_two);

        initVariable();

        initView();

        mTabOneLayout.performClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TAB_STATE = 0;
    }

    private void initVariable() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mFragmentList.add(TestFragment.newInstance("fragment " + (i + 1), i));
        }
        mTwoFragment = new TwoFragment();
    }

    private void initView() {
        mTabOneLayout = findViewById(R.id.rv_style_two_tab_one);
        mTabOneLayout.setOnClickListener(this);

        mTabTwoLayout = findViewById(R.id.rv_style_two_tab_two);
        mTabTwoLayout.setOnClickListener(this);

        mTabThreeLayout = findViewById(R.id.rv_style_two_tab_three);
        mTabThreeLayout.setOnClickListener(this);

        mTabFourLayout = findViewById(R.id.rv_style_two_tab_four);
        mTabFourLayout.setOnClickListener(this);

        mTabOneTextView = findViewById(R.id.tv_style_two_tab_one);
        mTabTwoTextView = findViewById(R.id.tv_style_two_tab_two);
        mTabThreeTextView = findViewById(R.id.tv_style_two_tab_three);
        mTabFourTextView = findViewById(R.id.tv_style_two_tab_four);

        mTabOneImageView = findViewById(R.id.iv_style_two_tab_one);
        mTabTwoImageView = findViewById(R.id.iv_style_two_tab_two);
        mTabThreeImageView = findViewById(R.id.iv_style_two_tab_three);
        mTabFourImageView = findViewById(R.id.iv_style_two_tab_four);

        mMenuImageView = findViewById(R.id.iv_style_two_menu);
        mMenuImageView.setOnClickListener(this);

        mTitleLayout = findViewById(R.id.rv_style_two_top_title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rv_style_two_tab_one:
                tabSelected();
                mTabOneImageView.setSelected(true);
                mTabOneTextView.setSelected(true);
                fragmentTransaction.show(mFragmentList.get(0));
                fragmentTransaction.commit();
                break;
            case R.id.rv_style_two_tab_two:
                tabSelected();
                mTabTwoImageView.setSelected(true);
                mTabTwoTextView.setSelected(true);
                fragmentTransaction.show(mFragmentList.get(1));
                fragmentTransaction.commit();
                break;
            case R.id.rv_style_two_tab_three:
                tabSelected();
                mTabThreeImageView.setSelected(true);
                mTabThreeTextView.setSelected(true);
                fragmentTransaction.show(mFragmentList.get(2));
                fragmentTransaction.commit();
                break;
            case R.id.rv_style_two_tab_four:
                tabSelected();
                mTabFourImageView.setSelected(true);
                mTabFourTextView.setSelected(true);
                fragmentTransaction.show(mFragmentList.get(3));
                fragmentTransaction.commit();
                break;
            case R.id.iv_style_two_menu:
                PopupMenu menu = new PopupMenu(this, mMenuImageView);
                menu.getMenuInflater().inflate(R.menu.menu_style_two, menu.getMenu());
                menu.show();
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_menu_style_two_fragment:
                                tabSelected();
                                fragmentTransaction.show(mTwoFragment);
                                fragmentTransaction.commit();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                break;
            default:
                break;
        }
    }

    private void tabSelected() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();  //开启一个事务
        if (TAB_STATE == 0) {
            for (int i = 0; i < mFragmentList.size(); i++) {
                fragmentTransaction.add(R.id.fl_style_two, mFragmentList.get(i));   //添加碎片到容器中
            }
            fragmentTransaction.add(R.id.fl_style_two, mTwoFragment);
            TAB_STATE = 1;
        }
        hideAllFragment(fragmentTransaction);
        setSelected();
    }

    /**
     * 隐藏所有的fragment
     * @param fragmentTransaction
     */
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        for (int i = 0; i < mFragmentList.size(); i++) {
            if (mFragmentList.get(i) != null) {
                fragmentTransaction.hide(mFragmentList.get(i));
            }
        }
        fragmentTransaction.hide(mTwoFragment);
    }

    /**
     * 设置图标和文字的选择状态为false
     */
    private void setSelected() {
        mTabOneTextView.setSelected(false);
        mTabTwoTextView.setSelected(false);
        mTabThreeTextView.setSelected(false);
        mTabFourTextView.setSelected(false);

        mTabOneImageView.setSelected(false);
        mTabTwoImageView.setSelected(false);
        mTabThreeImageView.setSelected(false);
        mTabFourImageView.setSelected(false);
    }
}
