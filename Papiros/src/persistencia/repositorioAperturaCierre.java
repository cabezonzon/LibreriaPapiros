/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.apertura_cierre;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class repositorioAperturaCierre {
  private static repositorioAperturaCierre instancia = null;
 
    private repositorioAperturaCierre() {
    }   
    
     public static repositorioAperturaCierre getInstancia() {
        if (instancia == null) {
            instancia = new repositorioAperturaCierre();
        }

        return instancia;
    }
      public boolean guardarAp_Ci(apertura_cierre ap) {
        boolean result = true;
           try {
                             Integer cont =0;
                       
            if (ap.getIdApertura_cierre_caja()!= null){
                  
            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE apertura_cierre_caja SET fecha=?, monto_apertura=?, turno=?, estado='Activo', idUsuario=? WHERE idapertura_cierre_caja=?;");
            
            cmdUpd.setDate(1, (Date) ap.getFecha()); 
            cmdUpd.setInt(2,ap.getMonto_apertura());
            cmdUpd.setString(3,ap.getTurno());
            cmdUpd.setInt(4,ap.getIdApertura_cierre_caja());
            cmdUpd.setInt(5,ap.getIdUsuario());
            
            
           cont = cmdUpd.executeUpdate();
            }
        if (cont == 0) {

                
                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  apertura_cierre_caja (fecha,monto_apertura,turno,estado, idUsuario) values (?,?,?,'Activa',?)");
                
                
                cmdIns.setDate(1, (Date) ap.getFecha());
                cmdIns.setInt(2, ap.getMonto_apertura());
                cmdIns.setString(3, ap.getTurno());
                cmdIns.setInt(4, ap.getIdUsuario());
                
                
                 cmdIns.executeUpdate();
                Conexion.getconexion().close();
        
        } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }    
     public boolean guardarCierre(apertura_cierre ap,Integer id) {
        boolean result = true;
           try {
                         Integer cont =0;
                       
         
            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE apertura_cierre_caja SET monto_Cierre=?, estado='Cerrada' where idapertura_cierre_caja=?;");
            
            cmdUpd.setInt(1, ap.getMonto_cierre()); 
            cmdUpd.setInt(2, id);
           cont = cmdUpd.executeUpdate();
            
                Conexion.getconexion().close();
        
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }       
   /* public Apertura_Cierre buscarCliente(Integer Codigo) {
        Apertura_Cierre mov = null;

        try {
            Connection conex = Conexion.getconexion();
           PreparedStatement cmd = conex
                    .prepareStatement("SELECT * FROM apertura_cierre_caja");
            cmd.setInt(1, Codigo);

            ResultSet res = cmd.executeQuery();
            if (res.next()) {
                mov = new Apertura_Cierre();
                mov.setFecha(res.getDate("Fecha"));
                mov.setMonto_Apertura(res.getInt("Monto_Apertura"));
                mov.setMonto_Cierre(res.getInt("Monto_Cierre"));
                mov.setTurno(res.getString("Turno"));
                
         
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return mov;
    }*/

    public void rellenarModeloApertura(DefaultTableModel modelo, String valor) {
          try {
           String sql= "";
        if(valor.equals("")){
            sql="Select * from apertura_cierre_caja";
        }else{
            sql="Select * from apertura_cierre_caja where fecha='"+valor+"'";
        }
          Connection conex = Conexion.getconexion();
          String []datos = new String [5];
          
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              datos[0] = res.getString(2);
              datos[1] = res.getString(3);
              datos[2] = res.getString(4);
              datos[3] = res.getString(6);
              datos[4] = res.getString(5);
              modelo.addRow(datos);
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioAperturaCierre.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
public String obtenerEstado(String modelo) {
          try {
           String sql= "";
       
            sql="SELECT estado FROM apertura_cierre_caja ORDER BY estado ASC LIMIT 1";
        
          Connection conex = Conexion.getconexion();
          
          
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              modelo = res.getString(1);
             
              
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioAperturaCierre.class.getName()).log(Level.SEVERE, null, ex);
      }
   return  modelo;
   }    

public Integer seleccionarMontoApertura(Integer modelo) {
          try {
           String sql= "";
       
            sql="SELECT monto_apertura FROM apertura_cierre_caja where estado='Activa' ORDER BY monto_apertura ASC LIMIT 1";
        
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
public Integer seleccionarIdApertura(Integer modelo) {
          try {
           String sql= "";
       
            sql="SELECT idapertura_cierre_caja FROM apertura_cierre_caja where estado='Activa' ORDER BY monto_apertura ASC LIMIT 1";
        
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
 public void rellenarModeloCierreCaja(DefaultTableModel modelo, Integer id) {
          try {
           String sql= "";
        
            sql="select a.idapertura_cierre_caja, m.nombre, SUM(v.monto) from apertura_cierre_caja a, mediopago m, venta v where a.idapertura_cierre_caja = v.idapertura_cierre_caja and v.idmedioPago = m.idmedioPago and v.idapertura_cierre_caja = '"+id+"' and m.Estado='Activo' group by m.nombre;";
        
          Connection conex = Conexion.getconexion();
          String []datos = new String [5];
          
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              datos[0] = res.getString(1);
              datos[1] = res.getString(2);
              datos[2] = res.getString(3);
              modelo.addRow(datos);
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioAperturaCierre.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}