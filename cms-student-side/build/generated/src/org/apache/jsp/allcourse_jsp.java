package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Model.Course;

public final class allcourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\n");
     
    ArrayList<Course> allCourses = new ArrayList<>();
    if (request.getAttribute("allCourses") != null)
        allCourses = (ArrayList<Course>) request.getAttribute("allCourses");

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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <div id=\"menu-bar\" onclick=\"menuOnClick()\">\n");
      out.write("                    <div id=\"bar1\" class=\"bar\"></div>\n");
      out.write("                    <div id=\"bar2\" class=\"bar\"></div>\n");
      out.write("                    <div id=\"bar3\" class=\"bar\"></div>\n");
      out.write("                </div>\n");
      out.write("                <nav class=\"nav\" id=\"nav\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"LoginGoogleHandler\">Home</a></li>\n");
      out.write("                        <li><a href=\"#\">About</a></li>\n");
      out.write("                        <li><a href=\"#\">Contact</a></li>\n");
      out.write("                        <li><a href=\"#\">Blog</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav> \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"menu-bg\" id=\"menu-bg\"></div>\n");
      out.write("            <img src=\"https://cmshn.fpt.edu.vn/pluginfile.php/1/core_admin/logocompact/0x70/1684246329/2020-FPTU-Eng.png\" alt=\"logo\" style=\"width: 100px; height: 27px; margin-left: 70px; margin-top: 15px\">\n");
      out.write("            <form action=\"searchkeyword\" method=\"get\">\n");
      out.write("                <input type=\"text\" id=\"keywordInput\" name=\"keyword\" placeholder=\"Nhập từ khóa\" style=\"height: 20px; margin-left: 10px; margin-top: 15px\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"body-content\">\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Roboto', sans-serif;\n");
      out.write("            background-color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #menu {\n");
      out.write("            z-index: 2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #menu-bar {\n");
      out.write("            width: 45px;\n");
      out.write("            height: 40px;\n");
      out.write("            margin: 30px 0 20px 20px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .bar {\n");
      out.write("            height: 5px;\n");
      out.write("            width: 100%;\n");
      out.write("            background-color: black;\n");
      out.write("            display: block;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            transition: 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #bar1 {\n");
      out.write("            transform: translateY(-4px);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #bar3 {\n");
      out.write("            transform: translateY(4px);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav {\n");
      out.write("            transition: 0.3s ease;\n");
      out.write("            display: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav ul {\n");
      out.write("            padding: 0 22px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav li {\n");
      out.write("            list-style: none;\n");
      out.write("            padding: 12px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav li a {\n");
      out.write("            color: white;\n");
      out.write("            font-size: 20px;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav li a:hover {\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .menu-bg, #menu {\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            position: absolute;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .menu-bg {\n");
      out.write("            z-index: 1;\n");
      out.write("            width: 0;\n");
      out.write("            height: 0;\n");
      out.write("            margin: 30px 0 20px 20px;\n");
      out.write("            background: radial-gradient(circle, #DC052D, #DC052D);\n");
      out.write("            border-radius: 50%;\n");
      out.write("            transition: 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .change {\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .change .bar {\n");
      out.write("            background-color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .change #bar1 {\n");
      out.write("            transform: translateY(4px) rotateZ(-45deg);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .change #bar2 {\n");
      out.write("            opacity: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .change #bar3 {\n");
      out.write("            transform: translateY(-6px) rotateZ(45deg);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .change-bg {\n");
      out.write("            width: 520px;\n");
      out.write("            height: 460px;\n");
      out.write("            transform: translate(-60%,-30%);\n");
      out.write("        }\n");
      out.write("        body {\n");
      out.write("            font-family: 'Roboto', sans-serif;\n");
      out.write("            background-color: white;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header {\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            background-color: white;\n");
      out.write("            height: 60px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .body-content {\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            justify-content: flex-start;\n");
      out.write("            align-items: flex-start;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .subject {\n");
      out.write("            width: 200px;\n");
      out.write("            height: auto;\n");
      out.write("            border: 1px solid black;\n");
      out.write("            margin: 10px;\n");
      out.write("            padding: 10px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("    function menuOnClick() {\n");
      out.write("        document.getElementById(\"menu-bar\").classList.toggle(\"change\");\n");
      out.write("        document.getElementById(\"nav\").classList.toggle(\"change\");\n");
      out.write("        document.getElementById(\"menu-bg\").classList.toggle(\"change-bg\");\n");
      out.write("    }\n");
      out.write("    function onKeywordInputKeyDown(event) {\n");
      out.write("        if (event.keyCode === 13) { // Enter key\n");
      out.write("            var keyword = document.getElementById(\"keywordInput\").value;\n");
      out.write("            window.location.href = \"searchkeyword?keyword=\" + encodeURIComponent(keyword);\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    document.getElementById(\"keywordInput\").addEventListener(\"keydown\", onKeywordInputKeyDown);\n");
      out.write("</script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allCourses}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("course");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <div class=\"subject\"\">\n");
          out.write("                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.picture}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"width: 100%; height: 100%\">\n");
          out.write("                    <a href=\"course?picture=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.picture}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&courseName=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.courseName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&semester=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.semester}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&teacher=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.teacherName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Course Name: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.courseName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                    <p>Semester: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.semester}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                    <p>Teacher: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${course.teacherName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                </div>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
