/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.apertura_cierre;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Validar;
import persistencia.repositorioAperturaCierre;
import persistencia.repositorioUsuario;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import persistencia.Conexion;

/**
 *
 * @author Matias
 */
public class AperturaCaja extends javax.swing.JFrame {

    /**
     * Creates new form AperturaCaja
     */
    Validar v = new Validar();
    JDialog viewer = new JDialog(new JFrame(), "ReporteStock", true);
    JDialog viewer2 = new JDialog(new JFrame(), "Historial de Ventas", true);
     JDialog viewer4 = new JDialog(new JFrame(),"Estado de cuenta",true);
    persistencia.Conexion conex = new persistencia.Conexion();

    public AperturaCaja() {
        initComponents();

        v.validarNumeros(jTextFieldMontoA);

        //mostrardatos("");
        String[] meses = {"Mañana", "Noche"};
        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel(meses));
    }

    /*    void mostrardatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("FECHA");
        modelo.addColumn("MONTO_APERTURA");
        modelo.addColumn("MONTO_CIERRE");
        modelo.addColumn("TURNO");
        modelo.addColumn("ESTADO");
//        modelo.addColumn("Id_EMPLEADO");
        jTableA.setModel(modelo);

        repositorioAperturaCierre.getInstancia().rellenarModeloApertura(modelo, valor);
        jTableA.setModel(modelo);

    }*/
    private boolean validar() {
        try {
            if ("".equals(jTextFieldMontoA.getText())) {
                JOptionPane.showMessageDialog(null, "El campo monto está vacio");
                return false;
            }
        } catch (HeadlessException e) {
            System.out.println(e.getMessage());

        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldMontoA = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        setTitle("Apertura de caja");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldMontoA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMontoAKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldMontoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 90, -1));

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurnoActionPerformed(evt);
            }
        });
        jComboBoxTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBoxTurnoKeyTyped(evt);
            }
        });
        getContentPane().add(jComboBoxTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 90, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 40, 40));

        jLabel2.setText("Monto Apertura");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel3.setText("Turno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 40, 40));

        jLabel4.setText("Guardar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        jLabel5.setText("Volver");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jLabel1.setBorder(dropShadowBorder1);
        jLabel1.setMaximumSize(new java.awt.Dimension(680, 600));
        jLabel1.setMinimumSize(new java.awt.Dimension(680, 600));
        jLabel1.setPreferredSize(new java.awt.Dimension(680, 600));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 600));

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

    private void jTextFieldMontoAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMontoAKeyTyped

        char car = evt.getKeyChar();
        if (jTextFieldMontoA.getText().length() >= 9) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        char cteclapress = evt.getKeyChar();

        if (cteclapress == KeyEvent.VK_ENTER) {
            jComboBoxTurno.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldMontoAKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validar()) {
            Integer modeloo = null;
            repositorioUsuario u = repositorioUsuario.getInstancia();
            Integer idUsuario = u.obtenerIdUsuario(modeloo, Acceso.txtusuario.getText(), Acceso.txtcontra.getText());
            Date fec = new Date();
            apertura_cierre ap = new apertura_cierre();
            String modelo = null;
            repositorioAperturaCierre rep = repositorioAperturaCierre.getInstancia();
            String resultado = rep.obtenerEstado(modelo);
            ap.setFecha(new java.sql.Date(fec.getTime()));
            ap.setMonto_apertura(Integer.parseInt(jTextFieldMontoA.getText()));
            ap.setTurno((String) jComboBoxTurno.getSelectedItem());
            ap.setIdUsuario(idUsuario);
            if (resultado == null) {
                rep.guardarAp_Ci(ap);
                JOptionPane.showMessageDialog(null, "La apertura de caja se realizo con exito");
                this.dispose();
                
            } else if (resultado.equals("Activa")) {
                JOptionPane.showMessageDialog(null, "Ya existe una caja abierta, por favor cierre la anterior");
                this.dispose();
                
            } else if (resultado.equals("Cerrada")) {
                rep.guardarAp_Ci(ap);
                JOptionPane.showMessageDialog(null, "La apertura de caja se realizo con exito");
                this.dispose();
               
            }
            // mostrardatos("");
            jTextFieldMontoA.setText("");

        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
//JFrame aux = new MenuPrincipal();
//aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxTurnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTurnoKeyTyped
        char cteclapress = evt.getKeyChar();

        if (cteclapress == KeyEvent.VK_ENTER) {
            btnGuardar.doClick();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTurnoKeyTyped

    private void jComboBoxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTurnoActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        this.dispose();
        JFrame aux = new ABMCliente();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.dispose();
        JFrame aux = new ABMProducto();

        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        this.dispose();
        JFrame aux = new ABMUsuario();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        this.dispose();
        JFrame aux = new ABMMedioPago();
        aux.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        this.dispose();
        JFrame aux = new VentanaVenta();
        aux.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        JFrame aux = new CompraMercaderia();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        this.dispose();
        JFrame aux = new BajaMercaderia();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        this.dispose();
        JFrame aux = new MovimientoCaja();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
        JFrame aux = new AperturaCaja();
        aux.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        this.dispose();
        JFrame aux = new CerrarTurno();
        aux.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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

    private void jMenuHistVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHistVentasActionPerformed
        this.dispose();
        JFrame aux= new ConsultaMovimiento();
        aux.setVisible(true);
    }//GEN-LAST:event_jMenuHistVentasActionPerformed

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AperturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AperturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AperturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AperturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AperturaCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTextField jTextFieldMontoA;
    // End of variables declaration//GEN-END:variables
}
