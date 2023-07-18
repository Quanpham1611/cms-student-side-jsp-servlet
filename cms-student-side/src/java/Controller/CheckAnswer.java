package Controller;

import Model.Answer;
import Model.Course;
import Model.Question;
import Model.Result;
import Model.UserGoogleDto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CheckAnswer", urlPatterns = {"/checkanswer"})
public class CheckAnswer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get practiseId from the hidden input field
        String practiseId = request.getParameter("practiseId");

        // Get the submitted answers from the request
        Map<String, String[]> parameterMap = request.getParameterMap();

        // Check if the user has provided answers for all questions
        List<Question> questions = new ArrayList<>();
        for (String key : parameterMap.keySet()) {
            if (key.startsWith("answers_")) {
                String questionId = key.substring("answers_".length());
                String[] selectedAnswers = parameterMap.get(key);

                Question q = new Question();
                q.setQuestionId(questionId);
                // Set the selected answers for this question
                q.setSelectedAnswers(selectedAnswers);
                questions.add(q);
            }
        }

        // Now you have the list of questions with their selected answers, you can process the answers
        Answer a = new Answer();
        int score = 0;
        boolean isCorrect = true;
        for (Question question : questions) {
            List<Answer> correctAnswers = a.getCorrectAnswersByQuesId(question.getQuestionId());
            for (Answer correctAnswer : correctAnswers) {
                boolean isSelected = contains(question.getSelectedAnswers(), correctAnswer.getAnswerId());
                boolean isCorrectAnswer = correctAnswer.isCorrect();
                if (!isSelected || !isCorrectAnswer) {
                    isCorrect = false;
                    break;
                } else {
                    score++;
                }
            }
        }

        HttpSession session = request.getSession();
        UserGoogleDto user = (UserGoogleDto) session.getAttribute("user");
        String userId = user.getId();
        
        Result r = new Result();

        String courseName = request.getParameter("name");
        Course c = new Course();
        String courseId = c.getCourseIdByCourseName(courseName);

        boolean insert = r.insertResult(userId, courseId, practiseId, score);

        if (insert) {
            request.setAttribute("courseId", courseId);
            request.setAttribute("score", score);
            request.setAttribute("practiseId", practiseId);
            request.setAttribute("courseName", courseName);
            request.getRequestDispatcher("showresult.jsp").forward(request, response);
        }
    }

    private boolean contains(String[] array, String value) {
        if (array == null || value == null) {
            return false;
        }
        for (String item : array) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
