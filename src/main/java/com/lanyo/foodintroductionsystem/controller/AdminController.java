package com.lanyo.foodintroductionsystem.controller;

import com.lanyo.foodintroductionsystem.pojo.essay;
import com.lanyo.foodintroductionsystem.pojo.user;
import com.lanyo.foodintroductionsystem.servcie.EssayService;
import com.lanyo.foodintroductionsystem.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    EssayService essayService;

    @Autowired
    UserService userService;

    @RequestMapping("/toadminpage")
    public String toAdminPage(HttpSession session , Model model) {
        if (!session.getAttribute("authority").equals("root")) {
            model.addAttribute("errorMsg" , "没有权限，无法访问管理员页面");
            return "error";
        }
        model.addAttribute("allUserCnt" , userService.countUsersNumber());
        model.addAttribute("allEssayCnt" , essayService.countEssaysNumber());
        model.addAttribute("lockedEssayNum" , essayService.countLockedEssay());
        model.addAttribute("unCheckEssayNum" , essayService.countCheckingEssay());
        model.addAttribute("bannedUserNum" , userService.countBannedUser());
        return "adminPages/adminIndex";
    }

    @RequestMapping("/toViewLockedEssay")
    public String toViewLockedEssay(Model model) {
        List<essay> essays = essayService.queryLockedEssays();
        model.addAttribute("LockedEssays" , essays);
        return "adminPages/lockedEssayPage";
    }

    @RequestMapping("/toViewCheckingEssay")
    public String toViewCheckingEssay(Model model) {
        List<essay> essays = essayService.queryCheckingEssays();
        model.addAttribute("checkingEssays" , essays);
        return "adminPages/checkingEssayPage";
    }

    @RequestMapping("/toViewBannedUser")
    public String toViewBannedUser(Model model) {
        List<user> users = userService.queryBannedUser();
        model.addAttribute("bannedUsers" , users);
        return "adminPages/bannedUserPage";
    }

    // 锁定但不审核的文章，直接修改锁定字段的值
    @RequestMapping("/adminUnlockEssay1/{essay_id}")
    public String adminUnlockEssay1(@PathVariable("essay_id") int essay_id) {
        essayService.unlockEssay(essay_id);
        return "redirect:/toViewLockedEssay";
    }

    // 锁定且需要审核的文章，需要修改锁定、审核两个字段的值
    @RequestMapping("/adminUnlockEssay2/{essay_id}")
    public String adminUnlockEssay2(@PathVariable("essay_id") int essay_id) {
        essayService.unSetEssayChecking(essay_id);
        essayService.unlockEssay(essay_id);
        return "redirect:/toViewCheckingEssay";
    }

    // 审核不通过，保持锁定，但修改审核字段的值
    @RequestMapping("/adminRejectUnlock/{essay_id}")
    public String adminRejectUnlock(@PathVariable("essay_id") int essay_id) {
        essayService.unSetEssayChecking(essay_id);
        return "redirect:/toViewCheckingEssay";
    }

    @RequestMapping("/adminUnbanUser/{user_id}")
    public String adminUnbanUser(@PathVariable("user_id") int user_id) {
        userService.unBanUser(user_id);
        return "redirect:/toViewBannedUser";
    }
}
