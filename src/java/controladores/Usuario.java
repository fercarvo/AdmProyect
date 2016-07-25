/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author estudiante.2016
 */
public class Usuario {
    
    private Integer id;
    private String nombre;
    private String email;
    private String rol;
    
    public static void guardar(String nombre, String email, String rol) {
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos la sentencia sql
        String sql = "insert into usuario (nombre, email, rol) values ('"+nombre+"','"+email+"','"+rol+"')";
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
    
    
    public Usuario getUsuario(Integer id) {
        Usuario usuario = new Usuario();
        //Cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //Creamos la sentencia sql
        String sql = "Select * from usuario where id = '"+id+"'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            //Obtenemos los datos del usuario
            rs.next();
            usuario.id = rs.getInt("id");
            usuario.nombre = rs.getString("nombre");
            usuario.email = rs.getString("email");
            usuario.rol = rs.getString("rol");
            //Cerramos las conexiones
            con.close();
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    
    public Integer getSizeUsuarios() {
        Integer cantReg = 0;
        //cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //creamos la sentencia sql para saber cuantos registros existen
        String sql = "select count(*) from usuario";
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

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }
    public Usuario [] getUsuarios() {
        //cargamos la conexión
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        //creamos la sentencia sql para saber cuantos registros existen
        String sql = "select count(*) from usuario";
        //Ejecutamos la sentencia sql
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            //Obtenemos el resultado
            rs.next();
            Integer cantReg = rs.getInt(1);
            
            Usuario [] usuarios = new Usuario[cantReg];
            //Obtenemos todos los registros
            for (int iterador = 0; iterador < cantReg; iterador++) {
                usuarios[iterador] = new Usuario().getUsuario(iterador+1);
            }
            
            con.close();
            rs.close();
            st.close();
            
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
        
    }

}
