/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.compra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class repositorioCompra {
private static repositorioCompra instancia = null;
 
    private repositorioCompra() {
    }   
    
     public static repositorioCompra getInstancia() {
        if (instancia == null) {
            instancia = new repositorioCompra();
        }

        return instancia;
    }
      public boolean guardarCompra(compra pro) {
        boolean result = true;
       
           try {
                   PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  compras (fecha,cantidad,idProducto) values (?,?,?)");
                cmdIns.setDate(1, (Date) pro.getFecha());
                cmdIns.setInt(2, pro.getCantidad());
                cmdIns.setInt(3, pro.getIdProducto());
                cmdIns.executeUpdate();
                PreparedStatement ultId = Conexion.getconexion().prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet resId = ultId.executeQuery();
                if (resId.next())
                pro.setIdCompras(resId.getInt(1));

                Conexion.getconexion().close();
        
           /**}*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    } 
}
