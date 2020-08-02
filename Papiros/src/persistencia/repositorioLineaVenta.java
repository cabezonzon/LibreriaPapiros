/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.linea_venta;
import java.sql.PreparedStatement;

/**
 *
 * @author Matias
 */
public class repositorioLineaVenta {
 private static repositorioLineaVenta instancia = null;
 
    private repositorioLineaVenta() {
    }   
    
     public static repositorioLineaVenta getInstancia() {
        if (instancia == null) {
            instancia = new repositorioLineaVenta();
        }

        return instancia;
    }
      public boolean guardarLineaVenta(linea_venta lv) {
        boolean result = true;
           try {
                              Integer cont =0;
                       
            if (lv.getIdLinea_venta()!= null){
                
               
            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE linea_venta SET cantidad=?, idproducto=?, idventa=?, subTotal=?, iva=?, total=? WHERE idlinea_venta=?;");
            
         
            cmdUpd.setString(1, lv.getCantidad());
            cmdUpd.setString(2,lv.getIdProducto());
            cmdUpd.setString(3,lv.getIdVenta());
            cmdUpd.setDouble(4,lv.getSubTotal());
            cmdUpd.setDouble(5,lv.getIVA());
            cmdUpd.setDouble(6,lv.getTotal());
            cmdUpd.setInt(7,lv.getIdLinea_venta());
            cont = cmdUpd.executeUpdate();
            }
            if (cont == 0) {

                
                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                "INSERT INTO  linea_venta (cantidad,idproducto, idventa, subTotal, iva, total) values (?,?,?,?,?,?)");
                
            cmdIns.setString(1, lv.getCantidad());    
            cmdIns.setString(2, lv.getIdProducto());
            cmdIns.setString(3, lv.getIdVenta());
            cmdIns.setDouble(4, lv.getSubTotal());
            cmdIns.setDouble(5, lv.getIVA());
            cmdIns.setDouble(6, lv.getTotal());
            cmdIns.executeUpdate();
              
                Conexion.getconexion().close();
        
        } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }    
}
