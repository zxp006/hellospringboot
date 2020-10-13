package com.zxp.moduleone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxp.moduleone.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxp
 * @date 2020-09-20 11:47
 */
@Slf4j
@SpringBootTest
public class HelloTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RestTemplate restTemplate;
    @Test
    public  void  postGood() throws JSONException {
        String good="{\n" +
                "    \"goodNo\":222333,\n" +
                "    \"goodName\":\"耳机\",\n" +
                "    \"goodPrice\":5000    \n" +
                "}";
        String result = HttpUtils.post(new JSONObject(good), "http://127.0.0.1:8080/good");
        log.info("返回的结果:{}",result);
    }

    @Test
    public  void  getGood() throws JSONException {
        Map<String,String> params=new HashMap<>();
        params.put("goodNo","123123");
        params.put("goodName","台灯");
        params.put("goodPrice","100");
        String result = HttpUtils.get(params, "http://127.0.0.1:8080/good");
        log.info("返回的结果:{}",result);
    }

    @Test
    public  void  restPostByForm(){
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("goodNo","111222");
        map.add("goodName","饮水机");
        map.add("goodPrice","2000");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/good3", request, String.class);
        log.info("返回的结果:{}",stringResponseEntity.getBody());
    }

    @Test
    public  void  restPostByJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("goodNo", 555666);
        jsonObject.put("goodName","json格式参数");
        jsonObject.put("goodPrice",100);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(),headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/good", request, String.class);
        log.info("返回的结果:{}",stringResponseEntity.getBody());
    }

    @Test
    public  void  restPostByXmlAndParams(){
       String xmlStr="<MESSAGE TEACHER_ID=\"1\">\n" +
               "    <TEACHER_NAME>邹老师</TEACHER_NAME>\n" +
               "    <STUDENT_LIST>\n" +
               "        <STUDENT STUDENT_ID=\"1\">\n" +
               "            <STUDENT_NAME>张三</STUDENT_NAME>\n" +
               "            <STUDENT_SEX>男</STUDENT_SEX>\n" +
               "        </STUDENT>\n" +
               "        <STUDENT STUDENT_ID=\"2\">\n" +
               "            <STUDENT_NAME>李四</STUDENT_NAME>\n" +
               "            <STUDENT_SEX>男</STUDENT_SEX>\n" +
               "        </STUDENT>\n" +
               "    </STUDENT_LIST>\n" +
               "</MESSAGE>";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> request = new HttpEntity<>(xmlStr,headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/teacher/post-info?paramtype={1}", request, String.class,"xml");
        log.info("返回的结果:{}",stringResponseEntity.getBody());
    }
}
