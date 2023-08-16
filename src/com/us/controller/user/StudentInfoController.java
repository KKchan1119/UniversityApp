package com.us.controller.user;

import com.us.entity.DAO.UserDAO;
import com.us.entity.DTO.StudentDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/main.do")
public class StudentInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            HttpSession session = request.getSession();
            String sessionId = (String)session.getAttribute("sessionId");
            if(sessionId == null){
                response.sendRedirect("/");
            }
            UserDAO userDAO = new UserDAO();
            StudentDTO student = userDAO.getStudent(sessionId);

            request.setAttribute("student", student);

            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
            dispatcher.forward(request, response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.removeAttribute("sessoinId");
        response.sendRedirect("login.do");
        System.out.println("logout");
    }
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
//        Cookie[] cookies = request.getCookies();
//        String userId = null;
//        if(cookies == null){
//            response.sendRedirect("login.html");
//        }else{
//
//            for(Cookie cookie : cookies){
//                if(cookie.getName().equals("userId")){
//                    userId = cookie.getValue();
//                }
//            }
//            if (userId == null){
//                response.sendRedirect("login.html");
//            }
//        }
//
//    }
}
