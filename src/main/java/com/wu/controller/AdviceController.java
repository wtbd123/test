package com.wu.controller;

import com.wu.entity.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class AdviceController {
    @PostMapping("/api/offeradvice")
    @ResponseBody
    public Object advicemethod(Advice advice){
        System.out.println("用户id:");
        System.out.println(advice.getUser_id());
        System.out.println("建议：");
        System.out.println(advice.getAdvice());
        return null;
    }
}
