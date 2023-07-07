package Controller;

import Model.ExamSubmit;
import Model.UserGoogleDto;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(name = "SubmitExam", urlPatterns = {"/submit-exam"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class SubmitExam extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String examName = request.getParameter("examName");
        //Đây là phương thức để lấy phần dữ liệu file được gửi lên từ client (trình duyệt) thông qua request
        Part filePart = request.getPart("examFile");
        //Đây là phương thức để lấy tên file gốc (chưa được thay đổi) của phần dữ liệu file
        String fileName = filePart.getSubmittedFileName();
        String filePath = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads-std\\" + fileName;

        // Lưu file vào thư mục uploads
        filePart.write(filePath);
        HttpSession session = request.getSession();
        UserGoogleDto user = (UserGoogleDto) session.getAttribute("user");
        String userId = user.getId();
        System.out.println(userId);
        ExamSubmit examSubmit = new ExamSubmit();
        boolean success = examSubmit.insertExamSubmission(userId, examName, fileName, filePath);

        if (success) {
            String message = "Bạn đã nộp bài thành công!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            String error = "Có lỗi xảy ra khi nộp bài!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }
    }
}
