/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;

public class Fecha implements Serializable {

    private int dia;
    private int mes;
    private int ano;
    
    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    /*
    public static void main(String[] args) {
        Fecha f = new Fecha(30,4,2000);
        System.out.println(f.validar());
    }*/
    
    public boolean validar(){
        
        if(dia>0 && dia<=28 && mes>0 && mes<=12)  {
            return true;
        }
        if(dia == 29 && mes == 2 && (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0)){
            return true;
        }
        if(dia>28 && dia<=30 &&(mes == 4 || mes == 6 || mes == 9 || mes == 11)){
            return true;
        }
        if(dia>28 && dia<=31 && ( mes != 2 && mes != 4 && mes != 6 && mes != 9 && mes != 11)){
            return true;
        }
        
        return false;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        return String.valueOf(dia)+'/'+String.valueOf(mes)+'/'+String.valueOf(ano);
    }


}
