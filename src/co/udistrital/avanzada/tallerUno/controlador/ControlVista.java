/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.tallerUno.vista.PantallaPrincipal;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Alex
 */
public class ControlVista implements ActionListener {
    
    private ControlGeneral clogica;
    private PantallaPrincipal vista;
    
    public ControlVista(ControlGeneral clogica) {
        //Asigna la inyeccion a su atributo propio
        this.clogica = clogica;
        cargarPantalla();
    }
    private void cargarPantalla(){
        this.vista = new PantallaPrincipal(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

   
}
