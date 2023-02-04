/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.gastoDao;
import java.sql.SQLException;
import java.util.List;
import modelo.Rubro;
import modelo.Gastos;
import modelo.Servicio;

/**
 *
 * @author jaime
 */
public class contGastos {
    private gastoDao ser = new gastoDao();
    /**
     * función que llama a la funcion insertarGasto del dao para insercion de gasto en la bd
     * @param gasto
     * @throws SQLException 
     */
    public void insertarGasto(Gastos gasto) throws SQLException{
        ser.insertarGasto(gasto);
    } 
    /**
     * funcion que llama a la funcion insertarRubroServicio del dao para insercion de rubro servicio en la bd
     * @param identificador_rubro
     * @param identificador_servicio
     * @throws SQLException 
     */
    public void insertarRubroServicio(int identificador_rubro, String identificador_servicio) throws SQLException{
        ser.insertarRubroServicio(identificador_rubro, identificador_servicio);
    }
    /**
     * función que llama a la función modificar gasto del dao para la modificación del registro de gasto en la bd
     * @param id_gasto
     * @param importe
     * @param fecha_registro
     * @param fecha_pago
     * @param numero_telefono
     * @param email_prov
     * @param direccion_prov
     * @param nombre_prov
     * @throws SQLException 
     */
    public void modificarGasto(int id_gasto, int importe, String fecha_registro, String fecha_pago, String numero_telefono, String email_prov, String direccion_prov, String nombre_prov) throws SQLException{
        ser.modificarGasto(id_gasto, importe, fecha_registro, fecha_pago, numero_telefono, email_prov, direccion_prov, nombre_prov);
    }
    /**
     * función que llama a la función eliminar gasto del dao para eliminar un registro de gasto de la bd
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarGasto(String identificador) throws SQLException{
        ser.eliminarGasto(identificador);
    }
    /**
     * función que llama a la función buscarIdentificadorRubro del dao para buscar el identificador del rubro en base a su nombre
     * @param nombre
     * @return
     * @throws SQLException 
     */
    public int buscarIdentificadorRubro(String nombre) throws SQLException{
        return ser.buscarIdentificadorRubro(nombre);
    }
    /**
     * función que llama a la funcion obtenerServiciosTabla del dao para obtener los servicios
     * @return
     * @throws SQLException 
     */
    public List<Servicio> obtenerServiciosTabla() throws SQLException{
        return ser.obtenerServiciosTabla();
    }  
    /**
     * función que llama a la funcion insertarGastoRubro del dao para insertar el registro de gasto rubro
     * @param id_rubro
     * @throws SQLException 
     */
    public void insertarGastoRubro(int id_rubro) throws SQLException{
        ser.insertarGastoRubro(id_rubro);
    }
    /**
     * función que llama a la funcion buscarIDServicio del dao para obtener el ID del servicio
     * @param nombre
     * @return
     * @throws SQLException 
     */
    public String buscarIDServicio(String nombre) throws SQLException{
        return ser.buscarIDServicio(nombre);
    }
    /**
     * función que llama a la función obtenerRubros del dao para obtener los rubros 
     * @return
     * @throws SQLException 
     */
    public List<Rubro> obtenerRubros() throws SQLException{
        return ser.obtenerRubros();
    }    
    /**
     * función que llama a la función obtener gastos del dao para obtener los gastos
     * @return
     * @throws SQLException 
     */
    public List<Gastos> obtenerGastos() throws SQLException{
        return ser.obtenerGastos();
    }  
}
