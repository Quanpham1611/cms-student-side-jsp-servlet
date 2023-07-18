package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Question extends DBContext {

    private String questionId;
    private String courseId;
    private String questionText;
    private List<Answer> answers;
    private String[] selectedAnswers;

    // Các phương thức hiện tại của lớp Question

    // Thêm phương thức setter cho danh sách câu trả lời đã chọn
    public void setSelectedAnswers(String[] selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    // Thêm phương thức getter cho danh sách câu trả lời đã chọn
    public String[] getSelectedAnswers() {
        return selectedAnswers;
    }
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Question() {
        connect();
    }

    public Question(String questionId, String courseId, String questionText) {
        this.questionId = questionId;
        this.courseId = courseId;
        this.questionText = questionText;
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

    public List<Question> getQuestionsByPractiseId(String practiseId) {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "SELECT TOP 10 * FROM question WHERE ID IN (SELECT TOP 10 QuestionId FROM Practise_Question WHERE PractiseId = ? ORDER BY NEWID())";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            pstmt.setString(1, practiseId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String questionId = rs.getString("ID");
                String courseId = rs.getString("CourseId");
                String questionText = rs.getString("Question");
                Question question = new Question(questionId, courseId, questionText);
                questions.add(question);
            }
        } catch (SQLException e) {
            System.out.println("getQuestionsByPractiseId: " + e.getMessage());
        }
        return questions;
    }

}
