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
public class CourseContent extends DBContext {

    private String contentId;
    private String courseId;
    private String contentName;
    private String contentLink;
    private String timeAdd;

    public CourseContent(String contentId, String courseId, String contentName, String contentLink, String timeAdd) {
        this.contentId = contentId;
        this.courseId = courseId;
        this.contentName = contentName;
        this.contentLink = contentLink;
        this.timeAdd = timeAdd;
        connect();
    }

    //khai bao cac thanh phan xu li database
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

    public CourseContent() {
        connect();
    }

    public CourseContent(String contentId, String courseId, String contentName, String contentLink) {
        this.contentId = contentId;
        this.courseId = courseId;
        this.contentName = contentName;
        this.contentLink = contentLink;
        connect();
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public ArrayList<CourseContent> getCourseContentByCourseId(String courseId) {
        ArrayList<CourseContent> searchResult = new ArrayList<>();

        try {
            // Truy vấn theo thứ tự ưu tiên: CourseId, CourseName, TeacherName
            String sqlQuery = "SELECT * FROM CourseContent where CourseId = ?";

            PreparedStatement statement = cnn.prepareStatement(sqlQuery);
            statement.setString(1, courseId);

            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các kết quả và thêm vào danh sách searchResult
            while (resultSet.next()) {
                contentId = resultSet.getString("ContentId");
                courseId = resultSet.getString("CourseId");
                contentName = resultSet.getString("FileName");
                contentLink = resultSet.getString("FilePath");
                timeAdd = resultSet.getString("timeAdd");
                CourseContent courseContent = new CourseContent(contentId, courseId, contentName, contentLink, timeAdd);
                searchResult.add(courseContent);
                

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("getCourseContentByCourseId: " + e.getMessage());
        }
        return searchResult;
    }

    public String getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(String timeAdd) {
        this.timeAdd = timeAdd;
    }

}
