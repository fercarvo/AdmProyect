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
 * @author stalyn
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/DashboardServlet"})
public class DashboardServlet extends HttpServlet {

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
        
        System.out.println("hola1");
        String parametro = request.getParameter("id_proyecto");
        System.out.println(parametro);
        Integer id_proyecto = Integer.parseInt(parametro);
        
        response.setContentType("application/json");
        
        Gson gson = new Gson();
        Tarea[] tareas = new Tarea().getTareasPorProyecto(id_proyecto);
        
        /*hola mundo*/
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(tareas));  
        out.flush();
        
        
        String action = request.getParameter("action");
        if (action.equals("guardar")){ 
            Tarea tarea = new Tarea();
            String titulo = request.getParameter("titulo");
            String estado=request.getParameter("estado");
             
            tarea.guardarTarea(titulo,estado,id_proyecto);
            
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
        System.out.println("hola2");
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
        System.out.println("hola3");
        response.setContentType( "text/html; charset=iso-8859-1");
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id_proyecto");
        Integer id_proyecto = Integer.parseInt(id);
        
        Tarea[] tareas = new Tarea().getTareasPorProyecto(id_proyecto);
        out.print(gson.toJson(tareas)); 
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
