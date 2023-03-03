package top.rectorlee.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import top.rectorlee.domain.User;
import top.rectorlee.service.ConsumerService;

/**
 * @author Lee
 * @description
 * @date 2023-03-01  15:57:06
 */
@Component
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public String getInfo() {
        return "远程调用出现异常";
    }

    @Override
    public User getUser(@RequestParam("age") Integer age, @RequestParam("name") String name) {
        return new User(3, "Lee", 888888);
    }
}
