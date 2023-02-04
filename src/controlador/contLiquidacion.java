/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.liquidacionDao;
import java.sql.SQLException;
import java.util.List;
import modelo.Liquidacion;

/**
 *
 * @author jaime
 */
public class contLiquidacion {
    private liquidacionDao ld = new liquidacionDao();
    /**
     * función que llama a la función obtenerLiquidaciones del dao para obtener todas las liquidaciones de un usuario entre una fecha de inicio y fin
     * @param usuario
     * @param fecha_inicio
     * @param fecha_fin
     * @return
     * @throws SQLException 
     */
    public List<Liquidacion> obtenerLiquidaciones(String usuario, String fecha_inicio, String fecha_fin) throws SQLException{
        return ld.obtenerLiquidaciones(usuario, fecha_inicio, fecha_fin);     
    }
}
