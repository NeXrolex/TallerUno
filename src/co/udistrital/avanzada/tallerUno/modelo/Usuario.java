/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa un usuario del aplicativo de ROLA PET
 * 
 * @author Alex
 * @version 1.0
 */
public class Usuario extends Persona {
    
    private String password; //criterio para el paso de usuarios
    private List<Vehiculo> vehiculos;
    private List<Usuario> amigos;

    public Usuario(int asignarId,String nombre, String apellido, String cedula, String numero,
            String correo, String password) {
        
        super(asignarId, nombre, apellido, cedula, numero, correo); // inicializa Persona
        this.password = password; // inicializa el atributo propio
        this.vehiculos = new ArrayList<>();
        this.amigos = new ArrayList<>();
        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }
    
    
    
}
