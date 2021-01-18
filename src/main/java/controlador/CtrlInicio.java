/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.Datos;

import modelo.Alumno;
import vista.frmEditarAlu;
import vista.frmIngresarAlu;
import vista.frmInicio;

/**
 * 
 * @author Luiggi Pasache
 */

public class CtrlInicio {
    frmInicio vista;
    ArrayList<Alumno> modelo;
    
    public CtrlInicio(frmInicio vista, ArrayList<Alumno> modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        ActionListener ingresarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmIngresarAlu fIngresar = new frmIngresarAlu();
                CtrlIngresarAlu mIngresar = new CtrlIngresarAlu(modelo, fIngresar);
                mIngresar.iniciar();
            }
        };
        
        ActionListener editarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vista.dispose();
                
                Datos.indiceALumnoSeleccionado = vista.tblAlumnos.getSelectedRow() + 1;
                
                frmEditarAlu fEditar = new frmEditarAlu();              
                CtrlEditarAlu cEditar = new CtrlEditarAlu(modelo, fEditar);
                cEditar.iniciar();
            }
        };
        
        ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Saliendo del sistema...");
                JOptionPane.showMessageDialog(vista, "Salir del sistema");
                System.exit(0);
            }
        };
        
        vista.btnIngresarAlumnos.addActionListener(ingresarAlu);
        
        vista.btnSalir.addActionListener(salir);
        
        vista.btnEditarAlumno.addActionListener(editarAlu);
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);     
        
        String[][] datos = new String[Datos.datosAlum.size()][8];
        
        for (int i = 0; i < Datos.datosAlum.size(); i++) {
            datos[i][0] = String.valueOf(Datos.datosAlum.get(i).getCodigo());
            datos[i][1] = Datos.datosAlum.get(i).getNombre();
            datos[i][2] = Datos.datosAlum.get(i).getApellido();
            datos[i][3] = Datos.datosAlum.get(i).getFecha().toString();
            datos[i][4] = Datos.datosAlum.get(i).getSexo();
            datos[i][5] = Datos.datosAlum.get(i).getNivel();
            datos[i][6] = String.valueOf(Datos.datosAlum.get(i).getGrado());
            datos[i][7] = Datos.datosAlum.get(i).getSeccion();
        }
        
        String[] cabecera = {"ID","Nombre","Apellidos","Fecha Nac","Sexo","Nivel","Grado","Seccion"};
        
        DefaultTableModel tabla = new DefaultTableModel(datos,cabecera);
        
        this.vista.tblAlumnos.setModel(tabla);
        
    }
    
}
    
