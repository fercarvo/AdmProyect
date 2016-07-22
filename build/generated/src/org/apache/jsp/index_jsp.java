package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    <title>Administrador de Proyectos</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"stylesheets/styles.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("      <div id=\"errorLogin\" class=\"alert alert-danger collapse\" role=\"alert\"></div>\r\n");
      out.write("\t<div class=\"container login-form\">\r\n");
      out.write("\t\t<h2 class=\"login-title\">- Ingreso al Sistema -</h2>\r\n");
      out.write("\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t<form id=\"loginForm\">\r\n");
      out.write("\t\t\t\t\t<div class=\"input-group login-userinput\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"usuario\" type=\"text\" class=\"form-control\" placeholder=\"Usuario\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-lock\"></span></span>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"password\" type=\"password\" class=\"form-control\" placeholder=\"Contraseña\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"showPassword\" class=\"input-group-btn\">\r\n");
      out.write("\t            \t\t\t<button class=\"btn btn-default reveal\" type=\"button\"><i class=\"glyphicon glyphicon-eye-open\"></i></button>\r\n");
      out.write("\t          \t\t\t</span>  \r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-primary btn-block login-button\" type=\"submit\"><i class=\"fa fa-sign-in\"></i> Login</button>\r\n");
      out.write("\t\t\t\t\t<div class=\"checkbox login-options\">\r\n");
      out.write("\t\t\t\t\t\t<label><input type=\"checkbox\"/> Recordarme</label>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"login-forgot\">Olvido su contraseña?</a>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t\t</form>\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"javascripts/script.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).ready(function(){\r\n");
      out.write("           $(\"#loginForm\").submit(function(e){\r\n");
      out.write("               e.preventDefault();\r\n");
      out.write("               \r\n");
      out.write("               var url = \"LoginServlets\";\r\n");
      out.write("               \r\n");
      out.write("               $.ajax({\r\n");
      out.write("                   type: \"POST\",\r\n");
      out.write("                   url: url,\r\n");
      out.write("                   data: $(\"#loginForm\").serialize(),\r\n");
      out.write("                   success: function(data) {\r\n");
      out.write("                       console.log(data);\r\n");
      out.write("                       if (data.error){\r\n");
      out.write("                           $(\"#errorLogin\").show();\r\n");
      out.write("                           $(\"#errorLogin\").text(data.errormsg);\r\n");
      out.write("                       }else {\r\n");
      out.write("                           window.location = data.url;\r\n");
      out.write("                       }\r\n");
      out.write("                   }\r\n");
      out.write("               });\r\n");
      out.write("           }); \r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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
