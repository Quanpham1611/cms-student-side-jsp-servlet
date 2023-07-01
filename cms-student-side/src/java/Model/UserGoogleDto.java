package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dell
 */
public class UserGoogleDto extends DBContext {

    private String id;

    private String email;

    private boolean verified_email;

    private String name;

    private String given_name;

    private String family_name;

    private String picture;

    public UserGoogleDto() {
        connect();
    }

    public UserGoogleDto(String id, String email, boolean verified_email, String name, String given_name, String family_name, String picture) {
        this.id = id;
        this.email = email;
        this.verified_email = verified_email;
        this.name = name;
        this.given_name = given_name;
        this.family_name = family_name;
        this.picture = picture;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified_email() {
        return verified_email;
    }

    public void setVerified_email(boolean verified_email) {
        this.verified_email = verified_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserGoogleDto{" + "id=" + id + ", email=" + email + ", verified_email=" + verified_email + ", name=" + name + ", given_name=" + given_name + ", family_name=" + family_name + ", picture=" + picture + '}';
    }

    //khai bao cac thanh phan xu li database
    Connection cnn;//Ket noi database
    Statement stm;//thực hiện câu lệnh sql
    ResultSet rs;//lưu trữ và xử lí dữ liệu

    private void connect() {
        cnn = super.connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Connect fail");
        }
    }

    public boolean checkEmailExistsInDatabase(String email) {
        try {
            String sql = "SELECT * FROM Users WHERE Email = '" + email + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                //vào được đây tức là rs.next trả về true
                //tức là rs có giá trị
                //tức là câu lệnh select có trả về giá trị khác null
                //tức là account và pass input có tồn tại
                //tức là login thành công
                String emai = rs.getString(1);
                System.out.println(email);
                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void insertUserToDatabase(UserGoogleDto user) {
//        try {
//            //String sql = "INSERT INTO Users (ID ,Email, Name, Given_Name, Family_Name, Picture) VALUES (" + user.getId() + " ," + user.getEmail() + ", " + user.getEmail() + ", " + user.getEmail() + ", " + user.getEmail() + ", " + user.getEmail() + ")";
//            String sql = "INSERT INTO Users (ID ,Email, Name, Given_Name, Family_Name, Picture) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            
//            stm.setString(1, user.getId());
//            stm.setString(2, user.getEmail());
//            stm.setString(3, user.getName());
//            stm.setString(4, user.getGiven_name());
//            stm.setString(5, user.getFamily_name());
//            stm.setString(6, user.getPicture());
//            
//            
//            int rowsAffected = stm.executeUpdate(sql);
//            System.out.println(rowsAffected + " row(s) inserted.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            String sql = "INSERT INTO Users (ID ,Email, Name, Given_Name, Family_Name, Picture) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = cnn.prepareStatement(sql);

            stm.setString(1, user.getId());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getName());
            stm.setString(4, user.getGiven_name());
            stm.setString(5, user.getFamily_name());
            stm.setString(6, user.getPicture());
            long numberRowsAffected = stm.executeUpdate();
            System.out.println("Affected rows after inserted: " + numberRowsAffected);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkCourseEnrolled(String userId, String courseName) {
        try {
            String sql = "SELECT uc.CourseId FROM UserCourse uc JOIN Course c ON uc.CourseId = c.CourseId WHERE uc.UserId = ? AND c.CourseName = ?";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, userId);
            pstm.setString(2, courseName);
            rs = pstm.executeQuery();

            if (rs.next()) {
                // Đã có dữ liệu trả về, tức là user đã đăng ký khóa học
                return true;
            }
        } catch (SQLException e) {
            System.out.println("checkCourseEnrolled: " + e.getMessage());
        }

        return false;
    }



}
