package com.test;

import com.DAO.*;
import com.DTO.*;
import com.Controllers.*;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
//        UsuarioDTO usuarioDTO= new UsuarioDTO();
//        usuarioDTO.setNombre("José");
//        usuarioDTO.setTelefono(927874082);
//        usuarioDTO.setClave("123456789");
//        usuarioDTO.setDireccion("Pasaje Lucio Mansilla");
//        usuarioDTO.setCorreo("josehm1999@gmail.com");
//        usuarioDTO.setPerfil("Usuario");
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//////        usuarioDAO.insert(usuarioDTO, "Usuario");
////          
//    ArrayList<UsuarioDTO> usuarios = usuarioDAO.selectAll();
//        
//        boolean var =usuarioDAO.update(usuarioDAO.selectByCorreo("josehm1999@gmail.com"), "Administrador");
//        if(var){
//            System.out.println("Si ta bien");
//        }else{
//            System.out.println("No ta bien");
//        }
//        ProductosDAO productosDAO = new ProductosDAO();
//        ProductosController productos = new ProductosController();
//        ArrayList<ProductosDTO> productos1 = productos.ListaProductos();
//        /*Listado de productos */
//                if (productos1.isEmpty()) {
//            System.out.println("No hay datos");
//        } else {
//            for (ProductosDTO  index : productos1) {
//                System.out.println(index.getCod_Pro()+ " " + index.getNombre()+ " "+ 
//                        index.getDescripcion()+ " "+index.getPrecio() + " "+ index.getStock()+ " "+index.getCategoria());
//            }
//        }
//                
//        System.out.println("");
//        ArrayList<String> categorias = productos.Categorias();
//        if(categorias.isEmpty()){
//            System.out.println("Vacio");
//        } else{
//            for (String cate : categorias){
//                System.out.println(cate+" ");
//            }
//        }
//        System.out.println("");

//Controlador
UsuarioController controler = new UsuarioController();
UsuarioDAO DAO = new UsuarioDAO();

UsuarioDTO usuario= DAO.selectById(7);
        System.out.println(usuario.getNombre());


        //Productos
//        ProductosController PDAO= new ProductosController();
//       
//        System.out.println( PDAO.SelectByName("Leche  Gloria Rojo").getNombre());
////FACTURAS
//ProductosDAO pDAO = new ProductosDAO();
//FacturasDAO fDAO = new FacturasDAO();
//ArrayList<ProductosDTO> produ = pDAO.selectAll();
////double total=0;
////for(ProductosDTO produ1: produ){
////        double valorF= produ1.getPrecio()* 2;
////        total =+ valorF;
////        for (int i=1; i<=6;i++){
////        int Fac = fDAO.GrabarFaccab(i,total);
////        }
////    }
//for(ProductosDTO produ1: produ){      
//    fDAO.GrabarFacdeta(1,produ1.getCod_Pro(),2,produ1.getPrecio());
//}  
}}
