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

    public Usuario() {
    }

    public Usuario(String nombre, String email, String rol) {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        String sql = "insert into usuario (nombre, email, rol) values ('"+nombre+"','"+email+"','"+rol+"')";
        try{
            st = con.createStatement();
            st.executeUpdate(sql);
            this.nombre = nombre;
            this.email = email;
            this.rol = rol;
            con.close();
            st.close();
            System.out.println("insertado con éxito!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    public Exception eliminar (String id){
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        String sql = "delete from usuario where id = '"+id+"'";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            con.close();
            st.close();
        } catch (Exception e) {
            return e;
        }
        return null;
    }
    
    public Exception update (String id, String nombre, String email, String rol){
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        String sql = "UPDATE usuario SET nombre ='"+nombre+"', email='"+email+"', rol='"+rol+"' WHERE id='"+id+"'";
        try{
            st = con.createStatement();
            st.executeUpdate(sql);
            con.close();
            st.close();
            return null;            
        } catch (SQLException e) {
            return e;
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
            System.out.println(e.getMessage());
        }
        return usuario;
    }    
    
    public Integer getSizeUsuarios() {
        Integer cantReg = 0;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        String sql = "select count(*) from usuario";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            cantReg = rs.getInt(1);
            con.close();
            rs.close();
            st.close();
            return cantReg;
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        String sql = "select * from usuario";
        try {
            Integer cantReg = getSizeUsuarios();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Usuario [] usuarios = new Usuario[cantReg];
            Integer i=0;
            while (rs.next()){
                Integer id = rs.getInt("id");
                usuarios[i] = new Usuario().getUsuario(id);
                i++;
            }
            con.close();
            rs.close();
            st.close();
            
            return usuarios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }

}
