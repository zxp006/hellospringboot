package com.zxp.module.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zxp
 * @date 2020-09-23 8:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {
    private String name;
    private Integer age;
    private String country;
    private char sex;

}
