package Model;

import dal.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Question extends DBContext {

    private String questionId;
    private String courseId;
    private String questionText;
    private List<Answer> answers;
    private String[] selectedAnswers;
    private boolean isCorrectAnswer;

    public void setSelectedAnswers(String[] selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    public String[] getSelectedAnswers() {
        return selectedAnswers;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(boolean correct) {
        isCorrectAnswer = correct;
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

    public boolean isIsCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setIsCorrectAnswer(boolean isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
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

    private Connection cnn;

    private void connect() {
        cnn = super.connection;
    }

    public List<Question> getQuestionsByPractiseId(String practiseId) {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "SELECT TOP 10 * FROM question WHERE ID IN (SELECT TOP 10 QuestionId FROM Practise_Question WHERE PractiseId = ? ORDER BY NEWID())";
            PreparedStatement pstmt = cnn.prepareStatement(strSQL);
            pstmt.setString(1, practiseId);
            ResultSet rs = pstmt.executeQuery();
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
