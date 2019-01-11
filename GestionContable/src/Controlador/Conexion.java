package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	static Connection con = null;

	String url = "jdbc:mysql://db4free.net:3306/proyecto_compras";
	String user = "diegopalacios";
	String pass = "DHpc1996";

	public Conexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, pass);

			System.out.println("conexion exitosa");
 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de conexion" + e);
		}

	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return con;
	}

	public static void close(Connection c) {
		// TODO Auto-generated method stub
		
	}



}
