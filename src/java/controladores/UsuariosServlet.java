/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author estudiante.2016
 */

public class UsuariosServlet {
    public String tablaUsuarios() throws SQLException {
        String codTabla = "";
        Usuario usuario = new Usuario();
        Usuario iterador = new Usuario();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        String sql = "select id from usuario";
        st = con.createStatement();
        rs = st.executeQuery(sql);
       while (rs.next()){
           Integer i = rs.getInt("id");
            usuario = iterador.getUsuario(i);
            codTabla = codTabla + "<tr >\n";
            codTabla = codTabla + "<th class = 'userId' scope=\"row\">" + usuario.getId() + "</th>\n";
            codTabla = codTabla + "<td>" + usuario.getNombre() + "</td>\n";
            codTabla = codTabla + "<td>" + usuario.getEmail() + "</td>\n";
            codTabla = codTabla + "<td>" + usuario.getRol() + "</td>\n";
            codTabla = codTabla + "<td class= 'editarUsuario' data-toggle=\"modal\" data-target=\"#modalUsuariosUpdate\"><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></a></td>\n";
            codTabla = codTabla + "<td class= 'eliminarUsuario'><a href=\"#\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a></td>\n";
            codTabla = codTabla + "</tr>\n";
       } 
       con.close();
        rs.close();
        st.close();
        return codTabla;
    }
}
