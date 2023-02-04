/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.usuarioDao;
import java.sql.SQLException;
import java.util.List;
import modelo.Usuario;

public class contUsuario {
    private usuarioDao c = new usuarioDao();
    /**
     * función que llama a la función insertarUsuario del dao para insertar un registro de usuario
     * @param user
     * @throws SQLException 
     */
    public void insertarUsuario(Usuario user) throws SQLException{
        c.insertarUsuario(user);
    } 
    /**
     * función que llama a la función obtenerUsuarios del dao para obtener todos los usuarios que hay
     * @return
     * @throws SQLException 
     */
    public List<Usuario> obtenerUsuarios() throws SQLException{
        return c.obtenerUsuarios();
    }
    /**
     * función que llama a la funcion modificarUsuario del dao para modificar un usuario de la base de datos
     * @param identificador
     * @param clave
     * @param telefono
     * @param email
     * @param baja
     * @throws SQLException 
     */
    public void modificarUsuario(String identificador, String clave, String telefono, String email, int baja) throws SQLException{
        c.modificarUsuario(identificador, clave, telefono, email, baja);
    }
    /**
     * función que llama a la función eliminarUsuario del dao para eliminar un usuario de la bd
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarUsuario(String identificador) throws SQLException{
        c.eliminarUsuario(identificador);
    }
}
