package top.rectorlee.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import top.rectorlee.domain.User;
import top.rectorlee.service.ProviderOtherService;

/**
 * @author Lee
 * @description
 * @date 2023-03-01  14:13:45
 */
@Service
public class ProviderOtherServiceImpl implements ProviderOtherService {
    @Override
    public String getInfo() {
        // int i = 1 / 0;
        return "调用的是providerOther服务";
    }

    @Override
    public User getUser(@RequestParam("age") Integer age, @RequestParam("name") String name) {
        // int i = 1 / 0;
        return new User(2, name, age);
    }
}
