/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.Controllers.UsuarioController;
import javax.swing.JOptionPane;

/**
 *
 * @author joseh
 */
public class Recuperar extends javax.swing.JFrame {

    UsuarioController controller = new UsuarioController();

    public Recuperar() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public Boolean ValidarCampos() {
        String correo = Correo.getText();
        String nombre = Nombre.getText();
        String nclave = NClave.getText();
        String cclave = CClave.getText();

        if (correo.trim().equals("") || nombre.trim().equals("") || nclave.trim().equals("") || cclave.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Uno o más campos se encuentran vacíos", "Error: Campos vacíos", 2);
            return false;
        } else if (nclave.trim().length() < 8) {
            JOptionPane.showMessageDialog(null, "La nueva clave tiene que tener mínimo 8 dígitos", "Error: Clave débil", 2);
            return false;
        } else if (!nclave.equals(cclave)) {
            JOptionPane.showMessageDialog(null, "Las claves ingresadas no coinciden", "Error: Claves diferentes", 2);
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Correo = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Recuperar = new javax.swing.JButton();
        Label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Iniciar_S = new javax.swing.JLabel();
        NClave = new javax.swing.JPasswordField();
        CClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 48, 48));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 232, 234));
        jLabel1.setText("Recuperar contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));

        jLabel2.setForeground(new java.awt.Color(241, 48, 48));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        jPanel2.setBackground(new java.awt.Color(34, 24, 28));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(246, 232, 234)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(246, 232, 234));
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 78, -1, 30));

        Correo.setForeground(new java.awt.Color(28, 48, 65));
        Correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Correo.setBorder(null);
        jPanel2.add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 47, 292, 30));

        Nombre.setForeground(new java.awt.Color(28, 48, 65));
        Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nombre.setBorder(null);
        jPanel2.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 119, 292, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(246, 232, 234));
        jLabel6.setText("Correo electrónico");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 11, -1, 30));

        Recuperar.setBackground(new java.awt.Color(241, 48, 48));
        Recuperar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Recuperar.setForeground(new java.awt.Color(246, 232, 234));
        Recuperar.setText("Recuperar");
        Recuperar.setBorder(null);
        Recuperar.setBorderPainted(false);
        Recuperar.setContentAreaFilled(false);
        Recuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Recuperar.setMaximumSize(new java.awt.Dimension(131, 41));
        Recuperar.setMinimumSize(new java.awt.Dimension(131, 41));
        Recuperar.setOpaque(true);
        Recuperar.setPreferredSize(new java.awt.Dimension(131, 41));
        Recuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecuperarActionPerformed(evt);
            }
        });
        jPanel2.add(Recuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 308, -1, 40));

        Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Label.setForeground(new java.awt.Color(246, 232, 234));
        Label.setText("Confirme contraseña");
        jPanel2.add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 222, -1, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 232, 234));
        jLabel7.setText("Nueva contraseña");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 155, -1, 30));

        Iniciar_S.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        Iniciar_S.setForeground(new java.awt.Color(246, 232, 234));
        Iniciar_S.setText("Iniciar Sesión");
        Iniciar_S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Iniciar_SMouseClicked(evt);
            }
        });
        jPanel2.add(Iniciar_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        NClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NClave.setBorder(null);
        jPanel2.add(NClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 190, 292, 30));

        CClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CClave.setBorder(null);
        jPanel2.add(CClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 260, 292, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir de la aplicación", "Salir", dialog);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(LoginForm.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void RecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecuperarActionPerformed
        String correo = Correo.getText();
        String nombre = Nombre.getText();
        String clave = NClave.getText();

        if (ValidarCampos()) {
            if (controller.Recuperar(correo, nombre, clave)) {
                LoginForm login = new LoginForm();
                login.setVisible(true);
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Ha actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error: Tal vez no estes registrado o los datos ingresados son invalidos");
            }
        }
    }//GEN-LAST:event_RecuperarActionPerformed

    private void Iniciar_SMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Iniciar_SMouseClicked
        LoginForm login = new LoginForm();
        login.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_Iniciar_SMouseClicked

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
            java.util.logging.Logger.getLogger(Recuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recuperar().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CClave;
    private javax.swing.JTextField Correo;
    private javax.swing.JLabel Iniciar_S;
    private javax.swing.JLabel Label;
    private javax.swing.JPasswordField NClave;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton Recuperar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
