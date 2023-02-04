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
import modelo.Liquidacion;

/**
 *
 * @author jaime
 */
public class liquidacionDao {
    static Connection con = DatabaseConnection.getConnection();
    /**
     * función que obtiene las liquidaciones
     * @param usuario
     * @param fecha_inicio
     * @param fecha_fin
     * @return
     * @throws SQLException 
     */
    public List<Liquidacion> obtenerLiquidaciones(String usuario, String fecha_inicio, String fecha_fin) throws SQLException{
        String sql = sql = "select s.actividades as servicio,\n" +
                "s.costo as costo, g.importe as importe, g.nombre_prov as proveedor,\n" +
                "g.email_prov, g.direccion_prov, r.nombre \n" +
                "from servicios s \n" +
                "left join rubro_servicio rs on rs.identificador_servicio = s.identificador \n" +
                "left join rubro r on r.identificador_rubro = rs.identificador_rubro \n" +
                "left join gasto_rubro gr on gr.identificador_rubro = rs.identificador_rubro \n" +
                "left join gastos g on g.id_gasto = gr.id_gasto \n" +
                "left join cuenta c on c.identificador_servicio = s.identificador \n" +
                "where g.fecha_registro >= ? and g.fecha_registro <=?  and c.identificador_usuarios =?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, fecha_inicio);
        ps.setString(2, fecha_fin);
        ps.setString(3, usuario);
        ResultSet rs = ps.executeQuery();
        List<Liquidacion> ls = new ArrayList();
        while(rs.next()){
            Liquidacion l = new Liquidacion(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            ls.add(l);
        }
        return ls;     
    }
}
