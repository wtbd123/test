package com.wu.controller;
import com.wu.dao.Connect;
import com.wu.dao.LoadUserInfo;
import com.wu.dao.Login;
import com.wu.dao.UpdateUserInfo;
import com.wu.entity.Loadid;
import com.wu.entity.Loginpost;
import com.wu.entity.Loginresponse;
import com.wu.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class LoaduserInfoController {
    @PostMapping(value = "/api/loaduserinfo")
    @ResponseBody
    public Object LoadUserInfomethod(Loadid loadid) throws SQLException {
        System.out.println(loadid.getUser_id());
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        LoadUserInfo loadUserInfo=new LoadUserInfo();
        Object [] obj = new Object[5];
        obj= (Object[]) loadUserInfo.load_user_info(deConn, loadid.getUser_id());
        UserInfo userInfo=new UserInfo();
        userInfo.setUser_id((Integer) obj[0]);
        userInfo.setNickname((String) obj[1]);
        userInfo.setPassword((String) obj[2]);
        userInfo.setCellphone((String) obj[3]);
        userInfo.setAddress((String) obj[4]);
        return userInfo;
    }
}

