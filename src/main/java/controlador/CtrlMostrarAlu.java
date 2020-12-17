/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import modelo.Alumno;
import vista.frmMostrarAlu;

/**
 * 
 * @author Luiggi Pasache
 */
public class CtrlMostrarAlu {

    ArrayList<Alumno> modelo;
    frmMostrarAlu vista;

    public CtrlMostrarAlu(ArrayList<Alumno> modelo, frmMostrarAlu vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);     
        
        //String[][] datos = new String[Datos.] 
        
        for (Iterator iterator = modelo.iterator(); iterator.hasNext();) {
            Alumno next = (Alumno) iterator.next();
            //this.vista.
        }
    }
}
