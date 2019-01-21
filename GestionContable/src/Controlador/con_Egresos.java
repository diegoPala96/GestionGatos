/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Egreso;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanix
 */
public class con_Egresos {

    private Conexion conexion = new Conexion();
    private Statement stmt;
    private ResultSet rs;
    PreparedStatement ps;
    private String consulta;

    public con_Egresos() {
    }

    public boolean Insert(Egreso egreso) {
        boolean retorno = false;
        consulta = "INSERT INTO Egresos (egr_detalle,egr_monto,egr_fecha, egr_categoria_id) values(?,?,?,?) ";
        try {
            ps = conexion.getConexion().prepareStatement(consulta);
            ps.setString(1, egreso.getDetalle());
            ps.setDouble(2, egreso.getMonto());
            ps.setDate(3, (Date) egreso.getFecha());
            ps.setInt(4, egreso.getCategoria());

            ps.executeUpdate();

            ps.close();
            conexion.desconectar();
            retorno = true;
        } catch (Exception e) {
            System.out.println(e);
            retorno = false;
        }
        return retorno;
    }

    public List<Egreso> select() {
        List<Egreso> listEgresos = new ArrayList<Egreso>();
        consulta = "SELECT egr_detalle,egr_monto,egr_fecha, egr_categoria_id FROM Egresos ";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Egreso egr = new Egreso();
                egr.setDetalle(rs.getString("egr_detalle"));
                egr.setMonto(rs.getDouble("egr_monto"));
                egr.setFecha(rs.getDate("egr_fecha"));
                egr.setCategoria(rs.getInt("egr_categoria_id"));
                listEgresos.add(egr);
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listEgresos;
    }

    public List<Egreso> selectCategoria(int cat_id) {
        List<Egreso> listEgresos = new ArrayList<Egreso>();
        consulta = "SELECT egr_detalle,egr_monto,egr_fecha, egr_categoria_id FROM Egresos WHERE egr_categoria_id = " + cat_id;
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Egreso egr = new Egreso();
                egr.setDetalle(rs.getString("egr_detalle"));
                egr.setMonto(rs.getDouble("egr_monto"));
                egr.setFecha(rs.getDate("egr_fecha"));
                egr.setCategoria(rs.getInt("egr_categoria_id"));
                listEgresos.add(egr);
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listEgresos;
    }

    public List<Egreso> selectFecha(String fecha) {
        List<Egreso> listEgresos = new ArrayList<Egreso>();
        consulta = "SELECT egr_detalle,egr_monto,egr_fecha, egr_categoria_id FROM Egresos WHERE egr_fecha = '" + fecha + "'";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Egreso egr = new Egreso();
                egr.setDetalle(rs.getString("egr_detalle"));
                egr.setMonto(rs.getDouble("egr_monto"));
                egr.setFecha(rs.getDate("egr_fecha"));
                egr.setCategoria(rs.getInt("egr_categoria_id"));
                listEgresos.add(egr);
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listEgresos;
    }

    public boolean delete(Egreso egreso) {
        boolean retorno = false;
        consulta = "DELETE FROM Egresos WHERE egr_detalle = '" + egreso.getDetalle() + "' AND egr_categoria_id = " + egreso.getCategoria();
        try {
            stmt = conexion.getConexion().createStatement();
            stmt.execute(consulta);
            retorno = true;
        } catch (SQLException ex) {
            System.out.println("ex");
        }
        return retorno;
    }
}
