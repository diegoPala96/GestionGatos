/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Sanix
 */
public class fecha {

    public fecha() {
    }
    
    
    public boolean esFecha(String strFecha) {
        boolean retorno = false;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
            retorno = true;
        } catch (ParseException ex) {
            System.out.println(ex);
            retorno = false;
        }
        return retorno;
    }
}
