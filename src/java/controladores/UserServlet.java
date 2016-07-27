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
        Exception e;
        System.out.println(request.getParameter("flag")+"siiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        switch (request.getParameter("flag")) {
            case "save":{
                String nombre = request.getParameter("inputNombre");
                String rol = request.getParameter("selectRol");
                String email = request.getParameter("inputEmail");
                Usuario usuario = new Usuario(nombre, email, rol);
                break;
                }
            case "update":{
                response.setContentType("application/json");
                Gson gson = new Gson();
                JsonObject object = new JsonObject();
                
                String id = request.getParameter("Id");
                String nombre = request.getParameter("inputNombre");
                String rol = request.getParameter("selectRol");
                String email = request.getParameter("inputEmail");
                
                e = u.update(id, nombre, email, rol);
                if(e==null){
                    object.addProperty("error", Boolean.FALSE);
                }
                else{
                    object.addProperty("error", Boolean.TRUE);
                    object.addProperty("errormsg", "No se actualizo: "+e.getMessage());
                }
                PrintWriter out = response.getWriter();
                out.print(gson.toJson(object));
                out.flush();
                break;
            }

            case "delete":{
                
                response.setContentType("application/json");
                Gson gson = new Gson();
                JsonObject object = new JsonObject();
                e=u.eliminar(request.getParameter("Id"));
                if(e==null){
                    object.addProperty("error", Boolean.FALSE);
                }
                else{
                    object.addProperty("error", Boolean.TRUE);
                    object.addProperty("errormsg", "No se puede eliminar por que tiene un proyecto asociado");
                }       
                PrintWriter out = response.getWriter();
                out.print(gson.toJson(object));
                out.flush();
                break;
                }
            default:
            break;
        }
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
