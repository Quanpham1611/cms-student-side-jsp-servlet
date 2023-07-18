package Controller;

import Model.Course;
import Model.ExamFile;
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
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "SubmitExam", urlPatterns = {"/submit-exam"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class SubmitExam extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examName = request.getParameter("examName");
        String courseName = request.getParameter("courseName");
        Course c = new Course();
        String courseId = c.getCourseIdByCourseName(courseName);

        // Đây là phương thức để lấy phần dữ liệu file được gửi lên từ client (trình duyệt) thông qua request
        Part filePart = request.getPart("examFile");
        // Đây là phương thức để lấy tên file gốc (chưa được thay đổi) của phần dữ liệu file
        String fileName = filePart.getSubmittedFileName();
        String filePath = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads-std\\" + fileName;

        HttpSession session = request.getSession();
        UserGoogleDto user = (UserGoogleDto) session.getAttribute("user");
        String userId = user.getId();
        System.out.println(userId);
        ExamSubmit examSubmit = new ExamSubmit();

        // Kiểm tra xem người dùng đã nộp bài trước đó chưa
        String existingFilePath = examSubmit.getFilePathByUserIdAndCourseId(userId, courseId);

        if (existingFilePath != null && !existingFilePath.isEmpty()) {
            // Nếu người dùng đã nộp bài trước đó, thì xóa file cũ trước khi ghi đè file mới
            File oldFile = new File(existingFilePath);
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }

        // Lưu file vào thư mục uploads
        filePart.write(filePath);

        // Lấy thời gian thực người dùng nộp file
        LocalDateTime submissionTime = LocalDateTime.now();
        String submissionTimeString = submissionTime.toString();
        boolean success = examSubmit.insertExamSubmission(userId, courseId, examName, fileName, filePath, submissionTimeString);

        if (success) {
            String message = "Bạn đã nộp bài thành công!";
            request.setAttribute("message", message);
        } else {
            String error = "Có lỗi xảy ra khi nộp bài!";
            request.setAttribute("error", error);
        }

        request.getRequestDispatcher("submitfile.jsp").forward(request, response);
    }

}
