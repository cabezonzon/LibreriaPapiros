/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.medioPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class repositorioMedioPago {
private static repositorioMedioPago instancia = null;
 
    private repositorioMedioPago() {
    }   
    
     public static repositorioMedioPago getInstancia() {
        if (instancia == null) {
            instancia = new repositorioMedioPago();
        }

        return instancia;
    }
      public boolean guardarMedio(medioPago pro) {
        boolean result = true;
           try {
            Integer cont =0;
            if (pro.getIdMedio()!= null){
               PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE mediopago SET nombre=?, estado='Activo' WHERE idmedioPago=?;");
            cmdUpd.setString(1, pro.getNombre()); 
            cmdUpd.setInt(2, pro.getIdMedio());
            cont = cmdUpd.executeUpdate();
            }
        if (cont == 0) {
        PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                
                        "INSERT INTO  mediopago (nombre,estado) values (?,'Activo')");
                cmdIns.setString(1, pro.getNombre());
               cmdIns.executeUpdate();
                PreparedStatement ultId = Conexion.getconexion().prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet resId = ultId.executeQuery();
                

                Conexion.getconexion().close();

        }
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
           
        return result;
    }    
      
    
public void darbajaMedio(medioPago pro) {
        boolean result = true;
        try {

            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                    "UPDATE mediopago SET estado = 'Desactivo' WHERE idmedioPago=?");
            cmdUpd.setInt(1, pro.getIdMedio());
            cmdUpd.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }         
 public void rellenarModeloMedio(DefaultTableModel modelo, String valor) {
 
      try {
           String sql= "";
        if(valor.equals("")){
            sql="Select * from mediopago where estado='Activo'";
        }else{
            sql="Select * from mediopago where nombre like '%"+valor+"%' and estado='Activo'";
        }
          Connection conex = Conexion.getconexion();
          String []datos = new String [4];
          
          PreparedStatement cmd = conex
                  .prepareStatement(sql);
          ResultSet res = cmd.executeQuery();
          while (res.next()){
              datos[0] = res.getString(1);
              datos[1] = res.getString(2);
         
              modelo.addRow(datos);
          }
      } catch (SQLException ex) {
          Logger.getLogger(repositorioMedioPago.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
public List<medioPago> listaMedio() {
        List<medioPago> lista = new ArrayList<>();
        medioPago tip;

        try {
            Connection conex = Conexion.getconexion();

            PreparedStatement cmd = conex
                    .prepareStatement("select * from mediopago where estado ='activo'");

            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                tip = new medioPago();
                tip.setIdMedio(res.getInt("idmedioPago"));
                tip.setNombre(res.getString("nombre"));
                
                lista.add(tip);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;

    }
}

