/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Sanix
 */
public class Usuario {

    private ArrayList<Persona> usuarios = new ArrayList<>();

    public Usuario() {
        this.usuarios = this.usuarios;
    }

    public boolean agregarUsuario(Persona persona) {
        boolean resultado = false;
        if (usuarios.add(persona)) {
            resultado = true;
        }
        return resultado;
    }

    public boolean Login(String usuario, String password) {
        boolean resultado = false;
        try {
            for (Persona persona : usuarios) {
                if ((usuario.equals(persona.getUsuario())) && (password.equals(persona.getPassword()))) {
                    resultado = true;
                }
            }
        } catch (Exception e) {
            resultado = false;
            System.out.println(e);
        }
        return resultado;
    }

    public ArrayList<Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Persona> usuarios) {
        this.usuarios = usuarios;
    }

}
