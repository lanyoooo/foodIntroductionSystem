package com.lanyo.foodintroductionsystem.controller;

import com.lanyo.foodintroductionsystem.pojo.user;
import com.lanyo.foodintroductionsystem.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/toLogin")
    public String login(@RequestParam("account") String account ,
                        @RequestParam("password") String password ,
                        HttpSession session ,
                        Model model) {
//        System.out.println("收到了来自login页面的请求");//action没有问题

        user u1 = userService.selectUserByAccount(account);
        if (u1 == null) {
            model.addAttribute("msg" , "该账号不存在");
            return "login";
        } else {
            if (password.equals(u1.getUser_pwd())) {
                session.setAttribute("name" ,  u1.getUser_name());
                session.setAttribute("uid" , u1.getUser_id());
                session.setAttribute("authority" , u1.getUser_authority());
                session.setAttribute("isBanned" , u1.isUser_isBanned());
                //model.addAttribute("name" , u1.getUser_name());
                //下面这个 session 有何用？
                session.setAttribute("loginUser" , u1.getUser_id());
                return "redirect:/index";
            } else {
                model.addAttribute("msg" , "密码不正确，请重新输入");
                return "login";
            }
        }
    }

    @RequestMapping("/")
    public String welcomePage() {
        return "login";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }
}
