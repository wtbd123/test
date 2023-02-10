package com.wu.controller;

import com.wu.dao.Connect;
import com.wu.dao.Search;
import com.wu.entity.BookList;
import com.wu.entity.SearchInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class BasesearchController {
    @GetMapping("/api/basesearch")
    @ResponseBody
    public Object basesearch(SearchInfo searchInfo) throws SQLException {
        String type=searchInfo.getType();
        String keyword=searchInfo.getKeyword();
        Connect connect=new Connect();
        Connection deConn=connect.connect2SQL("final","sa","121748sbS");
        Object[][]objects=null;
        System.out.println(keyword);
        System.out.println(type);
        Search search=new Search();
        if(keyword == "" && type == ""){
            System.out.println("搜索中,1");
            objects= (Object[][]) search.search_books_all(deConn);
            if(objects!=null){
                for (int i=0;i<objects.length;i++){
                    for(int j=0;j<7;j++){
                        System.out.println(objects[i][j]);
                    }
                }
                BookList bookList=new BookList();
                bookList.list=new BookList.Empty[objects.length];
                for(int i=0;i<objects.length;i++){
                    BookList.Empty book=new BookList.Empty();
                    book.setBookcover((String) objects[i][0]);
                    book.setBookname((String) objects[i][1]);
                    book.setWriter((String) objects[i][2]);
                    book.setPrice((Integer) objects[i][3]);
                    book.setBook_id((Integer) objects[i][4]);
                    book.setDesc((String) objects[i][5]);
                    book.setISBN((String) objects[i][6]);
                    bookList.list[i]=book;
                }
                return bookList;
            }else{
                return null;
            }
        }else if(type==""){
            System.out.println("搜索中,2");
            objects= (Object[][]) search.search_books_keyword(deConn,keyword);
            if(objects!=null){
                for (int i=0;i<objects.length;i++){
                    for(int j=0;j<7;j++){
                        System.out.println(objects[i][j]);
                    }
                }
                BookList bookList=new BookList();
                bookList.list=new BookList.Empty[objects.length];
                for(int i=0;i<objects.length;i++){
                    BookList.Empty book=new BookList.Empty();
                    book.setBookcover((String) objects[i][0]);
                    book.setBookname((String) objects[i][1]);
                    book.setWriter((String) objects[i][2]);
                    book.setPrice((Integer) objects[i][3]);
                    book.setBook_id((Integer) objects[i][4]);
                    book.setDesc((String) objects[i][5]);
                    book.setISBN((String) objects[i][6]);
                    bookList.list[i]=book;
                }
                return bookList;
            }else {
                return null;
            }
        }else if(keyword==""){
            System.out.println("搜索中,3");
            objects= (Object[][]) search.search_books_label(deConn,type);
            if(objects!=null){
                for (int i=0;i<objects.length;i++){
                    for(int j=0;j<7;j++){
                        System.out.println(objects[i][j]);
                    }
                }
                BookList bookList=new BookList();
                bookList.list=new BookList.Empty[objects.length];
                for(int i=0;i<objects.length;i++){
                    BookList.Empty book=new BookList.Empty();
                    book.setBookcover((String) objects[i][0]);
                    book.setBookname((String) objects[i][1]);
                    book.setWriter((String) objects[i][2]);
                    book.setPrice((Integer) objects[i][3]);
                    book.setBook_id((Integer) objects[i][4]);
                    book.setDesc((String) objects[i][5]);
                    book.setISBN((String) objects[i][6]);
                    bookList.list[i]=book;
                }
                return bookList;
            }else {
                return null;
            }
        }else {
            System.out.println("搜索中,4");
            objects= (Object[][]) search.search_books(deConn,type,keyword);
            if(objects!=null){
                for (int i=0;i<objects.length;i++){
                    for(int j=0;j<7;j++){
                        System.out.println(objects[i][j]);
                    }
                }
                BookList bookList=new BookList();
                bookList.list=new BookList.Empty[objects.length];
                for(int i=0;i<objects.length;i++){
                    BookList.Empty book=new BookList.Empty();
                    book.setBookcover((String) objects[i][0]);
                    book.setBookname((String) objects[i][1]);
                    book.setWriter((String) objects[i][2]);
                    book.setPrice((Integer) objects[i][3]);
                    book.setBook_id((Integer) objects[i][4]);
                    book.setDesc((String) objects[i][5]);
                    book.setISBN((String) objects[i][6]);
                    bookList.list[i]=book;
                }
                return bookList;
            }else{
                return null;
            }
        }
    }
}
