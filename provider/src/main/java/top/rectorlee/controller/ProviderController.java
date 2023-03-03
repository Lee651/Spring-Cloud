package top.rectorlee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.rectorlee.domain.User;
import top.rectorlee.service.ProviderService;

/**
 * @author Lee
 * @description
 * @date 2023-03-01  14:19:36
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping("/info")
    public String getInfo() {
        return providerService.getInfo();
    }

    @RequestMapping("/user")
    public User getUser(@RequestParam("age") Integer age, @RequestParam("name") String name) {
        return providerService.getUser(age, name);
    }
}
