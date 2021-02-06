/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controlador.CtrlInicio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Sistema;
import vista.frmInicio;

public class App {    
    
    public static void main(String[] args) {
        
        File file = new File("Alumnos.dat");

        //EN CASO QUE EL ARCHIVO CUENTAS NO EXISTA CREAR UNO POR DEFAULT//    
        if(!file.exists()){  
            serializar("Alumnos.dat", Datos.datosAlum);
        }
    
        //DESERIALZIANDO
        
        Sistema aux = (Sistema) deserializar("Alumnos.dat");
        
        Datos.datosAlum.addArreglo(aux.getDatos()); 
        
        frmInicio vista = new frmInicio();
        CtrlInicio controlador = new CtrlInicio(vista, Datos.datosAlum);
        
        controlador.iniciar();

    }

    public static void serializar ( String sNombreArchivo, Object  obj ) {
        try {
            ObjectOutputStream escritor = 
              new  ObjectOutputStream (
                      new FileOutputStream (sNombreArchivo));
            escritor.writeObject(obj);
            escritor.flush();
            escritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
   
    public static Object deserializar (String sNombreArchivo) {
        Object  obj  = new Object ();
        try{
            ObjectInputStream lector = 
                new ObjectInputStream(
                        new FileInputStream(sNombreArchivo)); 
            obj  = (Object)lector.readObject();
            lector.close();
        } catch ( FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return obj;    
    }

}
