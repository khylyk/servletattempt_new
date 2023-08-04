//package com.devhomework8;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@WebServlet(value = "/*")
//public class TimeServlet extends HttpServlet {
//
//    private String initTime;
//
//    @Override
//    public void init() throws ServletException{
//        initTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'"));
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html; charset=utf-8");
//        resp.getWriter().write(initTime);
//        resp.getWriter().close();
//    }
//
//    @Override
//    public void destroy() {
//        initTime = null;
//    }
//}
