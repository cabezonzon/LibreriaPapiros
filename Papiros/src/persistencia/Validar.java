/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Marcos
 */
public class Validar {

    public void validarLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras");
                }
                else if((int)e.getKeyChar()>32 && (int)e.getKeyChar()<=47
             ||(int)e.getKeyChar()>=58 && (int)e.getKeyChar()<=64
             || (int)e.getKeyChar()>=91 && (int)e.getKeyChar()<=96
             || (int)e.getKeyChar()>=123 && (int)e.getKeyChar()<=255){
                e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras");}
            }
        });

    }

    ;
    
    
    public void validarNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números");
                }
                else if((int)e.getKeyChar()>32 && (int)e.getKeyChar()<=45
               ||(int)e.getKeyChar()>=47 && (int)e.getKeyChar()<=47         
             ||(int)e.getKeyChar()>=58 && (int)e.getKeyChar()<=64
             || (int)e.getKeyChar()>=91 && (int)e.getKeyChar()<=96
             || (int)e.getKeyChar()>=123 && (int)e.getKeyChar()<=255){
                e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números");}
            ;}
        });

    }

    
    ;
    
      
    }

