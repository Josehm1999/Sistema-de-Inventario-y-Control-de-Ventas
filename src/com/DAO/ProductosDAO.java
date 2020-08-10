package com.DAO;

import com.DTO.ProductosDTO;
import com.interfaces.OperacionesBD;
import java.util.ArrayList;
import com.conexionBD.ConexionBd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductosDAO implements OperacionesBD<ProductosDTO> {

    private static ConexionBd con = null;
    private static PreparedStatement pstm = null;
    private static ResultSet res = null;

    public ProductosDAO() {
        con = ConexionBd.getInstance();
    }

    @Override
    public Boolean insert(ProductosDTO t, Object tipo) {
        Boolean result = false;

        String SQL_Insert = "insert into Productos values(?,?,?,?,?)";
        try {
            pstm = con.getCon().prepareStatement(SQL_Insert);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getDescripcion());
            pstm.setDouble(3, t.getPrecio());
            pstm.setInt(4, t.getStock());
            pstm.setString(5, t.getCategoria());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    @Override
    public Boolean update(ProductosDTO t, Object tipo) {
        Boolean result = false;
        final String SQL_UPDATE = "update Productos set nombre=?, descripcion=?, precio=?,stock=?,categoria=? where cod_Pro=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_UPDATE);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getDescripcion());
            pstm.setDouble(3, t.getPrecio());
            pstm.setInt(4, t.getStock());
            pstm.setString(5, t.getCategoria());
            pstm.setInt(6, t.getCod_Pro());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar");
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public Boolean delete(Object cod_Pro) {
        Boolean result = false;
        final String SQL_DELETE = "delete from Productos where cod_Pro=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, Integer.parseInt(cod_Pro.toString()));
            boolean var = pstm.execute();
            if (var) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public ProductosDTO selectById(Object id) {
        ProductosDTO producto = new ProductosDTO();
        final String SQL_SELECT_BYID = "select * from Productos where cod_Pro=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECT_BYID);
            pstm.setInt(1,Integer.parseInt( id.toString()));
            res = pstm.executeQuery();
            while (res.next()) {
                producto.setCod_Pro(res.getInt("cod_Pro"));
                producto.setNombre(res.getString("nombre"));
                producto.setDescripcion(res.getString("descripcion"));
                producto.setPrecio(res.getDouble("precio"));
                producto.setStock(res.getInt("stock"));
                producto.setCategoria(res.getString("categoria"));
            }
        } catch (Exception e) {
            System.out.println("Error al traer los datos :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return producto;
    }

    @Override
    public ArrayList<ProductosDTO> selectAll() {
        ArrayList<ProductosDTO> productos = new ArrayList();
        final String SQL_SELECTALL = "select * from Productos";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECTALL);
            res = pstm.executeQuery();
            while (res.next()) {
                ProductosDTO producto = new ProductosDTO();
                producto.setCod_Pro(res.getInt("cod_Pro"));
                producto.setNombre(res.getString("nombre"));
                producto.setDescripcion(res.getString("descripcion"));
                producto.setPrecio(res.getDouble("precio"));
                producto.setStock(res.getInt("stock"));
                producto.setCategoria(res.getString("categoria"));
                productos.add(producto);
            }
        } catch (Exception e) {
            System.out.println("Error al traer los datos a:" + e.getMessage());
        } finally {
            closeConnection();
        }
        return productos;
    }

    public ProductosDTO selectByName(Object nombre) {
        ProductosDTO producto = new ProductosDTO();
        final String SQL_SELECT_BYID = "select * from Productos where nombre=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECT_BYID);
            pstm.setString(1, nombre.toString());
            res = pstm.executeQuery();
            while (res.next()) {
                producto.setCod_Pro(res.getInt("cod_Pro"));
                producto.setNombre(res.getString("nombre"));
                producto.setDescripcion(res.getString("descripcion"));
                producto.setPrecio(res.getDouble("precio"));
                producto.setStock(res.getInt("stock"));
                producto.setCategoria(res.getString("categoria"));
            }
        } catch (Exception e) {
            System.out.println("Error al traer los datos :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return producto;
    }
    

    public ArrayList<ProductosDTO> selectByCategory(Object categoria) {
        ArrayList<ProductosDTO> productos = new ArrayList();
        final String SQL_SELECTBYCATEGORY = "select * from Productos where categoria=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECTBYCATEGORY);
            pstm.setString(1, categoria.toString());
            res = pstm.executeQuery();
            while (res.next()) {
                ProductosDTO producto = new ProductosDTO();
                producto.setCod_Pro(res.getInt("cod_Pro"));
                producto.setNombre(res.getString("nombre"));
                producto.setDescripcion(res.getString("descripcion"));
                producto.setPrecio(res.getDouble("precio"));
                producto.setStock(res.getInt("stock"));
                producto.setCategoria(res.getString("categoria"));
                productos.add(producto);
            }
        } catch (Exception e) {
            System.out.println("Error al traer los datos :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return productos;
    }
    public ArrayList<String> selectCategorias(){
        ArrayList<String> productos = new ArrayList();
        final String SQL_SELECTCATEGORY = "select categoria from Productos";
        try{
             pstm = con.getCon().prepareStatement(SQL_SELECTCATEGORY);
             res = pstm.executeQuery();
             while(res.next()){
                 productos.add(res.getString("categoria"));
             }
        }catch(Exception e){
            System.out.println("Error al traer los datos :" + e.getMessage());
        }finally{
            closeConnection();
        }
        return productos;
    }
    @Override
    public void closeConnection() {
        try {
            if (res != null) {
                res.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.closeConnectionBd();
            }

        } catch (Exception e) {
            System.out.println("Erro al cerrar :" + e.getMessage());
        }
    }
}
