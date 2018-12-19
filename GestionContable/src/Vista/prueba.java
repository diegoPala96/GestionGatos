/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Persona;
import Modelo.Usuario;

/**
 *
 * @author Sanix
 */
public class prueba {
    public static void main(String[] args) {
        Persona persona = new Persona("0106229164", "Jorge", "Sanisaca", 12, "jsanisaca", "cuenca");
        Usuario user = new Usuario();
        if(user.agregarUsuario(persona)){
            System.out.println("usuario agregado");
        }
        if(user.Login("jsanisaca", "cuenca")){
            System.out.println("El usuario eciste");
        }else{
            System.out.println("No existe");
        }
    }
}
