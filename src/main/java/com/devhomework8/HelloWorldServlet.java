package com.devhomework8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/*")
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        System.out.println("Servler init!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<h1>Hi Servlets!</h1>");
        resp.getWriter().close();
        super.doGet(req, resp);
    }
}
