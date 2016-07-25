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
 * @author Usuario
 */
public class Proyecto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer id_usuario;
    
    public static void guardar(String nombre, String descripcion,Integer id_usuario) {
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos la sentencia sql
        String sql = "insert into proyecto (nombre,descripcion,id_usuario) values ('"+nombre+"','"+descripcion+"','"+id_usuario+"')";
        
        //Ejecutamos la sentencia sql
        try{
            st = con.createStatement();
            st.executeUpdate(sql);
            //Cerramos las conexiones
            con.close();
            st.close();
            System.out.println("insertado con éxito!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
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
