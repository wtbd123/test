package com.wu.controller;

import com.wu.dao.Connect;
import com.wu.dao.Login;
import com.wu.dao.UpdateUserInfo;
import com.wu.entity.Loginpost;
import com.wu.entity.Loginresponse;
import com.wu.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class UpdateuserController {
    @PostMapping(value = "/api/updateuserinfo")
    @ResponseBody
    public Object UpdateUserInfomethod( UserInfo userInfo) throws SQLException {
        System.out.println(userInfo.getPassword());
        System.out.println(userInfo.getAddress());
        System.out.println(userInfo.getCellphone());
        System.out.println(userInfo.getNickname());
        System.out.println(userInfo.getUser_id());
        int t=0;
        if(userInfo.getPassword()!=null){
            t=1;
        }
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        if(connect.User_exist(deConn,userInfo.getUser_id())){
            Object [] obj = new Object[4];
            UpdateUserInfo updateUserInfo=new UpdateUserInfo();
            obj= (Object[]) updateUserInfo.update_user_info(deConn,userInfo.getUser_id(), userInfo.getCellphone(), userInfo.getAddress(), userInfo.getPassword(), userInfo.getNickname(),t);
            userInfo.setNickname((String) obj[0]);
            userInfo.setPassword((String) obj[1]);
            userInfo.setCellphone((String) obj[2]);
            userInfo.setAddress((String) obj[3]);
            return userInfo;
        }else {
            return null;
        }
    }
}
