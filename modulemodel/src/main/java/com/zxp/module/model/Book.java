package com.zxp.module.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author zxp
 * @date 2020-10-10 11:22
 */
@Data
@Accessors(chain = true)
public class Book {
    private  int id;
    private  String name;
    private BigDecimal price;
}
