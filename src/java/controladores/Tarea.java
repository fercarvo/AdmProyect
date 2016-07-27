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
 * @author stalyn
 */
public class Tarea {
    private Integer id;
    private String titulo;
    private String estado;
    
    public void guardarTarea(String titulo, String estado, Integer id_proyecto) {
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos la sentencia sql
        String sql = "insert into tarea (titulo, estado, id_proyecto) values ('"+titulo+"','"+estado+"','"+id_proyecto+"')";
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
    
        public Integer getSizeTarea(Integer id_Proyecto) {
        Integer cantReg = 0;
        //cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //creamos la sentencia sql para saber cuantos registros existen
        String sql = "select count(*) from tarea where id_proyecto="+ id_Proyecto;
        //Ejecutamos la sentencia sql
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            //Obtenemos el resultado
            rs.next();
            cantReg = rs.getInt(1);
            con.close();
            rs.close();
            st.close();
            
            return cantReg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cantReg;
        
    }
        
    public Tarea getTarea(Integer id_tarea) {
        Tarea tarea = new Tarea();
         //Cargamos la conexión
         Conexion conexion = new Conexion();
         Connection con = conexion.getConnection();
         Statement st;
         ResultSet rs;
         //Creamos la sentencia sql
         String sql = "Select * from tarea where id_tarea = '"+id_tarea+"'";
         try {
             st = con.createStatement();
             rs = st.executeQuery(sql);
             //Obtenemos los datos del usuario
             rs.next();
             tarea.id = rs.getInt("id_tarea");
             tarea.titulo = rs.getString("titulo");
             tarea.estado = rs.getString("estado");
             //Cerramos las conexiones
             con.close();
             rs.close();
             st.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
         return tarea;
    }
    
    public Tarea [] getTareasPorProyecto(Integer id_proyecto) {
        Integer cantTareas = getSizeTarea(id_proyecto);
        Tarea [] tareas = new Tarea[cantTareas];
        Tarea tarea;
        int iterador = 0;
        
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //Creamos la sentencia sql
        String sql = "Select * from tarea where id_proyecto = '"+id_proyecto+"'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            //Obtenemos los datos del usuario
            while(rs.next()){
                tarea = getTarea(rs.getInt("id_tarea"));
                tareas[iterador] = tarea;
                iterador++;
            }
            //Cerramos las conexiones
            con.close();
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tareas;
    }
    
    public void modificarEstadoTarea(Integer id_tarea, String estado) {
        
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos la sentencia sql
        String sql = "UPDATE tarea set estado='"+estado+"' where id_tarea='"+id_tarea+"'";
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

    public String getTitulo() {
        return titulo;
    }
    
}
