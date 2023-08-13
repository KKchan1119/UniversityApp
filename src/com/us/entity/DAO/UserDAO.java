package com.us.entity.DAO;

import com.system.DB.DBClose;
import com.system.DB.DBConnection;
import com.us.entity.DTO.StudentDTO;
import com.us.entity.DTO.UserDTO;

import java.sql.*;
import java.text.SimpleDateFormat;

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private String GET_USER_ACCESS_INFO = "SELECT * FROM Users WHERE userId =?";
    private String INSERT_USER = "INSERT INTO Users" +
            "(userId, password, `name`, birth, address, majorId, `role`, status, userImageUrl)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String SELECT_USER = "SELECT * FROM `Users`";
    private String GET_STUDENT_INFO =
            "SELECT S.studentId AS 학번, `U1`.name AS 이름," +
            "       `U1`.birth AS 생년월일, `U2`.name AS 지도교수," +
            "       `U1`.status AS 재적상태, `U1`.address AS 주소" +
            "FROM Student S" +
            "INNER JOIN Users U1 ON S.studentId =U1.userId" +
            "INNER JOIN Professor P ON S.professorId = P.userId" +
            "INNER Join Users U2 ON P.userId = U2.userId WHERE S.studentId =?";

    public StudentDTO getStudent(UserDTO dto){
        StudentDTO student = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(GET_STUDENT_INFO);
            psmt.setLong(1, dto.getUserId());
            rs = psmt.executeQuery();
            while(rs.next()){
                student = new StudentDTO();
                student.setStudentId(rs.getLong("studentId"));
                student.setName(rs.getString("name"));
                student.setBirth(rs.getDate("birth"));
                student.setAge(rs.getInt("age"));
                student.setAvgScore(rs.getFloat("avgScore"));
                student.setAdvisor(rs.getString(""));

            }
        }catch (SQLException e){

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

            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                }
            }
            if(psmt!=null){
                try {
                    psmt.close();
                }catch (SQLException e){
                }
            }
            if(rs !=null){

            }
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
                user.setUserImageUrl(rs.getString("userImageUrl"));
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
            psmt.setString(9,dto.getUserImageUrl());
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
