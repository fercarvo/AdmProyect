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

public class listaDeProyectos {
    public String tablaProyectos() throws SQLException {
        String codTabla = "";
        Proyecto proyecto = new Proyecto();
        Usuario usuario = new Usuario();
        Usuario iteradorUser = new Usuario();
        Proyecto iterador = new Proyecto();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //creamos la sentencia sql para saber cuantos registros existen
        String sql = "select id_proyecto from proyecto";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()){
                Integer id = rs.getInt("id_proyecto");
                proyecto = iterador.getProyecto(id);
                usuario=iteradorUser.getUsuario(proyecto.getId_usuario());
                codTabla = codTabla + "<tr >\n";
                codTabla = codTabla + "<th class = 'userId' scope=\"row\">" + proyecto.getId() + "</th>\n";
                codTabla = codTabla + "<td>" + proyecto.getNombre() + "</td>\n";
                codTabla = codTabla + "<td>" + proyecto.getDescripcion() + "</td>\n";
                codTabla = codTabla + "<td>" +usuario.getNombre()  + "</td>\n";
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
