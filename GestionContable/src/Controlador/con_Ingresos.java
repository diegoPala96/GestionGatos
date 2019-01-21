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
  //    PreparedStatement rs;
    private ResultSet rs;
    private String consulta="";
  //   consulta = "INSERT INTO Ingresos (descripcion,monto,fecha) values(?,?,?) ";
     public void Insert(Ingreso ingreso) {
		Connection c=null;
        
		 String query  = "INSERT INTO Ingresos (detalle,monto,fecha) values(?,?,?) ";
		
		
	       
	       try {
	    	   
	    	   c=conexion.getConexion();
		
                   PreparedStatement rs=c.prepareStatement(query);
                   
                  
                    rs.setString    (1, ingreso.getDetalle());
	            rs.setDouble    (2, ingreso.getMonto());
                    rs.setDate    (3, (Date) ingreso.getFecha());
				
				
		            
				
				
	            // Indicamos que comience la actualizaciï¿½n de la tabla en nuestra base de datos
	            rs.executeUpdate();
	        	JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
	            // Cerramos las conexiones, en orden inverso a su apertura
	    

	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
		conexion.desconectar();
	}
     }

 public List<Ingreso> select() {
     List<Ingreso> listProveedor= new ArrayList<Ingreso>();    
     
        boolean retorno = false;
        consulta = "SELECT detalle,monto,fecha FROM Ingresos ";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Ingreso mI=new Ingreso();
                mI.setDetalle(rs.getString("detalle"));
                mI.setMonto(rs.getDouble("monto"));
                mI.setFecha(rs.getDate("fecha"));
                
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            retorno = false;
            System.out.println(e);
        }
        return listProveedor;
    }




}
    
	       
