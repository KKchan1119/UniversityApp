package com.us.controller.user;

import com.us.entity.DAO.UserDAO;
import com.us.entity.DTO.UserDTO;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        UserDTO user = dao.getUserLogin(dto);


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (user != null) {
            if (user.getPassword().equals(password)) {
                Cookie userIdCookie =
                        new Cookie("userId", String.valueOf(user.getUserId()));
                response.addCookie(userIdCookie);
                response.sendRedirect("main.html");
            } else {
                showLoginFailAlert(response);
            }
        } else {
            showLoginFailAlert(response);
        }
    }
    private void showLoginFailAlert(HttpServletResponse response) throws IOException {
        response.getWriter().println("<script>");
        response.getWriter().println("alert('로그인 실패입니다.');");
        response.getWriter().println("location.href = '/';");
        response.getWriter().println("</script>");
    }

}
