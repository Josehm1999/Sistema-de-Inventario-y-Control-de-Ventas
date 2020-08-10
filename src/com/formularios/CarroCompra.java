/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.Controllers.*;
import com.DTO.ProductosDTO;
import com.Utilidades.ModeloTabla;
import java.util.ArrayList;
import javax.swing.table.JTableHeader;
import com.Utilidades.GestionCeldas;
import com.Utilidades.GestionEncabezadoTabla;

import javax.swing.JOptionPane;

public class CarroCompra extends javax.swing.JPanel {

    ModeloTabla modelo;
    ArrayList<ProductosDTO> Cproductos = null;
    private int cantidad = 0;
    ProductosController ProduC = new ProductosController();
    FacturasController FacC = new FacturasController();
    int id = 0;

    public CarroCompra() {
        initComponents();
        AñadirProductos(null, 0);
        construirTabla();
    }

    public void AñadirProductos(ProductosDTO productos, int cantidad) {
        if (Cproductos == null) {
            Cproductos = new ArrayList<>();
        } else {
            Cproductos.add(productos);
            this.cantidad = cantidad;
            construirTabla();

        }
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("El id si llego " + id);
    }

    private void validarBorrar(int fila) {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea borrar el producto ?", "Salir", dialog);
        if (result == 0) {
            String nombre = jTable1.getValueAt(fila, 0).toString();
            Cproductos.removeIf(n -> n.getNombre().equals(nombre.trim()));
            ProductosDTO producto = ProduC.SelectByName(nombre);
            producto.setStock(producto.getStock() + cantidad);
            ProduC.Actualizar(producto);
        }
    }

    private void construirTabla() {
        ArrayList<String> titulosList = new ArrayList();
        titulosList.add("Nombre");
        titulosList.add("Cantidad");
        titulosList.add("");
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
        String informacion[][] = new String[Cproductos.size()][titulosList.size()];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][0] = Cproductos.get(x).getNombre() + "";
            informacion[x][1] = cantidad + "";
            informacion[x][2] = "DESC";
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos, null);
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("numerico"));
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("icono"));
        for (int i = 0; i < titulos.length - 2; i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setRowHeight(30);//tamaño de las celdas
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));

        jTable1.getColumnModel().getColumn(0).setMaxWidth(130);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(65);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(30);

        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        jTable1.setTableHeader(jtableHeader);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        GenerarFactura = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(34, 24, 28));
        setPreferredSize(new java.awt.Dimension(240, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(246, 232, 234));
        jLabel10.setText("Tu carrito: ");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        GenerarFactura.setBackground(new java.awt.Color(241, 48, 48));
        GenerarFactura.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        GenerarFactura.setForeground(new java.awt.Color(246, 232, 234));
        GenerarFactura.setText("Generar factura");
        GenerarFactura.setBorder(null);
        GenerarFactura.setBorderPainted(false);
        GenerarFactura.setContentAreaFilled(false);
        GenerarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GenerarFactura.setMaximumSize(new java.awt.Dimension(131, 41));
        GenerarFactura.setMinimumSize(new java.awt.Dimension(131, 41));
        GenerarFactura.setOpaque(true);
        GenerarFactura.setPreferredSize(new java.awt.Dimension(131, 41));
        GenerarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenerarFacturaMouseClicked(evt);
            }
        });
        add(GenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 140, 20));

        Limpiar.setBackground(new java.awt.Color(241, 48, 48));
        Limpiar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(246, 232, 234));
        Limpiar.setText("Limpiar");
        Limpiar.setBorder(null);
        Limpiar.setBorderPainted(false);
        Limpiar.setContentAreaFilled(false);
        Limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Limpiar.setMaximumSize(new java.awt.Dimension(131, 41));
        Limpiar.setMinimumSize(new java.awt.Dimension(131, 41));
        Limpiar.setOpaque(true);
        Limpiar.setPreferredSize(new java.awt.Dimension(131, 41));
        Limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimpiarMouseClicked(evt);
            }
        });
        add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 70, 20));

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
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 220, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.rowAtPoint(evt.getPoint());
        int columna = jTable1.columnAtPoint(evt.getPoint());
        if (columna == 2) {
            validarBorrar(fila);
            construirTabla();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void LimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiarMouseClicked
        int rows = jTable1.getRowCount();
        ArrayList<ProductosDTO> ALL = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ALL.add(ProduC.SelectByName(jTable1.getValueAt(i, 0).toString()));
            ALL.get(i).setStock(ALL.get(i).getStock() + Integer.parseInt(jTable1.getValueAt(i, 1).toString()));
        }
        ProduC.ActualizarTodo(ALL);
        Cproductos.clear();
        construirTabla();
    }//GEN-LAST:event_LimpiarMouseClicked

    private void GenerarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerarFacturaMouseClicked
        if (!Cproductos.isEmpty()) {
            int rows = jTable1.getRowCount();
            double total = 0;
            for (int i = 0; i < rows; i++) {
                int canti =Integer.parseInt(jTable1.getValueAt(i, 1).toString());
                total =+Cproductos.get(i).getPrecio()*canti;
                int id_factura = FacC.CrearFactura(id, total);
                FacC.AgregarProductos(id_factura, Cproductos.get(i).getCod_Pro(), canti, Cproductos.get(i).getPrecio() * canti);
            }
            JOptionPane.showMessageDialog(null, "La factura se ha generado sin problemas", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            Factura fac = new Factura();
            fac.setId(id);
            fac.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No puede generar una factura si el carrito se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_GenerarFacturaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerarFactura;
    private javax.swing.JButton Limpiar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
