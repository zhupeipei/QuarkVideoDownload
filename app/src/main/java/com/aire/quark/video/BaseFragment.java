package com.aire.quark.video;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

/**
 * @author ZhuPeipei
 * @date 2023/7/28 19:46
 */
public abstract class BaseFragment extends Fragment {
    public View mContainer = null;
    protected Context mContext;

    public BaseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContainer = inflater.inflate(getContainerLayoutId(), container, false);
        mContext = mContainer.getContext();
        initUi();
        return mContainer;
    }

    public <T extends View> T findViewById(int id) {
        return mContainer.findViewById(id);
    }

    public abstract int getContainerLayoutId();

    public abstract void initUi();
}