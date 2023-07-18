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
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Dell
 */
public class ExamSubmit extends DBContext {

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
//        if (cnn != null) {
//            System.out.println("Connect success");
//        } else {
//            System.out.println("Connect fail");
//        }
    }

    public boolean insertExamSubmission(String userId, String courseId, String examName, String fileName, String filePath, String submissionTimeString) {
        try {
            // Kiểm tra xem đã tồn tại bản ghi với UserId, CourseId, và ExamName tương ứng hay chưa
            String sqlCheckExist = "SELECT COUNT(*) AS Count FROM SubmitExam WHERE UserId = ? AND CourseId = ? AND ExamName = ?";
            PreparedStatement pstmtCheckExist = cnn.prepareStatement(sqlCheckExist);
            pstmtCheckExist.setString(1, userId);
            pstmtCheckExist.setString(2, courseId);
            pstmtCheckExist.setString(3, examName);
            ResultSet rsCheckExist = pstmtCheckExist.executeQuery();
            rsCheckExist.next();
            int count = rsCheckExist.getInt("Count");
            rsCheckExist.close();
            pstmtCheckExist.close();

            if (count > 0) {
                // Nếu đã tồn tại, thực hiện cập nhật thông tin
                String sqlUpdate = "UPDATE SubmitExam SET FileName = ?, FilePath = ?, SubmissionTime = ? WHERE UserId = ? AND CourseId = ? AND ExamName = ?";
                PreparedStatement pstmtUpdate = cnn.prepareStatement(sqlUpdate);
                pstmtUpdate.setString(1, fileName);
                pstmtUpdate.setString(2, filePath);
                pstmtUpdate.setString(3, submissionTimeString);
                pstmtUpdate.setString(4, userId);
                pstmtUpdate.setString(5, courseId);
                pstmtUpdate.setString(6, examName);
                pstmtUpdate.executeUpdate();
                pstmtUpdate.close();
            } else {
                // Nếu chưa tồn tại, thực hiện chèn mới
                String sqlInsert = "INSERT INTO SubmitExam (UserId, CourseId, ExamName, FileName, FilePath, SubmissionTime) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmtInsert = cnn.prepareStatement(sqlInsert);
                pstmtInsert.setString(1, userId);
                pstmtInsert.setString(2, courseId);
                pstmtInsert.setString(3, examName);
                pstmtInsert.setString(4, fileName);
                pstmtInsert.setString(5, filePath);
                pstmtInsert.setString(6, submissionTimeString);
                pstmtInsert.executeUpdate();
                pstmtInsert.close();
            }

            return true;
        } catch (SQLException e) {
            System.out.println("insertExamSubmission: " + e.getMessage());
            return false;
        }
    }

    public String getFilePathByUserIdAndCourseId(String userId, String courseId) {
        String filePath = null;
        try {
            String sql = "SELECT FilePath FROM SubmitExam WHERE UserId = ? AND CourseId = ?";
            PreparedStatement pstmt = cnn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, courseId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                filePath = rs.getString("FilePath");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("getFilePathByUserIdAndCourseId: " + e.getMessage());
        }
        return filePath;
    }

}
