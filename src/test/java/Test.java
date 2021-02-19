import okhttp3.*;
import org.javaboy.Book;
import org.javaboy.DataSource;
import org.javaboy.JavaConfig;
import org.javaboy.SayHello;
import org.javaboy.service.ShowCmdService;
import org.javaboy.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 15:17
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = (Book) ctx.getBean("book");
//        ctx.getBean(Book.class);
        System.out.println(book);

        //静态工厂注入
        OkHttpClient okHttpClient = ctx.getBean("okHttpClient", OkHttpClient.class);
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
                FileOutputStream out = new FileOutputStream(new File("D:\\学习书籍\\workspace\\iu.jpg"));
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
        //注意，配置的加载，是使用 AnnotationConfigApplicationContext 来实现
        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(JavaConfig.class);
        SayHello hello = ctx2.getBean(SayHello.class);
        System.out.println(hello.sayHello("javaboy"));

        UserService userService = ctx2.getBean(UserService.class);
        System.out.println(userService.getAllUser());

        //条件注解
        ShowCmdService showCmdService = (ShowCmdService) ctx2.getBean("showCmd");
        System.out.println(showCmdService.showCmd());

        AnnotationConfigApplicationContext ctx3 = new AnnotationConfigApplicationContext();
        //多环境切换
        ctx3.getEnvironment().setActiveProfiles("dev");
        //xml配置
        //ctx.setConfigLocation("application.xml");
        //java配置
        ctx3.register(JavaConfig.class);
        ctx3.refresh();
        DataSource dataSource = (DataSource) ctx3.getBean("ds");
        System.out.println(dataSource);
    }
}
