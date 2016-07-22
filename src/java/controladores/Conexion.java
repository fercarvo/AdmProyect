/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author estudiante.2016
 */
public class Conexion {
    private static String servidor = "jdbc:mysql://localhost/admproyecto?";
    private static String user = "root";
    private static String pass = null;
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection conexion;
    
    public Conexion () {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(servidor, user, pass);
            System.out.println("conexion realizada con exito");
            
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println("conexion fallida");
        }
    }
    
    public Connection getConnection() {
        return conexion;
    }
    
}
