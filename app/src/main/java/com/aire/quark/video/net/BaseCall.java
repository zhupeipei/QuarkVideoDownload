package com.aire.quark.video.net;

import okhttp3.OkHttpClient;

/**
 * @author ZhuPeipei
 * @date 2023/7/28 20:27
 */
public class BaseCall {
    private final static class BaseCallHolder {
        private final static BaseCall INSTANCE = new BaseCall();
    }

    public final static BaseCall getInstance() {
        return BaseCallHolder.INSTANCE;
    }

    private OkHttpClient mOkHttpClient = null;

    private BaseCall() {
        mOkHttpClient = new OkHttpClient();
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
