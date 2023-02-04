/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import dao.servicioDao;
import java.sql.SQLException;
import java.util.List;
import modelo.Cuenta;
import modelo.Rubro;
import modelo.Servicio;
/**
 *
 * @author jaime
 */
public class contServicio {
    private servicioDao ser = new servicioDao();
    /**
     * función que llama a la función de insertarServicio del dao para insertar la información de un servicio
     * @param s
     * @throws SQLException 
     */
    public void insertarServicio(Servicio s) throws SQLException{
        ser.insertarServicio(s);
    }
    /**
     * función que llama a la función eliminar servicio del dao para eliminar un servicio de la bd
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarServicio(String identificador) throws SQLException{
        ser.eliminarServicio(identificador);
    }
    /**
     * función que llama a la función modificarServicio del dao para modificar un servicio de la bd
     * @param identificador
     * @param actividades
     * @param obligatorio
     * @param costo
     * @throws SQLException 
     */
    public void modificarServicio(String identificador, String actividades, int obligatorio, int costo) throws SQLException{
        ser.modificarServicio(identificador, actividades, obligatorio, costo);
    }
    /**
     * función que llama a la función insertarCuenta del dao para insertar una cuenta en la bd
     * @param c
     * @throws SQLException 
     */
    public void insertarCuenta(Cuenta c) throws SQLException{
        ser.insertarCuenta(c);
    }
    /**
     * función que llama a la función obtenerRubros del dao para obtener todos los rubros
     * @return
     * @throws SQLException 
     */
    public List<Rubro> obtenerRubros() throws SQLException{
        return ser.obtenerRubros();
    }  
    /**
     * función que llama a la función insertarRuborServicio del dao para insertar
     * @param identificador
     * @param nombre_rubro
     * @throws SQLException 
     */
    public void insertarRuborServicio(String identificador, String nombre_rubro) throws SQLException{
        ser.insertarRuborServicio(identificador, nombre_rubro);
    }
    /**
     * función que llama a la funcion buscarIDServicio en el cual obtiene el id del un servicio
     * @param nombre
     * @return
     * @throws SQLException 
     */
    public String buscarIDServicio(String nombre) throws SQLException{
        return ser.buscarIDServicio(nombre);
    }
    /**
     * función que llama a la función eliminarCuenta del dao para eliminar una cuenta
     * @param usuario
     * @param identificador_inmueble
     * @param identificador_servicio
     * @throws SQLException 
     */
    public void eliminarCuenta(String usuario, String identificador_inmueble, String identificador_servicio) throws SQLException{
        ser.eliminarCuenta(usuario, identificador_inmueble, identificador_servicio);
    }
    /**
     * función que llama a la función obtenerServicios del dao para obtener todos los servicios
     * @return
     * @throws SQLException 
     */
    public List<String> obtenerServicios() throws SQLException{
        return ser.obtenerServicios();
    }    
    /**
     * función que llama a la función obtenerServiciosTabla del dao para la obtención de los servicios
     * @return
     * @throws SQLException 
     */
    public List<Servicio> obtenerServiciosTabla() throws SQLException{
        return ser.obtenerServiciosTabla();
    }  
    /**
     * función que llama a la función obtenerCuenta del dao para obtener la cuenta en base a un identificador de un inmueble y un usuario
     * @param identificador_inmueble
     * @param usuario
     * @return
     * @throws SQLException 
     */
    public List<String> obtenerCuenta(String identificador_inmueble, String usuario) throws SQLException{
        return ser.obtenerCuenta(identificador_inmueble, usuario);
    }   
}
