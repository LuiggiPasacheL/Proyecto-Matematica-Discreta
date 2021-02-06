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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import main.App;
import main.Datos;

import modelo.Alumno;
import modelo.Sistema;
import vista.frmEditarAlu;
import vista.frmIngresarAlu;
import vista.frmInicio;

public class CtrlInicio {
    frmInicio vista;
    Sistema modelo;
    int columnaAFiltrar;

    public CtrlInicio(frmInicio vista, Sistema modelo){
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
        
        ActionListener eliminarAlu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(vista.tblAlumnos.getSelectedRow() < 0){
                    JOptionPane.showMessageDialog(vista, "Debe seleccionar algun Alumno");
                    return;
                }
                    
                Datos.indiceALumnoSeleccionado = vista.tblAlumnos.getSelectedRow();

                int opc = JOptionPane.showConfirmDialog(vista, "¿Esta seguro de borrar al alumno: "+Datos.datosAlum.get(Datos.indiceALumnoSeleccionado).getNombre(),"Borrar alumno",0);

                if(opc == 1){
                    return;
                }

                Datos.datosAlum.remove(Datos.indiceALumnoSeleccionado);

                int i = 0;

                for(Alumno a : Datos.datosAlum.getDatos()){
                    i++;
                    a.setCodigo(i);
                    System.out.println(a);
                }

                vista.dispose();

                iniciar();

                App.serializar("Alumnos.dat",Datos.datosAlum);
            }
        };
        
        
        vista.btnIngresarAlumnos.addActionListener(ingresarAlu);
        
        vista.btnEliminarAlumno.addActionListener(eliminarAlu);
        
        vista.btnEditarAlumno.addActionListener(editarAlu);
        
        vista.txtFiltrar.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e){
                
                if(vista.rDFiltroxApellido.isSelected()){
                    columnaAFiltrar = 2;
                }else if(vista.rDFiltroxGrado.isSelected()){
                    columnaAFiltrar = 6;
                }else if(vista.rDFiltroxNombre.isSelected()){
                    columnaAFiltrar = 1;
                }else if(vista.rDFiltroxSeccion.isSelected()){
                    columnaAFiltrar = 7;
                }else{
                    JOptionPane.showMessageDialog(vista, "Seleccione una opcion");
                }
                
                vista.trs.setRowFilter(RowFilter.regexFilter(vista.txtFiltrar.getText(), columnaAFiltrar));
            }
            
        });
        
        ActionListener ordenarXApellido = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] cabecera = Sistema.getCabecera();
                
                Alumno[] ordenado = Sistema.quickSortApellido(modelo.getDatos());
                
                String[][] datos = new String[Datos.datosAlum.dimension()][8];
                
                for (int i = 0; i < modelo.dimension(); i++) {
                    datos[i][0] = String.valueOf(ordenado[i].getCodigo());
                    datos[i][1] = ordenado[i].getNombre();
                    datos[i][2] = ordenado[i].getApellido();
                    datos[i][3] = ordenado[i].getFecha().toString();
                    datos[i][4] = ordenado[i].getSexo();
                    datos[i][5] = ordenado[i].getNivel();
                    datos[i][6] = String.valueOf(ordenado[i].getGrado());
                    datos[i][7] = ordenado[i].getSeccion();
                }
                
                vista.trs.setRowFilter(RowFilter.regexFilter(vista.txtFiltrar.getText(), columnaAFiltrar));
                
                DefaultTableModel tabla = new DefaultTableModel(datos,cabecera);
                
                vista.trs = new TableRowSorter(tabla);
                vista.tblAlumnos.setRowSorter(vista.trs);
                vista.tblAlumnos.setModel(tabla);
            }
        };
        
        ActionListener ordenarxNombre = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] cabecera = Sistema.getCabecera();
                
                Alumno[] ordenado = Sistema.quickSortNombre(modelo.getDatos());
                
                String[][] datos = new String[Datos.datosAlum.dimension()][8];
                
                for (int i = 0; i < modelo.dimension(); i++) {
                    datos[i][0] = String.valueOf(ordenado[i].getCodigo());
                    datos[i][1] = ordenado[i].getNombre();
                    datos[i][2] = ordenado[i].getApellido();
                    datos[i][3] = ordenado[i].getFecha().toString();
                    datos[i][4] = ordenado[i].getSexo();
                    datos[i][5] = ordenado[i].getNivel();
                    datos[i][6] = String.valueOf(ordenado[i].getGrado());
                    datos[i][7] = ordenado[i].getSeccion();
                }
                
                vista.trs.setRowFilter(RowFilter.regexFilter(vista.txtFiltrar.getText(), columnaAFiltrar));
                
                DefaultTableModel tabla = new DefaultTableModel(datos,cabecera);
                
                vista.trs = new TableRowSorter(tabla);
                vista.tblAlumnos.setRowSorter(vista.trs);
                vista.tblAlumnos.setModel(tabla);
            }
        };
        ActionListener ordenarxID = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] cabecera = Sistema.getCabecera();
                
                Alumno[] ordenado = Sistema.quickSortID(modelo.getDatos());
                
                String[][] datos = new String[Datos.datosAlum.dimension()][8];
                
                for (int i = 0; i < modelo.dimension(); i++) {
                    datos[i][0] = String.valueOf(ordenado[i].getCodigo());
                    datos[i][1] = ordenado[i].getNombre();
                    datos[i][2] = ordenado[i].getApellido();
                    datos[i][3] = ordenado[i].getFecha().toString();
                    datos[i][4] = ordenado[i].getSexo();
                    datos[i][5] = ordenado[i].getNivel();
                    datos[i][6] = String.valueOf(ordenado[i].getGrado());
                    datos[i][7] = ordenado[i].getSeccion();
                }
                
                vista.trs.setRowFilter(RowFilter.regexFilter(vista.txtFiltrar.getText(), columnaAFiltrar));
                
                DefaultTableModel tabla = new DefaultTableModel(datos,cabecera);
                
                vista.trs = new TableRowSorter(tabla);
                vista.tblAlumnos.setRowSorter(vista.trs);
                vista.tblAlumnos.setModel(tabla);
            }
        };
        ActionListener ordenarxSeccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] cabecera = Sistema.getCabecera();
                
                Alumno[] ordenado = Sistema.quickSortSeccion(modelo.getDatos());
                
                String[][] datos = new String[Datos.datosAlum.dimension()][8];
                
                for (int i = 0; i < modelo.dimension(); i++) {
                    datos[i][0] = String.valueOf(ordenado[i].getCodigo());
                    datos[i][1] = ordenado[i].getNombre();
                    datos[i][2] = ordenado[i].getApellido();
                    datos[i][3] = ordenado[i].getFecha().toString();
                    datos[i][4] = ordenado[i].getSexo();
                    datos[i][5] = ordenado[i].getNivel();
                    datos[i][6] = String.valueOf(ordenado[i].getGrado());
                    datos[i][7] = ordenado[i].getSeccion();
                }
                
                vista.trs.setRowFilter(RowFilter.regexFilter(vista.txtFiltrar.getText(), columnaAFiltrar));
                
                DefaultTableModel tabla = new DefaultTableModel(datos,cabecera);
                
                vista.trs = new TableRowSorter(tabla);
                vista.tblAlumnos.setRowSorter(vista.trs);
                vista.tblAlumnos.setModel(tabla);
            }
        };

        
        FocusListener fl = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                vista.txtFiltrar.setText("");
                vista.trs.setRowFilter(RowFilter.regexFilter(vista.txtFiltrar.getText(), columnaAFiltrar));
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        };
        
        vista.rDFiltroxApellido.addFocusListener(fl);
        vista.rDFiltroxNombre.addFocusListener(fl);
        vista.rDFiltroxGrado.addFocusListener(fl);
        vista.rDFiltroxSeccion.addFocusListener(fl);

        vista.btnQuickID.addActionListener(ordenarxID);
        vista.btnQuickNombre.addActionListener(ordenarxNombre);
        vista.btnQuickApellido.addActionListener(ordenarXApellido);
        vista.btnQuickSeccion.addActionListener(ordenarxSeccion);
        
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);     
        
        String[][] datos = new String[modelo.dimension()][8];
        
        for (int i = 0; i < modelo.dimension(); i++) {
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

        this.vista.trs = new TableRowSorter(tabla);
        this.vista.tblAlumnos.setRowSorter(this.vista.trs);
        this.vista.tblAlumnos.setModel(tabla);
        
    }
    
}
    
