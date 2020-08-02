/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.stock;
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
public class repositorioStock {
  private static repositorioStock instancia = null;
 
    public repositorioStock() {
    }   
    
     public static repositorioStock getInstancia() {
        if (instancia == null) {
            instancia = new repositorioStock();
        }

        return instancia;
    }
       public boolean guardarStock(stock pro) {
        boolean result = true;
       
           try {
            Integer cont =0;
                       
            if (pro.getIdProducto()!= null){
                
               PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE stock SET cantidad=? WHERE idproducto=?;");
            
            cmdUpd.setInt(1, pro.getCantidad()); 
            cmdUpd.setInt(2, pro.getIdProducto());
               cont = cmdUpd.executeUpdate();
            }
        if (cont == 0) {

                
                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  stock (cantidad,idproducto) values (?,?)");
                cmdIns.setInt(1, pro.getCantidad());
                cmdIns.setInt(2, pro.getIdProducto());
                cmdIns.executeUpdate();
                PreparedStatement ultId = Conexion.getconexion().prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet resId = ultId.executeQuery();
                if (resId.next())
                pro.setIdProducto(resId.getInt(1));

                Conexion.getconexion().close();
        }
           /**}*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }    
public void rellenarModeloControl(DefaultTableModel modelo, String valor) {
          try {
           String sql= "";
        if(valor.equals("")){
            sql="Select * from stock";
        }else{
            sql="Select * from stock where fecha='"+valor+"'";
        }
        ///  Connection conex = Conexion.getconexion();
          String []datos = new String [5];
          
          PreparedStatement cmd = Conexion.getconexion()
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              datos[1] = res.getString(3);
              datos[0] = res.getString(2);
              modelo.addRow(datos);
          }
      } catch (SQLException ex) {
          Logger.getLogger(persistencia.repositorioStock.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
public Integer obtenerCantidad(Integer modelo, Integer valor) {
          try {
           String sql= "";
          sql="Select cantidad from stock where idProducto='"+valor+"'";
          Connection conex = Conexion.getconexion();
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
          modelo = res.getInt(1);
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioStock.class.getName()).log(Level.SEVERE, null, ex);
      }
   return  modelo;
   }
public Integer obtenerCantidad2(Integer modelo, String valor) {
          try {
           String sql= "";
          sql="Select cantidad from stock where idProducto='"+valor+"'";
          Connection conex = Conexion.getconexion();
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
          modelo = res.getInt(1);
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioStock.class.getName()).log(Level.SEVERE, null, ex);
      }
   return  modelo;
   }
public void descontarstock(String codi,String can)
    {
       int des = Integer.parseInt(can);
       String cap="";
       int desfinal;
       String consul="SELECT * FROM stock WHERE  idproducto='"+codi+"'";
        try {
            Connection conex = Conexion.getconexion();
          PreparedStatement cmd = conex
                  .prepareStatement(consul);
          ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                cap= rs.getString(2);
            }
            
            
        } catch (Exception e) {
        }
        desfinal=Integer.parseInt(cap)-des;
        String modi="UPDATE stock SET cantidad='"+desfinal+"' WHERE idproducto='"+codi+"'";
        try {
            PreparedStatement pst = Conexion.getconexion().prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        
       
         
    }
}
