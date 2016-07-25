/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author stalyn
 */
public class Proyecto {
    
    private Integer id;
    private String nombre;
    private String descripcion;
    
    
    
    public Proyecto getProyecto(Integer id) {
        Proyecto proyecto = new Proyecto();
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //Creamos la sentencia sql
        String sql = "Select * from proyecto where id_proyecto = '"+id+"'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            //Obtenemos los datos del usuario
            rs.next();
            proyecto.id = rs.getInt("id_proyecto");
            proyecto.nombre = rs.getString("nombre");
            proyecto.descripcion = rs.getString("descripcion");
            //Cerramos las conexiones
            con.close();
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proyecto;
    }
    
    
    
    public String enlistarProyectos(){
        String codigo = "";
        Proyecto proyecto;
        //cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //creamos la sentencia sql para saber cuantos registros existen
        String sql = "select count(*) from proyecto";
        //Ejecutamos la sentencia sql
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            //Obtenemos el resultado
            rs.next();
            for(int i = 1; i <= rs.getInt(1); i++) {
                proyecto = getProyecto(i);
                codigo = codigo + "<option value=\""+ proyecto.id + "\">"+ proyecto.nombre +"</option>\n";
            }
            con.close();
            rs.close();
            st.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return codigo;
    }
    
}
