/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import persistencia.Conexion;

/**
 *
 * @author Marcos
 */
public class ConsultasFacturas extends javax.swing.JFrame {

    
     JDialog viewer = new JDialog(new JFrame(), "ReporteStock", true);
    JDialog viewer2 = new JDialog(new JFrame(), "Historial de Ventas", true);
     JDialog viewer4 = new JDialog(new JFrame(),"Estado de cuenta",true);
    persistencia.Conexion conex = new persistencia.Conexion();
    /**
     * Creates new form ConsultasFacturas
     */
    public ConsultasFacturas() {
        initComponents();
        cargartodasfacturas();
        this.setLocation(25, 15);
        jDateChooser1.setEnabled(false);
    }

    void cargartodasfacturas() {
        DefaultTableModel tabla = new DefaultTableModel();
        String[] titulos = {"NUMERO", "ID USUARIO", "NOMBRE", "APELLIDO", "TOTAL", "FECHA"};
        tabla.setColumnIdentifiers(titulos);
        this.tbfacturas.setModel(tabla);
        String consulta = "SELECT v.idventa,v.idusuario,c.Nombre,c.Apellido,v.monto,v.fecha FROM venta v, cliente c WHERE v.idusuario=c.ci";
        String[] Datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                Datos[0] = rs.getString("idventa");
                Datos[1] = rs.getString("idusuario");
                Datos[2] = rs.getString("Nombre");
                Datos[3] = rs.getString("Apellido");
                Datos[4] = rs.getString("monto");
                Datos[5] = rs.getString("fecha");

                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbfacturas = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        rdbnnumero = new javax.swing.JRadioButton();
        txtnumero = new javax.swing.JTextField();
        rdbbnfecha = new javax.swing.JRadioButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        rbnombre = new javax.swing.JRadioButton();
        txtnombre = new javax.swing.JTextField();
        rdbntodos = new javax.swing.JRadioButton();
        txtapellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnbuscador = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuRepStock = new javax.swing.JMenuItem();
        jMenuHistVentas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuRepStock1 = new javax.swing.JMenuItem();
        jMenuRepDeu = new javax.swing.JMenuItem();
        jMenuHistVentas1 = new javax.swing.JMenuItem();
        jMenuEstCu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas de facturas");
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(680, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(680, 580));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbfacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbfacturas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 520, 142));

        btngrupo.add(rdbnnumero);
        rdbnnumero.setSelected(true);
        rdbnnumero.setText("Mostrar  por Nº:");
        rdbnnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbnnumeroActionPerformed(evt);
            }
        });
        jPanel1.add(rdbnnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });
        txtnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroKeyTyped(evt);
            }
        });
        jPanel1.add(txtnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 80, -1));

        btngrupo.add(rdbbnfecha);
        rdbbnfecha.setText("Mostrar por Fecha");
        rdbbnfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbbnfechaActionPerformed(evt);
            }
        });
        jPanel1.add(rdbbnfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 100, -1));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 100, -1));

        btngrupo.add(rbnombre);
        rbnombre.setText("Mostrar por nombre de Cliente");
        rbnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnombreActionPerformed(evt);
            }
        });
        jPanel1.add(rbnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 80, -1));

        btngrupo.add(rdbntodos);
        rdbntodos.setText("Mostrar todas:");
        rdbntodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbntodosActionPerformed(evt);
            }
        });
        jPanel1.add(rdbntodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 80, -1));

        jLabel2.setText("nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 60, -1));

        jLabel4.setText("BUSCAR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        btnbuscador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnbuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 40, 40));

        jLabel3.setText("apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        jLabel5.setText("Entre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 40, 20));

        jLabel6.setText("y");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 20, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 580, 370));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 40, 40));

        jLabel7.setText("Volver");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 600));

        jMenu1.setText("ABM");

        jMenuItem8.setText("Administrar Clientes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Administrar Productos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Administrar Usuarios del sistema");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("Administrar Medios de pago");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Transacciones");

        jMenuItem14.setText("Ventas");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuItem1.setText("Compra de Mercadería");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem15.setText("Baja de Mercadería");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuItem16.setText("Movimiento de caja");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuItem4.setText("Apertura de caja");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem7.setText("Cerrar Turno");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem12.setText("Pagar Deuda");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Consultas");

        jMenuRepStock.setText("consulta de facturas");
        jMenuRepStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRepStockActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuRepStock);

        jMenuHistVentas.setText("consulta de movimientos de caja");
        jMenuHistVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHistVentasActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuHistVentas);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Reportes");

        jMenuRepStock1.setText("Reporte de stock");
        jMenuRepStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRepStock1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuRepStock1);

        jMenuRepDeu.setText("Reporte de Deudores");
        jMenuRepDeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRepDeuActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuRepDeu);

        jMenuHistVentas1.setText("Reporte de ventas");
        jMenuHistVentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHistVentas1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuHistVentas1);

        jMenuEstCu.setText("Estado de Cuentas");
        jMenuEstCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEstCuActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuEstCu);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscadorActionPerformed
        // TODO add your handling code here:

        String num = txtnumero.getText();
        String nom = txtnombre.getText();
        String ape = txtapellido.getText();
        String consulta = "";
        if (rdbnnumero.isSelected() == true) {
            consulta = "SELECT v.idventa,v.idusuario,c.Nombre,c.Apellido,v.monto,v.fecha FROM venta v, cliente c WHERE idventa='" + num + "'";
        }
        if (rdbbnfecha.isSelected() == true) {
            Date fecha = jDateChooser1.getDate();
            Date fecha2 = jDateChooser2.getDate();
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd");
            String fec = "" + formatofecha.format(fecha);
            String fec2 = "" + formatofecha.format(fecha2);

            consulta = "SELECT v.idventa,v.idusuario,c.Nombre,c.Apellido,v.monto,v.fecha FROM venta v, cliente c WHERE v.fecha between'" + fec + "' and '" + fec2 + "'";
        }
        if (rbnombre.isSelected() == true) {
            consulta = "SELECT v.idventa,v.idusuario,c.Nombre,c.Apellido,v.monto,v.fecha FROM venta v, cliente c WHERE c.nombre like '%" + nom + "%' and c.apellido like '%" + ape + "%' and v.idusuario=c.ci ";

        }

        if (rdbntodos.isSelected() == true) {
            consulta = "SELECT SELECT v.idventa,v.idusuario,c.Nombre,c.Apellido,v.monto,v.fecha FROM venta v, cliente c WHERE v.idusuario=c.ci ";
        }
        DefaultTableModel tabla = new DefaultTableModel();
        String[] titulos = {"NUMERO", "ID USUARIO", "NOMBRE", "APELLIDO", "TOTAL", "FECHA"};
        tabla.setColumnIdentifiers(titulos);
        this.tbfacturas.setModel(tabla);

        String[] Datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                Datos[0] = rs.getString("v.idventa");
                Datos[1] = rs.getString("v.idusuario");
                Datos[2] = rs.getString("c.Nombre");
                Datos[3] = rs.getString("c.Apellido");
                Datos[4] = rs.getString("v.monto");
                Datos[5] = rs.getString("v.fecha");

                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {

        int fila = tbfacturas.getSelectedRow();
        if (fila >= 0) {
            String cod = tbfacturas.getValueAt(fila, 0).toString();
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM venta WHERE idventa='" + cod + "'");
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasFacturas.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargartodasfacturas();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
        }
    }//GEN-LAST:event_btnbuscadorActionPerformed

    private void rdbntodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbntodosActionPerformed
        // TODO add your handling code here:
        if (rdbntodos.isSelected() == true) {
            jDateChooser1.setEnabled(false);
            jDateChooser1.setDate(null);
            jDateChooser2.setEnabled(false);
            jDateChooser2.setDate(null);
            txtnumero.setText("");
            txtnumero.setEnabled(false);
            txtnombre.setEnabled(false);
            txtnombre.setText("");
            txtapellido.setEnabled(false);
            txtapellido.setText("");
            cargartodasfacturas();
        }
    }//GEN-LAST:event_rdbntodosActionPerformed

    private void rbnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnombreActionPerformed
        if (rbnombre.isSelected() == true) {
            txtnombre.setEnabled(true);
            txtnombre.requestFocus();
            txtapellido.setEnabled(true);
            txtapellido.requestFocus();
            jDateChooser1.setEnabled(false);
            jDateChooser1.setDate(null);
            jDateChooser2.setEnabled(false);
            jDateChooser2.setDate(null);
            txtnumero.setText("");
            txtnumero.setEnabled(false);

        }
    }//GEN-LAST:event_rbnombreActionPerformed

    private void rdbbnfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbbnfechaActionPerformed
        // TODO add your handling code here:
        if (rdbbnfecha.isSelected() == true) {
            jDateChooser1.setEnabled(true);
            jDateChooser2.setEnabled(true);
            txtnumero.setEnabled(false);
            txtnumero.setText("");
            txtnombre.setEnabled(false);
            txtnombre.setText("");
            txtapellido.setEnabled(false);
            txtapellido.setText("");
        }
    }//GEN-LAST:event_rdbbnfechaActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void rdbnnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbnnumeroActionPerformed
        // TODO add your handling code here:
        if (rdbnnumero.isSelected() == true) {
            txtnumero.setEnabled(true);
            txtnumero.requestFocus();
            jDateChooser1.setDate(null);
            jDateChooser1.setEnabled(false);
            jDateChooser2.setDate(null);
            jDateChooser2.setEnabled(false);
            txtnombre.setEnabled(false);
            txtnombre.setText("");
            txtapellido.setEnabled(false);
            txtapellido.setText("");

        }
    }//GEN-LAST:event_rdbnnumeroActionPerformed

    private void txtnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroKeyTyped
        if (rdbnnumero.isSelected()) {
            char cteclapress = evt.getKeyChar();

            if (cteclapress == KeyEvent.VK_ENTER) {

                btnbuscador.doClick();
            }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroKeyTyped

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        this.dispose();
        JFrame aux = new VentanaVenta();
        aux.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        this.dispose();
        JFrame aux = new PagarCredito();
        aux.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuRepStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRepStockActionPerformed
        this.dispose();
        JFrame aux = new ConsultasFacturas();
        aux.setVisible(true);
    }//GEN-LAST:event_jMenuRepStockActionPerformed

    private void jMenuRepStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRepStock1ActionPerformed
        this.dispose();
        try {
            JasperReport reportes = JasperCompileManager.compileReport("C:\\reportes\\ReporteStock.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportes, null, conex.getconexion());

            viewer.setSize(1000, 700);
            viewer.setLocationRelativeTo(null);
            JRViewer jrv = new JRViewer(jasperPrint);
            viewer.getContentPane().add(jrv);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRepStock1ActionPerformed

    private void jMenuRepDeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRepDeuActionPerformed
        this.dispose();
        try {
            JasperReport reported = JasperCompileManager.compileReport("C:\\reportes\\ReporteDeudores.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reported, null, conex.getconexion());

            viewer2.setSize(1000, 700);
            viewer2.setLocationRelativeTo(null);
            JRViewer jrv = new JRViewer(jasperPrint);
            viewer2.getContentPane().add(jrv);
            viewer2.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRepDeuActionPerformed

    private void jMenuHistVentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHistVentas1ActionPerformed
        this.dispose();
        JFrame aux = new BuscadorRepVentas();
        aux.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuHistVentas1ActionPerformed

    private void jMenuEstCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEstCuActionPerformed
        String ced = JOptionPane.showInputDialog("ingrese ci del cliente");
        if ((ced.equals("")) || (ced.equals("0"))) {
            JOptionPane.showMessageDialog(this, "Debe ingresar CI");
        } else if (ced.length() != 8) {
            JOptionPane.showMessageDialog(this, "La CI debe tener 8 dígitos");
        } else {
            int canting = Integer.parseInt(ced);
            this.dispose();
            try {

                Map parametro = new HashMap();
                parametro.put("ci", canting);

                JasperReport reported = JasperCompileManager.compileReport("C:\\reportes\\RepEst.jrxml");
                JasperPrint jasperPrint = JasperFillManager.fillReport(reported, parametro, conex.getconexion());

                viewer4.setSize(1000, 700);
                viewer4.setLocationRelativeTo(null);
                JRViewer jrv = new JRViewer(jasperPrint);
                viewer4.getContentPane().add(jrv);
                viewer4.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuEstCuActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        this.dispose();
        JFrame aux = new ABMMedioPago();
        aux.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        this.dispose();
        JFrame aux = new ABMUsuario();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.dispose();
        JFrame aux = new ABMProducto();

        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        this.dispose();
        JFrame aux = new ABMCliente();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        this.dispose();
        JFrame aux = new CerrarTurno();
        aux.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
        JFrame aux = new AperturaCaja();
        aux.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        this.dispose();
        JFrame aux = new MovimientoCaja();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        this.dispose();
        JFrame aux = new BajaMercaderia();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        JFrame aux = new CompraMercaderia();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuHistVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHistVentasActionPerformed
        this.dispose();
        JFrame aux= new ConsultaMovimiento();
        aux.setVisible(true);
    }//GEN-LAST:event_jMenuHistVentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultasFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultasFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscador;
    private javax.swing.ButtonGroup btngrupo;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuEstCu;
    private javax.swing.JMenuItem jMenuHistVentas;
    private javax.swing.JMenuItem jMenuHistVentas1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuRepDeu;
    private javax.swing.JMenuItem jMenuRepStock;
    private javax.swing.JMenuItem jMenuRepStock1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbnombre;
    private javax.swing.JRadioButton rdbbnfecha;
    private javax.swing.JRadioButton rdbnnumero;
    private javax.swing.JRadioButton rdbntodos;
    public static javax.swing.JTable tbfacturas;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnumero;
    // End of variables declaration//GEN-END:variables

    Conexion cc = new Conexion();
    Connection cn = cc.getconexion();

}
