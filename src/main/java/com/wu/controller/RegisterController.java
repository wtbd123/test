package com.wu.controller;

import com.wu.dao.Connect;
import com.wu.dao.Login;
import com.wu.entity.Loginpost;
import com.wu.entity.Loginresponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;

@Controller
public class RegisterController {
    @PostMapping(value = "/api/userregister")
    @ResponseBody
    public Object loginmethod(Loginpost login){
        System.out.println(login.getUsername());
        System.out.println(login.getPassword());
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        Login login1=new Login();
        if(connect.register(deConn,login.getUsername(), login.getPassword())){
            Object [] obj = new Object[3];
            obj= (Object[]) login1.login(deConn,login.getUsername(), login.getPassword());
            Loginresponse loginresponse=new Loginresponse();
            loginresponse.setUsername((String) obj[0]);
            loginresponse.setUser_id((Integer) obj[1]);
            loginresponse.setType((Integer) obj[2]);
            return loginresponse;
        }else {
            return null;
        }
    }
}