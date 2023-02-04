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
import modelo.Inmueble;
import modelo.usuarioInmueble;

/**
 *
 * @author jaime
 */
public class inmuebleDao {
    static Connection con = DatabaseConnection.getConnection();
    /**
     * función que inserta un inmueble
     * @param inm
     * @return
     * @throws SQLException 
     */
    public int insertarInmueble(Inmueble inm) throws SQLException{
        String sql = "INSERT INTO inmuebles(identificador, nombre) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, inm.getIdentificador());
        ps.setString(2, inm.getNombre());
        int n = ps.executeUpdate();
        return n;
    }
    /**
     * función que elimina un inmueble
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarInmueble(String identificador) throws SQLException{
        String sql = "DELETE FROM usuario_inmueble where identificador_inmueble=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, identificador);
        ps.executeUpdate();
        sql = "DELETE FROM inmuebles where identificador=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, identificador);
        ps.executeUpdate();
    }
    /**
     * función que modifica un inmueble
     * @param identificador
     * @param nombre
     * @throws SQLException 
     */
    public void modificarInmueble(String identificador, String nombre) throws SQLException{
        String sql = "UPDATE inmuebles set nombre=? where identificador=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, identificador);
        ps.executeUpdate();
    }
    /**
     * función que inserta un usuario inmueble
     * @param uinm
     * @return
     * @throws SQLException 
     */
    public int insertarUsuarioInmueble(usuarioInmueble uinm) throws SQLException{
        String sql = "INSERT INTO usuario_inmueble(identificador_usuario, identificador_inmueble) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, uinm.getIdentificador_usuario());
        ps.setString(2, uinm.getIdentificador_inmueble());
        int n = ps.executeUpdate();
        return n;        
    } 
    /**
     * función que obtiene los inmuebles
     * @return
     * @throws SQLException 
     */
    public List<Inmueble> obtenerInmuebles() throws SQLException{
        String sql = "SELECT i.identificador, i.nombre, ui.identificador_usuario FROM inmuebles i join usuario_inmueble ui on i.identificador = ui.identificador_inmueble";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Inmueble> ls = new ArrayList();
        while (rs.next()) {
            Inmueble i = new Inmueble(rs.getString("identificador"), rs.getString("nombre"));
            i.setUsuario(rs.getString("identificador_usuario"));
            ls.add(i);
        }
        return ls;      
    }
    /**
     * función que obtiene los usuarios
     * @return
     * @throws SQLException 
     */
    public List<String> obtenerUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuarios";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<String> ls = new ArrayList();
        while (rs.next()) {
            ls.add(rs.getString("identificador"));
        }
        return ls;
    }
}
