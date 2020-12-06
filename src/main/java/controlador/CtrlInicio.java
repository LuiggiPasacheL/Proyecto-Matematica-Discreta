/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ArregloAlumno;
import vista.frmBuscarAlu;
import vista.frmEliminarAlu;
import vista.frmIngresarAlu;
import vista.frmInicio;
import vista.frmMostrarAlu;

/**
 * 
 * @author Luiggi Pasache
 */
public class CtrlInicio {
    frmInicio vista;
    ArregloAlumno modelo;
    
    public CtrlInicio(frmInicio vista, ArregloAlumno modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        ActionListener ingresarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmIngresarAlu vista = new frmIngresarAlu();
                //agregar controlador ingresarALu
            }
        };
        
        ActionListener buscarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmBuscarAlu vista = new frmBuscarAlu();
                //agregar controlador buscar
            }
        };
        
        ActionListener eliminarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmEliminarAlu vista = new frmEliminarAlu();
                //agregar controlador eliminar
            }
        };
        
        ActionListener mostrarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmMostrarAlu vista = new frmMostrarAlu();
                //agregar controlador mostrar
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
        
        vista.btnIngresarAlum.addActionListener(ingresarAlu);
        vista.btnMostrarAlum.addActionListener(mostrarAlu);
        vista.btnbuscarAlum.addActionListener(buscarAlu);
        vista.btnEliminarAlum.addActionListener(eliminarAlu);
        vista.btnSalir.addActionListener(salir);
    }
}
