package com.wu.controller;

import com.wu.dao.Addbookdao;
import com.wu.dao.Connect;
import com.wu.entity.Addbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class AdmInsertController {
    @PostMapping(value = "/api/admininsertbook")
    @ResponseBody
    public Object admaddbook(Addbook addbook) throws SQLException {
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        Addbookdao addbookdao=new Addbookdao();
        if(addbookdao.add_book(deConn,addbook.getBookname(), (int) addbook.getPrice(),addbook.getWriter(),addbook.getISBN(),addbook.getBookcover(),addbook.getTranslator(),addbook.getDesc())){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        return null;
    }
}
