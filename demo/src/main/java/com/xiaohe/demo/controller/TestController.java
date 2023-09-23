package com.xiaohe.demo.controller;

import com.xiaohe.demo.util.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-09-22 10:29
 */
@Controller
@RequestMapping("/count")
public class TestController {
    @ResponseBody
    @GetMapping("/doCount")
    public Result doCount(@RequestParam("userId") Integer userId, HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        Integer count = (Integer) context.getAttribute(String.valueOf(userId));
        count = count == null ? 1 : count + 1 ;
        context.setAttribute(String.valueOf(userId), count);
        return Result.success("用户id: " + userId + " 访问了" + count + "次");
    }

    @RequestMapping("/a")
    public String forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了" + request.getRequestURI());
        request.setAttribute("name", "小明");
//        request.getRequestDispatcher("/b").forward(request, response);
        return "forward:/count/b";
    }

    @ResponseBody
    @RequestMapping("/b")
    public Result forward1(HttpServletRequest request, HttpServletResponse response) {
        String name = (String) request.getAttribute("name");
        System.out.println("name: " + name);
        return Result.success("从forward转发到" + request.getRequestURI() + "的请求，请求域中的name:" + name);
    }

    @ResponseBody
    @RequestMapping("/read")
    public Result readProperties() {
        // 返回结果
        Map<String, String> map = new HashMap<>();
        // 读取内容
        Properties properties = new Properties();
        InputStream in = TestController.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(in);
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            map.put("url", url);
            map.put("driver", driver);
            map.put("username", username);
            map.put("password", password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.success(map);
    }

    @ResponseBody
    @RequestMapping("/referer")
    public Result referer(HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if ("http://localhost:8080/login.html".equals(referer)) {
            return Result.success("访问成功");
        } else {
            return Result.error("访问失败");
        }
    }
}
