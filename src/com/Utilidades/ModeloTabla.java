package com.Utilidades;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

    String[] Titulos;
    Object[][] Datos;
    private String Perfil;

    public ModeloTabla(Object[][] Datos, String[] titulos, String Perfil) {
        super(Datos, titulos);
        this.Titulos = titulos;
        this.Datos = Datos;
        this.Perfil=Perfil;
        setDataVector(Datos, titulos);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if("Administrador".equals(Perfil)){
             if (column == Utilidades.COD_PRO  || column==Utilidades.CATEGORIA) {
            return false;
        } else {
            return true;
        }
        }else{
            if(column == Utilidades.DESC){
                return true;
            }
            return false;
        }
    }
}
