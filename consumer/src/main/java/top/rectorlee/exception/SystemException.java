package top.rectorlee.exception;

import lombok.extern.slf4j.Slf4j;
import top.rectorlee.domain.User;

/**
 * @author Lee
 * @description
 * @date 2023-03-02  14:27:21
 */
@Slf4j
public class SystemException {
    public static User defaultUser(Integer age, String name, Throwable ex) {
        log.info(ex.getMessage());
        log.info("............");
        return new User(34353, "xxxxxx", 999999999);
    }
}
