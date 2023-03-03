package top.rectorlee.service;

import org.springframework.web.bind.annotation.RequestParam;
import top.rectorlee.domain.User;

public interface ProviderOtherService {
    String getInfo();

    User getUser(@RequestParam("age") Integer age, @RequestParam("name") String name);
}
