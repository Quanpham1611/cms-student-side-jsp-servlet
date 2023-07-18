package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Answer extends DBContext {

    private String answerId;
    private String questionId;
    private String answerText;
    private boolean isCorrect;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
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

    public Answer() {
        connect();
    }

    public Answer(String answerId, String questionId, String answerText, boolean isCorrect) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        connect();
    }

    // Trong lớp Answer
    public List<Answer> getAnswersByQuesId(String questionId) {
        List<Answer> answers = new ArrayList<>();
        try {
            String strSQL = "SELECT * FROM answer WHERE QuesID = ?";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            pstmt.setString(1, questionId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String answerId = rs.getString("ID");
                String answerText = rs.getString("Answer");
                boolean isCorrect = rs.getBoolean("Iscorrect");
                Answer answer = new Answer(answerId, questionId, answerText, isCorrect);
                answers.add(answer);
            }
        } catch (SQLException e) {
            System.out.println("getAnswersByQuesId: " + e.getMessage());
        }
        return answers;
    }

    public List<Answer> getCorrectAnswersByQuesId(String questionId) {
        List<Answer> correctAnswers = new ArrayList<>();
        try {
            String strSQL = "SELECT * FROM answer WHERE QuesID = ? AND Iscorrect = ?";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            pstmt.setString(1, questionId);
            pstmt.setBoolean(2, true);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String answerId = rs.getString("ID");
                String answerText = rs.getString("Answer");
                boolean isCorrect = rs.getBoolean("Iscorrect");
                Answer answer = new Answer(answerId, questionId, answerText, isCorrect);
                correctAnswers.add(answer);
            }
        } catch (SQLException e) {
            System.out.println("getCorrectAnswersByQuesId: " + e.getMessage());
        }
        return correctAnswers;
    }

}
