/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.Controllers.ProductosController;

import javax.swing.JOptionPane;

public class RegistroProducto extends javax.swing.JPanel {

    ProductosController controller = new ProductosController();

    public RegistroProducto() {
        initComponents();
    }

    public Boolean ValidarCampos() {
        String nombre = Nombre.getText();
        String descripcion = Descripcion.getText();
        String precio = Precio.getText();
        String stock = Cantidad.getText();
        String categoria = Categoria.getText();

        if (nombre.trim().equals("") || descripcion.trim().equals("") || precio.trim().equals("") || stock.trim().equals("") || categoria.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Uno o más campos se encuentran vacíos", "Error: Campos vacíos", 2);
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Crear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Categoria = new javax.swing.JTextField();
        Descripcion = new javax.swing.JTextField();
        Cantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Precio = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(240, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(34, 24, 28));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(246, 232, 234)));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(246, 232, 234));
        jLabel6.setText("Nombre:");

        Crear.setBackground(new java.awt.Color(241, 48, 48));
        Crear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Crear.setForeground(new java.awt.Color(246, 232, 234));
        Crear.setText("Crear");
        Crear.setBorder(null);
        Crear.setBorderPainted(false);
        Crear.setContentAreaFilled(false);
        Crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Crear.setMaximumSize(new java.awt.Dimension(131, 41));
        Crear.setMinimumSize(new java.awt.Dimension(131, 41));
        Crear.setOpaque(true);
        Crear.setPreferredSize(new java.awt.Dimension(131, 41));
        Crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 232, 234));
        jLabel5.setText("Cantidad");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 232, 234));
        jLabel7.setText("Descripción:");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(246, 232, 234));
        jLabel8.setText("Categoría:");

        Categoria.setForeground(new java.awt.Color(28, 48, 65));
        Categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Categoria.setBorder(null);

        Descripcion.setForeground(new java.awt.Color(28, 48, 65));
        Descripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Descripcion.setBorder(null);

        Cantidad.setForeground(new java.awt.Color(28, 48, 65));
        Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cantidad.setBorder(null);
        Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantidadKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(246, 232, 234));
        jLabel11.setText("Precio:");

        Precio.setForeground(new java.awt.Color(28, 48, 65));
        Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Precio.setBorder(null);
        Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrecioKeyTyped(evt);
            }
        });

        Nombre.setForeground(new java.awt.Color(28, 48, 65));
        Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nombre.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(246, 232, 234));
        jLabel10.setText("Añada un nuevo producto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void PrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrecioKeyTyped
        char[] p = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
        int b = 0;
        for (int i = 0; i <= 10; i++) {
            if (p[i] == evt.getKeyChar()) {
                b = 1;
            }
        }
        if (b == 0) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_PrecioKeyTyped

    private void CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_CantidadKeyTyped

    private void CrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearMouseClicked
        String nombre = Nombre.getText();
        String descripcion = Descripcion.getText();
        String precio = Precio.getText();
        String stock = Cantidad.getText();
        String categoria = Categoria.getText();
        if (ValidarCampos()) {
            controller.Crear(nombre, descripcion, precio, stock, categoria);
            Catalogo_Productos Cata = new Catalogo_Productos("Administrador");
            Nombre.setText("");
            Descripcion.setText("");
            Precio.setText("");
            Cantidad.setText("");
            Categoria.setText("");
            JOptionPane.showMessageDialog(null, "Ha creado un producto correctamente");
            Cata.construirTabla(null);
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error:los datos ingresados son invalidos");
        }
         
    }//GEN-LAST:event_CrearMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad;
    private javax.swing.JTextField Categoria;
    private javax.swing.JButton Crear;
    private javax.swing.JTextField Descripcion;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Precio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
