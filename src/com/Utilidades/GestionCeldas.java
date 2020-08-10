package com.Utilidades;

import com.DTO.ProductosDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer {

    ProductosDTO productos = new ProductosDTO();
    private String tipo = "text";
    
    private Font bold = new Font("Yu Gothic UI", Font.BOLD, 14);
    private JLabel label = new JLabel();
    private ImageIcon iconoGuardar = new ImageIcon(getClass().getResource("/imagenes/ico_guardar.png"));
    private ImageIcon iconoBuscar = new ImageIcon(getClass().getResource("/imagenes/ico_buscar.png"));
    private ImageIcon iconoBorrar = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/borrar.png")));

    public GestionCeldas() {
    }

    public GestionCeldas(String tipo) {
        this.tipo = tipo;
       
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

        Color background = null;
        Color backgroundDefault = new Color(192, 192, 192);
        Color backgroundSelected = new Color(140, 140, 140);
        if (selected) {
            this.setBackground(backgroundDefault);
        } else {
            this.setBackground(Color.white);
        }

        if (tipo.equals("texto")) {
            if (focused) {
                background = backgroundSelected;
            } else {
                background = backgroundDefault;
            }
            this.setHorizontalAlignment(JLabel.LEFT);
            this.setText((String) value);
            this.setBackground((selected) ? background : Color.white);
            this.setFont(bold);
            return this;
        }
        if (tipo.equals("icono")) {
            if (String.valueOf(value).equals("DESC")) {
                Image img1 = iconoBorrar.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                ImageIcon i = new ImageIcon(img1);
                label.setIcon(i);
                

            } else if (String.valueOf(value).equals("EVENTO")) {
                label.setIcon(iconoGuardar);

            }else{
                label.setIcon(iconoBuscar);
            }
            label.setHorizontalAlignment(JLabel.LEFT);
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            return label;
        }
        if (tipo.equals("numerico")) {
            if (focused) {
                background = backgroundSelected;
            } else {
                background = backgroundDefault;
            }
            // System.out.println(value);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setForeground((selected) ? new Color(255, 255, 255) : new Color(32, 117, 32));
            this.setBackground((selected) ? background : Color.white);
            this.setFont(bold);
            return this;
        }

        return this;

    }
}
