package com.aire.quark.video.webview.util;

import android.os.Build;
import android.webkit.WebView;

/**
 * @author ZhuPeipei
 * @date 2023/7/28 20:07
 */
public class WebViewUtil {
    public static void excludeWebViewLoophole(WebView webView) {
        if (webView == null) {
            return;
        }
        //  fix webview bug https://juejin.im/post/5c7b6de56fb9a049dc02f7b0
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
    }
}
