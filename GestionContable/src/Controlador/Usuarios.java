/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sanix
 */
public class Usuarios {

    private Conexion conexion = new Conexion();
    ;
    private Statement stmt;
    private ResultSet rs;
    private String consulta;

    public Usuarios() {

    }

    public boolean login(Usuario usuario) {
        boolean retorno = false;
        consulta = "SELECT usr_username, usr_password FROM Usuarios WHERE usr_username LIKE '" + usuario.getUsername() + "' AND usr_password LIKE '" + usuario.getPassword() + "'";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                if (rs.getString(1).equals(usuario.getUsername()) && rs.getString(2).equals(usuario.getPassword())) {
                    retorno = true;
                }
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            retorno = false;
            System.out.println(e);
        }
        return retorno;
    }
}
