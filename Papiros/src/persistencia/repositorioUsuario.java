/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class repositorioUsuario {
  private static repositorioUsuario instancia = null;
 
    private repositorioUsuario() {
    }   
    
     public static repositorioUsuario getInstancia() {
        if (instancia == null) {
            instancia = new repositorioUsuario();
        }

        return instancia;
    }

     
public String acceder(String usuario, String pass) {
    String cap="";
    String resultado="";
    String sql="Select * from usuario where nick='"+usuario+"' && contrasenia='"+pass+"'";
    try {
        
    
    PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(sql);
    ResultSet res = cmdUpd.executeQuery();  
    while (res.next()){
        cap=res.getString("tipousuario");
    }
    if (cap.equals("admin")){
    
    resultado ="admin";
        
    }
else if (cap.equals("vendedor")){
    
    resultado ="vendedor";
        
    }   
    } catch (Exception ex) {
            ex.printStackTrace();
        }
return resultado;    
} 
 public boolean guardarUsuario(usuario pro) {
        boolean result = true;
       
           try {
            Integer cont =0;
                       
            if (pro.getIdUsuario()!= null){
                
               PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE usuario SET nick=?, contrasenia=?, tipousuario=?, estado = 'Activo' WHERE idUsuario=?;");
            
            cmdUpd.setString(1, pro.getNick()); 
            cmdUpd.setString(2,pro.getContra());
            cmdUpd.setString(3,pro.getTipoUsuario());
            cmdUpd.setInt(4, pro.getIdUsuario());
               cont = cmdUpd.executeUpdate();
            }
        if (cont == 0) {

                
                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  usuario (nick,contrasenia,tipousuario,estado) values (?,?,?,'activo')");
                cmdIns.setString(1, pro.getNick());
                cmdIns.setString(2, pro.getContra());
                cmdIns.setString(3, pro.getTipoUsuario());
                cmdIns.executeUpdate();
                PreparedStatement ultId = Conexion.getconexion().prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet resId = ultId.executeQuery();
                if (resId.next())
                pro.setIdUsuario(resId.getInt(1));

                Conexion.getconexion().close();
        }
           /**}*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }       
 public void rellenarModeloUsuario(DefaultTableModel modelo, String valor) {
 
      try {
           String sql= "";
        if(valor.equals("")){
            sql="Select * from usuario where estado='activo'";
        }else{
            sql="Select * from usuario where nick like'%"+valor+"%' and estado='activo'";
        }
          Connection conex = Conexion.getconexion();
          String []datos = new String [4];
          
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              datos[0] = res.getString(1);
              datos[1] = res.getString(2);
              datos[2] = res.getString(3);
              datos[3] = res.getString(4);
              modelo.addRow(datos);
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioProducto.class.getName()).log(Level.SEVERE, null, ex);
      }
    }                    
public void darbajaUsuario(usuario pro) {
        boolean result = true;
        try {

            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE usuario SET estado = 'Desactivo' WHERE idUsuario=?");
            cmdUpd.setInt(1, pro.getIdUsuario());
            cmdUpd.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }             
 public boolean guardarLogin(String nick, String contra) {
        boolean result = true;
           try {
            
         
            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE usuario SET login='logeado' where nick='"+nick+"' and contrasenia='"+contra+"';");
            
          
            cmdUpd.executeUpdate();
            Conexion.getconexion().close();
       } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    } 
public Integer obtenerIdUsuario(Integer modelo, String nick, String contra) {
          try {
           String sql= "";
       
            sql="SELECT idUsuario FROM usuario where nick='"+nick+"' and contrasenia='"+contra+"'";
        
          Connection conex = Conexion.getconexion();
          
          
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              modelo = res.getInt(1);
             
              
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioAperturaCierre.class.getName()).log(Level.SEVERE, null, ex);
      }
   return  modelo;
   }    
}
