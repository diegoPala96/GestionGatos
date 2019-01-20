package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection conn;

 
    private final String driver;
    private final String user;
    private final String password;
    private final String url;

    public Conexion() {
        conn = null;
        driver = "com.mysql.cj.jdbc.Driver";
        user = "diegopalacios";
        password = "DHpc1996";
        url = "jdbc:mysql://db4free.net:3306/proyecto_compras";

    }

    public Connection getConexion() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion: " + ex);
        }
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al desconectar: " + ex);
        }
    }

}
