/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.movimientoStock;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class repositorioMovimientoStock {
private static repositorioMovimientoStock instancia = null;
 
    private repositorioMovimientoStock() {
    }   
    
     public static repositorioMovimientoStock getInstancia() {
        if (instancia == null) {
            instancia = new repositorioMovimientoStock();
        }

        return instancia;
    }
      public boolean guardarBaja(movimientoStock pro) {
        boolean result = true;
       
           try {
                   PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  movimientoStock (fecha,cantidad,razon,tipo,idProducto) values (?,?,?,'Salida',?)");
                cmdIns.setDate(1, (java.sql.Date) pro.getFecha());
                cmdIns.setInt(2, pro.getCantidad());
                cmdIns.setString(3, pro.getRazon());
                cmdIns.setInt(4, pro.getIdProducto());
                cmdIns.executeUpdate();
            
                Conexion.getconexion().close();
        
           /**}*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }
public boolean guardarCompra(movimientoStock pro) {
        boolean result = true;
       
           try {
                   PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  movimientoStock (fecha,cantidad,razon,tipo,idProducto) values (?,?,'null','Entrada',?)");
                cmdIns.setDate(1, (java.sql.Date) pro.getFecha());
                cmdIns.setInt(2, pro.getCantidad());
               
                cmdIns.setInt(3, pro.getIdProducto());
                cmdIns.executeUpdate();
            
                Conexion.getconexion().close();
        
           /**}*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    } 
}
