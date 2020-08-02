/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Indicadores;
import dominio.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class repositorioProducto {

    private static repositorioProducto instancia = null;

    private repositorioProducto() {
    }

    public static repositorioProducto getInstancia() {
        if (instancia == null) {
            instancia = new repositorioProducto();
        }

        return instancia;
    }

    public boolean guardarProducto(producto pro) {
        boolean result = true;

        try {
            Integer cont = 0;

            if (pro.getIdProducto() != null) {

                PreparedStatement cmdUpd = Conexion
                        .getconexion()
                        .prepareStatement(
                                "UPDATE producto SET nombre=?, precio=?, descripcion=?, estado = 'activo', idIndicadores=? WHERE idProducto=?;");

                cmdUpd.setString(1, pro.getNombre());
                cmdUpd.setInt(2, pro.getPrecio());
                cmdUpd.setString(3, pro.getDescripcion());
              
                cmdUpd.setInt(4, pro.getIdicador());
                cmdUpd.setInt(5, pro.getIdProducto());
                cont = cmdUpd.executeUpdate();
            }
            if (cont == 0) {

                PreparedStatement cmdIns = Conexion
                        .getconexion()
                        .prepareStatement(
                                "INSERT INTO  producto (idProducto,nombre,precio,descripcion,estado,idIndicadores) values (?,?,?,?,'activo',?)");
                cmdIns.setInt(1, pro.getIdProducto());
                cmdIns.setString(2, pro.getNombre());
                cmdIns.setInt(3, pro.getPrecio());
                cmdIns.setString(4, pro.getDescripcion());
                cmdIns.setInt(5, pro.getIdicador());

                cmdIns.executeUpdate();
                PreparedStatement ultId = Conexion.getconexion().prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet resId = ultId.executeQuery();
                if (resId.next()) {
                    pro.setIdProducto(resId.getInt(1));
                }

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

    public  producto buscarProducto(Integer Codigo) {
      producto pro = null;

        try {
            Connection conex = Conexion.getconexion();
            PreparedStatement cmd = conex
                    .prepareStatement("SELECT * FROM producto WHERE idProducto=?");
            cmd.setInt(1, Codigo);

            ResultSet res = cmd.executeQuery();
            if (res.next()) {
                pro = new producto();
                pro.setIdProducto(res.getInt("idProducto"));
                pro.setNombre(res.getString("nombre"));
                pro.setPrecio(res.getInt("precio"));
                pro.setDescripcion(res.getString("descripcion"));
             
                pro.setCodigo(res.getInt("idIndicadores"));

            }
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pro;
    }

    public void darbajaProducto(producto pro) {
        boolean result = true;
        try {

            PreparedStatement cmdUpd = Conexion
                    .getconexion()
                    .prepareStatement(
                            "UPDATE producto SET estado = 'Desactivo' WHERE idProducto=?");
            cmdUpd.setInt(1, pro.getIdProducto());
            cmdUpd.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void rellenarModeloProducto(DefaultTableModel modelo, String valor) {

        try {
            String sql = "";
            if (valor.equals("")) {
                sql = "Select * from producto where estado='activo'";
//sql="Select * from producto where estado='activo'";
            } else {
                sql = "Select * from producto where Nombre like '%" + valor + "%' and estado='activo'";
            }
            Connection conex = Conexion.getconexion();
            String[] datos = new String[4];

            PreparedStatement cmd = conex
                    .prepareStatement(sql);
            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getString(4);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(repositorioProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String comparar(String cod) {
        String cant = "";
        try {
            PreparedStatement cmd = Conexion.getconexion()
                    .prepareStatement("SELECT * FROM stock WHERE idproducto='"+cod+"'");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                cant = rs.getString(2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(repositorioProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    public void rellenarModeloProductoyStock(DefaultTableModel modelo, String valor) {

        try {
            String sql = "";
            if (valor.equals("")) {
                sql = "Select p.idProducto, p.nombre, p.precio, p.descripcion, s.cantidad from producto p, stock s where p.idproducto = s.idproducto and p.estado='activo'";
            } else {
                sql = "Select p.idProducto, p.nombre, p.precio, p.descripcion, s.cantidad from producto p, stock s where p.idproducto = s.idproducto and p.estado='activo' and p.nombre like '%" + valor + "%' ";
            }
            Connection conex = Conexion.getconexion();
            String[] datos = new String[5];

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

    public List<Indicadores> listaIndicadores() {
        List<Indicadores> lista = new ArrayList<>();
        Indicadores tip;

        try {
            Connection conex = Conexion.getconexion();

            PreparedStatement cmd = conex
                    .prepareStatement("select * from indicadores");

            ResultSet res = cmd.executeQuery();
            while (res.next()) {
                tip = new Indicadores();
                tip.setIdIdentificador(res.getInt("idIndicadores"));
                tip.setNombre(res.getString("Nombre"));
                tip.setValor(res.getInt("valor"));

                lista.add(tip);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;

    }
    public Integer obtenerValorIndicador(String codProducto, Integer modelo) {
          try {
           String sql= "";
         
            sql="SELECT i.valor FROM indicadores i, producto p where i.idIndicadores = p.idIndicadores and p.idProducto = '"+codProducto+"'";
        
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
   return modelo;
   }   
}
