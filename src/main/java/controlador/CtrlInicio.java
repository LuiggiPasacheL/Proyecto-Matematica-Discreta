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

import modelo.Alumno;
import vista.frmBuscarAlu;
import vista.frmEditarAlu;
import vista.frmIngresarAlu;
import vista.frmInicio;
import vista.frmMostrarAlu;

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
        
        ActionListener buscarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmBuscarAlu vista = new frmBuscarAlu();
                //agregar controlador buscar
            }
        };
        
        ActionListener editarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                frmEditarAlu vistaEditar = new frmEditarAlu();
                CtrlEditarAlu controlEditar = new CtrlEditarAlu(modelo, vistaEditar);
                
                controlEditar.iniciar();
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
        vista.btnEditarAlum.addActionListener(editarAlu);
        vista.btnSalir.addActionListener(salir);
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);     
    }
    
}
    
