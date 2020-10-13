package com.zxp.moduletwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TwoApplication {

    public static void main(String[] args) {

//        try {
            SpringApplication.run(TwoApplication.class, args);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
