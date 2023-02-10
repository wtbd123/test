package com.wu.controller;

import com.wu.dao.Addbookdao;
import com.wu.dao.Connect;
import com.wu.dao.Delbook;
import com.wu.entity.Bookid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class AdmDeleController {
    @PostMapping(value = "/api/admindeletebook")
    @ResponseBody
    public Object deletebook(Bookid bookid) throws SQLException {
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        Delbook delbook=new Delbook();
        if(delbook.delete_book(deConn,bookid.getBook_id())){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        return null;
    }
}
