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

/**
 *
 * @author Dell
 */
public class ExamSubmit extends DBContext{
    String examName, fileName, filePath;

    public ExamSubmit(String examName, String fileName, String filePath) {
        this.examName = examName;
        this.fileName = fileName;
        this.filePath = filePath;
        connect();
    }

    public ExamSubmit() {
        connect();
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    
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

    public boolean insertExamSubmission(String userId, String examName, String fileName, String filePath) {
    try {
        String sql = "INSERT INTO SubmitExam (UserId, ExamName, FileName, FilePath) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = cnn.prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.setString(2, examName);
        pstmt.setString(3, fileName);
        pstmt.setString(4, filePath);
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.out.println("insertExamSubmission: " + e.getMessage());
        return false;
    }
}

}
