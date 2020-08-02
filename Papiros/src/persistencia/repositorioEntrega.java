/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.entrega;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class repositorioEntrega {
private static repositorioEntrega instancia = null;
 
    private repositorioEntrega() {
    }   
    
     public static repositorioEntrega getInstancia() {
        if (instancia == null) {
            instancia = new repositorioEntrega();
        }

        return instancia;
    }
      public boolean guardarEntrega(entrega pro) {
        boolean result = true;
       
           try {
            
                
                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  entregas (monto,fecha,idCredito) values (?,?,?)");
              
                cmdIns.setInt(1, pro.getMonto());
                cmdIns.setDate(2, (Date) pro.getFecha());
                cmdIns.setInt(3, pro.getIdCredito());
                cmdIns.executeUpdate();
                PreparedStatement ultId = Conexion.getconexion().prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet resId = ultId.executeQuery();
                if (resId.next())
                pro.setIdCredito(resId.getInt(1));

                Conexion.getconexion().close();
        
           /**}*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }
}
