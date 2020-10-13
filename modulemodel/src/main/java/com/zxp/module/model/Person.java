package com.zxp.module.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zxp
 * @date 2020-09-14 22:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Person {
    private Integer id;
    @JsonProperty("username")
    private  String name;
    private  int sex;
    @JsonIgnore
    private  String desc;


    private  String work;
}
