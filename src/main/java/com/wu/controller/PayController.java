package com.wu.controller;

import com.wu.dao.Connect;
import com.wu.dao.Paybook;
import com.wu.entity.Paydata;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class PayController {
    @PostMapping(value = "/api/pay")
    @ResponseBody
    public Object paymethod(Paydata paydata) throws SQLException {
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        Paybook paybook=new Paybook();
        System.out.println("购买订单信息");
        System.out.println("book_id");
        System.out.println(paydata.list[0].book_id);
        System.out.println(paydata.list[1].book_id);
        System.out.println("number:");
        System.out.println(paydata.list[0].number);
        System.out.println(paydata.list[1].number);
        int t=paydata.getList().length;
        System.out.println("总价");
        System.out.println(paydata.getTotal_price());
        int [][]booklist=new int[t][3];
        for(int i=0;i<t;i++){
            booklist[i][0]=paydata.list[i].book_id;
            booklist[i][1]=paydata.list[i].number;
            booklist[i][2]=paydata.list[i].getPrice();
        }
        paybook.add_order(deConn,booklist,paydata.getUser_id(),paydata.getTotal_price());
        paybook.clear_cart(deConn,paydata.getUser_id());
        return null;
    }
}
