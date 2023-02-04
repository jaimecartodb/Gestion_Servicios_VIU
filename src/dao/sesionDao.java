/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;
/**
 *
 * @author jaime
 */
public class sesionDao {
    static Connection con = DatabaseConnection.getConnection();
    /**
     * función que chequea el inicio de sesión correcto
     * @param usuario
     * @param contra
     * @return
     * @throws SQLException 
     */
    public Usuario inicioSesion(String usuario, String contra) throws SQLException{
        String sql = "SELECT * FROM usuarios where identificador=? and clave=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, contra);  
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        Usuario u = new Usuario();
        while (rs.next()) {
            check = true;
            u.setIdentificador(rs.getString("identificador"));
            u.setClave(rs.getString("clave"));
            u.setTipo_usuario(rs.getString("tipo_usuario"));
            u.setTelefono(rs.getString("telefono"));
            u.setEmail(rs.getString("email"));
            u.setBaja(rs.getBoolean("baja"));
        }
  
        if (check == true) {
            return u;
        }
        else{
            return null;
        }
    }  
}
