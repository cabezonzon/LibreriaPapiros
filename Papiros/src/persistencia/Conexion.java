/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Matias
 */
public class Conexion {
public static String bd = "papiros";
public static String login = "root";
public static String password = "sakura";
public static String url = "jdbc:mysql://localhost/"+bd;

public static Connection getconexion() {
        Connection conex = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conex = DriverManager.getConnection(url,login,password);
       
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return conex; 
    }

}