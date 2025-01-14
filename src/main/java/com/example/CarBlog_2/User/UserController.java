package com.example.CarBlog_2.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping("/user/login")
    public String userLogin(Model model){
        String title ="로그인 페이지";
        model.addAttribute("title",title);
        return "user_login.html";
    }

    @GetMapping("/user/register")
    public String userRegister(Model model){
        String title = "회원가입 페이지";
        model.addAttribute("title", title);
        return "user_register.html";
    }

}
