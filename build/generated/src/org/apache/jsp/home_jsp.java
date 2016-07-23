package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controladores.UsuariosServlet;

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

      out.write("\r\n");
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
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"stylesheets/styles.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-static-top\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("          <a class=\"navbar-brand\" href=\"#\">AdmProyectos</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"navbar\" class=\"collapse navbar-collapse\">\r\n");
      out.write("          <ul class=\"nav navbar-nav\">\r\n");
      out.write("            <li class=\"active\"><a href=\"#\">Usuarios</a></li>\r\n");
      out.write("            <li><a href=\"#\">Proyectos</a></li>\r\n");
      out.write("            <li><a href=\"#\">Dashboard</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("          <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("            <li><a href=\"#about\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span></a></li>\r\n");
      out.write("            <li><a href=\"#\">Logout</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div><!--/.nav-collapse -->\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <div class=\"container usuarios\">\r\n");
      out.write("      <h2>Registro de Usuarios</h2>\r\n");
      out.write("      <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#modalUsuarios\">Agregar Usuario</button>\r\n");
      out.write("      <table id=\"tablaUsuarios\" class=\"table table-bordered table-striped\">\r\n");
      out.write("        <thead>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <th>#</th>\r\n");
      out.write("            <th>Nombre</th>\r\n");
      out.write("            <th>Email</th>\r\n");
      out.write("            <th>Rol</th>\r\n");
      out.write("            <th>Editar</th>\r\n");
      out.write("            <th>Eliminar</th>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody id = \"tabla\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <th scope=\"row\">1</th>\r\n");
      out.write("            <td>Juan Perez</td>\r\n");
      out.write("            <td>jperez@example.com</td>\r\n");
      out.write("            <td>Desarrollador</td>\r\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\r\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <th scope=\"row\">2</th>\r\n");
      out.write("            <td>Rodrigo Castro</td>\r\n");
      out.write("            <td>rcastro@example.com</td>\r\n");
      out.write("            <td>Diseñador</td>\r\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\r\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("              <th scope=\"row\">3</th>\r\n");
      out.write("            <td>Jose Sanchez</td>\r\n");
      out.write("            <td>jsanchez@example.com</td>\r\n");
      out.write("            <td>Administrador</td>\r\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\r\n");
      out.write("            <td><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");
      out.print( new UsuariosServlet().tablaUsuarios() );
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("      </table>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Modal -->\r\n");
      out.write("    <div class=\"modal fade\" id=\"modalUsuarios\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("      <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("          <form>\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("              <h4 class=\"modal-title\">Ingresar Usuario</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" id=\"inputNombre\" name=\"inputNombre\" placeholder=\"Nombre\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                  <input type=\"email\" class=\"form-control\" id=\"inputApellido\" name=\"inputEmail\" placeholder=\"Email\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                  <select class=\"form-control\" id=\"selectRol\" name=\"selectRol\">\r\n");
      out.write("                    <option value=\"1\">Desarrollador</option>\r\n");
      out.write("                    <option value=\"2\">Diseñador</option>\r\n");
      out.write("                    <option value=\"3\">Administrador</option>\r\n");
      out.write("                  </select>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("              <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>\r\n");
      out.write("              <button type=\"submit\" class=\"btn btn-primary\">Ingresar</button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).ready(function() {\r\n");
      out.write("            $('#tablaUsuarios').DataTable({\r\n");
      out.write("                \"language\": {\r\n");
      out.write("                    url: 'i18n/dt-spanish.json'\r\n");
      out.write("                },\r\n");
      out.write("                \"aoColumnDefs\": [\r\n");
      out.write("                    { 'bSortable': false, 'aTargets': [ 4, 5 ] }\r\n");
      out.write("                 ]\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
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
