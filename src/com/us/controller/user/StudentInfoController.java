package com.us.controller.user;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/main.do")
public class StudentInfoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        String getDisplayStudentId = request.getParameter("name");



    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        Cookie[] cookies = request.getCookies();
        String userId = null;
        if(cookies == null){
            response.sendRedirect("login.html");
        }else{

            for(Cookie cookie : cookies){
                if(cookie.getName().equals("userId")){
                    userId = cookie.getValue();
                }
            }
            if (userId == null){
                response.sendRedirect("login.html");
            }
        }

    }
}
