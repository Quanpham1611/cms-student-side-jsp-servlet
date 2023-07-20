package Controller;

import Model.Answer;
import Model.Question;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "Practise", urlPatterns = {"/practise"})
public class Practise extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String practiseId = request.getParameter("id");
        String name = request.getParameter("name");
        Question q = new Question();
        Answer a = new Answer();
        // 2. Retrieve questions and answers from the database
        List<Question> questions = q.getQuestionsByPractiseId(practiseId);
        for (Question question : questions) {
            List<Answer> answers = a.getAnswersByQuesId(question.getQuestionId());
            question.setAnswers(answers); // Đặt danh sách câu trả lời cho từng câu hỏi
        }

        // 3. Set the data in the request attributes
        request.setAttribute("questions", questions);
        request.setAttribute("name", name);
        request.setAttribute("practiseId", practiseId);
        request.getRequestDispatcher("Practise.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
