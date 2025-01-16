package com.example.CarBlog_2.User;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login")
    public String userLogin(Model model){
        String title ="로그인 페이지";
        model.addAttribute("title",title);
        return "user_login.html";
    }

    @GetMapping("/user/register")
    public String userRegister(UserCreateForm userCreateForm, Model model){
        String title = "회원가입 페이지";
        model.addAttribute("title", title);
        return "user_register.html";
    }

    @PostMapping("/user/register")
    public String userRegister(@Valid UserCreateForm userCreateForm , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user_register.html";
        }
        this.userService.create(userCreateForm.getUsername(), userCreateForm.getPassword(), userCreateForm.getEmail());
        return "redirect:/board/list";
    }

}
