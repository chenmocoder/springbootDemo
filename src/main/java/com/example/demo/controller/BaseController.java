package com.example.demo.controller;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaseController {


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
