/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Indicadores;
import dominio.producto;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Validar;
import persistencia.repositorioProducto;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
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
public class ABMProducto extends javax.swing.JFrame {

    DefaultComboBoxModel mdlCamara = new DefaultComboBoxModel();
    Validar v = new Validar();
    JDialog viewer = new JDialog(new JFrame(), "ReporteStock", true);
    JDialog viewer2 = new JDialog(new JFrame(), "Historial de Ventas", true);
    JDialog viewer4 = new JDialog(new JFrame(), "Estado de cuenta", true);
    persistencia.Conexion conex = new persistencia.Conexion();

    /**
     * Creates new form ABMProducto
     */
    public ABMProducto() {
        initComponents();
        cargarIndicadores();
        v.validarLetras(txtNombre);
        v.validarNumeros(txtPrecio);
        v.validarLetras(txtbuscar);

        this.setTitle("Gestion de los datos de los Productos");
        mostrardatos("");
        btnmodificar.setEnabled(false);

    }

    private boolean validar() {
        try {
            if ("".equals(txtNombre.getText())) {
                JOptionPane.showMessageDialog(null, "El campo nombre está vacio");
                return false;
            } else if ("".equals(txtPrecio.getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio está vacío");
                return false;
            } else if ("".equals(txtDescripcion.getText())) {
                JOptionPane.showMessageDialog(null, "El campo descripción está vacío");
                return false;
            } else if ("".equals(txtCodigo.getText())){
                JOptionPane.showMessageDialog(null, "El campo codigo esta vacio");
                return false;
            }
        } catch (HeadlessException e) {
            System.out.println("hola");

        }

        return true;
    }

    void mostrardatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("DESCRIPCION");
        
        jTableProducto.setModel(modelo);

        repositorioProducto.getInstancia().rellenarModeloProducto(modelo, valor);
        jTableProducto.setModel(modelo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducto = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        btnmodificar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnMostrarProducto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboIndicador = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
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

        jMenuItem1.setText("modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Baja");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de productos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 140, -1));

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 140, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 140, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 40, 40));

        jTableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableProducto.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTableProducto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 630, 170));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 40, 40));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 90, -1));

        btnMostrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/show all.png"))); // NOI18N
        btnMostrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 50, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 40, 40));

        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 130));

        jLabel1.setText("Volver");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabel3.setText("Precio:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        jLabel5.setText("Descripción:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        jLabel6.setText("Guardar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jLabel7.setText("Modificar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jLabel9.setText("Mostrar todo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        cboIndicador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cboIndicador, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 140, -1));

        jLabel8.setText("Indicador:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLabel10.setText("Codigo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 140, -1));

        jLabel11.setText("Buscar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jLabel4.setBorder(dropShadowBorder1);
        jLabel4.setMaximumSize(new java.awt.Dimension(680, 600));
        jLabel4.setMinimumSize(new java.awt.Dimension(680, 600));
        jLabel4.setPreferredSize(new java.awt.Dimension(680, 600));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        jMenuItem13.setText("Compra de Mercadería");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (validar()) {

            producto pro = new producto();
            Indicadores med = (Indicadores) cboIndicador.getSelectedItem();
            Integer medio = med.getIdIdentificador();
            pro.setIdicador(medio);
            pro.setNombre(txtNombre.getText());
            pro.setPrecio(Integer.parseInt(txtPrecio.getText()));
            pro.setDescripcion(txtDescripcion.getText());
            pro.setIdProducto(Integer.parseInt(txtCodigo.getText()));

            repositorioProducto rep = repositorioProducto.getInstancia();
            rep.guardarProducto(pro);
            JOptionPane.showMessageDialog(null, "Se guardo el nuevo Producto con exito");
            mostrardatos("");
            txtNombre.setText("");
            txtPrecio.setText("");
            txtDescripcion.setText("");
            txtCodigo.setText("");

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila = jTableProducto.getSelectedRow();
        if (fila >= 0) {
            txtNombre.setText(jTableProducto.getValueAt(fila, 1).toString());
            txtPrecio.setText(jTableProducto.getValueAt(fila, 2).toString());
            txtDescripcion.setText(jTableProducto.getValueAt(fila, 3).toString());
            txtCodigo.setText(jTableProducto.getValueAt(fila, 0).toString());
            btnGuardar.setEnabled(false);
            btnmodificar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila");

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {

            DefaultTableModel tm = (DefaultTableModel) jTableProducto.getModel();
            producto pro = new producto();

            pro.setIdProducto(Integer.parseInt((String) tm.getValueAt(jTableProducto.getSelectedRow(), 0)));

            repositorioProducto rep = repositorioProducto.getInstancia();
            rep.darbajaProducto(pro);
            mostrardatos("");
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        JOptionPane.showMessageDialog(null, "El Producto fue dado de baja");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed

        DefaultTableModel tm = (DefaultTableModel) jTableProducto.getModel();
        producto pro = new producto();
        Indicadores med = (Indicadores) cboIndicador.getSelectedItem();
        Integer medio = med.getIdIdentificador();
        pro.setIdicador(medio);
        pro.setNombre(txtNombre.getText());
        pro.setPrecio(Integer.parseInt(txtPrecio.getText()));
        pro.setDescripcion(txtDescripcion.getText());
        pro.setIdProducto(Integer.parseInt(txtCodigo.getText()));
        //pro.setIdProducto(Integer.parseInt((String) tm.getValueAt(jTableProducto.getSelectedRow(), 0)));
        repositorioProducto rep = repositorioProducto.getInstancia();
        rep.guardarProducto(pro);
        JOptionPane.showMessageDialog(null, "El producto se modifico con exito");
        btnGuardar.setEnabled(true);
        btnmodificar.setEnabled(false);

        mostrardatos("");

        txtNombre.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
        txtCodigo.setText("");


    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnMostrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProductoActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
        txtbuscar.setText("");
    }//GEN-LAST:event_btnMostrarProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        //JFrame aux = new MenuPrincipal();
        //aux.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.dispose();
        JFrame aux = new MenuPrincipal();
        aux.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char cteclapress = evt.getKeyChar();

        if (cteclapress == KeyEvent.VK_ENTER) {
            txtPrecio.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char cteclapress = evt.getKeyChar();

        if (cteclapress == KeyEvent.VK_ENTER) {
            txtDescripcion.requestFocus();
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        char cteclapress = evt.getKeyChar();

        if (cteclapress == KeyEvent.VK_ENTER) {
            if (btnGuardar.isEnabled()) {
                btnGuardar.doClick();
            } else {
                btnmodificar.doClick();
            }
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrardatos(txtbuscar.getText());


    }//GEN-LAST:event_txtbuscarKeyReleased

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

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        this.dispose();
        JFrame aux = new CompraMercaderia();
        aux.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

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
        JFrame aux = new ConsultaMovimiento();
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
            java.util.logging.Logger.getLogger(ABMProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABMProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABMProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABMProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABMProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMostrarProducto;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JComboBox cboIndicador;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuRepDeu;
    private javax.swing.JMenuItem jMenuRepStock;
    private javax.swing.JMenuItem jMenuRepStock1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
private void cargarIndicadores() {
        mdlCamara.removeAllElements();
        cboIndicador.setModel(mdlCamara);
        List<Indicadores> lista = repositorioProducto.getInstancia().listaIndicadores();
        for (Indicadores c : lista) {
            mdlCamara.addElement(c);

        }
    }
}