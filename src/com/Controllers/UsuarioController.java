package com.Controllers;

import com.DAO.UsuarioDAO;
import com.DTO.UsuarioDTO;


public class UsuarioController {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Boolean Login(String correo, String clave) {
        Boolean resultado = false;
        if (usuarioDAO.Login(correo, clave)) {
            String mensajeExito = "Ya has iniciado sesión";
            System.out.println(mensajeExito);
            resultado = true;
        } else {
            String mensajeError = "Error al iniciar sesión";
            System.out.println(mensajeError);
        }
        return resultado;
    }

    public UsuarioDTO selectByCorreo(String correo) {
        return usuarioDAO.selectByCorreo(correo);
    }

    public Boolean Registrar(String nombre, int telefono,String correo, String direccion, String clave ) {
        if (!usuarioDAO.siExisteMail(correo)) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre(nombre);
        usuarioDTO.setTelefono(telefono);
        usuarioDTO.setCorreo(correo);
        usuarioDTO.setDireccion(direccion);
        usuarioDTO.setClave(clave);
        usuarioDAO.insert(usuarioDTO,"usuario");
        }else{
            return false;
        }
        return true;
    }

    public Boolean Recuperar(String correo, String Nombre, String nclave) {
        Boolean resultado = false;
        if (usuarioDAO.siExisteMail(correo)) {
            UsuarioDTO usuarioDTO = usuarioDAO.selectByCorreo(correo);
            if (usuarioDTO.getNombre().equals(Nombre)) {
                usuarioDTO.setClave(nclave);
                usuarioDAO.update(usuarioDTO, usuarioDTO.getPerfil());
                resultado = true;
            }
        }
        return resultado;
    }
}
