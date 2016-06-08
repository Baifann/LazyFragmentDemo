package com.baifan.lazyfragmentdemo.fragment;


import android.support.v4.app.Fragment;

/**
 * Created by baifan on 16/6/8.
 */
public abstract class LazyFragment extends Fragment {
    public boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            isVisible = true;
            onVisible();
        }else{
            onInVisible();
        }
    }

    private void onInVisible(){

    };

    private void onVisible(){
        onLazyLoad();
    }

    protected abstract void onLazyLoad();
}
