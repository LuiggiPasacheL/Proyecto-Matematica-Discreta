/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 * 
 * @author Luiggi Pasache
 */
public class Alumno {
    
    private int codigo;
    private String nombre;
    private Fecha fecha;
    private int edad;
    private char sexo;
    private int grado;
    private String seccion;
    private boolean existe;

    public Alumno(int codigo, String nombre, Fecha fecha, int edad, char sexo, int grado, String seccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.edad = edad;
        this.sexo = sexo;
        this.grado = grado;
        this.seccion = seccion;
        this.existe = true; 
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
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
    
    
}
