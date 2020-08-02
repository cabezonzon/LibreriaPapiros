/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.linea_venta;
import dominio.venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class repositorioVenta {

    private static repositorioVenta instancia = null;

    private repositorioVenta() {
    }

    public static repositorioVenta getInstancia() {
        if (instancia == null) {
            instancia = new repositorioVenta();
        }

        return instancia;
    }

    public void venta(String total, Date fecha, String pago, Integer medio, Integer id, Integer idUsuario, Integer subTotal, Integer iva, Integer codFactura) {
        String InsertarSQL = "INSERT INTO venta(fecha,subTotal,iva, monto, tipoDePago,idmedioPago, idapertura_cierre_caja, idusuario,codFactura) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexion.getconexion().prepareStatement(InsertarSQL);
            pst.setDate(1, (java.sql.Date) fecha);
            pst.setInt(2, subTotal);
            pst.setInt(3, iva);
            pst.setString(4, total);
            pst.setString(5, pago);
            pst.setInt(6, medio);
            pst.setInt(7, id);
            pst.setInt(8, idUsuario);
            pst.setInt(9, codFactura);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(repositorioVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ventalinea(List<linea_venta> lineas) {

        try {

            PreparedStatement ultId = Conexion.getconexion().prepareStatement("SELECT idventa FROM venta ORDER BY idventa DESC LIMIT 1");
            ResultSet resId = ultId.executeQuery();

            if (resId.next()) {

                repositorioLineaVenta rep = repositorioLineaVenta.getInstancia();
                for (linea_venta lv : lineas) {
                    lv.setIdVenta(resId.getString(1));
                    rep.guardarLineaVenta(lv);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(repositorioVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer totalTurno(Integer id, Integer modelo) {
        try {
            String sql = "";

            sql = "SELECT SUM(monto) FROM venta v, mediopago m where idapertura_cierre_caja=? and v.idmedioPago=m.idmedioPago and m.nombre = 'Efectivo'";

            Connection conex = Conexion.getconexion();

            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            cmd.setInt(1, id);
            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                modelo = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public Integer seleccionarIdVenta(Integer modelo) {
        try {
            String sql = "";

            sql = "SELECT idVenta FROM venta ORDER BY idVenta DESC LIMIT 1";

            Connection conex = Conexion.getconexion();

            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                modelo = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioAperturaCierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public String obtenerNumFactura() {
        String SQL = "select max(codFactura) from venta";
        String c = "";
        try {
            Statement st = Conexion.getconexion().createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioAperturaCierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
