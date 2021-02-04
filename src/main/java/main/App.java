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
        Datos.datosAlum = (Sistema) deserializar("Alumnos.dat");

        Alumno.setIndice(Datos.datosAlum.dimension()+1);

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

    public static Alumno[] quickSortNombre(Alumno[] alumno){
        Alumno[] resultado = alumno;

        if(resultado.length < 1){
            return new Alumno[]{};
        }

        Alumno[] arrayi = new Alumno[]{};
        Alumno[] arrayd = new Alumno[]{};

        Alumno pivote = resultado[0];

        for(int i = 1 ; i < resultado.length; i++){
            if(resultado[i].getNombre().compareTo(pivote.getNombre()) < 0){
                arrayi = concatenar(arrayi, new Alumno[] { resultado[i] });
            } else {
                arrayd = concatenar(arrayd, new Alumno[] { resultado[i] });
            }
        }

        resultado = concatenar(quickSortNombre(arrayi), new Alumno[] { pivote });

        resultado = concatenar(resultado,arrayd);

        return resultado;
    }


    private static Alumno[] concatenar(Alumno[] vector1, Alumno[] vector2) {
        Alumno[] resultado = new Alumno[vector1.length+vector2.length];

        for(int i=0;i < vector1.length ; i++){
            resultado[i] = vector1[i];
        }

        for(int i=vector1.length; i < vector2.length ; i++){
            resultado[i] = vector2[i - vector1.length];
        }

        return resultado;
    }
}
