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

    private String CourseId, CourseName, Semester, TeacherName, Picture, dateBegin, dateEnd;

    //khai bao cac thanh phan xu li database
    Connection cnn;//Ket noi database
    Statement stm;//thực hiện câu lệnh sql
    ResultSet rs;//lưu trữ và xử lí dữ liệu

    public Course(String CourseId, String CourseName) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        connect();
    }

    public Course(String CourseId, String CourseName, String Semester, String TeacherName, String Picture, String dateBegin, String dateEnd) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        this.Semester = Semester;
        this.TeacherName = TeacherName;
        this.Picture = Picture;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        connect();
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    private void connect() {
        cnn = super.connection;
//        if (cnn != null) {
//            System.out.println("Connect success");
//        } else {
//            System.out.println("Connect fail");
//        }
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

                // Kiểm tra xem đã tồn tại bản ghi trong bảng UserCourse với cùng userId và courseId hay chưa
                sql = "SELECT COUNT(*) AS count FROM UserCourse WHERE UserId = ? AND CourseId = ?";
                pstmt = cnn.prepareStatement(sql);
                pstmt.setString(1, userId);
                pstmt.setString(2, courseId);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt("count");
                    if (count > 0) {
                        // Khóa học đã được đăng ký bởi người dùng
                        return true;
                    }
                }

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
//            String sqlQuery = "SELECT * FROM Course WHERE CourseId like ? UNION ALL "
//                    + "SELECT * FROM Course WHERE CourseName like ? AND CourseId <> ? UNION ALL "
//                    + "SELECT * FROM Course WHERE TeacherName like ? AND CourseId <> ? AND CourseName <> ?";
            String sqlQuery = "SELECT * FROM Course WHERE TeacherName like ? OR CourseId like ? OR CourseName like ?";

            PreparedStatement statement = cnn.prepareStatement(sqlQuery);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
//            statement.setString(4, "%" + keyword + "%");
//            statement.setString(5, "%" + keyword + "%");
//            statement.setString(6, "%" + keyword + "%");

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
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("searchByKeyWord: " + e.getMessage());
        }

        return searchResult;
    }

    public String getCourseIdByCourseName(String courseName) {
        String courseId = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT courseId FROM course WHERE courseName = ?");
            statement.setString(1, courseName);
            ResultSet resultSet = statement.executeQuery();

            // Lấy kết quả từ ResultSet
            if (resultSet.next()) {
                courseId = resultSet.getString("courseId");
            }
        } catch (SQLException e) {
            System.out.println("getCourseIdByCourseName: " + e.getMessage());
        }
        return courseId;
    }

    public String getDateBeginInDatabase(String courseId) {
        String dateBegin = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT dateBegin FROM course WHERE courseId = ?");
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();

            // Lấy kết quả từ ResultSet
            if (resultSet.next()) {
                dateBegin = resultSet.getString("dateBegin");
            }
        } catch (SQLException e) {
            System.out.println("getDateBeginInDatabase: " + e.getMessage());
        }
        return dateBegin;

    }

    public String getDateEndInDatabase(String courseId) {
        String dateEnd = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT dateEnd FROM course WHERE courseId = ?");
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();

            // Lấy kết quả từ ResultSet
            if (resultSet.next()) {
                dateEnd = resultSet.getString("dateEnd");
            }
        } catch (SQLException e) {
            System.out.println("getDateEndInDatabase: " + e.getMessage());
        }
        return dateEnd;
    }

    public boolean deleteEnrollCourse(String userId, String courseId) {
        try {
            // Kiểm tra xem bản ghi có tồn tại trong bảng UserCourse với cùng userId và courseId hay chưa
            String sql = "SELECT COUNT(*) AS count FROM UserCourse WHERE UserId = ? AND CourseId = ?";
            PreparedStatement pstmt = cnn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, courseId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    // Xóa bản ghi khỏi bảng UserCourse
                    sql = "DELETE FROM UserCourse WHERE UserId = ? AND CourseId = ?";
                    pstmt = cnn.prepareStatement(sql);
                    pstmt.setString(1, userId);
                    pstmt.setString(2, courseId);
                    pstmt.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("deleteEnrollCourse: " + e.getMessage());
        }
        return false;
    }
}
