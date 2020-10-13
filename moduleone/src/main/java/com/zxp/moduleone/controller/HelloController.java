package com.zxp.moduleone.controller;

import com.zxp.module.model.Book;
import com.zxp.module.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zxp
 * @date 2020-09-20 10:03
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("/person")
    public Person getPerson(){
        return  new Person().setId(1).setName("张三").setDesc("测试");
    }

    @RequestMapping("/book")
    public Book getBook(){
        return  new Book().setId(1).setName("天龙八部").setPrice(new BigDecimal(100));
    }
}
