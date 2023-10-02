package com.xiaohe.demo.controller;

import com.xiaohe.demo.pojo.Books;
import com.xiaohe.demo.pojo.ShoppingCart;
import com.xiaohe.demo.util.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        count = count == null ? 1 : count + 1;
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

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "重理工 CQUT";
    }


    @ResponseBody
    @RequestMapping("/testCookie")
    public Result cookie(String username, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        Date oldDate = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(username)) {
                // 如果有，说明不是第一次访问. 获取上一次访问时间
                oldDate = simpleDateFormat.parse(cookie.getValue());
                break;
            }
        }
        String now = simpleDateFormat.format(new Date()).replaceAll(" ", "/");
        Cookie cookie = new Cookie(username, now);
        response.addCookie(cookie);
        if (oldDate == null) {
            // 如果为空，说明之前没有访问过
            return Result.success("你之前没有访问过");
        } else {
            return Result.success("上次访问时间: " + simpleDateFormat.format(oldDate));
        }
    }

    @ResponseBody
    @GetMapping("/noSignIn")
    public Result noSignIn(HttpServletRequest request, HttpServletResponse response,
                           String username,
                           String password,
                           Integer noSignIn) {
        // 查看cookie中有没有
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(username) && cookie.getValue().equals(password)) {
                // 如果有，说明可以免登陆。刷新cookie时间
                cookie.setMaxAge(60 * 2);
                response.addCookie(cookie);
                return Result.success("两分钟内登录过，不需要再登陆");
            }
        }
        // 走到这是没有
        if (!username.equals("xiaoming") || !password.equals("123")) {
            return Result.error("账号/密码错误");
        }
        if (noSignIn == 1) {
            Cookie cookie = new Cookie(username, password);
            cookie.setMaxAge(60 * 2);
            response.addCookie(cookie);
        }
        return Result.success("登陆成功");
    }


    @ResponseBody
    @RequestMapping("/login")
    public Result login(String username, String password, HttpSession session) {
        if (!username.equals("xiaoming") || !password.equals("123")) {
            return Result.error("账号/密码错误");
        }
        // 登陆成功记录信息
        session.setAttribute("loginUser", username);
        return Result.success("登陆成功");
    }



    @RequestMapping("/shopping")
    @ResponseBody
    public Result shopping(@RequestBody Books books, HttpSession session) {
        // 从session中当前登录的用户的名字
        String username = (String) session.getAttribute("loginUser");
        // 从session中取出该用户的购物车
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(username + "shopping");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        for (String book : books.getShopping()) {
            shoppingCart.addItem(book);
        }

        String result = "您已购买的书籍: \n" + shoppingCart.toString();
        return Result.success(result);
    }
}
