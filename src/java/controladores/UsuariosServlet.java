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
        String codTabla = "";
        Usuario usuario = new Usuario();
        Usuario iterador = new Usuario();
        for(int i = 1 ; i <= iterador.getSizeUsuarios(); i++ ) {
            usuario = iterador.getUsuario(i);
            codTabla = codTabla + "<tr>\n";
            codTabla = codTabla + "<th scope=\"row\">" + usuario.getId() + "</th>\n";
            codTabla = codTabla + "<td>" + usuario.getNombre() + "</td>\n";
            codTabla = codTabla + "<td>" + usuario.getEmail() + "</td>\n";
            codTabla = codTabla + "<td>" + usuario.getRol() + "</td>\n";
            codTabla = codTabla + "<td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\n";
            codTabla = codTabla + "<td><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\n";
            codTabla = codTabla + "</tr>\n";
        }
        return codTabla;
    }
}
