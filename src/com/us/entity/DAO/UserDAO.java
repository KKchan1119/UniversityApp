package com.us.entity.DAO;

import com.system.DB.DBConnection;
import com.us.entity.UserDTO;

import java.sql.*;

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private String GET = "SELECT * FROM Users WHERE userId =?";
    private String INSERT = "INSERT INTO Users" +
            "(userId, password, `name`, birth, address, majorId, `role`, status)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public UserDTO getUser(UserDTO dto){
        UserDTO user = null;
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(GET);
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
    public void insertUserList(UserDTO dto) {
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(INSERT);

            psmt.setLong(1, dto.getUserId());
            psmt.setString(2, dto.getPassword());
            psmt.setString(3, dto.getName());
            psmt.setDate(4, dto.getBirth());
            psmt.setString(5, dto.getAddress());
            psmt.setLong(6, dto.getMajorId());
            psmt.setString(7, dto.getRole());
            psmt.setString(8, dto.getStatus());
            psmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                }

            }
            if(psmt!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                }
            }


        }

    }




}
