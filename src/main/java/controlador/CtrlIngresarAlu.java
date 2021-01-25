/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.MutableComboBoxModel;
import javax.swing.event.ListDataListener;
import main.Datos;
import modelo.Alumno;
import vista.frmIngresarAlu;
import modelo.Fecha;
import vista.frmInicio;

/**
 * 
 * @author Luiggi Pasache
 */
public class CtrlIngresarAlu {
    ArrayList<Alumno> modelo;
    frmIngresarAlu vista;

    public CtrlIngresarAlu(ArrayList<Alumno> modelo, frmIngresarAlu vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nombre = vista.txtNombre.getText().trim();
                    String apellido = vista.txtApellidos.getText().trim();
                    
                    if(nombre.isEmpty() || apellido.isEmpty()){
                        throw new NumberFormatException();
                    }
                    
                    int dia = Integer.parseInt((String) vista.cBdia.getSelectedItem());
                    int mes = Integer.parseInt((String) vista.cBmes.getSelectedItem());
                    int ano = Integer.parseInt((String) vista.cBano.getSelectedItem());
                    Fecha fecha = new Fecha(dia,mes,ano);
                    
                    if(!fecha.validar()){
                        throw new ArithmeticException();
                    }
                    
                    String nivel = (String) vista.cBnivel.getSelectedItem();
                    
                    String sexo = (String) vista.cBsexo.getSelectedItem();
                    
                    int grado = Integer.parseInt((String) vista.cBgrado.getSelectedItem());
                    
                    String seccion = vista.txtSeccion.getText().trim();

                    Datos.datosAlum.add(new Alumno(nombre, apellido, fecha, nivel, sexo, grado, seccion));
                    System.out.println(Datos.datosAlum);

                    vista.txtNombre.setText("");
                    vista.txtApellidos.setText("");
                    vista.txtSeccion.setText("");
                    
                    JOptionPane.showMessageDialog(vista, "Agregado exitosamente Alumno: "+nombre,"Error",1);
                    
                }catch(NumberFormatException excepcion){
                    
                    JOptionPane.showMessageDialog(vista, "Error en los elementos","Error",0);
                    
                }catch(ArithmeticException ex){
                    JOptionPane.showMessageDialog(vista, "Fecha ingresada incorrectamente","Error",0);

                }
            }
        });
        
        this.vista.cBgrado.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(vista.cBnivel.getSelectedIndex() == 0){
                    vista.cBgrado.removeAllItems();
                    System.out.println("hola1");
                    vista.cBgrado.addItem("1");
                    vista.cBgrado.addItem("2");
                    vista.cBgrado.addItem("3");
                    vista.cBgrado.addItem("4");
                    vista.cBgrado.addItem("5");

                }else if(vista.cBnivel.getSelectedIndex() == 1){
                    vista.cBgrado.removeAllItems();
                    System.out.println("hola2");

                    vista.cBgrado.addItem("1");
                    vista.cBgrado.addItem("2");
                    vista.cBgrado.addItem("3");
                    vista.cBgrado.addItem("4");
                    vista.cBgrado.addItem("5");
                    vista.cBgrado.addItem("6");
                }else if(vista.cBnivel.getSelectedIndex() == 2){
                    vista.cBgrado.removeAllItems();
                                System.out.println("hola3");

                    vista.cBgrado.addItem("1");
                    vista.cBgrado.addItem("2");
                    vista.cBgrado.addItem("3");
                    vista.cBgrado.addItem("4");
                    vista.cBgrado.addItem("5");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
        
        this.vista.btnRetroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmInicio fInicio = new frmInicio();
                CtrlInicio mInicio = new CtrlInicio(fInicio, modelo);
        
                mInicio.iniciar();
            }
        });
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        
    }
}
