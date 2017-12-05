package com.iparhan.blog.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



import com.iparhan.blog.bean.User;
import com.iparhan.blog.dao.UserDao;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/hello")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserDao userDao;

	//index页面
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //注册页面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    //注册方法
    @RequestMapping("/addregister")
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userDao.save(user);
            return "login";
        }else {
            return "register";
        }
    }

    //登录方法
    @RequestMapping("/addlogin")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.findByUsernameAndPassword(username,password);
        System.out.println(user);
        String str = "";
        if (user !=null){
            str = "index";
            logger.info("SUCCESS");
        }else {
        	logger.error("NULL");
            str = "login";
        }
        return str;
    }
   
}
