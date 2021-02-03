package org.javaboy.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/3 17:23
 * @Version 1.0
 **/
@Service
public class UserService {
    public List<String> getAllUser() {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add("javaboy:" + i);
        }
        return users;
    }
}
