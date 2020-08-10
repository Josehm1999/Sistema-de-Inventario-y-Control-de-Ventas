
package com.DTO;
public class ProductosDTO {
    private int cod_Pro;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;
    
    public ProductosDTO(){
        
    }

    public int getCod_Pro() {
        return cod_Pro;
    }

    public void setCod_Pro(int cod_Pro) {
        this.cod_Pro = cod_Pro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
