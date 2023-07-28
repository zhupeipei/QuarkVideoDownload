package com.aire.quark.video.webview.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.aire.quark.video.webview.util.WebViewUtil;

/**
 * @author ZhuPeipei
 * @date 2023/7/28 20:08
 */
public class QuarkWebView extends WebView {
    public QuarkWebView(@NonNull Context context) {
        this(context, null);
    }

    public QuarkWebView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public QuarkWebView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public QuarkWebView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public QuarkWebView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        WebViewUtil.excludeWebViewLoophole(this);
    }
}
