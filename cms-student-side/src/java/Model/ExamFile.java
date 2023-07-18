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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ExamFile extends DBContext {

    private String fileName;
    private String submissionTime;
    private String filePath;

    public ExamFile() {
        connect();
    }

    public ExamFile(String fileName, String filePath, String submissionTime) {
        this.fileName = fileName;
        this.submissionTime = submissionTime;
        this.filePath = filePath;
        connect();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    Connection cnn; // Ket noi database

    private void connect() {
        cnn = super.connection;
//        if (cnn != null) {
//            System.out.println("Connect success");
//        } else {
//            System.out.println("Connect fail");
//        }
    }

    public ArrayList<ExamFile> getExamFilesByUserId(String userId, String courseId, String examName) {
        ArrayList<ExamFile> fileList = new ArrayList<>();

        // Truy vấn cơ sở dữ liệu để lấy danh sách các tệp đã nộp của người dùng dựa vào userId, courseId và examName
        // Dùng ResultSet để lấy thông tin của các tệp đã nộp
        // Ví dụ truy vấn có thể là:
        String query = "SELECT FileName, SubmissionTime, FilePath FROM SubmitExam WHERE UserId = ? AND CourseId = ? AND ExamName = ?";
        try ( Connection connection = super.connection;  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, courseId);
            preparedStatement.setString(3, examName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String fileName = resultSet.getString("FileName");
                String submissionTime = resultSet.getString("SubmissionTime"); // Change to String
                String filePath = resultSet.getString("FilePath");

                // Tạo đối tượng ExamFile và thêm vào danh sách
                ExamFile examFile = new ExamFile(fileName, filePath, submissionTime);
                fileList.add(examFile);
            }
        } catch (SQLException e) {
            System.out.println("getExamFilesByUserId: " + e.getMessage());
        }

        return fileList;
    }

}
