package com.wx.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.jwt.annotation.CheckToken;
import com.wx.jwt.annotation.LoginToken;
import com.wx.jwt.entity.User;
import com.wx.jwt.service.UserService;
import com.wx.jwt.service.impl.UserServiceImpl;
import com.wx.jwt.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/jwt")
public class UserController {

    //登录
    @PostMapping("/login")
    @LoginToken
    public Object login(@RequestBody User user, HttpServletResponse response) {
        UserService userService = new UserServiceImpl();
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = JwtUtil.createJWT(6000000, userForBase);
                response.setHeader("token",token);//把token保存在header中，前端直接在header信息中取出token，之后判断
//                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    //查看后台
    @CheckToken
    @GetMapping("/home")
    public String Home() {
        return "到达登陆后台";
    }


}
