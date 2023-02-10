package com.wu.controller;

import com.wu.dao.Addbookdao;
import com.wu.dao.Connect;
import com.wu.dao.UpdateBook;
import com.wu.entity.Upbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class AdmUpdateController {
    @PostMapping(value = "/api/adminupdatebook")
    @ResponseBody
    public Object updatebook(Upbook upbook) throws SQLException {
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        UpdateBook updateBook=new UpdateBook();
        if(updateBook.update_book(deConn,(int) upbook.getBook_id(),upbook.getBookname(),(int)upbook.getPrice(),upbook.getWriter(),upbook.getISBN(),upbook.getBookcover(),upbook.getTranslator(),upbook.getDesc())){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        return null;
    }
}
