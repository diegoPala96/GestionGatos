/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                    rs.setString    (3, ingreso.getFecha()+"");
				
				
		            
				
				
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
}
    
	       
