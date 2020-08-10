package com.Controllers;

import com.DAO.FacturasDAO;
import com.DTO.FaccabDTO;
import com.DTO.FacdetDTO;
import java.util.ArrayList;

public class FacturasController {

    FacturasDAO FDAO = new FacturasDAO();

    public int CrearFactura(int id_cliente, double total) {
        return FDAO.GrabarFaccab(id_cliente, total);
    }

    public boolean AgregarProductos(int id_factura, int cod_Pro, int cantidad, double precio) {
        return FDAO.GrabarFacdeta(id_factura, cod_Pro, cantidad, precio);
    }

    public ArrayList<FaccabDTO> facturasByCliente(Object id_cliente) {
        return FDAO.facturasByCliente(id_cliente);
    }

    public ArrayList<FacdetDTO> detallesByFactura(int id_factura) {
        return FDAO.detallesByFactura(id_factura);
    }

    public ArrayList selectAll() {
        return FDAO.selectAll();
    }
}
