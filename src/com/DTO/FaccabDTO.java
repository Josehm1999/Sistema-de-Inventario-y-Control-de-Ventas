/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DTO;

import java.util.Date;

public class FaccabDTO {
    private int NroFactura;
    private Date FechaFactura;
    private int id_cliente;
    private double MontoTotal;

    public FaccabDTO() {
    }

    public int getNroFactura() {
        return NroFactura;
    }

    public void setNroFactura(int NroFactura) {
        this.NroFactura = NroFactura;
    }

    public Date getFechaFactura() {
        return FechaFactura;
    }

    public void setFechaFactura(Date FechaFactura) {
        this.FechaFactura = FechaFactura;
    }

    public int getId() {
        return id_cliente;
    }

    public void setId(int id) {
        this.id_cliente = id;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(double MontoTotal) {
        this.MontoTotal = MontoTotal;
    }
    
}
