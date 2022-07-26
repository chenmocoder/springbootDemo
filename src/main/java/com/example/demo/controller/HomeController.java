package com.example.demo.controller;


import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class HomeController extends BaseController {

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

}
