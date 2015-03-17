package com.sundy.action;

import com.sundy.pojo.User;
import com.sundy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liuguozhu on 2015/3/16.
 */
@Controller
public class UserAction {
    @Autowired
    UserService userService;

    //http://localhost:8080/queryUser.action?id=1
    //获取用户测试
    @RequestMapping("/queryUser")
    public String queryUser(Model model, int id) throws Exception {

        //调用service指定id的用户
        User user = userService.findUserById(id);
        model.addAttribute("user", user);

        return "queryUser";
    }

    @RequestMapping("/saveUser")
    public String queryUser(Model model) throws Exception {
        //调用service指定id的用户
        userService.saveUser();
        return "queryUser";
    }
}

