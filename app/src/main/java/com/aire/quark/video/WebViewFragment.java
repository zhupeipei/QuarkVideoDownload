package com.aire.quark.video;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.*;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.aire.quark.video.net.BaseCall;
import com.aire.quark.video.webview.webview.QuarkWebView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.ByteArrayInputStream;

public class WebViewFragment extends BaseFragment {
    private static final String TAG = "WebViewFragment";

    @Override
    public int getContainerLayoutId() {
        return R.layout.fragment_web_view;
    }

    @Override
    public void initUi() {
        Log.i(TAG, "WebViewFragment init");
        QuarkWebView webView = new QuarkWebView(mContext);
        webView.setWebViewClient(mWebViewClient);
        webView.setWebChromeClient(mWebChromeClient);
        webView.loadUrl("https://live.juejin.cn/4354/9932368");
        if (mContainer instanceof FrameLayout) {
            ((FrameLayout) mContainer).addView(webView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            Log.i(TAG, "onLoadResource: " + url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.i(TAG, "onPageStarted: " + url);
        }

        @Nullable
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            Log.i(TAG, "shouldInterceptRequest: " + request.getUrl());
            Uri uri = request.getUrl();
            String path = uri.getPath();
            if (path.endsWith(".m3u8")) {
                Log.i(TAG, "shouldInterceptRequest111 " + uri + "," + request.getRequestHeaders());

                try {
                    OkHttpClient okHttpClient = BaseCall.getInstance().getOkHttpClient();
                    Request.Builder builder = new Request.Builder();
                    //do you want to do for builder
                    Request req = builder.url(request.getUrl().toString()).get().build();
                    Response response = okHttpClient.newCall(req).execute();
                    //do you want to do for response
                    Log.i(TAG, "shouldInterceptRequest111: " + response.body().string());
                    WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(response.body().string().getBytes()));
                    return webResourceResponse;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return super.shouldInterceptRequest(view, request);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.i(TAG, "shouldOverrideUrlLoading: " + request.getUrl());
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.i(TAG, "onPageFinished: " + url);
            super.onPageFinished(view, url);
        }
    };

    private WebChromeClient mWebChromeClient = new WebChromeClient() {

    };
}