/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author estudiante.2016
 */

public class UsuariosServlet {
    public String tablaUsuarios() {
        Usuario u = new Usuario();
        Usuario [] usuarios = u.getUsuarios(); 
        String codTabla = "";
        for (Usuario usuario : usuarios) {
            codTabla = codTabla + "<tr >\n";
            codTabla = codTabla + "<th class = 'userId' scope=\"row\">" + usuario.getId() + "</th>\n";
            codTabla = codTabla + "<td class = 'nombre'>" + usuario.getNombre() + "</td>\n";
            codTabla = codTabla + "<td class = 'email'>" + usuario.getEmail() + "</td>\n";
            codTabla = codTabla + "<td class = 'rol'>" + usuario.getRol() + "</td>\n";
            codTabla = codTabla + "<td class= 'editarUsuario' data-toggle=\"modal\" data-target=\"#modalUsuariosUpdate\"><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\n";
            codTabla = codTabla + "<td class= 'eliminarUsuario'><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\n";
            codTabla = codTabla + "</tr>\n";
        } 
        return codTabla;
    }
}
