/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;

public class Alumno implements Serializable {

    private static int indice = 1;
    private int codigo;
    private String nombre;
    private String apellido;
    private Fecha fecha;
    private String nivel;
    private String sexo;
    private int grado;
    private String seccion;
    private boolean existe;

    //por si necesita cambiar nivel
    public Alumno(String nombre,String apellido, Fecha fecha, String nivel, String sexo, int grado, String seccion) {
        this.codigo = indice++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.nivel = nivel;
        this.sexo = sexo;
        this.grado = grado;
        this.seccion = seccion;
        this.existe = true; 
    }
    
    public Alumno(String nombre,String apellido, Fecha fecha, String sexo, int grado, String seccion) {
        this.codigo = indice++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.nivel = "Primaria";
        this.sexo = sexo;
        this.grado = grado;
        this.seccion = seccion;
        this.existe = true; 
    }
    
    
    //para buscar alumnos por nombre y apellido
    public Alumno(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        
        if (this.nombre.equals(other.nombre) && this.apellido.equals(other.apellido)){
            return true;
        }
        return false;
    }

    public static int getIndice() {
        return indice;
    }

    public static void setIndice(int indice) {
        Alumno.indice = indice;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    @Override
    public String toString() {
        return this.nombre+'-'+this.codigo;
    }
}
