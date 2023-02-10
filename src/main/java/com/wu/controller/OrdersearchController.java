package com.wu.controller;

import com.wu.dao.Connect;
import com.wu.dao.Ordersearch;
import com.wu.entity.BookList;
import com.wu.entity.Loadid;
import com.wu.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class OrdersearchController {
    @PostMapping("/api/ordersearch")
    @ResponseBody
    public Object ordersearch(Loadid loadid) throws SQLException {
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        Ordersearch ordersearch=new Ordersearch();
        Object[][]objects=null;
        Object[][]obj=null;
        objects= (Object[][]) ordersearch.look_for_order_0(deConn,loadid.getUser_id());
        if(objects!=null){
            System.out.println("测试中：");
            Object [][][] objects1=new Object[objects.length][][];
            for (int i=0;i<objects.length;i++){
                objects1[i]= (Object[][]) objects[i][1];
            }
            System.out.println("订单书目数量：");
            for(int i=0;i<objects.length;i++){
                System.out.println(objects1[i].length);
            }
            System.out.println("断点");
            Order order=new Order();
            order.list=new Order.List[objects.length];
            for(int i=0;i<objects.length;i++){
                Order.List book=new Order.List();
                book.setUser_id((Integer) objects[i][0]);
                book.order_info=new Order.List.Order_info[objects1[i].length];
                for(int j=0;j< objects1[i].length;j++){
                    Order.List.Order_info orderinfo=new Order.List.Order_info();
                    orderinfo.setBook_id((Integer)objects1[i][j][0]);
                    orderinfo.setCount((Integer)objects1[i][j][1]);
                    System.out.println(orderinfo.getCount());
                    book.order_info[j]=orderinfo;
                }
                book.setAddress((String) objects[i][2]);
                book.setIs_finish((Integer) objects[i][3]);
                book.setOrder_id((Integer) objects[i][4]);
                order.list[i]=book;
            }
            return order;
        }else{
            return null;
        }
    }
}
