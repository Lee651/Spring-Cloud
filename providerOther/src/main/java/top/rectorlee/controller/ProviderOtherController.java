package top.rectorlee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.rectorlee.domain.User;
import top.rectorlee.service.ProviderOtherService;

/**
 * @author Lee
 * @description
 * @date 2023-03-01  14:07:41
 */
@RestController
@RequestMapping("/provider")
public class ProviderOtherController {
    @Autowired
    private ProviderOtherService providerOtherService;

    @RequestMapping("/info")
    public String getInfo() {
        return providerOtherService.getInfo();
    }

    @RequestMapping("/user")
    public User getUser(@RequestParam("age") Integer age, @RequestParam("name") String name) {
        return providerOtherService.getUser(age, name);
    }
}
