/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Result extends DBContext {

    String userId, practiseId, courseId, submissionTime;
    Float score;

    public Result(String practiseId, String courseId, Float score, String submissionTime) {
        this.practiseId = practiseId;
        this.courseId = courseId;
        this.submissionTime = submissionTime;
        this.score = score;
        connect();
    }

    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    Connection cnn;//Ket noi database
    Statement stm;//thực hiện câu lệnh sql
    ResultSet rs;//lưu trữ và xử lí dữ liệu

    private void connect() {
        cnn = super.connection;
//        if (cnn != null) {
//            System.out.println("Connect success");
//        } else {
//            System.out.println("Connect fail");
//        }
    }

    public Result(String userId, String practiseId, String courseId, Float score, String submissionTime) {
        this.userId = userId;
        this.courseId = courseId;
        this.practiseId = practiseId;
        this.score = score;
        this.submissionTime = submissionTime;
        connect();
    }

    public Result() {
        connect();
    }

    public String getPractiseId() {
        return practiseId;
    }

    public void setPractiseId(String practiseId) {
        this.practiseId = practiseId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }

    public boolean insertResult(String userId, String courseId, String practiseId, float score) {
        try {
            // Chúng ta sử dụng PreparedStatement để tránh lỗi SQL Injection
            String sql = "INSERT INTO Result (UserId, CourseId, PractiseId, Score, SubmissionTime) VALUES (?, ?, ?, ?, GETDATE())";
            PreparedStatement pstmt = cnn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, courseId);
            pstmt.setString(3, practiseId);
            pstmt.setFloat(4, score);

            int rowsAffected = pstmt.executeUpdate();

            // Nếu có ít nhất 1 hàng được chèn thành công, tức là insert thành công
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("insertResult: " + e.getMessage());
        }
        return false; // Trả về false nếu có lỗi xảy ra hoặc insert không thành công
    }

    public ArrayList<Result> getResult(String userId, String courseId, String practiseId) {
        ArrayList<Result> result = new ArrayList<>();
        try {
            String strSQL = "select * from Result where UserId = ? AND CourseId = ? AND PractiseId = ?";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            pstmt.setString(1, userId);
            pstmt.setString(2, courseId);
            pstmt.setString(3, practiseId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                courseId = rs.getString("CourseId");
                practiseId = rs.getString("PractiseId");
                score = rs.getFloat("Score");
                submissionTime = rs.getString("SubmissionTime");
                Result rs = new Result(courseId, practiseId, score, submissionTime);
                result.add(rs);
            }
        } catch (SQLException e) {
            System.out.println("getResult: " + e.getMessage());
        }
        return result;
    }

}
