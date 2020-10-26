package com.feng.tablayoutdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feng.tabdemo.R;

/**
 * @author Feng Zhaohao
 * Created on 2018/8/24
 */
public class TestFragment extends Fragment {
    private static final String TAG = "TestFragment";

    private String content; //碎片正文内容
    private int index;

    /**
     * 返回碎片实例
     * @param content
     * @return
     */
    public static TestFragment newInstance(String content, int index) {
        TestFragment fragment = new TestFragment();
        //动态加载fragment，接受activity传入的值
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        bundle.putInt("index", index);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        content = getArguments().getString("content");
        index = getArguments().getInt("index");
        Log.d(TAG, "onAttach: run, content = " + content);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: run, content = " + content);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_test, null);
        view.setTag(index);
        TextView contentTextView = view.findViewById(R.id.tv_fragment_test_content);
        contentTextView.setText(content);

        Log.d(TAG, "onCreateView: run, content = " + content);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: run, content = " + content);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: run, content = " + content);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: run, content = " + content);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: run, content = " + content);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: run, content = " + content);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: run, content = " + content);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: run, content = " + content);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: run, content = " + content);
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        Log.d(TAG, "setUserVisibleHint: run, isVisibleToUser = " + isVisibleToUser
//            + ", content = " + content);
//    }
}
