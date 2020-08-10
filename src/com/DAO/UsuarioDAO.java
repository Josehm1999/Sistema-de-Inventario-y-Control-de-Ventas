package com.DAO;

import com.DTO.UsuarioDTO;
import com.conexionBD.ConexionBd;
import com.interfaces.OperacionesBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO implements OperacionesBD<UsuarioDTO> {

    //Objeto para establecer la conexion a la base de datos
    private static ConexionBd con = null;
    //Objeto para enviar la consulta SQL al Servidor de BD desde JAVA
    private static PreparedStatement pstm = null;
    //Objeto para guardar los resultado de una consulta JAVA
    private static ResultSet res = null;

    public UsuarioDAO() {
        con = ConexionBd.getInstance();
    }

    public Boolean Login(String correo, String clave) {
        Boolean result = false;
        final String SQL_VALIDATELOGIN = "select * from clientes where correo=? and clave=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_VALIDATELOGIN);
            pstm.setString(1, correo);
            pstm.setString(2, clave);
            res = pstm.executeQuery();
            while (res.next()) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Has ingresado mal el correo o la contraseña" + e.getMessage());
        } finally {
            closeConnection();
        }
        return result;
    }

    public Boolean siExisteMail(String correo) {
        Boolean result = false;
        final String SQL_VALIDATEMAIL = "select * from clientes where correo=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_VALIDATEMAIL);
            pstm.setString(1, correo);
            res = pstm.executeQuery();
            while (res.next()) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al comprobar mail :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return result;

    }

    @Override
    public Boolean insert(UsuarioDTO t, Object tipo) {
        Boolean result = false;
        
        String SQL_Insert = "insert into clientes values(?,?,?,?,?,?)";
        try {
            pstm = con.getCon().prepareStatement(SQL_Insert);
            pstm.setString(1, t.getNombre());
            pstm.setInt(2, t.getTelefono());
            pstm.setString(3, t.getCorreo());
            pstm.setString(4, t.getDireccion());
            pstm.setString(5, t.getClave());
            pstm.setString(6,tipo.toString());
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
    public Boolean update(UsuarioDTO t, Object tipo) {
        Boolean result = false;
        final String SQL_UPDATE = "update clientes set nombre=?,telefono=?, correo=?,direccion=?,clave=?,perfil=? where Id_Cliente=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_UPDATE);
            pstm.setString(1, t.getNombre());
            pstm.setInt(2, t.getTelefono());
            pstm.setString(3, t.getCorreo());
            pstm.setString(4, t.getDireccion());
            pstm.setString(5, t.getClave());
            pstm.setString(6, tipo.toString());
            pstm.setInt(7, t.getId());
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
    public Boolean delete(Object id) {
        Boolean result = false;
        final String SQL_DELETE = "delete from clientes where Id_Cliente=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, Integer.parseInt(id.toString()));
            boolean var = pstm.execute();
            if (var) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el registro.");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public UsuarioDTO selectById(Object id) {
        UsuarioDTO usuarios = new UsuarioDTO();
        final String SQL_SELECT_BYID = "select * from clientes where Id_Cliente=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECT_BYID);
            pstm.setInt(1, Integer.parseInt(id.toString()));
            res = pstm.executeQuery();
            while (res.next()) {
                usuarios.setId(res.getInt("Id_Cliente"));
                usuarios.setNombre(res.getString("nombre"));
                usuarios.setTelefono(res.getInt("telefono"));
                usuarios.setCorreo(res.getString("correo"));
                usuarios.setDireccion(res.getString("direccion"));
                usuarios.setClave(res.getString("clave"));
                usuarios.setPerfil(res.getString("perfil"));
            }
        } catch (Exception e) {
            System.out.println("Error al traer los datos :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuarios;
    }

    @Override
    public ArrayList<UsuarioDTO> selectAll() {
        ArrayList<UsuarioDTO> usuarios = new ArrayList();
        final String SQL_SELECTALL = "select * from clientes";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECTALL);
            res = pstm.executeQuery();
            while (res.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId(res.getInt("Id_Cliente"));
                usuario.setNombre(res.getString("nombre"));
                usuario.setTelefono(res.getInt("telefono"));
                usuario.setCorreo(res.getString("correo"));
                usuario.setDireccion(res.getString("direccion"));
                usuario.setClave(res.getString("clave"));
                usuario.setPerfil(res.getString("perfil"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al traer los datos :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuarios;
    }
    
    public UsuarioDTO selectByCorreo(String correo) {
        UsuarioDTO usuarios = new UsuarioDTO();
        final String SQL_SELECT_BYCORREO = "select * from clientes where correo=?";
        try {
            pstm = con.getCon().prepareStatement(SQL_SELECT_BYCORREO);
            pstm.setString(1, correo);
            res = pstm.executeQuery();
            while (res.next()) {
                usuarios.setId(res.getInt("Id_Cliente"));
                usuarios.setNombre(res.getString("nombre"));
                usuarios.setTelefono(res.getInt("telefono"));
                usuarios.setCorreo(res.getString("correo"));
                usuarios.setDireccion(res.getString("direccion"));
                usuarios.setClave(res.getString("clave"));
                usuarios.setPerfil(res.getString("perfil"));
            }
        } catch (Exception e) {
            System.out.println("Error al traer los datos :" + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuarios;
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
