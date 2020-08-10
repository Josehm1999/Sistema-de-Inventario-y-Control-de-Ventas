/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.DTO.FaccabDTO;
import com.DTO.FacdetDTO;
import com.conexionBD.ConexionBd;
import com.interfaces.OperacionesBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joseh
 */
public class FacturasDAO implements OperacionesBD<FaccabDTO> {

    private static PreparedStatement pstm;
    private static CallableStatement cstm;
    private static ResultSet res;
    private static ConexionBd con;

    public FacturasDAO() {
        con = ConexionBd.getInstance();
    }
    
    public int GrabarFaccab(Object id, Object total){
        int id_cli=0;
        final String SQL_GRABARFCAB = "{?= call dbo.grabafac(?,?)}";
        try{
            cstm = con.getCon().prepareCall(SQL_GRABARFCAB);
            cstm.registerOutParameter(1,java.sql.Types.INTEGER);
            cstm.setInt(2,Integer.parseInt(id.toString()));
            cstm.setDouble(3,Double.parseDouble(total.toString()));
            cstm.execute();
            id_cli=cstm.getInt(1);
        }catch(NumberFormatException | SQLException e){
           System.out.println("Error al grabar la factura faccab:" + e.getMessage());
        }finally{
            closeConnection();
        }
        return id_cli;
    }
    public Boolean GrabarFacdeta(int id, int cod_Pro,int cantidad,double  precio){
        Boolean Resultado=false;
        final String SQL_GRABARFCAB = "{call grabadeta(?,?,?,?)}";
        try{
            cstm = con.getCon().prepareCall(SQL_GRABARFCAB);
            cstm.setInt(1,id);
            cstm.setInt(2, cod_Pro);
            cstm.setInt(3, cantidad);
            cstm.setDouble(4, precio);
            if(cstm.executeUpdate()>0){
             Resultado=true;
            }            
        }catch(Exception e){
           System.out.println("Error al grabar la factura faccab:" + e.getMessage());
        }finally{
            closeConnection();
        }
        return Resultado;
    }

    public ArrayList<FaccabDTO> facturasByCliente(Object id) {
        ArrayList<FaccabDTO> Facturas = new ArrayList<>();
        final String SQL_SELECTALL = "select * from faccab where IdCliente = ?";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECTALL);
            pstm.setInt(1, Integer.parseInt(id.toString()));
            res = pstm.executeQuery();
            while (res.next()) {
                FaccabDTO factura = new FaccabDTO();
                factura.setNroFactura(res.getInt("NroFactura"));
                factura.setId(res.getInt("IdCliente"));
                factura.setMontoTotal(res.getDouble("MontoTotal"));
                factura.setFechaFactura(res.getDate("FechaFactura"));
                Facturas.add(factura);
            }
        } catch (Exception e) {
            System.out.println("Error al traer las facturas :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return Facturas;
    }
    public ArrayList<FacdetDTO> detallesByFactura(int NroFactura){
        ArrayList<FacdetDTO> detalles = new ArrayList<>();
        final String SQL_SELECTALL = "select * from facdet where NroFactura = ?";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECTALL);
            pstm.setInt(1, NroFactura);
            res = pstm.executeQuery();
            while (res.next()) {
                FacdetDTO detalle = new FacdetDTO();
                detalle.setNroFactura(res.getInt("NroFactura"));
                detalle.setIdArticulo(res.getInt("IdArticulo"));
                detalle.setCantidad(res.getInt("Cantidad"));
                detalle.setPrecioUnidad(res.getDouble("PrecioUnidad"));
                detalles.add(detalle);
            }
        } catch (Exception e) {
            System.out.println("Error al traer los detalles :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return detalles;
    }
    @Override
    public Boolean insert(FaccabDTO t, Object tipo) {
        throw new UnsupportedOperationException("No es necesario contar con este método");

    }

    @Override
    public Boolean update(FaccabDTO t, Object tipo) {
        throw new UnsupportedOperationException("No es necesario contar con este método");
    }

    @Override
    public Boolean delete(Object id) {
        throw new UnsupportedOperationException("No es necesario contar con este método");
    }

    @Override
    public FaccabDTO selectById(Object id) {
        throw new UnsupportedOperationException("No es necesario contar con este método");
    }

    @Override
    public ArrayList<FaccabDTO> selectAll() {
        ArrayList<FaccabDTO> Facturas = new ArrayList<>();
        final String SQL_SELECTALL = "select * from faccab";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECTALL);
            res = pstm.executeQuery();
            while (res.next()) {
                FaccabDTO factura = new FaccabDTO();
                factura.setNroFactura(res.getInt("NroFactura"));
                factura.setId(res.getInt("IdCliente"));
                factura.setMontoTotal(res.getDouble("MontoTotal"));
                factura.setFechaFactura(res.getDate("FechaFactura"));
                Facturas.add(factura);
            }
        } catch (Exception e) {
            System.out.println("Error al traer las facturas :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return Facturas;
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
