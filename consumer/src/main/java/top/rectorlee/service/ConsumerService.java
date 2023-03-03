package top.rectorlee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.rectorlee.domain.User;

@FeignClient(name = "provider", path = "/provider")
public interface ConsumerService {
    @RequestMapping("/info")
    String getInfo();

    @RequestMapping("/user")
    User getUser(@RequestParam("age") Integer age, @RequestParam("name") String name);
}
