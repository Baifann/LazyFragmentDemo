package com.baifan.lazyfragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.baifan.lazyfragmentdemo.R;

/**
 * Created by baifan on 16/6/8.
 */
public class DemoFragment extends LazyFragment implements View.OnClickListener{
    private String mTitle;
    private int mPage;
    private boolean isPrepared;
    private boolean isFirstLoaded = true;

    private TextView mTvTitle;
    private Button mBtnChange;

    public static DemoFragment newInstance(int page, String title) {
        DemoFragment demoFragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        demoFragment.setArguments(args);
        return demoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt("page");
        mTitle = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, null);
        initViews(view);
        initEvents();
        isFirstLoaded = true;
        isPrepared = true;
        onLazyLoad();
        return view;
    }

    private void initViews(View view) {
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
    }

    @Override
    protected void onLazyLoad() {
        if (!isPrepared || !isVisible || !isFirstLoaded) {
            Log.i("caonima", "还没有到初始化的时候");
            return;
        }
        //初始化数据
        changeTv();
        Log.i("caonima", "初始化");
        isFirstLoaded = false;
    }

    private void changeTv(){
        mPage++;
        mTvTitle.setText(mTitle + ",page:" + mPage);
    }

    private void initEvents(){
        mBtnChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        changeTv();
    }
}
