/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import modelo.Alumno;
import modelo.Fecha;

/**
 * 
 * @author Luiggi Pasache
 */
public class App {    
    public static void main(String[] args) {
        Datos.datosAlum.add(new Alumno(12,"luiggi",new Fecha(11,20,2000),15,'m', 12, "d"));
    }
}
