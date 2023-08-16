package com.us.entity.DAO;

import com.system.DB.DBClose;
import com.system.DB.DBConnection;
import com.us.entity.DTO.StudentDTO;
import com.us.entity.DTO.UserDTO;

import java.sql.*;

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private String GET_USER_ACCESS_INFO = "SELECT * FROM Users WHERE userId =?";
    private String INSERT_USER = "INSERT INTO Users" +
            "(userId, password, name, birth, address, majorId, role, status)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private String SELECT_USER = "SELECT * FROM `Users`";
    private String GET_STUDENT_INFO =
    "SELECT S.studentId, U1.name, U1.birth, U2.name, U1.role, U1.status, U1.address "+
    "FROM Student S "+
    "INNER JOIN Users U1 ON S.studentId = U1.userId "+
    "INNER JOIN Professor P ON S.professorId = P.userId "+
    "INNER JOIN Users U2 ON P.userId = U2.userId "+
    "WHERE S.studentId = ?";
    public StudentDTO getStudent(String sId){
        StudentDTO student = new StudentDTO();
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(GET_STUDENT_INFO);
            psmt.setString(1, sId.trim());
            rs = psmt.executeQuery();
            while(rs.next()){
                student.setStudentId(rs.getLong("S.studentId"));
                student.setName(rs.getString("U1.name"));
                student.setRole(rs.getString("U1.Role"));
                student.setBirth(rs.getDate("U1.birth"));
                student.setAdvisor(rs.getString("U2.name"));
                student.setStatus(rs.getString("U1.status"));
                student.setAddress(rs.getString("U1.address"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return student;
    }



    public UserDTO getUserLogin(UserDTO dto){
        UserDTO user = null;
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(GET_USER_ACCESS_INFO);
            psmt.setLong(1, dto.getUserId());
            rs= psmt.executeQuery();
            while(rs.next()){
                user = new UserDTO();
                user.setUserId(rs.getLong("userId"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
            }
        }catch (SQLException e){

        }finally {
            DBClose.close(rs, psmt, conn);
        }

        return user;
    }
    public UserDTO selectUserList(UserDTO dto){
        UserDTO user = null;
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(SELECT_USER);
            rs = psmt.executeQuery();
            while(rs.next()){
                user = new UserDTO();
                user.setUserId(rs.getLong("userId"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setBirth(rs.getDate("birth"));
                user.setAddress(rs.getString("address"));
                user.setMajorId(rs.getLong("majorId"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBClose.close(rs, psmt, conn);
        }
        return user;
    }


    public void insertUserList(UserDTO dto) {
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(INSERT_USER);

            psmt.setLong(1, dto.getUserId());
            psmt.setString(2, dto.getPassword().trim());
            psmt.setString(3, dto.getName().trim());
            psmt.setDate(4, dto.getBirth());
            psmt.setString(5, dto.getAddress().trim());
            psmt.setLong(6, dto.getMajorId());
            psmt.setString(7, dto.getRole().trim());
            psmt.setString(8, dto.getStatus());

            psmt.executeUpdate();
            if(dto.getRole().equals("학생")){
                try{
                    String insertStudent = "INSERT INTO `Student`" +
                            "(studentId, userId)" +
                            "VALUES(?, ?)";
                    psmt = conn.prepareStatement(insertStudent);
                    psmt.setLong(1, dto.getUserId());
                    psmt.setLong(2, dto.getUserId());
                    psmt.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else{
                try{
                    String insertStudent = "INSERT INTO `professor`" +
                            "(professorId, userId)" +
                            "VALUES(?, ?)";
                    psmt = conn.prepareStatement(insertStudent);
                    psmt.setLong(1, dto.getUserId());
                    psmt.setLong(2, dto.getUserId());
                    psmt.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }

            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBClose.close(rs, psmt, conn);


        }

    }




}
