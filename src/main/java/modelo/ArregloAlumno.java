/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 
 * @author Luiggi Pasache
 */
public class ArregloAlumno {
    
    ArrayList<Alumno> alumnoA;

    public ArregloAlumno() {
        alumnoA = new ArrayList<Alumno>();
    }

    public boolean add(Alumno a){
        try{
            alumnoA.add(a);
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
    
    public boolean validar(Alumno a){
        if(alumnoA.indexOf(a) == -1){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean borrar(Alumno a){
        try{
            alumnoA.remove(a);
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
}
