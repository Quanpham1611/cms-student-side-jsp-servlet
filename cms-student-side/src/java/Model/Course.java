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
import java.util.List;

/**
 *
 * @author Dell
 */
public class Course extends DBContext {

    private String CourseId, CourseName, Semester, TeacherName, Picture;

    //khai bao cac thanh phan xu li database
    Connection cnn;//Ket noi database
    Statement stm;//thực hiện câu lệnh sql
    ResultSet rs;//lưu trữ và xử lí dữ liệu

    public Course(String CourseId, String CourseName) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        connect();
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    private void connect() {
        cnn = super.connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Connect fail");
        }
    }

    public Course() {
        connect();
    }

    public Course(String CourseId, String CourseName, String Semester, String TeacherName, String Picture) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        this.Semester = Semester;
        this.TeacherName = TeacherName;
        this.Picture = Picture;
        connect();
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String CourseId) {
        this.CourseId = CourseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }

    public ArrayList<Course> getUsersEnrolledCourses(String userId) {
        ArrayList<Course> enrolledCourses = new ArrayList<>();
        try {
            String strSQL = "SELECT UC.CourseId, C.CourseName FROM UserCourse UC JOIN Course C ON UC.CourseId = C.CourseId WHERE UC.UserId = ?";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String courseId = rs.getString("CourseId");
                String courseName = rs.getString("CourseName");
                Course course = new Course(courseId, courseName);
                enrolledCourses.add(course);
            }
        } catch (Exception e) {
            System.out.println("getUsersEnrolledCourses: " + e.getMessage());
        }
        return enrolledCourses;
    }

    public ArrayList<Course> getAllCourse() {
        ArrayList<Course> allcourse = new ArrayList<>();
        try {
            String strSQL = "select * from Course";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String courseId = rs.getString("CourseId");
                String courseName = rs.getString("CourseName");
                String Semester = rs.getString("Semester");
                String TeacherName = rs.getString("TeacherName");
                String Picture = rs.getString("Picture");
                Course course = new Course(courseId, courseName, Semester, TeacherName, Picture);
                allcourse.add(course);
            }
        } catch (Exception e) {
            System.out.println("getAllCourse: " + e.getMessage());
        }
        return allcourse;
    }

    public boolean enrollCourse(String courseName, String userId) {
        try {
            // Truy vấn lấy courseId từ bảng Course
            String sql = "SELECT CourseId FROM Course WHERE CourseName = ?";
            PreparedStatement pstmt = cnn.prepareStatement(sql);
            pstmt.setString(1, courseName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String courseId = rs.getString("CourseId");

                // Chèn dữ liệu vào bảng UserCourse
                sql = "INSERT INTO UserCourse (UserId, CourseId) VALUES (?, ?)";
                pstmt = cnn.prepareStatement(sql);
                pstmt.setString(1, userId);  // Thay userId bằng giá trị tương ứng
                pstmt.setString(2, courseId);
                pstmt.executeUpdate();

                return true;
            }
        } catch (SQLException e) {
            System.out.println("EnrollServlet: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Course> searchByKeyWord(String keyword) {
        ArrayList<Course> searchResult = new ArrayList<>();

        try {
            // Truy vấn theo thứ tự ưu tiên: CourseId, CourseName, TeacherName
            String sqlQuery = "SELECT * FROM Course WHERE CourseId like ? UNION ALL "
                    + "SELECT * FROM Course WHERE CourseName like ? AND CourseId <> ? UNION ALL "
                    + "SELECT * FROM Course WHERE TeacherName like ? AND CourseId <> ? AND CourseName <> ?";

            PreparedStatement statement = cnn.prepareStatement(sqlQuery);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            statement.setString(4, "%" + keyword + "%");
            statement.setString(5, "%" + keyword + "%");
            statement.setString(6, "%" + keyword + "%");

            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các kết quả và thêm vào danh sách searchResult
            while (resultSet.next()) {
                String courseId = resultSet.getString("CourseId");
                String courseName = resultSet.getString("CourseName");
                String semester = resultSet.getString("Semester");
                String teacherName = resultSet.getString("TeacherName");
                String picture = resultSet.getString("Picture");

                Course course = new Course(courseId, courseName, semester, teacherName, picture);
                searchResult.add(course);
                System.out.println(courseId);
                System.out.println(courseName);
                System.out.println(semester);
                System.out.println(teacherName);
                System.out.println(picture);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("searchByKeyWord: " + e.getMessage());
        }

        return searchResult;
    }

}
