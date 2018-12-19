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
        Persona persona1 = new Persona("0106229164", "Jorge", "Sanisaca", 12, "jbarbebecho", "cuenca");
        Persona persona2 = new Persona("0106229164", "Jorge", "Sanisaca", 12, "apaqui", "cuenca");
        Persona persona3 = new Persona("0106229164", "Jorge", "Sanisaca", 12, "jsanisaca", "cuenca");
        Usuario user = new Usuario();
        user.agregarUsuario(persona1);
        user.agregarUsuario(persona2);
        user.agregarUsuario(persona3);
        if(user.Login("apaqui", "cuenca")){
            System.out.println("El usuario eciste");
        }else{
            System.out.println("No existe");
        }
    }
}
