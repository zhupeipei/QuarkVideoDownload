package com.aire.quark.video.util;

import android.util.Log;

/**
 * @author ZhuPeipei
 * @date 2023/7/28 20:24
 */
public class Logger {
    private final static int LEVEL = Log.DEBUG;

    public static void i(String tag, String msg) {
        if (LEVEL >= Log.INFO) {
            Log.i(tag, msg);
        }
    }
}
