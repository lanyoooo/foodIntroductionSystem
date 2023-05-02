package com.lanyo.foodintroductionsystem.controller;

import com.lanyo.foodintroductionsystem.pojo.user;
import com.lanyo.foodintroductionsystem.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("/toRegister")
    public String registerNewUser(@RequestParam("account") String account ,
                                  @RequestParam("password") String pwd ,
                                  @RequestParam("confirm-password") String confirmedPwd ,
                                  HttpSession session ,
                                  Model model) {
        if (userService.selectUserByAccount(account) != null) {
            model.addAttribute("msg" , "该账号已被使用");
            return "register";
        }
        if (!pwd.equals(confirmedPwd)) {
            model.addAttribute("msg" , "两次密码输入不一致");
            return "register";
        }
        user newUser = new user(0,account,pwd,"用户"+account,null , false);
        userService.addUser(newUser);
        model.addAttribute("name" , newUser.getUser_name());
        // 暂时没有更新session信息的一步
        return "login";
    }

}
