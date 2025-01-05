package com.example.CarBlog_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "byebye";
    }

    @GetMapping("/jump")
    @ResponseBody
    public String jump(){
        return "점프 투 스프링부트";
    }
}
