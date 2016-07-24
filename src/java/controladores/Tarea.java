/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
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
    private Integer id_proyecto;

    public Tarea(String titulo, String estado) {
        this.titulo = titulo;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEstado() {
        return estado;
    }
    
    public void guardarTarea(Tarea tarea, Integer id_proyecto) {
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos la sentencia sql
        String sql = "insert into tarea (titulo, estado, id_proyecto) values ('"+tarea.titulo+"','"+tarea.estado+"','"+id_proyecto+"')";
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
    
}
