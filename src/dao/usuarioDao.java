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
import modelo.Usuario;

/**
 *
 * @author jaime
 */
public class usuarioDao {
    static Connection con = DatabaseConnection.getConnection();
    /**
     * función que inserta un usuario
     * @param u
     * @return
     * @throws SQLException 
     */
    public int insertarUsuario(Usuario u) throws SQLException{
        String sql = "INSERT INTO usuarios(identificador, clave, tipo_usuario, telefono, email, baja) VALUES (?,?,?,?,?,0)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getIdentificador());
        ps.setString(2, u.getClave());
        ps.setString(3, u.getTipo_usuario());
        ps.setString(4, u.getTelefono());
        ps.setString(5, u.getEmail());
        int n = ps.executeUpdate();
        return n;
    }
    /**
     * función que obtiene los usuarios
     * @return
     * @throws SQLException 
     */
    public List<Usuario> obtenerUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuarios";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Usuario> ls = new ArrayList();
        while (rs.next()) {
            ls.add(new Usuario(rs.getString(1),rs.getString(2),
                     rs.getString(3),rs.getString(4),rs.getString(5), rs.getBoolean(6)));
        }
        return ls;
    }
    /**
     * función que modifica un usuario
     * @param identificador
     * @param clave
     * @param telefono
     * @param email
     * @param baja
     * @throws SQLException 
     */
    public void modificarUsuario(String identificador, String clave, String telefono, String email, int baja) throws SQLException{
        String sql = "UPDATE usuarios set clave=?, telefono = ?, email=?, baja=? where identificador=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, clave);
        ps.setString(2, telefono);
        ps.setString(3, email);
        ps.setInt(4, baja);
        ps.setString(5, identificador);
        ps.executeUpdate();
        System.out.println("aqui");
    }
    /**
     * función que elimina un usuario
     * @param identificador
     * @throws SQLException 
     */
    public void eliminarUsuario(String identificador) throws SQLException{
        String sql = "DELETE FROM usuarios where identificador = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, identificador);
        ps.executeUpdate();
    }
}
