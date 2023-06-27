package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>CMS - Course Management System</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"https://cmshn.fpt.edu.vn/theme/image.php/trema/theme/1684246329/favicon\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                background-image: url('https://cmshn.fpt.edu.vn/pluginfile.php/1/theme_trema/loginbackgroundimage/1684246329/sanhAlpha2.jpg');\n");
      out.write("                background-size: cover;\n");
      out.write("                background-position: center;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .center {\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .content {\n");
      out.write("                text-align: center;\n");
      out.write("                align-self: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .frame {\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("                align-items: center;\n");
      out.write("                padding: 20px;\n");
      out.write("                border: 1px solid gray;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                background-color: white;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                align-self: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"center\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <h1 style=\"font-weight: bold; color: #FF0000\">CMS - Course Management System</h1>\n");
      out.write("                <h2 style=\"font-size: 10px\">Đăng nhập bằng tài khoản của bạn trên:</h2>\n");
      out.write("            </div>\n");
      out.write("            <!-- Các phần tử khác trong body -->\n");
      out.write("            <div class=\"frame\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.error == 'invalid_email'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <p style=\"color: red;\">Vui lòng sử dụng email @fpt.edu.vn để đăng nhập!</p>\n");
      out.write("                </c:if>\n");
      out.write("                <a href=\"https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:9999/cms-student-side/LoginGoogleHandler&response_type=code&client_id=583884386426-mlf21d5nb8jt74s56bn737i5lsp6jk2p.apps.googleusercontent.com\" style=\"color: black\">\n");
      out.write("                    <image src=\"https://th.bing.com/th/id/R.21aa10651ccc4d8a2dca610304c5e4d7?rik=Kyg41BisxMt1Yg&pid=ImgRaw&r=0\" style=\"width: 15px\">\n");
      out.write("                    FPT.EDU.VN\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
