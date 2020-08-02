/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.cliente;
import java.sql.Connection;
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
public class repositorioCliente {

    private static repositorioCliente instancia = null;

    private repositorioCliente() {
    }

    public static repositorioCliente getInstancia() {
        if (instancia == null) {
            instancia = new repositorioCliente();
        }

        return instancia;
    }

    public boolean guardarCliente(cliente pro) {
        boolean result = true;

        try {
            Integer cont = 0;

            if (pro.getci() != null) {

                PreparedStatement cmdUpd = Conexion
                        .getconexion()
                        .prepareStatement(
                                "UPDATE cliente SET ci=?, nombre=?, apellido=?, telefono=?, direccion=?, estado = 'Activo'WHERE ci=?;");

                cmdUpd.setInt(1, pro.getci());
                cmdUpd.setString(2, pro.getNombre());
                cmdUpd.setString(3, pro.getApellido());
                cmdUpd.setInt(4, pro.getTelefono());
                cmdUpd.setString(5, pro.getDireccion());
  
                cmdUpd.setInt(6, pro.getci());
                cont = cmdUpd.executeUpdate();
            }
            if (cont == 0) {

                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                "INSERT INTO cliente (ci,nombre,apellido,telefono,direccion,estado) values (?,?,?,?,?,'activo')");

                cmdIns.setInt(1, pro.getci());
                cmdIns.setString(2, pro.getNombre());
                cmdIns.setString(3, pro.getApellido());
                cmdIns.setInt(4, pro.getTelefono());
                cmdIns.setString(5, pro.getDireccion());
                
                
                cmdIns.executeUpdate();
                ;

                Conexion.getconexion().close();
            }
            /**
             * }
             */
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public cliente buscarCliente(Integer Codigo) {
        cliente pro = null;

        try {
            Connection conex = Conexion.getconexion();
            PreparedStatement cmd = conex
                    .prepareStatement("SELECT * FROM cliente WHERE ci=?");
            cmd.setInt(1, Codigo);

            ResultSet res = cmd.executeQuery();
            if (res.next()) {
                pro = new cliente();
                pro.setci(res.getInt("ci"));
                pro.setNombre(res.getString("nombre"));
                pro.setApellido(res.getString("apellido"));
                pro.setTelefono(res.getInt("telefono"));
                pro.setDireccion(res.getString("direccion"));
               

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pro;
    }

    public void darbajaCliente(cliente pro) {
        boolean result = true;
        try {

            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                            "UPDATE cliente SET estado = 'Desactivo' WHERE ci=?");
            cmdUpd.setInt(1, pro.getci());
            cmdUpd.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void rellenarModeloCliente(DefaultTableModel modelo, String valor) {

        try {
            String sql = "";
            if (valor.equals("")) {
                sql = "Select * from cliente where estado='activo'";
            } else  {
                sql = "Select * from cliente where estado='activo' and (Nombre like'%" + valor + "%' or Apellido like'%" + valor + "%' or ci like'%" + valor + "%')";
            }
            
            Connection conex = Conexion.getconexion();
            String[] datos = new String[7];

            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getString(4);
                datos[4] = res.getString(5);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean obtenerCliente(Integer CI) {
        try {
            String sql = "";
            sql = "Select idcredito from credito where ci_cliente='" + CI + "'";
            Connection conex = Conexion.getconexion();
            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                res.getInt(1);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
