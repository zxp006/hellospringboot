package com.zxp.moduletwo.controller;

import com.zxp.module.model.Student;
import com.zxp.module.model.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping(value = "/get-info",method = RequestMethod.GET, produces = "application/xml")
    @ResponseBody
    public Teacher getTest(){
        Student student1 = new Student();
        student1.setId(1);
        student1.setStuName("张三");
        student1.setSex("男");
        Student student2 = new Student();
        student2.setId(2);
        student2.setStuName("李四");
        student2.setSex("男");
        Teacher teacher = new Teacher();
        teacher.setId(11);
        teacher.setTeacherName("杨老师");
        teacher.setStudentList(Arrays.asList(student1,student2));
        return teacher;
    }

    @RequestMapping(value = "/post-info",method = RequestMethod.POST, consumes = "application/xml",params = "paramtype=xml")
    public Teacher  postTest(@RequestBody Teacher teacher){
        System.out.println("postman传过来的xml信息转换成实体类如下：==========");
        System.out.println(teacher.toString());
        teacher.setTeacherName("后台换的新老师");
        return teacher;
    }
}