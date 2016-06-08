package com.baifan.lazyfragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.baifan.lazyfragmentdemo.fragment.DemoFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager mVp;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    private void initEvents() {
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(mAdapter);
        mVp.setOffscreenPageLimit(4);
    }

    private void initViews() {
        mVp = (ViewPager) findViewById(R.id.vp);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return DemoFragment.newInstance(0, "这里是fragment0");
                case 1:
                    return DemoFragment.newInstance(0, "这里是fragment1");
                case 2:
                    return DemoFragment.newInstance(0, "这里是fragment2");
                case 3:
                    return DemoFragment.newInstance(0, "这里是fragment3");
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}
