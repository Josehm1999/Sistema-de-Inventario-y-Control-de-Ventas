
package com.DTO;

public class FacdetDTO {
  private int NroFactura;  
  private int IdArticulo;  
  private double PrecioUnidad; 
  private int Cantidad ;

    public FacdetDTO() {
    }

    public int getNroFactura() {
        return NroFactura;
    }

    public void setNroFactura(int NroFactura) {
        this.NroFactura = NroFactura;
    }

    public int getIdArticulo() {
        return IdArticulo;
    }

    public void setIdArticulo(int IdArticulo) {
        this.IdArticulo = IdArticulo;
    }

    public double getPrecioUnidad() {
        return PrecioUnidad;
    }

    public void setPrecioUnidad(double PrecioUnidad) {
        this.PrecioUnidad = PrecioUnidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
  
  
}
