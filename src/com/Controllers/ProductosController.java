package com.Controllers;

import com.DAO.ProductosDAO;
import com.DTO.ProductosDTO;
import java.util.ArrayList;

public class ProductosController {

    ProductosDAO productoDAO = new ProductosDAO();
    
    public ArrayList<ProductosDTO> ListaProductos() {
        ArrayList<ProductosDTO> productos = productoDAO.selectAll();
        return productos;
    }
    
    
    public void Crear(String nombre,String descripcion, String precio, String stock, String  categoria){
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setNombre(nombre);
        productosDTO.setDescripcion(descripcion);
        productosDTO.setPrecio(Double.parseDouble(precio));
        productosDTO.setStock(Integer.parseInt(stock));
        productosDTO.setCategoria(categoria);
        productoDAO.insert(productosDTO,null);
    }
    public void BorrarElemento(int cod_Pro){
        productoDAO.delete(cod_Pro);
    }
    public void ActualizarTodo(ArrayList<ProductosDTO> productos){
        for(ProductosDTO produ: productos){
            productoDAO.update(produ, null);
        }
    }
    public void Actualizar(ProductosDTO producto){
        productoDAO.update(producto, null);
        
    }
    public ProductosDTO SelectByName(String nombre){
        ProductosDTO producto = productoDAO.selectByName(nombre.trim());
        return producto;
    }
    public ProductosDTO SelectById(int id){
        ProductosDTO producto = productoDAO.selectById(id);
        return producto;
    }
    public ArrayList<ProductosDTO> SelectByCategory(String categoria){
        ArrayList<ProductosDTO> productosByCate = productoDAO.selectByCategory(categoria);
        return productosByCate;
    }
    public ArrayList<String> Categorias() {
        ArrayList<String> categorias = productoDAO.selectCategorias();
        ArrayList<String> categoriasEnviar = new ArrayList();
        for (int i = 0; i < categorias.size(); i++) {
            boolean distinto = false;
            for (int j = 0; j < i; j++) {
                if (categorias.get(i).equals(categorias.get(j))) {
                    distinto = true;
                    break;
                }
            }
            if (!distinto) {
                categoriasEnviar.add(categorias.get(i));
            }
        }
        return categoriasEnviar;
    }
    
}
