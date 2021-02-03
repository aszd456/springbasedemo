package org.javaboy;

import okhttp3.OkHttpClient;

/**
 * @ClassName OkHttpUtils
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 16:07
 * @Version 1.0
 * 静态工厂方法
 **/
public class OkHttpUtils {
    private static OkHttpClient okHttpClient;

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
