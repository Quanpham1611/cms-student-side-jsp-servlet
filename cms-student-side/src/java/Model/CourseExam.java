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
public class CourseExam extends DBContext {

    String examName, courseId, begin, finish;

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

    public CourseExam(String examName, String courseId, String begin, String finish) {
        this.examName = examName;
        this.courseId = courseId;
        this.begin = begin;
        this.finish = finish;
        connect();
    }

    public CourseExam() {
        connect();
    }

    public String getExamName() {
        return examName;
    }

    public void setCourseName(String examName) {
        this.examName = examName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public ArrayList<CourseExam> getExamByCourseId(String courseId) {
        ArrayList<CourseExam> searchResult = new ArrayList<>();

        try {
            // Truy vấn theo thứ tự ưu tiên: CourseId, CourseName, TeacherName
            String sqlQuery = "SELECT * FROM CourseExam where CourseId = ?";

            PreparedStatement statement = cnn.prepareStatement(sqlQuery);
            statement.setString(1, courseId);

            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các kết quả và thêm vào danh sách searchResult
            while (resultSet.next()) {
                examName = resultSet.getString("ExamName");
                courseId = resultSet.getString("CourseId");
                begin = resultSet.getString("ExamBegin");
                finish = resultSet.getString("ExamFinish");

                CourseExam courseExam = new CourseExam(examName, courseId, begin, finish);
                searchResult.add(courseExam);
                System.out.println("1 " + examName +" 2 "+ courseId +" 3 " + begin +" 4 " +finish);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("getExamByCourseId: " + e.getMessage());
        }
        return searchResult;
    }

}
