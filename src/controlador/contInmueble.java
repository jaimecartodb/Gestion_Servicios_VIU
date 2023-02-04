/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.inmuebleDao;
import java.sql.SQLException;
import java.util.List;
import modelo.Inmueble;
import modelo.usuarioInmueble;

/**
 *
 * @author jaime
 */
public class contInmueble {
    private inmuebleDao ser = new inmuebleDao();
    /**
     * función que llama a la función insertarInmueble del dao para insertar la información del inmueble
     * @param inm
     * @throws SQLException 
     */
    public void insertarInmueble(Inmueble inm) throws SQLException{
        ser.insertarInmueble(inm);
    } 
    /**
     * función que llama a la función eliminar inmueble del dao para eliminar un registro de inmueble
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarInmueble(String identificador) throws SQLException{
        ser.eliminarInmueble(identificador);
    }
    /**
     * función que llama a la función modificar inmueble del dao para modificar el registro de un inmueble
     * @param identificador
     * @param nombre
     * @throws SQLException 
     */
    public void modificarInmueble(String identificador, String nombre) throws SQLException{
        System.out.println(identificador+" "+ nombre);
        ser.modificarInmueble(identificador, nombre);
    }
    /**
     * función que llama a la función insertarUsuarioInmueble del dao para insertar el usuario de un inmueble
     * @param uinm
     * @throws SQLException 
     */
    public void insertarUsuarioInmueble(usuarioInmueble uinm) throws SQLException{
        ser.insertarUsuarioInmueble(uinm);
    } 
    /**
     * función que llama a la función obtenerInmuebles del dao para obtener todos los inmuebles de la bd
     * @return
     * @throws SQLException 
     */
    public List<Inmueble> obtenerInmuebles() throws SQLException{
        return ser.obtenerInmuebles();
    }
    /**
     * función que llama a la función obtenerUsuarios del dao para obtener todos los usuarios de la bd
     * @return
     * @throws SQLException 
     */
    public List<String> obtenerUsuarios() throws SQLException{
        return ser.obtenerUsuarios();
    }
    
}
