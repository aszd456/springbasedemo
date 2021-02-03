package org.javaboy;

import jdk.internal.util.xml.impl.Input;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @ClassName OkHttpMain
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 15:35
 * @Version 1.0
 **/
public class OkHttpMain {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get()
                .url("https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2020%2F1227%2F5eba4df6j00qlzdb50051c000u000u0m.jpg&thumbnail=650x2147483647&quality=80&type=jpg").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                FileOutputStream out = new FileOutputStream(new File("D:\\学习书籍\\workspace\\123.jpg"));
                int len;
                byte[] buf = new byte[1024];
                InputStream is = Objects.requireNonNull(response.body()).byteStream();
                while ((len = is.read(buf)) != -1) {
                    out.write(buf, 0, len);
                }
                out.close();
                is.close();
            }
        });
    }
}
