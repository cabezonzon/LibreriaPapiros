/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.credito;

import dominio.linea_venta;
import dominio.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class repositorioCredito {
private static repositorioCredito instancia = null;
 
    private repositorioCredito() {
    }   
    
     public static repositorioCredito getInstancia() {
        if (instancia == null) {
            instancia = new repositorioCredito();
        }

        return instancia;
    }
      public boolean guardarCredito(credito pro) {
        boolean result = true;
       
           try {
            
                
                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  credito (saldo,ci_cliente, fecha, idVenta) values (?,?,?,?)");
              
                cmdIns.setString(1, pro.getSaldo());
                cmdIns.setInt(2, pro.getCi_cliente());
                cmdIns.setDate(3, pro.getFechaFin());
                cmdIns.setInt(4, pro.getIdVenta());
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

public Integer seleccionarIdCredito(Integer modelo, Integer valor) {
          try {
           String sql= "";
       
            sql="SELECT idCredito FROM credito where ci_cliente='"+valor+"'";
        
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
public void rellenarModeloClienteDeuda(DefaultTableModel modelo, String valor) {
 
      try {
           String sql= "";
        if(valor.equals("")){
            sql="select c.ci, c.Nombre, c.Apellido, c.Telefono, a.saldo , a.idcredito, a.fecha from cliente c, credito a where c.ci = a.ci_cliente and a.saldo>0";
        }else{
            sql="select c.ci, c.Nombre, c.Apellido, c.Telefono, a.saldo. a.idcredito, a.fecha from cliente c, credito a where c.ci = a.ci_cliente and a.saldo>0 and (Nombre like'%" + valor + "%' or Apellido like'%" + valor + "%' or ci like'%" + valor + "%')";
        }
          Connection conex = Conexion.getconexion();
          String []datos = new String [7];
          
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              datos[0] = res.getString(1);
              datos[1] = res.getString(2);
              datos[2] = res.getString(3);
              datos[3] = res.getString(4);
              datos[4] = res.getString(5);
              datos[5] = res.getString(6);
              datos[6] = res.getString(7);
              modelo.addRow(datos);
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioProducto.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
public Integer obtenerCantidad(Integer modelo, Integer valor) {
          try {
           String sql= "";
          sql="Select saldo from credito where idcredito='"+valor+"'";
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
public void descontarMonto(Integer codi,String can)
    {
       int des = Integer.parseInt(can);
       String cap="";
       int desfinal;
       String consul="SELECT * FROM credito WHERE  idcredito='"+codi+"'";
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
        String modi="UPDATE credito SET saldo='"+desfinal+"' WHERE idcredito='"+codi+"'";
        try {
            PreparedStatement pst = Conexion.getconexion().prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        
       
         
    }
public Integer obtenerIdCredito(Integer modelo, Integer valor) {
          try {
           String sql= "";
          sql="Select idcredito from credito where ci_cliente='"+valor+"'";
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
public void AumentarSaldo(Integer codi,String can)
    {
    
       String cap="";
       Integer desfinal;
       String consul="SELECT * FROM credito WHERE  ci_cliente='"+codi+"'";
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
        desfinal= Integer.parseInt(cap) + Integer.parseInt(can);
        String modi="UPDATE credito SET saldo='"+desfinal+"' WHERE ci_cliente='"+codi+"'";
        try {
            PreparedStatement pst = Conexion.getconexion().prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        
       
         
    }
}