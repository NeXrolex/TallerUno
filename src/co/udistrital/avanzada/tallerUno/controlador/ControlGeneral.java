/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.controlador;

/**
 *
 * @author Alex
 */
public class ControlGeneral {
    
    private ControlVista cVista;
    private ControlVehiculo controlVehiculo;
    private ControlPersona controlPersona;
    
    public ControlGeneral(){
        iniciarPrograma();
    }
    
    private void iniciarPrograma(){
        //se instancia el control de la ventana
        //Se le inyecta una copia de la logica, para que sea invocada desde los elementos de la ventana
        this.cVista = new ControlVista(this);
    }
}
