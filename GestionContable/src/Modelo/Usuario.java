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

    private ArrayList<Persona> usuarios;

    public Usuario() {
        this.usuarios = new ArrayList<>();
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
        for (Persona persona : usuarios) {
            if ((usuario.equals(persona.getUsuario())) && (usuario.equals(persona.getPassword()))) {
                resultado = true;
            }
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
