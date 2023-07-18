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
public class Practise extends DBContext {

    private String practiseId, courseId, practiseName;

    public Practise() {
        connect();
    }

    public Practise(String practiseId, String courseId, String practiseName) {
        this.practiseId = practiseId;
        this.courseId = courseId;
        this.practiseName = practiseName;
        connect();
    }

    public String getPractiseId() {
        return practiseId;
    }

    public void setPractiseId(String practiseId) {
        this.practiseId = practiseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getPractiseName() {
        return practiseName;
    }

    public void setPractiseName(String practiseName) {
        this.practiseName = practiseName;
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

    public ArrayList<Practise> getListPractiseByCourseId(String courseId) {
        ArrayList<Practise> practiseList = new ArrayList<>();
        try {
            String strSQL = "SELECT * from Practise where courseId = ?";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            pstmt.setString(1, courseId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                practiseId = rs.getString("PractiseId");
                courseId = rs.getString("CourseId");
                practiseName = rs.getString("Practisename");
                Practise p = new Practise(practiseId, courseId, practiseName);
                practiseList.add(p);
            }
        } catch (SQLException e) {
            System.out.println("getListPractiseByCourseId: " + e.getMessage());
        }
        return practiseList;
    }
}
