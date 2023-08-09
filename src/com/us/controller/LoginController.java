package com.us.controller;

import com.us.entity.DAO.UserDAO;
import com.us.entity.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");


        UserDTO dto = new UserDTO();
        dto.setUserId(Long.parseLong(userId));

        UserDAO dao = new UserDAO();
        UserDTO user = dao.getUser(dto);


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

            if (user != null) {
                if (user.getPassword().equals(password)) {
                    out.println(user.getName() + "님 접속을 환영합니다.<br>");
                    out.println("<a href='/Info.do>정보 페이지로 이동</a>");
                } else {
                    out.println("비밀번호 오류입니다.<br>");
                    out.println("<a href='/'>다시 로그인</a>");
                }
            } else {
                out.println("아이디 오류입니다.<br>");
                out.println("<a href='/'>다시 로그인</a>");
            }


    }
}
