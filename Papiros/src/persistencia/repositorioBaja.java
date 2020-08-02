/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.baja;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class repositorioBaja {
private static repositorioBaja instancia = null;
 
    private repositorioBaja() {
    }   
    
     public static repositorioBaja getInstancia() {
        if (instancia == null) {
            instancia = new repositorioBaja();
        }

        return instancia;
    }
      public boolean guardarBaja(baja pro) {
        boolean result = true;
       
           try {
                   PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  baja (fecha,cantidad,razon,idProducto) values (?,?,?,?)");
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
}
