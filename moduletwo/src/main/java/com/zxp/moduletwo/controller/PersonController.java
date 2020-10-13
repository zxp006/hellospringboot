package com.zxp.moduletwo.controller;

import com.zxp.module.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author zxp
 * @date 2020-09-14 22:11
 */

@RestController

public class PersonController {

    @GetMapping("/person")
    public Person getPerson(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        Object objectTicket = attributes.getAttribute("logintick", NativeWebRequest.SCOPE_REQUEST);
        attributes.setAttribute("login","bbb", NativeWebRequest.SCOPE_REQUEST);
        Object object= attributes.getAttribute("login",NativeWebRequest.SCOPE_REQUEST);
        Object object2=attributes.getRequest().getAttribute("login");
        Person person=new Person(100,"haha",1,"北京海淀",objectTicket.toString());
        return person ;
    }
}
