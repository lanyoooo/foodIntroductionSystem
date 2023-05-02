package com.lanyo.foodintroductionsystem.controller;

import com.lanyo.foodintroductionsystem.pojo.*;
import com.lanyo.foodintroductionsystem.servcie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class IndexController {

    @Autowired
    EssayService essayService;

    @Autowired
    PublishService publishService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    LikeService likeService;

    // 查询推荐攻略、随机几个攻略传到前端
    @RequestMapping("/index")
    public String indexPage(Model model) {
        List<essay> recommendEssays = essayService.queryAllRecommendEssay();
        List<essay> randomEssays = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int essayIdMax = essayService.queryLatestPublishId();
        while(randomEssays.size() < 10) {
            int randomEssayId = new Random().nextInt(essayIdMax);
            if (set.contains(randomEssayId)) {
                continue;
            } else {
                set.add(randomEssayId);
            }
            essay tempEssay = essayService.selectEssay(randomEssayId);
            if (tempEssay != null && !tempEssay.isEssay_isLocked()) {
                randomEssays.add(tempEssay);
            }
        }
        model.addAttribute("recommendEssays" , recommendEssays);
        model.addAttribute("randomEssays" , randomEssays);
        return "index";
    }

    @RequestMapping("/toMyPublish")
    public String toMyPublish(HttpSession session , Model model) {
        List<essay> myEssays = essayService.queryEssayByAuthor((int) session.getAttribute("uid"));
        model.addAttribute("myEssays" , myEssays);
        return "myPublish";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate(); // 使session失效
        return "redirect:/login"; // 重定向到登录页面
    }

    @RequestMapping("/query")
    public String query(@RequestParam("words") String words ,
                        Model model) {
        List<essay> essays = essayService.queryLikelyEssay(words);

        for (essay e : essays) {
            String name = essayService.queryAuthorNameByEssayId(e.getEssay_id());
//            System.out.println(name);
        }

        model.addAttribute("queryResults" , essays);
        return "essays/queryResult";
    }

    @RequestMapping("/toPublish")
    public String toPublishEssay(HttpSession session , Model model) {
        if (userService.selectUser((int)session.getAttribute("uid")).isUser_isBanned()) {
            model.addAttribute("errorMsg" , "您已被禁言，无法发布攻略或评论");
            return "error";
        }
        return "essays/publish";
    }

    // 怎么从前端接收文件并存储到数据库？
    @RequestMapping("publishEssay")
    public String publishEssay(@RequestParam("title") String title ,
                               @RequestParam("content") String content ,
                               HttpSession session) {
        Date publishTime = new Date();
        essay newEssay = new essay(0,title,content,0,0,publishTime,false, false);
        essayService.insertEssay(newEssay);
        int uid = (int) session.getAttribute("uid");
        publishService.addPublish(new publish(0,uid, essayService.queryLatestPublishId()));
        return "essays/tempPage";
    }

    @RequestMapping("/essays/update/{essay_id}")
    public String updateEssay(@PathVariable("essay_id") int essay_id, Model model) {
        essay essay = essayService.selectEssay(essay_id);
        model.addAttribute("essay" , essay);
        return "essays/updatePage";
    }

    @RequestMapping("/applyUpdate")
    public String applyUpdate(@RequestParam("title") String title ,
                              @RequestParam("content") String content ,
                              @RequestParam("id") int id) {
        System.out.println("更新了essay");
        essay updateEssay = new essay(id,title,content,0,0,new Date(),false, false);
        essayService.updateEssay(updateEssay);
        return "redirect:/toMyPublish";
    }

    @RequestMapping("/essays/delete/{essay_id}")
    public String deleteEssay(@PathVariable("essay_id") int essay_id ,
                              HttpSession session) {
        publishService.deletePubByEssayId(essay_id);   // 在删除essay的时候，要把publish关系表的记录也删除
        essayService.deleteEssay(essay_id);
        return "redirect:/toMyPublish";
    }

    @RequestMapping("/essays/{essay_id}")
    public String toBrowsePage(@PathVariable("essay_id") int essay_id ,
                               HttpSession session ,
                               Model model) {
        // 锁定页面只有管理员和发布者能看
        if (essayService.selectEssay(essay_id).isEssay_isLocked() &&
                !(session.getAttribute("authority").equals("root") ||
                        publishService.queryAuthorIdByEssayId(essay_id) == (int)session.getAttribute("uid"))) {
            model.addAttribute("errorMsg" , "该攻略已被锁定，暂时无法查看");
            return "error";
        }
        essayService.updateEssayView(essay_id);     // 每次点击进去都更新浏览量
        essay essay = essayService.selectEssay(essay_id);   // 查询essay发到前端
        List<comment> comments = commentService.queryCommentsByEssay(essay_id);
        String authorName = essayService.queryAuthorNameByEssayId(essay_id);    // 查询作者名字发到前端
        boolean isLiked = likeService.queryIfLike((int) session.getAttribute("uid"), essay_id) != null;     // 查询用户是否对当前文章点赞
        model.addAttribute("essay" , essay);
        model.addAttribute("author" , authorName);
        model.addAttribute("comments" , comments);
        model.addAttribute("isLiked" , isLiked);
        return "essays/browsePage";
    }

    // 提交评论到数据库，功能正常运行
    @RequestMapping("/publishComment")
    public String publishComment(@RequestParam("pub_comment") String commentContent ,
                                 @RequestParam("pub_comment_essayId") int commentArticleId ,
                                 @RequestParam("pub_publisher_id") int commentPublisherId ,
                                 @RequestParam("pub_publisher_name") String commentPublisherName ,
                                 HttpSession session ,
                                 Model model) {
        if (userService.selectUser((int)session.getAttribute("uid")).isUser_isBanned()) {
            model.addAttribute("errorMsg" , "您已被禁言，无法发布攻略或评论");
            return "error";
        }
        comment newComment = new comment(0 , commentArticleId , commentPublisherId , commentPublisherName , commentContent , new Date());
        commentService.addComment(newComment);
        return "redirect:/essays/" + commentArticleId;
    }

    @RequestMapping("/deleteComment/{essay_id}/{comment_id}")
    public String deleteComment(@PathVariable("essay_id") int essay_id ,
                                @PathVariable("comment_id") int comment_id) {
        commentService.deleteComment(comment_id);
        return "redirect:/essays/"+essay_id;
    }

    @RequestMapping("/toUpdateUser")
    public String toUpdateUser() {
        return "editUser";
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("newName") String newUserName ,
                                 @RequestParam("newPwd") String newPwd ,
                                 @RequestParam("confirm-newPwd") String confPwd ,
                                 HttpSession session ,
                                 Model model) {
        if (userService.queryUserByName(newUserName) != null) {
            System.out.println("该用户名已被使用");
            model.addAttribute("msg" , "该用户名已被使用");
            return "editUser";
        }
        if (!newPwd.equals(confPwd)) {
            System.out.println("两次密码输入不一致");
            model.addAttribute("msg" , "两次密码输入不一致");
            return "editUser";
        }
        user updUser = new user((int)session.getAttribute("uid") , "" , newPwd ,  newUserName, "" , false);
        userService.updateUser(updUser);
        session.setAttribute("name" , newUserName);
        return "index";
    }

    @RequestMapping("/cancelLike/{essay_id}/{user_id}")
    public String cancelLike(@PathVariable("essay_id") int essay_id ,
                             @PathVariable("user_id") int user_id) {
        like like = likeService.queryIfLike(user_id, essay_id);
        likeService.deleteLike(like.getLike_id());
        essayService.updateEssayLikeCancel(essay_id);
        return "redirect:/essays/" + essay_id;
    }

    @RequestMapping("/applyLike/{essay_id}/{user_id}")
    public String applyLike(@PathVariable("essay_id") int essay_id ,
                            @PathVariable("user_id") int user_id) {
        like newlike = new like(0 , user_id , essay_id);
        likeService.addLike(newlike);
        essayService.updateEssayLikePlus(essay_id);
        return "redirect:/essays/" + essay_id;
    }

    @RequestMapping("/lockEssay/{essay_id}")
    public String lockEssay(@PathVariable("essay_id") int essay_id) {
        essayService.lockEssay(essay_id);
        return "redirect:/essays/"+essay_id;
    }

    @RequestMapping("/unlockEssay/{essay_id}")
    public String unlockEssay(@PathVariable("essay_id") int essay_id) {
        essayService.unlockEssay(essay_id);
        return "redirect:/essays/"+essay_id;
    }

    @RequestMapping("/banUser/{essay_id}/{user_id}")
    public String banUser(@PathVariable("essay_id") int essay_id ,
                          @PathVariable("user_id") int user_id) {
        userService.banUser(user_id);
        String tmp = "/"+essay_id+"/"+user_id;
        return "redirect:/toUserPerPage"+tmp;
    }

    @RequestMapping("/unBanUser/{essay_id}/{user_id}")
    public String unBanUser(@PathVariable("essay_id") int essay_id ,
                            @PathVariable("user_id") int user_id) {
        userService.unBanUser(user_id);
        String tmp = "/"+essay_id+"/"+user_id;
        return "redirect:/toUserPerPage"+tmp;
    }

    @RequestMapping("/toUserPerPage/{essay_id}/{user_id}")
    public String toUserPerPage(@PathVariable("essay_id") int essay_id ,
                                @PathVariable("user_id") int user_id ,
                                Model model) {
        user user = userService.selectUser(user_id);
        model.addAttribute(user);
        model.addAttribute("oriEssayId" , essay_id);
        return "userPerPage";
    }

    // 申请解禁
    @RequestMapping("/applyUnlock/{essay_id}")
    public String applyUnlock(@PathVariable("essay_id") int essay_id) {
        essayService.setEssayChecking(essay_id);
        return "redirect:/toMyPublish";
    }

    // 审核essay的功能等待完成
}
