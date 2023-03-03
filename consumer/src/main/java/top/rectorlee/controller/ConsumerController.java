package top.rectorlee.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import top.rectorlee.domain.User;
import top.rectorlee.service.ConsumerService;

/**
 * @author Lee
 * @description
 * @date 2023-03-01  14:30:26
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
@RefreshScope
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @Value("${name}")
    private String name;

    @RequestMapping("/info")
    public String getInfo() {
        return consumerService.getInfo();
    }

    @RequestMapping("/user")
    @SentinelResource(value = "user", fallback = "getDefaultUser")
    public User getUser(@RequestParam("age") Integer age, @RequestParam("name") String name) {
        return consumerService.getUser(age, name);
    }

    public User getDefaultUser(Integer age, String name, Throwable ex) {
        if (ex instanceof FlowException) {
            log.info("流控规则限流");
        } else if (ex instanceof ParamFlowException) {
            log.info("热点规则限流");
        } else if (ex instanceof DegradeException) {
            log.info("熔断规则限流");
        } else if (ex instanceof SystemBlockException) {
            log.info("系统规则限流");
        } else {
            log.info("权限规则限流");
        }
        return new User(4, "li", 30);
    }

    @RequestMapping("/requestHeader")
    public String getRequestHeader(@RequestHeader("X-Request-Default-Name") String requestHeader) {
        return requestHeader;
    }

    @RequestMapping("/requestParameter")
    public String getRequestParameter(@RequestParam("X-Request-Parameter") String requestParameter) {
        return requestParameter;
    }

    @RequestMapping("/name")
    public String getName() {
        return name;
    }
}
