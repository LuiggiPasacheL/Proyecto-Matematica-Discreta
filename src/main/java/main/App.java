/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controlador.CtrlInicio;
import modelo.Alumno;
import modelo.Fecha;
import vista.frmInicio;

/**
 * 
 * @author Luiggi Pasache
 */
public class App {    
    
    public static void main(String[] args) {
        
        Datos.datosAlum.add(new Alumno("luiggi","pasache", new Fecha(21,8,2000), "Secundaria", "Masculino", 5, "C"));
        Datos.datosAlum.add(new Alumno("steep","lopera" ,new Fecha(21,8,2000), "Secundaria", "Masculino", 5, "D"));
        
        frmInicio vista = new frmInicio();
        CtrlInicio controlador = new CtrlInicio(vista, Datos.datosAlum);
        
        controlador.iniciar();
    }
}
