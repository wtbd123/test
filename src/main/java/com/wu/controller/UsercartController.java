package com.wu.controller;

import com.wu.dao.Cartinfo;
import com.wu.dao.Connect;
import com.wu.entity.Cartinfodata;
import com.wu.entity.Loadid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class UsercartController {
    @PostMapping(value = "/api/usershoppingcart")
    @ResponseBody
    public Object getusercart(Loadid loadid) throws SQLException {
        System.out.println("获取购物车信息");
        System.out.println(loadid.getUser_id());
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        Object[][]objects=null;
        Cartinfo cartinfo=new Cartinfo();
        objects= (Object[][])cartinfo.get_cart_info(deConn,loadid.getUser_id());
        if(objects!=null){
            for (int i=0;i<objects.length;i++){
                for(int j=0;j<5;j++){
                    System.out.println(objects[i][j]);
                }
            }
            Cartinfodata cartinfodata=new Cartinfodata();
            cartinfodata.list=new Cartinfodata.List[objects.length];
            for(int i=0;i<objects.length;i++){
//                Listresponse.Empty book=new Listresponse.Empty();
                Cartinfodata.List cart=new Cartinfodata.List();
                cart.setBookcover((String) objects[i][0]);
                cart.setBookname((String) objects[i][1]);
                cart.setPrice((Integer) objects[i][2]);
                cart.setAmount((Integer) objects[i][3]);
                cart.setBook_id((Integer) objects[i][4]);
                cartinfodata.list[i]=cart;
            }
            return cartinfodata;
        }else {
            return null;
        }
    }
}
