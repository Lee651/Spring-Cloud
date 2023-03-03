package top.rectorlee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lee
 * @description
 * @date 2023-03-02  11:01:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String name;

    private Integer age;
}
