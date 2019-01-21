/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanix
 */
public class con_categoria {

    private Conexion conexion = new Conexion();
    private Statement stmt;
    private ResultSet rs;
    PreparedStatement ps;
    private String consulta;

    public con_categoria() {
    }

    public boolean Insert(Categoria categoria) {
        boolean retorno = false;
        consulta = "INSERT INTO Categorias (cat_nombre,cat_descripcion) values(?,?) ";
        try {
            ps = conexion.getConexion().prepareStatement(consulta);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());

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

    public List<Categoria> select() {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        consulta = "SELECT cat_nombre,cat_descripcion FROM Categorias ";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setNombre(rs.getString("cat_nombre"));
                cat.setDescripcion(rs.getString("cat_descripcion"));
                listaCategorias.add(cat);
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaCategorias;
    }

    public List<Categoria> selectNombre(String nombre) {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        consulta = "SELECT cat_nombre,cat_descripcion FROM Categorias WHERE cat_nombre LIKE '" + nombre + "%'";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setNombre(rs.getString("cat_nombre"));
                cat.setDescripcion(rs.getString("cat_descripcion"));
                listaCategorias.add(cat);
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaCategorias;
    }

    public int selectId(String nombre) {
        int id = 0;
        consulta = "SELECT cat_id FROM Categorias WHERE cat_nombre LIKE '" + nombre + "'";
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                id = rs.getInt("cat_id");
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }
    
    public String selectCateNom(int cat_id) {
        String nombre = "";
        consulta = "SELECT cat_nombre FROM Categorias WHERE cat_id =" + cat_id;
        try {
            stmt = conexion.getConexion().createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                nombre = rs.getString("cat_nombre");
            }
            rs.close();
            stmt.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return nombre;
    }

    public boolean delete(Categoria cat) {
        boolean retorno = false;
        System.out.println(cat.getNombre());
        consulta = "DELETE FROM Categorias WHERE cat_nombre = '" + cat.getNombre() + "'";
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
