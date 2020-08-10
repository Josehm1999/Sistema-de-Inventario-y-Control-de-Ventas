/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.Controllers.FacturasController;
import com.Controllers.ProductosController;
import com.DTO.FaccabDTO;
import com.DTO.FacdetDTO;
import com.Utilidades.GestionCeldas;
import com.Utilidades.GestionEncabezadoTabla;
import com.Utilidades.ModeloTabla;
import java.util.ArrayList;
import javax.swing.table.JTableHeader;

public class Factura extends javax.swing.JFrame {

    FacturasController FacC = new FacturasController();
    ProductosController ProC = new ProductosController();
    private int id = 7;
    ArrayList<FaccabDTO> listaFacturas;
    ArrayList<FacdetDTO> listarDetalles;
    ModeloTabla modelo;
    public Factura() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        construirTabla();
    }

    public void setId(int id) {
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(34, 24, 28));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 232, 234));
        jLabel1.setText("Factura:");

        Regresar.setBackground(new java.awt.Color(241, 48, 48));
        Regresar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Regresar.setForeground(new java.awt.Color(246, 232, 234));
        Regresar.setText("Regresar");
        Regresar.setBorder(null);
        Regresar.setBorderPainted(false);
        Regresar.setContentAreaFilled(false);
        Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Regresar.setDoubleBuffered(true);
        Regresar.setMaximumSize(new java.awt.Dimension(131, 41));
        Regresar.setMinimumSize(new java.awt.Dimension(131, 41));
        Regresar.setOpaque(true);
        Regresar.setPreferredSize(new java.awt.Dimension(131, 41));
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarMouseClicked(evt);
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        Catalogo_Productos cata = new Catalogo_Productos("Usuario");
        cata.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.rowAtPoint(evt.getPoint());
        int columna = jTable1.columnAtPoint(evt.getPoint());
            if(columna == 3){
                construirTablaDetalles(Integer.parseInt(jTable1.getValueAt(fila,0).toString()));
            }
    }//GEN-LAST:event_jTable1MouseClicked

    public void construirTabla() {
        listaFacturas = FacC.facturasByCliente(id);
        ArrayList<String> titulosList = new ArrayList();
        titulosList.add("");
        titulosList.add("Fecha de compra");
        titulosList.add("Monto Total");
        titulosList.add("");
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList, "Facturas");
        construirTabla(titulos, data);
    }
    public void construirTablaDetalles(int nrofac){
        listarDetalles = FacC.detallesByFactura(nrofac);
        ArrayList<String> titulosProductos = new ArrayList();
        titulosProductos.add("Nombre Artículo");
        titulosProductos.add("Precio");
        titulosProductos.add("Cantidad");
        String titulosP[] = new String[titulosProductos.size()];
        for (int i = 0; i < titulosP.length; i++) {
            titulosP[i] = titulosProductos.get(i);
        }
        Object[][] data1 = obtenerMatrizDatos(titulosProductos, "Detalles");
        construirTablaDetalle(titulosP, data1);
    }
private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList,String cate) {
    if(cate.equals("Detalles")){
        String informacion[][] = new String[listarDetalles.size()][titulosList.size()];
        for (int x = 0; x < informacion.length; x++) {
            System.out.println(ProC.SelectById(1).getNombre());
            informacion[x][0] = ProC.SelectById(listarDetalles.get(x).getIdArticulo()).getNombre()+ "";
            informacion[x][1] = listarDetalles.get(x).getPrecioUnidad() + "";
            informacion[x][2] = listarDetalles.get(x).getCantidad() + "";
        }
        return informacion;
    }else{
        String informacion[][] = new String[listaFacturas.size()][titulosList.size()];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = listaFacturas.get(x).getNroFactura() + "";
            informacion[x][1] = listaFacturas.get(x).getFechaFactura() + "";
            informacion[x][2] = listaFacturas.get(x).getMontoTotal() + "";
            informacion[x][3] = "BUSCAR";
        }
        return informacion;
    }
    }

private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos,"Usuario");
        
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("numerico"));
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("numerico"));
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("icono"));
        
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setRowHeight(25);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(45);
        
     
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        jTable1.setTableHeader(jtableHeader);
    }
private void construirTablaDetalle(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos,"Usuario");
        
        jTable2.setModel(modelo);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        jTable2.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("numerico"));
        jTable2.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("numerico"));      
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setRowHeight(25);
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));

        jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(200);
    
        
     
        JTableHeader jtableHeader = jTable2.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        jTable2.setTableHeader(jtableHeader);
    }

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
