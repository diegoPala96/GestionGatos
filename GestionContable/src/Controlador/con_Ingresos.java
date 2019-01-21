/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ingreso;
import java.util.List;
;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class con_Ingresos {

    private Conexion conexion = new Conexion();
    private Statement stmt;
    private ResultSet rs;
    PreparedStatement ps;
    private String consulta;

    public boolean Insert(Ingreso ingreso) {
        boolean retorno = false;
        consulta = "INSERT INTO Ingresos (detalle,monto,fecha) values(?,?,?) ";
        try {
            ps = conexion.getConexion().prepareStatement(consulta);
            ps.setString(1, ingreso.getDetalle());
            ps.setDouble(2, ingreso.getMonto());
            ps.setDate(3, (Date) ingreso.getFecha());

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

    public List<Ingreso> select() {
        List<Ingreso> listIngreso = new ArrayList<Ingreso>();
        consulta = "SELECT detalle,monto,fecha FROM Ingresos";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Ingreso mI = new Ingreso();
                mI.setDetalle(rs.getString("detalle"));
                mI.setMonto(rs.getDouble("monto"));
                mI.setFecha(rs.getDate("fecha"));
                listIngreso.add(mI);

            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listIngreso;
    }

    public List<Ingreso> selectFecha(String fecha) {
        List<Ingreso> ListIngreso = new ArrayList<Ingreso>();
        consulta = "SELECT detalle,monto,fecha FROM Ingresos WHERE fecha = '" + fecha + "'";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Ingreso ingr = new Ingreso();
                ingr.setDetalle(rs.getString("detalle"));
                ingr.setMonto(rs.getDouble("monto"));
                ingr.setFecha(rs.getDate("fecha"));
                ListIngreso.add(ingr);
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ListIngreso;
    }

    public boolean delete(Ingreso ingreso) {
        boolean retorno = false;
        consulta = "DELETE FROM Egresos WHERE detalle = '" + ingreso.getDetalle() + "'";
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
