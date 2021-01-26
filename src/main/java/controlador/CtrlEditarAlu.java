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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import main.App;
import main.Datos;
import modelo.Alumno;
import modelo.Fecha;
import vista.frmEditarAlu;
import vista.frmInicio;

/**
 * 
 * @author Luiggi Pasache
 */
public class CtrlEditarAlu {
    ArrayList<Alumno> modeloM;
    frmEditarAlu vista;

    public CtrlEditarAlu(ArrayList<Alumno> modelo, frmEditarAlu vista) {
        this.modeloM = modelo;
        this.vista = vista;
        
        ActionListener volverInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                
                frmInicio fInicio = new frmInicio();
                CtrlInicio mInicio = new CtrlInicio(fInicio, modelo);
                
                mInicio.iniciar();
            }
        };
        
        this.vista.btnRetroceder.addActionListener(volverInicio);
        
        this.vista.btnEditar.addActionListener(new ActionListener() {
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
                    
                    
                    String sexo = (String) vista.cBSexo.getSelectedItem();
                    
                    int grado = Integer.parseInt((String) vista.cBGrado.getSelectedItem());
                    
                    String seccion = vista.txtSeccion.getText().trim();
                    
                    int i = vista.cBAlumnos.getSelectedIndex()-1;
                    
                    if(i != -1){
                    
                        System.out.println(i);
                        
                        Datos.datosAlum.get(i).setNombre(nombre);
                        Datos.datosAlum.get(i).setApellido(apellido);
                        Datos.datosAlum.get(i).setFecha(fecha);
                        Datos.datosAlum.get(i).setSexo(sexo);
                        Datos.datosAlum.get(i).setGrado(grado);
                        Datos.datosAlum.get(i).setSeccion(seccion);

                        System.out.println(Datos.datosAlum);

                        JOptionPane.showMessageDialog(vista, "Modificado exitosamente Alumno: "+nombre);
                        
                        volverInicio.actionPerformed(e);

                        App.serializar("Alumnos", modelo);
                    }
                }catch(Exception excepcion){ //agregar mas errores
                    JOptionPane.showMessageDialog(vista, "Error al editar alumno, datos erroneos","Error",0);
                    
                }
            }
        });
        
        this.vista.cBAlumnos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int i = vista.cBAlumnos.getSelectedIndex()-1;
                    
                if(i != -1){
                    Alumno a = (Alumno) vista.cBAlumnos.getSelectedItem();
                    System.out.println(a);
                    vista.txtID.setText(String.valueOf(a.getCodigo()));
                    vista.txtNombre.setText(a.getNombre());
                    vista.txtApellidos.setText(a.getApellido());
                    vista.txtSeccion.setText(a.getSeccion());
                    vista.cBSexo.setSelectedItem(a.getSexo());
                    vista.cBdia.setSelectedItem(String.valueOf(a.getFecha().getDia()));
                    vista.cBano.setSelectedItem(String.valueOf(a.getFecha().getAno()));
                    vista.cBmes.setSelectedItem(String.valueOf(a.getFecha().getMes()));
                    vista.cBGrado.setSelectedItem(String.valueOf(a.getGrado()));
                }
                else{
                    vista.txtNombre.setText("");
                    vista.txtApellidos.setText("");
                    vista.txtSeccion.setText("");
                    vista.txtID.setText("");
                }
            }
        });
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);

        DefaultComboBoxModel modeloAlumnos = new DefaultComboBoxModel();
        Alumno[] alumnoArreglo = Datos.datosAlum.toArray(new Alumno[Datos.datosAlum.size()]);
        modeloAlumnos.addElement("Seleccione -- Alumno");
        for(Object a: alumnoArreglo){
            modeloAlumnos.addElement(a);
        }
        
        this.vista.cBAlumnos.setModel(modeloAlumnos);
        
        this.vista.cBAlumnos.setSelectedIndex(Datos.indiceALumnoSeleccionado);
    }
}
