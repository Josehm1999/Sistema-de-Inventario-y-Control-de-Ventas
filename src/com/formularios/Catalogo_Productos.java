/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.Controllers.ProductosController;
import com.DTO.ProductosDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.Utilidades.GestionCeldas;
import com.Utilidades.GestionEncabezadoTabla;
import com.Utilidades.ModeloTabla;
import com.Utilidades.Utilidades;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.table.JTableHeader;

public class Catalogo_Productos extends javax.swing.JFrame {

    ProductosController ProController = new ProductosController();
    RegistroProducto RegistroPro;
    CarroCompra CarroC;
    ArrayList<ProductosDTO> listaProductos;
    ModeloTabla modelo;
    private int id = 0;

    public Catalogo_Productos(String Perfil1) {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        LlenarDatosCBX();
        Perfil.setText(Perfil1);
        construirTabla(null);
        Guardar_Todo.setVisible(false);
        Facturas.setVisible(false);
        if ("Administrador".equals(Perfil1)) {
            Guardar_Todo.setVisible(true);
            RegistroPro = new RegistroProducto();
            jPanel5.add(RegistroPro);
        } else {
            Facturas.setVisible(true);
            CarroC = new CarroCompra();
            jPanel5.add(CarroC);
        }
        ImageIcon iconoGuardar = new ImageIcon(getClass().getResource("/imagenes/ico_guardar.png"));
        Image img1 = iconoGuardar.getImage().getScaledInstance(Guardar_Todo.getWidth(), Guardar_Todo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img1);
        Guardar_Todo.setIcon(i);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void construirTabla(String categoria) {
        if (categoria == null) {
            listaProductos = ProController.ListaProductos();
        } else {
            listaProductos = ProController.SelectByCategory(categoria);
        }
        ArrayList<String> titulosList = new ArrayList();
        titulosList.add("Código");
        titulosList.add("Nombre");
        titulosList.add("Descripción");
        titulosList.add("Categoría");
        titulosList.add("Precio");
        titulosList.add("Stock");
        if ("Administrador".equals(Perfil.getText())) {
            titulosList.add("");
        } else {
            titulosList.add("Cantidad");
        }
        titulosList.add("");
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
        String informacion[][] = new String[listaProductos.size()][titulosList.size()];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][Utilidades.COD_PRO] = listaProductos.get(x).getCod_Pro() + "";
            informacion[x][Utilidades.NOMBRE] = listaProductos.get(x).getNombre() + "";
            informacion[x][Utilidades.DESCRIPCION] = listaProductos.get(x).getDescripcion() + "";
            informacion[x][Utilidades.CATEGORIA] = listaProductos.get(x).getCategoria() + "";
            informacion[x][Utilidades.PRECIO] = listaProductos.get(x).getPrecio() + "";
            informacion[x][Utilidades.STOCK] = listaProductos.get(x).getStock() + "";
            informacion[x][Utilidades.EVENTO] = "EVENTO";
            if ("Administrador".equals(Perfil.getText())) {
                informacion[x][Utilidades.DESC] = "DESC";
            } else {
                informacion[x][Utilidades.DESC] = "0";
            }
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos, Perfil.getText());
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(Utilidades.PRECIO).setCellRenderer(new GestionCeldas("numerico"));
        jTable1.getColumnModel().getColumn(Utilidades.STOCK).setCellRenderer(new GestionCeldas("numerico"));
        jTable1.getColumnModel().getColumn(Utilidades.DESC).setCellRenderer(new GestionCeldas("numerico"));
        jTable1.getColumnModel().getColumn(Utilidades.EVENTO).setCellRenderer(new GestionCeldas("icono"));
        if ("Administrador".equals(Perfil.getText())) {
            jTable1.getColumnModel().getColumn(Utilidades.DESC).setCellRenderer(new GestionCeldas("icono"));
            for (int i = 0; i < titulos.length - 5; i++) {
                jTable1.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
            }
        } else {
            for (int i = 0; i < titulos.length - 4; i++) {
                jTable1.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
            }
        }
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setRowHeight(25);//tamaño de las celdas
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));

        jTable1.getColumnModel().getColumn(Utilidades.COD_PRO).setPreferredWidth(75);
        jTable1.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(380);
        jTable1.getColumnModel().getColumn(Utilidades.DESCRIPCION).setPreferredWidth(350);
        jTable1.getColumnModel().getColumn(Utilidades.PRECIO).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(Utilidades.STOCK).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(Utilidades.CATEGORIA).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(Utilidades.EVENTO).setPreferredWidth(40);
        if ("Administrador".equals(Perfil.getText())) {
            jTable1.getColumnModel().getColumn(Utilidades.DESC).setPreferredWidth(40);

        } else {
            jTable1.getColumnModel().getColumn(Utilidades.DESC).setPreferredWidth(75);
        }
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        jTable1.setTableHeader(jtableHeader);
    }

    private void validarSeleccionMouse(int fila) {

        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea actualizar el producto ?", "Salir", dialog);
        if (result == 0) {
            ProductosDTO producto = new ProductosDTO();
            producto.setCod_Pro(Integer.parseInt(jTable1.getValueAt(fila, Utilidades.COD_PRO).toString()));
            producto.setNombre(jTable1.getValueAt(fila, Utilidades.NOMBRE).toString());
            producto.setDescripcion(jTable1.getValueAt(fila, Utilidades.DESCRIPCION).toString());
            producto.setPrecio(Double.parseDouble(jTable1.getValueAt(fila, Utilidades.PRECIO).toString()));
            producto.setStock(Integer.parseInt(jTable1.getValueAt(fila, Utilidades.STOCK).toString()));
            producto.setCategoria(jTable1.getValueAt(fila, Utilidades.CATEGORIA).toString());
            ProController.Actualizar(producto);
            construirTabla(null);
        }
    }

   

    private void AñadirACompra(int fila) {
        int cantidad = Integer.parseInt(jTable1.getValueAt(fila, Utilidades.DESC).toString());
        if (cantidad > Integer.parseInt(jTable1.getValueAt(fila, Utilidades.STOCK).toString()) || cantidad == 0) {
            JOptionPane.showMessageDialog(null, "Ha escogido más productos de los que tenemos o nos has escogido ninguno", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ProductosDTO producto = new ProductosDTO();
            producto.setCod_Pro(Integer.parseInt(jTable1.getValueAt(fila, Utilidades.COD_PRO).toString()));
            producto.setNombre(jTable1.getValueAt(fila, Utilidades.NOMBRE).toString());
            producto.setDescripcion(jTable1.getValueAt(fila, Utilidades.DESCRIPCION).toString());
            producto.setPrecio(Double.parseDouble(jTable1.getValueAt(fila, Utilidades.PRECIO).toString()));
            producto.setStock(Integer.parseInt(jTable1.getValueAt(fila, Utilidades.STOCK).toString()) - cantidad);
            producto.setCategoria(jTable1.getValueAt(fila, Utilidades.CATEGORIA).toString());
            ProController.Actualizar(producto);
            CarroC.AñadirProductos(producto, cantidad);
            CarroC.setId(id);
        }
    }

    private void validarBorrar(int fila) {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea borrar el producto ?", "Salir", dialog);
        if (result == 0) {
            int cod_Pro = Integer.parseInt(jTable1.getValueAt(fila, Utilidades.COD_PRO).toString());
            ProController.BorrarElemento(cod_Pro);
        }

    }

    public void LlenarDatosCBX() {
        ArrayList cate = ProController.Categorias();
        Categorias.addItem("Categorías");
        for (int i = 0; i < cate.size(); i++) {
            Categorias.addItem(cate.get(i).toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Categorias = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Guardar_Todo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Nombre_usu = new javax.swing.JLabel();
        Perfil = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Facturas = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(34, 24, 28));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(246, 232, 234)));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 232, 234));
        jLabel1.setText("Cátalogo de productos:");

        Categorias.setBackground(new java.awt.Color(241, 48, 48));
        Categorias.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Categorias.setForeground(new java.awt.Color(246, 232, 234));
        Categorias.setToolTipText("");
        Categorias.setBorder(null);
        Categorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriasActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        Guardar_Todo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Guardar_TodoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Guardar_Todo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Guardar_Todo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 670, 430));

        jPanel3.setBackground(new java.awt.Color(241, 48, 48));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(241, 48, 48));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 40, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 0, 40, 60));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 232, 234));
        jLabel5.setText("SyC");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 40));

        Nombre_usu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Nombre_usu.setForeground(new java.awt.Color(246, 232, 234));
        jPanel3.add(Nombre_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 250, 30));

        Perfil.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Perfil.setForeground(new java.awt.Color(246, 232, 234));
        Perfil.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 130, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 60));

        jPanel4.setBackground(new java.awt.Color(34, 24, 28));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(246, 232, 234)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Facturas.setBackground(new java.awt.Color(241, 48, 48));
        Facturas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Facturas.setForeground(new java.awt.Color(246, 232, 234));
        Facturas.setText("Ver facturas");
        Facturas.setBorder(null);
        Facturas.setBorderPainted(false);
        Facturas.setContentAreaFilled(false);
        Facturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Facturas.setDoubleBuffered(true);
        Facturas.setMaximumSize(new java.awt.Dimension(131, 41));
        Facturas.setMinimumSize(new java.awt.Dimension(131, 41));
        Facturas.setOpaque(true);
        Facturas.setPreferredSize(new java.awt.Dimension(131, 41));
        Facturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacturasMouseClicked(evt);
            }
        });
        jPanel4.add(Facturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 150, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 910, 50));

        jPanel5.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 240, 430));

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

    private void CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasActionPerformed
        String cate = Categorias.getSelectedItem().toString();
        if (cate.equals("Categorías")) {
            construirTabla(null);
        } else {
            construirTabla(cate);
        }

    }//GEN-LAST:event_CategoriasActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.rowAtPoint(evt.getPoint());
        int columna = jTable1.columnAtPoint(evt.getPoint());
        if ("Administrador".equals(Perfil.getText())) {
            if (columna == Utilidades.DESC) {
                validarBorrar(fila);
                construirTabla(null);
            } else if (columna == Utilidades.EVENTO) {
                validarSeleccionMouse(fila);
                construirTabla(null);
            }
        } else {
            if (columna == Utilidades.EVENTO) {
                AñadirACompra(fila);
                construirTabla(null);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void Guardar_TodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar_TodoMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea actualizar todos los producto ?", "Salir", dialog);
        int rows = jTable1.getRowCount();
        ArrayList<ProductosDTO> productos = new ArrayList<>();
        if (result == 0) {
            for (int i = 0; i < rows; i++) {
                ProductosDTO producto = new ProductosDTO();
                producto.setCod_Pro(Integer.parseInt(jTable1.getValueAt(i, Utilidades.COD_PRO).toString()));
                producto.setNombre(jTable1.getValueAt(i, Utilidades.NOMBRE).toString());
                producto.setDescripcion(jTable1.getValueAt(i, Utilidades.DESCRIPCION).toString());
                producto.setPrecio(Double.parseDouble(jTable1.getValueAt(i, Utilidades.PRECIO).toString()));
                producto.setStock(Integer.parseInt(jTable1.getValueAt(i, Utilidades.STOCK).toString()));
                producto.setCategoria(jTable1.getValueAt(i, Utilidades.CATEGORIA).toString());
                productos.add(producto);
                
            }
            ProController.ActualizarTodo(productos);
            construirTabla(null);
        }
    }//GEN-LAST:event_Guardar_TodoMouseClicked

    private void FacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacturasMouseClicked
            Factura fac = new Factura();
            fac.setId(id);
            fac.setVisible(true);
    }//GEN-LAST:event_FacturasMouseClicked
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
            java.util.logging.Logger.getLogger(Catalogo_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogo_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogo_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogo_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Catalogo_Productos("Usuario").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Categorias;
    private javax.swing.JButton Facturas;
    private javax.swing.JLabel Guardar_Todo;
    public static javax.swing.JLabel Nombre_usu;
    public static javax.swing.JLabel Perfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
