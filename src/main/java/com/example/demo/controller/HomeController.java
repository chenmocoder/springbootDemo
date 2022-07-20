package com.example.demo.controller;


import com.alibaba.fastjson2.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class HomeController {

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public java.lang.String login(HttpServletRequest req, HttpServletResponse res) {
        //将request请求体字符串转为json
        JSONObject jsonObject = JSONObject.parseObject(getRequestString(req));
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.get("username"));
        return "hello";
    }

    @PostMapping("/logout")
    public java.lang.String logout() {
        return "bye";
    }

    /**
     * 将http请求body体转换为字符串
     * @param req http request body object
     * @return
     */
    public java.lang.String getRequestString(HttpServletRequest req) {
        try {
            ServletInputStream inputStream = req.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            java.lang.String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }catch (Exception e) {
            return null;
        }
    }

}
