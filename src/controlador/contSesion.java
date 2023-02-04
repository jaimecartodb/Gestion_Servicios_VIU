/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.sesionDao;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author ignac
 */
public class contSesion {
    private sesionDao c = new sesionDao();
    /**
     * función que llama a la función inicioSesion del dao para iniciar sesión en el sistema
     * @param usuario
     * @param contra
     * @return
     * @throws SQLException 
     */
    public Usuario iniciarSesion(String usuario, String contra) throws SQLException{
        Usuario respuesta = c.inicioSesion(usuario, contra);
        return respuesta;
    }
}
