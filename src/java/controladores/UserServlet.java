/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

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
        Usuario u = new Usuario();        
        switch (request.getParameter("flag")) {
            case "save":{
                String nombre = request.getParameter("inputNombre");
                String rol = request.getParameter("selectRol");
                String email = request.getParameter("inputEmail");
                u.guardar(nombre,email,rol);
                    break;
                }
            case "update":{
                response.setContentType("application/json");
                String action = request.getParameter("action");
                Gson gson = new Gson();
                String id = request.getParameter("Id");
                Integer  id_usuario=Integer.valueOf(id);
                PrintWriter out = response.getWriter();
                out.print(gson.toJson(u.getUsuario(id_usuario)));
                out.flush();
                if (action.equals("actualizar")){
                    String nombre = request.getParameter("inputNombre");
                    String rol = request.getParameter("selectRol");
                    String email = request.getParameter("inputEmail");
                    
                    u.update(id, nombre, email, rol);
                }       break;
                }
            case "delete":{
                String exito;
                response.setContentType("application/json");
                Gson gson = new Gson();
                JsonObject object = new JsonObject();
                exito=u.eliminar(request.getParameter("Id"));
                if(exito=="bien"){
                    object.addProperty("error", Boolean.FALSE);
                }
                else{
                    object.addProperty("error", Boolean.TRUE);
                    object.addProperty("errormsg", "No se puede eliminar este usuario por que tiene proyectos asociados");
                }       PrintWriter out = response.getWriter();
                out.print(gson.toJson(object));
                out.flush();
                    break;
                }
            default:
                break;
        }
            
        
        
        
<<<<<<< HEAD:src/java/controladores/UpdateUsuario.java
        out.print(gson.toJson(u.getUsuario(id_usuario)));  
        out.flush();
       
        if (action.equals("actualizar")){ 
        String nombre = request.getParameter("inputNombre");
        String rol = request.getParameter("selectRol");
        String email = request.getParameter("inputEmail");
       
        u.update(id, nombre, email, rol);
        }
=======
>>>>>>> servletUsuario:src/java/controladores/UserServlet.java
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
