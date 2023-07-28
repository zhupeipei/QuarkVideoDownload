package com.aire.quark.video;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebViewFragment extends BaseFragment {
    @Override
    public int getContainerLayoutId() {
        return R.layout.fragment_web_view;
    }

    @Override
    public void initUi() {
        WebView webView = new WebView(mContext);
        webView.loadUrl("https://live.juejin.cn/4354/9932368");
    }
}