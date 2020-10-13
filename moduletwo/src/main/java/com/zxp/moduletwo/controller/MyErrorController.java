package com.zxp.moduletwo.controller;//package com.zxp.hellospringboot.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.bridge.SLF4JBridgeHandler;
//import org.springframework.boot.autoconfigure.web.ErrorProperties;
//import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@Controller
//public class MyErrorController extends BasicErrorController {
//
//    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
//        super(errorAttributes, errorProperties);
//    }
//
//    @Override
//    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//        Map<String, Object> body = getErrorAttributes(request,
//                isIncludeStackTrace(request, MediaType.ALL));
//        HttpStatus status = getStatus(request);
//        //输出自定义的Json格式
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", status.value());
//        String message = (String) body.get("message");
//        if (message == null || message.equals("No message available")) {
//            map.put("msg", status.getReasonPhrase());
//        } else {
//            map.put("msg", body.get("message"));
//        }
//        map.put("timestamp", new Date());
//        return new ResponseEntity<>(map, status);
//    }
//
//}