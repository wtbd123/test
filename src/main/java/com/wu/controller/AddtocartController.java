package com.wu.controller;

import com.wu.dao.AddToCart;
import com.wu.dao.Connect;
import com.wu.entity.AddtoCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;

@Controller
public class AddtocartController {
    @PostMapping(value = "/api/addtoshoppingcart")
    @ResponseBody
    public Object addtocart(AddtoCart addtoCart){
        System.out.println(addtoCart.getUser_id());
        System.out.println(addtoCart.getBook_id());
        System.out.println(addtoCart.getPrice());
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        AddToCart addToCart=new AddToCart();
        addToCart.add_to_cart(deConn,addtoCart.getUser_id(), addtoCart.getBook_id());
        return null;
    }
}
