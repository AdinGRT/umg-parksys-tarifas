package com.adingrt.datos;

import com.adingrt.model.Tarifa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gian_
 */
public class TarifaDao {

    private static final String SQL_LISTAR_TODO = "SELECT t.id_tarifa, v.descripcion_tipo_vehiculo, tt.descripcion_tipo_tarifa, t.monto_tarifa\n"
            + "FROM tarifa t\n"
            + "INNER JOIN tipo_vehiculo v ON t.id_tipo_vehiculo = v.id_tipo_vehiculo\n"
            + "INNER JOIN tipo_tarifa tt ON t.id_tipo_tarifa = tt.id_tipo_tarifa";
    
    private static final String SQL_UPDATE_TARIFA = "UPDATE tarifa SET monto_tarifa = ? WHERE id_tarifa = ?";
    
    
    
    public int actualizarTarifa(Tarifa tarifa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.conectar();
            stmt = conn.prepareStatement(SQL_UPDATE_TARIFA);
            stmt.setDouble(1, tarifa.getMontoTarifa());
            stmt.setInt(2, tarifa.getIdTarifa());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.desconectar(stmt);
                Conexion.desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return rows;
    }
    
    public List<Tarifa> listarTodo() {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarifa tarifa =  null;
        List<Tarifa> tarifas = new ArrayList<>();
        try {
            conn = Conexion.conectar();
            stmt = conn.prepareStatement(SQL_LISTAR_TODO);
            rs = stmt.executeQuery();
            while (rs.next()) {
                tarifa = new Tarifa();
                tarifa.setIdTarifa(rs.getInt(1));
                tarifa.setTipoVehiculo(rs.getString(2));
                tarifa.setTipoTarifa(rs.getString(3));
                tarifa.setMontoTarifa(rs.getDouble(4));
                tarifas.add(tarifa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.desconectar(rs);
                Conexion.desconectar(stmt);
                Conexion.desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return tarifas;
    }
}
