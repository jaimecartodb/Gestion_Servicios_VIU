/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Gastos;
import modelo.Rubro;
import modelo.Servicio;

/**
 *
 * @author jaime
 */
public class gastoDao {
    static Connection con = DatabaseConnection.getConnection();
    /**
     * función que inserta un gasto en la bd
     * @param gas
     * @return
     * @throws SQLException 
     */
    public int insertarGasto(Gastos gas) throws SQLException{
        String sql = "INSERT INTO gastos(importe, fecha_registro, fecha_pago, numero_telefono_prov, email_prov, direccion_prov, nombre_prov) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, gas.getImporte());
        ps.setString(2, gas.getFecha_registro());
        ps.setString(3, gas.getFecha_pago());
        ps.setString(4, gas.getNumero_telefono());
        ps.setString(5, gas.getEmail_prov());
        ps.setString(6, gas.getDireccion_prov());
        ps.setString(7, gas.getNombre_prov());
        int n = ps.executeUpdate();
        return n;
    }    
    /**
     * función que insertar uin rubro servicio en la base de datos
     * @param identificador_rubro
     * @param identificador_servicio
     * @return
     * @throws SQLException 
     */
    public int insertarRubroServicio(int identificador_rubro, String identificador_servicio)throws SQLException{
        String sql = "INSERT INTO rubro_servicio(identificador_rubro, identificador_servicio) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, identificador_rubro);
        ps.setString(2, identificador_servicio);
        int n = ps.executeUpdate();
        return n;
    }  
    /**
     * función que busca el id de un servicio
     * @param nombre
     * @return
     * @throws SQLException 
     */
    public String buscarIDServicio(String nombre) throws SQLException{
        String sql = "select identificador from servicios where actividades = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        String resultado = "";
        if (rs.next()) {
            resultado = rs.getString(1);
        }
        return resultado;        
    }
    /**
     * funcióin que modifica el registro de un gasto
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
        String sql = "UPDATE gastos set importe=?, fecha_registro= ?, fecha_pago=?, numero_telefono_prov=?, email_prov=?, direccion_prov=?, nombre_prov=? where id_gasto=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, importe);
        ps.setString(2, fecha_registro);
        ps.setString(3, fecha_pago);
        ps.setString(4, numero_telefono);
        ps.setString(5, email_prov);
        ps.setString(6, direccion_prov);
        ps.setString(7, nombre_prov);
        ps.setInt(8, id_gasto);
        ps.executeUpdate();
    }
    /**
     * función que elimina un gasto
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarGasto(String identificador) throws SQLException{
        String sql = "DELETE FROM gastos where id_gasto = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, identificador);
        ps.executeUpdate();
    }
    /**
     * función que busca el identificador de un rubro
     * @param nombre
     * @return
     * @throws SQLException 
     */
    public int buscarIdentificadorRubro(String nombre) throws SQLException{
        String sql = "select * from rubro where nombre = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        int resultado = 0;
        if (rs.next()) {
            resultado = rs.getInt(1);
        }
        return resultado;           
    }
    /**
     * función que obtiene los servicios
     * @return
     * @throws SQLException 
     */
    public List<Servicio> obtenerServiciosTabla() throws SQLException{
        String sql = "select * from servicios";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Servicio> ls = new ArrayList();
        while (rs.next()) {
            Servicio s = new Servicio(rs.getString("identificador"), rs.getString("actividades"), rs.getInt("obligatorio"), rs.getInt("costo"));
            ls.add(s);       
        }
        return ls;        
    }
    /**
     * función que insertar el gasto rubro 
     * @param id_rubro
     * @return
     * @throws SQLException 
     */
    public int insertarGastoRubro(int id_rubro) throws SQLException{
        String sql = "SELECT MAX(id_gasto) as id_gasto FROM gastos";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int id_gasto = 0;
        if (rs.next()) {
            id_gasto = rs.getInt(1);
        }
        sql = "INSERT INTO gasto_rubro(identificador_rubro, id_gasto) VALUES (?, ?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id_rubro);
        ps.setInt(2, id_gasto);
        int n = ps.executeUpdate();
        return n;
    }
    /**
     * función que obtiene todos los rubros
     * @return
     * @throws SQLException 
     */
    public List<Rubro> obtenerRubros() throws SQLException{
        String sql = "select * from rubro";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Rubro> ls = new ArrayList();
        while (rs.next()) {
            ls.add(new Rubro(rs.getInt(1),rs.getString(2)));   
        } 
        return ls;
    }
    /**
     * función que obtiene todos los gastos
     * @return
     * @throws SQLException 
     */
    public List<Gastos> obtenerGastos() throws SQLException{
        String sql = "select * from gastos";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Gastos> ls = new ArrayList();
        while (rs.next()) {
            Gastos g = new Gastos(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            g.setId_gasto(rs.getInt(1));
            ls.add(g); 
        } 
        return ls;
    }
}
