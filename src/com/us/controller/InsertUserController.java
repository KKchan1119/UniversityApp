package com.us.controller;

import com.us.entity.DAO.UserDAO;
import com.us.entity.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/insertUser.do")
public class InsertUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String majorId = request.getParameter("majorId");
        String role = request.getParameter("role");
        String status = request.getParameter("status");

        UserDTO dto = new UserDTO();
        dto.setUserId(Long.parseLong(userId));
        dto.setPassword(password);
        dto.setName(name);
        dto.setBirth(Date.valueOf(birth));
        dto.setAddress(address);
        dto.setMajorId(Long.parseLong(majorId));
        dto.setRole(role);
        dto.setStatus(status);

        UserDAO dao = new UserDAO();
        dao.insertUserList(dto);

        response.sendRedirect("login.html");
    }
}
