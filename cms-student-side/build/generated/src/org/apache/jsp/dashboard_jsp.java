package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    String name = (String) request.getAttribute("name");
    String picture = (String) request.getAttribute("picture");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>CMS - Course Management System</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"https://cmshn.fpt.edu.vn/theme/image.php/trema/theme/1684246329/favicon\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\n");
      out.write("            integrity=\"sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("            referrerpolicy=\"no-referrer\"\n");
      out.write("            />\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"hamburger-menu\">\n");
      out.write("            <input id=\"menu__toggle\" type=\"checkbox\" />\n");
      out.write("            <label class=\"menu__btn\" for=\"menu__toggle\">\n");
      out.write("                <span></span>\n");
      out.write("            </label>\n");
      out.write("            <img src=\"https://cmshn.fpt.edu.vn/pluginfile.php/1/core_admin/logocompact/0x70/1684246329/2020-FPTU-Eng.png\" alt=\"logo\">\n");
      out.write("            <label for=\"cars\" class=\"fa fa-mortar-board\" style=\"margin-left: 2px; width: 100px\">Khóa học của bạn:</label>\n");
      out.write("\n");
      out.write("            <select id=\"cars\">\n");
      out.write("                <option value=\"volvo\">Volvo</option>\n");
      out.write("                <option value=\"saab\">Saab</option>\n");
      out.write("                <option value=\"opel\">Opel</option>\n");
      out.write("                <option value=\"audi\">Audi</option>\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <a class=\"login-title\">BẠN CHƯA ĐĂNG NHẬP(<a href=\"login.jsp\" class=\"underline-link\">ĐĂNG NHẬP</a>)</a>\n");
      out.write("            <ul class=\"menu__box\">\n");
      out.write("                <li><a class=\"menu__item\" href=\"doashborad.jsp\"><i class=\"fa fa-home\"></i>Trang chủ</a></li>\n");
      out.write("                <li><a class=\"menu__item\" href=\"home.jsp\"><i class=\"fa fa-desktop\"></i>Bảng điều khiển</a></li>\n");
      out.write("                <li><a class=\"menu__item\" href=\"index.html\"><i class=\"fa fa-home\"></i>Trang chủ</a></li>\n");
      out.write("                <li><a class=\"menu__item\" href=\"index.html\"><i class=\"fa fa-home\"></i>Trang chủ</a></li>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"background-section\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <h1 style=\"color: white\">FPT EDUCATION</h1>\n");
      out.write("                <br><h2 style=\"color: white;\">COURSE MANAGEMENT SYSTEM</h2>\n");
      out.write("                <input type=\"submit\" name=\"learn-more\" value=\"LEARN MORE\" style=\"background-color: #FD647A; width: 80px; height: 40px\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"image-overlay\"></div>\n");
      out.write("        </div>\n");
      out.write("        <footer class=\"site-footer\">\n");
      out.write("            <div class=\"footer-content\">\n");
      out.write("                <a>Bạn chưa đăng nhập(<a href=\"login.jsp\" style=\"color: white\">ĐĂNG NHẬP</a>)</a>\n");
      out.write("            </div>       \n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("    <style>\n");
      out.write("        #menu__toggle {\n");
      out.write("            opacity: 0;\n");
      out.write("        }\n");
      out.write("        #menu__toggle:checked + .menu__btn > span {\n");
      out.write("            transform: rotate(45deg);\n");
      out.write("        }\n");
      out.write("        #menu__toggle:checked + .menu__btn > span::before {\n");
      out.write("            top: 0;\n");
      out.write("            transform: rotate(0deg);\n");
      out.write("        }\n");
      out.write("        #menu__toggle:checked + .menu__btn > span::after {\n");
      out.write("            top: 0;\n");
      out.write("            transform: rotate(90deg);\n");
      out.write("        }\n");
      out.write("        #menu__toggle:checked ~ .menu__box {\n");
      out.write("            left: 0 !important;\n");
      out.write("        }\n");
      out.write("        .menu__btn {\n");
      out.write("            position: fixed;\n");
      out.write("            top: 20px;\n");
      out.write("            left: 20px;\n");
      out.write("            width: 26px;\n");
      out.write("            height: 26px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            z-index: 1;\n");
      out.write("        }\n");
      out.write("        .menu__btn > span,\n");
      out.write("        .menu__btn > span::before,\n");
      out.write("        .menu__btn > span::after {\n");
      out.write("            display: block;\n");
      out.write("            position: absolute;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 2px;\n");
      out.write("            background-color: #616161;\n");
      out.write("            transition-duration: .25s;\n");
      out.write("        }\n");
      out.write("        .menu__btn > span::before {\n");
      out.write("            content: '';\n");
      out.write("            top: -8px;\n");
      out.write("        }\n");
      out.write("        .menu__btn > span::after {\n");
      out.write("            content: '';\n");
      out.write("            top: 8px;\n");
      out.write("        }\n");
      out.write("        .menu__box {\n");
      out.write("            display: block;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: -100%;\n");
      out.write("            width: 300px;\n");
      out.write("            height: 100%;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 80px 0;\n");
      out.write("            list-style: none;\n");
      out.write("            background-color: #ECEFF1;\n");
      out.write("            box-shadow: 2px 2px 6px rgba(0, 0, 0, .4);\n");
      out.write("            transition-duration: .25s;\n");
      out.write("        }\n");
      out.write("        .menu__item {\n");
      out.write("            display: block;\n");
      out.write("            padding: 12px 24px;\n");
      out.write("            color: #333;\n");
      out.write("            font-family: 'Roboto', sans-serif;\n");
      out.write("            font-size: 20px;\n");
      out.write("            font-weight: 600;\n");
      out.write("            text-decoration: none;\n");
      out.write("            transition-duration: .25s;\n");
      out.write("        }\n");
      out.write("        .menu__item:hover {\n");
      out.write("            background-color: #CFD8DC;\n");
      out.write("        }\n");
      out.write("        img {\n");
      out.write("            width: 90px;\n");
      out.write("            margin-left: 35px;\n");
      out.write("        }\n");
      out.write("        .login-title {\n");
      out.write("            margin-left: 850px;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .hamburger-menu{\n");
      out.write("            position: fixed;\n");
      out.write("            background-color: transparent;\n");
      out.write("        }\n");
      out.write("        .background-section {\n");
      out.write("            position: fixed;\n");
      out.write("            top: 50px; /* Đặt top thành chiều cao của menu */\n");
      out.write("            left: 0;\n");
      out.write("            width: 100%;\n");
      out.write("            height: calc(100% - 50px); /* Điều chỉnh chiều cao của phần tử này để lấp đầy phần còn lại của trang */\n");
      out.write("            background-image: url(\"https://cmshn.fpt.edu.vn/pluginfile.php/1/theme_trema/frontpagebanner/1684246329/sanhAlpha.jpg\");\n");
      out.write("            background-size: cover;\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-position: center center;\n");
      out.write("            z-index: -1;\n");
      out.write("        }\n");
      out.write("        .content {\n");
      out.write("            margin: 200px;\n");
      out.write("            margin-left: 589px;\n");
      out.write("        }\n");
      out.write("        .site-footer {\n");
      out.write("            color: white;\n");
      out.write("            position: fixed;\n");
      out.write("            bottom: 0;\n");
      out.write("            left: 0;\n");
      out.write("            width: 100%;\n");
      out.write("            background-color: #333;\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            z-index: 1; /* Lớp vượt qua ảnh nền */\n");
      out.write("        }\n");
      out.write("        .footer-content {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center; /* Căn giữa theo chiều ngang */\n");
      out.write("            align-items: center; /* Căn giữa theo chiều dọc */\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
