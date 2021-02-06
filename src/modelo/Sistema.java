package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Sistema implements Serializable{
    
    private ArrayList<Alumno> alumno;

    public Sistema() {
        this.alumno = new ArrayList<Alumno>();
    }

    public void add(Alumno a){
        a.setCodigo(alumno.size() + 1);
        this.alumno.add(a);
    }
    
    public void addArreglo(Alumno[] alumno){
        for(Alumno a : alumno){
            try{
                add(a);
            }catch(IndexOutOfBoundsException e){
                break;
            }
        }
    }
    
    public Alumno get(int i){
        return this.alumno.get(i);
    }

    public Alumno[] getDatos(){
        return (Alumno[]) this.alumno.toArray(new Alumno[this.alumno.size()]);
    }

    public static String[] getCabecera(){
        return new String[]{"ID","Nombre","Apellidos","Fecha Nac","Sexo","Nivel","Grado","Seccion"};
    }

    public int dimension(){
        return alumno.size();
    }

    public String[][] getDatosString(){
        String[][] datos = new String[alumno.size()][8];

        for (int i = 0; i < alumno.size(); i++) {
            datos[i][0] = String.valueOf(alumno.get(i).getCodigo());
            datos[i][1] = alumno.get(i).getNombre();
            datos[i][2] = alumno.get(i).getApellido();
            datos[i][3] = alumno.get(i).getFecha().toString();
            datos[i][4] = alumno.get(i).getSexo();
            datos[i][5] = alumno.get(i).getNivel();
            datos[i][6] = String.valueOf(alumno.get(i).getGrado());
            datos[i][7] = alumno.get(i).getSeccion();
        }

        return datos;
    }
    
    public static Alumno[] quickSortApellido(Alumno[] vector){
         if(vector.length < 1){
             return new Alumno[]{};
         }

         Alumno[] arrayi = new Alumno[]{};
         Alumno[] arrayd = new Alumno[]{};
         Alumno pivote = vector[0];

         for (int i = 1; i < vector.length;i++){
             //unir los array (derecha/izquierda) con el elemento
             if(vector[i].getApellido().compareTo(pivote.getApellido()) < 0 ){
                 arrayi = concatenar(arrayi,new Alumno[]{vector[i]});
             }
             else{
                 arrayd = concatenar(arrayd,new Alumno[]{vector[i]});
             }
         }

         Alumno[] resultado = concatenar(quickSortApellido(arrayi),new Alumno[]{pivote});

         resultado = concatenar(resultado,quickSortApellido(arrayd));

         return resultado;

    }
    
    public static Alumno[] quickSortNombre(Alumno[] vector){
         if(vector.length < 1){
             return new Alumno[]{};
         }

         Alumno[] arrayi = new Alumno[]{};
         Alumno[] arrayd = new Alumno[]{};
         Alumno pivote = vector[0];

         for (int i = 1; i < vector.length;i++){
             //unir los array (derecha/izquierda) con el elemento
             if(vector[i].getNombre().compareTo(pivote.getNombre()) < 0 ){
                 arrayi = concatenar(arrayi,new Alumno[]{vector[i]});
             }
             else{
                 arrayd = concatenar(arrayd,new Alumno[]{vector[i]});
             }
         }

         Alumno[] resultado = concatenar(quickSortNombre(arrayi),new Alumno[]{pivote});

         resultado = concatenar(resultado,quickSortNombre(arrayd));

         return resultado;

    }

    public static Alumno[] quickSortSeccion(Alumno[] vector){
         if(vector.length < 1){
             return new Alumno[]{};
         }

         Alumno[] arrayi = new Alumno[]{};
         Alumno[] arrayd = new Alumno[]{};
         Alumno pivote = vector[0];

         for (int i = 1; i < vector.length;i++){
             //unir los array (derecha/izquierda) con el elemento
             if(vector[i].getSeccion().compareTo(pivote.getSeccion()) < 0 ){
                 arrayi = concatenar(arrayi,new Alumno[]{vector[i]});
             }
             else{
                 arrayd = concatenar(arrayd,new Alumno[]{vector[i]});
             }
         }

         Alumno[] resultado = concatenar(quickSortSeccion(arrayi),new Alumno[]{pivote});

         resultado = concatenar(resultado,quickSortSeccion(arrayd));

         return resultado;

    }

    public static Alumno[] quickSortID(Alumno[] vector){
         if(vector.length < 1){
             return new Alumno[]{};
         }

         Alumno[] arrayi = new Alumno[]{};
         Alumno[] arrayd = new Alumno[]{};
         Alumno pivote = vector[0];

         for (int i = 1; i < vector.length;i++){
             //unir los array (derecha/izquierda) con el elemento
             if(vector[i].getCodigo() < pivote.getCodigo() ){
                 arrayi = concatenar(arrayi,new Alumno[]{vector[i]});
             }
             else{
                 arrayd = concatenar(arrayd,new Alumno[]{vector[i]});
             }
         }

         Alumno[] resultado = concatenar(quickSortID(arrayi),new Alumno[]{pivote});

         resultado = concatenar(resultado,quickSortID(arrayd));

         return resultado;

    }

    public static Alumno[] concatenar(Alumno[] vector1, Alumno[]vector2){

        Alumno[] resultado = new Alumno[vector1.length+vector2.length];

        for(int i=0;i < vector1.length ; i++){
            resultado[i] = vector1[i];
        }

        for(int i=0; i < vector2.length ; i++){
            resultado[i + vector1.length] = vector2[i];
        }

        return resultado;

    }

    public void remove (int indice){
       alumno.remove(indice);

    }
    
}
