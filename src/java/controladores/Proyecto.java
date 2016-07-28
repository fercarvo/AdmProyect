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

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }
    
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
    public Integer cantProy(){
        Integer cantidad = 0;
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
            cantidad = rs.getInt(1);
            con.close();
            rs.close();
            st.close();
            
            return cantidad;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cantidad; 
    }
    public void update (String id_proyecto, String nombre, String descripcion, String id_user){
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        String sql = "UPDATE proyecto SET nombre ='"+nombre+"', descripcion='"+descripcion+"', id_usuario='"+id_user+"' WHERE id_proyecto='"+id_proyecto+"'";
        try{
            st = con.createStatement();
            st.executeUpdate(sql);
            
            con.close();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    /*public Proyecto[] getProyectos() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //creamos la sentencia sql para saber cuantos registros existen
        String sql = "select id_proyecto from proyecto";
        
        //Ejecutamos la sentencia sql
        try {
            Integer cantidad=cantProy();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Proyecto [] proyectos = new Proyecto[cantidad];
            Integer i=0;
            while (rs.next()){
                Integer id = rs.getInt("id_proyecto");
                 proyectos[i] = new Proyecto().getProyecto(id);
                 i++;
            }
            con.close();
            rs.close();
            st.close();
            
            return proyectos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }*/
    public  String eliminar (String id){
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        Conexion conexion1 = new Conexion();
        Connection con1 = conexion1.getConnection();
        Statement st1;
        ResultSet rs1;
        String exito;
        String sql = "delete from tarea where id_proyecto = '"+id+"'";
        String sql1 = "delete from proyecto where id_proyecto= '"+id+"'";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            
            st1 = con1.createStatement();
            st1.executeUpdate(sql1);
            
            //Obtenemos los datos del usuario
            exito="bien";
            con.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            exito="mal";
            
        }
        return exito;
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
             proyecto.id_usuario = rs.getInt("id_usuario");
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
         String sql = "select id_proyecto from proyecto";
         //Ejecutamos la sentencia sql
         try {
             
             st = con.createStatement();
             rs = st.executeQuery(sql);
             while (rs.next()){
                Integer id = rs.getInt("id_proyecto");
                proyecto = getProyecto(id);
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
