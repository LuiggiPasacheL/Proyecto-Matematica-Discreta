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
public class Fecha {

    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return " dia: "+dia+" mes: "+mes+" año: "+ano;
    }


}
