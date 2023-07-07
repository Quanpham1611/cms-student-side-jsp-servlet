/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import Model.CourseContent;
import Model.CourseExam;
import Model.UserGoogleDto;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class CourseDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String picture = request.getParameter("picture");
        String courseName = request.getParameter("courseName");
        String semester = request.getParameter("semester");
        String teacher = request.getParameter("teacher");

        Course c = new Course();
        String courseId = c.getCourseIdByCourseName(courseName);

        request.setAttribute("picture", picture);
        request.setAttribute("courseName", courseName);
        request.setAttribute("semester", semester);
        request.setAttribute("teacher", teacher);

        HttpSession session = request.getSession();
        UserGoogleDto user = (UserGoogleDto) session.getAttribute("user");
        String userId = user.getId();

        boolean isEnrolled = user.checkCourseEnrolled(userId, courseName);

        if (!isEnrolled) {
//            request.getRequestDispatcher("coursedetailenrolled.jsp").forward(request, response);
            request.getRequestDispatcher("coursedetail.jsp").forward(request, response);
        } else {
//            request.getRequestDispatcher("coursedetail.jsp").forward(request, response);
            CourseContent courseContent = new CourseContent();
            ArrayList<CourseContent> content = courseContent.getCourseContentByCourseId(courseId);
            
            CourseExam courseExam = new CourseExam();
            ArrayList<CourseExam> exam = courseExam.getExamByCourseId(courseId);

            if (!content.isEmpty() || !exam.isEmpty()) {
                request.setAttribute("exam", exam);
                request.setAttribute("content", content);
                request.getRequestDispatcher("coursedetailenrolled.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("coursedetailenrolledempty.jsp").forward(request, response);
            }
        }
//        request.getRequestDispatcher("coursedetail.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
