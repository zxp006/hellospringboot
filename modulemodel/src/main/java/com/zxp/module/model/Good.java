package com.zxp.module.model;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class Good {

    @NotBlank(message = "商品编号不能为空")
    @Pattern(regexp = "^[0-9]{6}$", message = "商品编号不正确")
    private String goodNo;

    @NotBlank(message = "商品名不能为空")
    private String goodName;

    @NotNull(message = "商品价格不能为空")
    private Integer goodPrice;

}
