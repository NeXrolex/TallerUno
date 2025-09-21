/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 *
 * @author santi
 */
public class Usuario extends Persona {
    
    private String password; //criterio para el paso de usuarios

    public Usuario(String nombre, String apellido, String cedula, String numero, String correo, String password) {
        
        super.nombre = nombre;
        super.apellido = apellido;
        super.cedula = cedula;
        super.numero = numero;
        super.correo = correo;
        this.password = password;
    }
    
    
    
}
