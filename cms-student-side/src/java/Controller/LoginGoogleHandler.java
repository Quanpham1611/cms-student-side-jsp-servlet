package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Model.UserGoogleDto;
import Common.Constants;
import Model.Course;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author Dell
 */
public class LoginGoogleHandler extends HttpServlet {

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
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogleDto user = getUserInfo(accessToken);
        System.out.println(user);

        String email = user.getEmail();
        String name = user.getName();
        String picture = user.getPicture();
        String userId = user.getId();
        System.out.println(email.endsWith("@fpt.edu.vn"));
        if (email.endsWith("@fpt.edu.vn")) {
            boolean existsInDatabase = user.checkEmailExistsInDatabase(email);
            System.out.println(existsInDatabase);
            if (!existsInDatabase) {
                user.insertUserToDatabase(user);
            }
            startUserSession(request, user);
//            response.sendRedirect("dashboard.jsp");
            request.setAttribute("name", name);
            request.setAttribute("picture", picture);

            
            System.out.println(userId);
            Course course = new Course();
            ArrayList<Course> enrolledCourses = course.getUsersEnrolledCourses(userId);
            request.setAttribute("enrolledCourses", enrolledCourses);
            request.getRequestDispatcher("doashboard.jsp").forward(request, response);            
        } else {
            response.sendRedirect("login.jsp?error=invalid_email");
        }

//        String userId = user.getId(); // lấy userId
//
//        // Gọi phương thức getUsersEnrolledCourses trong lớp Course và truyền userId vào
//        Course course = new Course();
//        ArrayList<String> enrolledCourses = course.getUsersEnrolledCourses(userId);
//
//        // Đặt danh sách CourseId vào thuộc tính course của request
//        request.setAttribute("course", enrolledCourses);
//
//        // Chuyển hướng đến trang dashboard.jsp để hiển thị danh sách
//        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

        return googlePojo;
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

    private void startUserSession(HttpServletRequest request, UserGoogleDto user) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(1800); //user have max time is 30 minutes, after that require log in again
    }

}
