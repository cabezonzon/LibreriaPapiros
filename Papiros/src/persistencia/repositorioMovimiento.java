/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.movimientoCaja;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import presentacion.ConsultaMovimiento;
import static presentacion.ConsultaMovimiento.jdfec1;
import static presentacion.ConsultaMovimiento.jdfec2;

/**
 *
 * @author Matias
 */
public class repositorioMovimiento {

    private static repositorioMovimiento instancia = null;

    private repositorioMovimiento() {
    }

    public static repositorioMovimiento getInstancia() {
        if (instancia == null) {
            instancia = new repositorioMovimiento();
        }

        return instancia;
    }

    public boolean guardarMovimiento(movimientoCaja mov) {
        boolean result = true;
        try {
            Integer cont = 0;

            if (mov.getIdMovimiento() != null) {

                PreparedStatement cmdUpd = Conexion
                        .getconexion()
                        .prepareStatement(
                                "UPDATE movimiento_caja SET descripcion=?, entrada_salida=?, fecha=?, monto=?, idapertura_cierre_caja=?, idUsuario=? WHERE idMovimiento_caja=?;");

                cmdUpd.setString(1, mov.getDescripcion());
                cmdUpd.setString(2, mov.getEntrada_salida());
                cmdUpd.setDate(3, (Date) mov.getFecha());
                cmdUpd.setInt(4, mov.getMonto());
                cmdUpd.setInt(5, mov.getIdMovimiento());
                cmdUpd.setInt(6, mov.getIdapertura_cierre_caja());
                cmdUpd.setInt(7, mov.getIdUsuario());
                cont = cmdUpd.executeUpdate();
            }
            if (cont == 0) {

                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                "INSERT INTO  movimiento_caja (Descripcion,Entrada_Salida,Fecha,Monto,idapertura_cierre_caja, idUsuario) values (?,?,?,?,?,?)");

                cmdIns.setString(1, mov.getDescripcion());
                cmdIns.setString(2, mov.getEntrada_salida());
                cmdIns.setDate(3, (Date) mov.getFecha());
                cmdIns.setInt(4, mov.getMonto());
                cmdIns.setInt(5, mov.getIdapertura_cierre_caja());
                cmdIns.setInt(6, mov.getIdUsuario());

                cmdIns.executeUpdate();
                Conexion.getconexion().close();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /* public movimientoCaja buscarCliente(Integer Codigo) {
     movimientoCaja mov = null;

     try {
     Connection conex = Conexion.getconexion();
     PreparedStatement cmd = conex
     .prepareStatement("SELECT * FROM movimientocaja");
     cmd.setInt(1, Codigo);

     ResultSet res = cmd.executeQuery();
     if (res.next()) {
     mov = new Movimiento_Caja();
     mov.setDescripcion(res.getString("Descripcion"));
     mov.setEntrada_salida(res.getString("Entrada/Salida"));
     mov.setFecha(res.getDate("Fecha"));
     mov.setMonto(res.getInt("Monto"));
                
         
     }

     } catch (Exception ex) {
     ex.printStackTrace();
     }

     return mov;
     }*/
    public void rellenarModeloControl(DefaultTableModel modelo, String valor) {
        try {
            String sql = "";
            if (valor.equals("")) {
                sql = "Select * from movimiento_caja";
            } else {
                sql = "Select * from movimiento_caja where Fecha='" + valor + "'";
            }
            Connection conex = Conexion.getconexion();
            String[] datos = new String[5];

            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                datos[0] = res.getString(2);
                datos[1] = res.getString(3);
                datos[2] = res.getString(4);
                datos[3] = res.getString(5);
                datos[4] = res.getString(6);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer totalEntrada(Integer id, Integer modelo) {
        try {
            String sql = "";

            sql = "SELECT SUM(monto) FROM movimiento_caja where idapertura_cierre_caja=? and entrada_salida='Entrada'";

            Connection conex = Conexion.getconexion();

            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            cmd.setInt(1, id);

            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                modelo = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public Integer totalSalida(Integer id, Integer modelo) {
        try {
            String sql = "";

            sql = "SELECT SUM(monto) FROM movimiento_caja where idapertura_cierre_caja=? and entrada_salida='Salida'";

            Connection conex = Conexion.getconexion();

            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            cmd.setInt(1, id);
            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                modelo = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public Integer obtenerUltimoMonto(Integer modelo) {
        try {
            String sql = "";

            sql = "SELECT monto_apertura FROM apertura_cierre_caja ORDER BY idapertura_cierre_caja DESC LIMIT 1";

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

    public Integer ventaTotalMomentanea(Integer modelo, Integer id) {
        try {
            String sql = "";

            sql = "SELECT SUM(monto) FROM venta where idapertura_cierre_caja = '" + id + "'";

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

    public void rellenarModeloMovimiento(DefaultTableModel modelo, java.util.Date Fecha1, java.util.Date Fecha2) {

        try {
            String sql = "";
           
            
            sql = "Select m.idmovimiento_caja, m.descripcion, m.entrada_salida, m.fecha, m.monto, m.idapertura_cierre_caja, u.nick from movimiento_caja m, usuario u where u.idusuario = m.idusuario and m.fecha >=  '" + Fecha1 + "' and m.fecha <=  '" + Fecha2 + "'";

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
                datos[5] = res.getString(6);
                datos[6] = res.getString(7);

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
