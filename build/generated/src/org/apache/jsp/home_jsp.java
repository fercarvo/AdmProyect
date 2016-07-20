package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("    <title>Administrador de Proyectos</title>\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"stylesheets/styles.css\">\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-static-top\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <a class=\"navbar-brand\" href=\"#\">AdmProyectos</a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"navbar\" class=\"collapse navbar-collapse\">\n");
      out.write("          <ul class=\"nav navbar-nav\">\n");
      out.write("            <li class=\"active\"><a href=\"#\">Usuarios</a></li>\n");
      out.write("            <li><a href=\"#\">Proyectos</a></li>\n");
      out.write("            <li><a href=\"#\">Dashboard</a></li>\n");
      out.write("          </ul>\n");
      out.write("          <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("            <li><a href=\"#about\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span></a></li>\n");
      out.write("            <li><a href=\"#\">Logout</a></li>\n");
      out.write("          </ul>\n");
      out.write("        </div><!--/.nav-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("    <div class=\"container usuarios\">\n");
      out.write("      <h2>Registro de Usuarios</h2>\n");
      out.write("      <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#modalUsuarios\">Agregar Usuario</button>\n");
      out.write("      <table id=\"tablaUsuarios\" class=\"table table-bordered table-striped\">\n");
      out.write("        <thead>\n");
      out.write("          <tr>\n");
      out.write("            <th>#</th>\n");
      out.write("            <th>Nombre</th>\n");
      out.write("            <th>Email</th>\n");
      out.write("            <th>Rol</th>\n");
      out.write("            <th>Editar</th>\n");
      out.write("            <th>Eliminar</th>\n");
      out.write("          </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("          <tr>\n");
      out.write("            <th scope=\"row\">1</th>\n");
      out.write("            <td>Juan Perez</td>\n");
      out.write("            <td>jperez@example.com</td>\n");
      out.write("            <td>Desarrollador</td>\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <th scope=\"row\">2</th>\n");
      out.write("            <td>Rodrigo Castro</td>\n");
      out.write("            <td>rcastro@example.com</td>\n");
      out.write("            <td>Diseñador</td>\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <th scope=\"row\">3</th>\n");
      out.write("            <td>Jose Sanchez</td>\n");
      out.write("            <td>jsanchez@example.com</td>\n");
      out.write("            <td>Administrador</td>\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\n");
      out.write("          </tr>\n");
      out.write("        </tbody>\n");
      out.write("      </table>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Modal -->\n");
      out.write("    <div class=\"modal fade\" id=\"modalUsuarios\" tabindex=\"-1\" role=\"dialog\">\n");
      out.write("      <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("          <form>\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("              <h4 class=\"modal-title\">Ingresar Usuario</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"inputNombre\" name=\"inputNombre\" placeholder=\"Nombre\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                  <input type=\"email\" class=\"form-control\" id=\"inputApellido\" name=\"inputEmail\" placeholder=\"Email\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                  <select class=\"form-control\" id=\"selectRol\" name=\"selectRol\">\n");
      out.write("                    <option value=\"1\">Desarrollador</option>\n");
      out.write("                    <option value=\"2\">Diseñador</option>\n");
      out.write("                    <option value=\"3\">Administrador</option>\n");
      out.write("                  </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("              <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("              <button type=\"submit\" class=\"btn btn-primary\">Ingresar</button>\n");
      out.write("            </div>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function() {\n");
      out.write("            $('#tablaUsuarios').DataTable({\n");
      out.write("                \"language\": {\n");
      out.write("                    url: 'i18n/dt-spanish.json'\n");
      out.write("                },\n");
      out.write("                \"aoColumnDefs\": [\n");
      out.write("                    { 'bSortable': false, 'aTargets': [ 4, 5 ] }\n");
      out.write("                 ]\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("  </body>\n");
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
