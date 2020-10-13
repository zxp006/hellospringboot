package com.zxp.moduletwo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxp.module.model.Good;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * @author zxp
 * @date 2020-09-15 8:19
 */
@Validated
@RestController
@Slf4j
public class ParasCheckController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/good/{goodNo}")
    public String good(@Pattern(regexp = "^[0-9]{6}$", message = "商品编号不正确") @PathVariable("goodNo") String goodNo) {
        log.info("TAG=good, METHOD=get, goodNo={}", goodNo);
        return "good";
    }

    @GetMapping("/good")
    public String getGood(@Validated Good good, BindingResult bindingResult) throws Exception {
        log.info("传入的对象{}", good);
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(e -> {
                log.error("error msg:【{}】", e.getDefaultMessage());
            });
            return null;
        }
        return objectMapper.writeValueAsString(good);
    }

    @PostMapping(value = "/good")
    public String good(@RequestBody @Valid Good goodReq, BindingResult bindingResult) throws JsonProcessingException {
        log.info("TAG=good, METHOD=post, goodNo={}, goodName={}, goodPrice={}", goodReq.getGoodNo(), goodReq.getGoodName(), goodReq.getGoodPrice());
        Good goodReq1 = new Good().setGoodName(goodReq.getGoodName()).setGoodNo("001").setGoodPrice(1000);
        return objectMapper.writeValueAsString(goodReq1);
    }

    @PostMapping(value = "/good1")
    public String good1(@RequestBody Good parm) throws Exception {
        log.info("请求的url{},{}", request.getRequestURI(), parm);
        return objectMapper.writeValueAsString(parm);
    }

    @PostMapping(value = "/good2")
    public String good2(@RequestBody String parm) throws Exception {
        log.info("请求的url{},参数{}", request.getRequestURI(), parm);
        return parm;
    }

    @PostMapping(value = "/good3")
    public String good3(String goodNo, String goodName, String goodPrice) throws Exception {
        String parm = String.format("接受的参数%s,%s,%s", goodNo, goodName, goodPrice);
        log.info("请求的url{},{}", request.getRequestURI(), parm);
        return parm;
    }

    @PostMapping(value = "/good5", consumes = "application/xml", params = "type=xml")
    public String goodXml(@RequestBody String parm) throws Exception {
        log.info("请求的url{},{}", request.getRequestURI(), parm);
        return parm;
    }
}
