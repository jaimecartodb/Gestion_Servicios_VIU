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
import modelo.Cuenta;
import modelo.Rubro;
import modelo.Servicio;


/**
 *
 * @author jaime
 */
public class servicioDao {
    static Connection con = DatabaseConnection.getConnection();
    /**
     * función que inserta un servicio en la bd
     * @param ser
     * @return
     * @throws SQLException 
     */
    public int insertarServicio(Servicio ser) throws SQLException{
        String sql = "INSERT INTO servicios(identificador, actividades, obligatorio, costo) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ser.getIdentificador());
        ps.setString(2, ser.getActividades());
        ps.setInt(3, ser.getObligatorio());
        ps.setInt(4, ser.getCosto());
        int n = ps.executeUpdate();
        return n;
    }  
    /**
     * función que elimina un servicio
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarServicio(String identificador) throws SQLException{
        String sql = "DELETE FROM servicios where identificador = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, identificador);
        ps.executeUpdate();
    }
    /**
     * función que modifica un servicio
     * @param identificador
     * @param actividades
     * @param obligatorio
     * @param costo
     * @throws SQLException 
     */
    public void modificarServicio(String identificador, String actividades, int obligatorio, int costo) throws SQLException{
        String sql =  "UPDATE servicios set actividades=?, obligatorio = ?, costo=? where identificador=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, actividades);
        ps.setInt(2, obligatorio);
        ps.setInt(3, costo);
        ps.setString(4, identificador);
        ps.executeUpdate();
    }
    /**
     * función que inserta una cuenta 
     * @param cta
     * @return
     * @throws SQLException 
     */
    public int insertarCuenta(Cuenta cta) throws SQLException{
        String sql = "INSERT INTO cuenta(identificador_inmueble, identificador_usuarios, identificador_servicio) VALUES (?, ? ,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cta.getIdentificador_inmueble());
        ps.setString(2, cta.getIdentificador_usuarios());
        ps.setString(3, cta.getIdentificador_servicio());
        int n = ps.executeUpdate();
        return n;
    } 
    /**
     * función que inserta un rubro servicio
     * @param identificador
     * @param nombre_rubro
     * @return
     * @throws SQLException 
     */
    public int insertarRuborServicio(String identificador, String nombre_rubro) throws SQLException{
        int identificador_rubro  = buscarIdentificadorRubro(nombre_rubro);
        String sql = "INSERT INTO rubro_servicio(identificador_rubro, identificador_servicio) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, identificador_rubro);
        ps.setString(2, identificador);
        int n = ps.executeUpdate();
        return n;        
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
     * función que obtiene los rubros
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
     * función que elimina una cuenta
     * @param usuario
     * @param identificador_inmueble
     * @param identificador_servicio
     * @throws SQLException 
     */
    public void eliminarCuenta(String usuario, String identificador_inmueble, String identificador_servicio) throws SQLException{
        String sql = "DELETE FROM cuenta where identificador_inmueble = ? and identificador_usuario= ?  and identificador_servicio=?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, identificador_inmueble);
        ps.setString(2, usuario);
        ps.setString(3, identificador_servicio);
        ps.executeUpdate();        
    }
    /**
     * función que obtiene los actividades de los servicios
     * @return
     * @throws SQLException 
     */
    public List<String> obtenerServicios() throws SQLException{
        String sql = "select * from servicios";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<String> ls = new ArrayList();
        while (rs.next()) {
            ls.add(rs.getString("actividades"));
        }
        return ls;
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
     * función que obtiene una cuenta
     * @param identificador_inmueble
     * @param usuario
     * @return
     * @throws SQLException 
     */
    public List<String> obtenerCuenta(String identificador_inmueble, String usuario) throws SQLException{
        String sql = sql = "select s.actividades from cuenta c join servicios s on s.identificador = c.identificador_servicio where c.identificador_inmueble=? and c.identificador_usuarios=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, identificador_inmueble);
        ps.setString(2, usuario);
        ResultSet rs = ps.executeQuery();
        List<String> ls = new ArrayList();
        while (rs.next()) {
            ls.add(rs.getString("actividades"));        
        }
        return ls;            
        
    }
}
