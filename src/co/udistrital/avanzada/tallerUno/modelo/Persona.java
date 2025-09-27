/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Clase base que representa a una persona dentro del sistema
 * Contiene los atributos basicos comunes a todas las personas 
 * 
 * @author Alex
 * @version 1.0
 * 
 * Esta clase sera extendida por Usuario,provedor y Administrador
 */
public class Persona {

    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String numero;
    protected String correo;
    
    /**
     * Obtiene el nombre de la persona.
     * 
     * @return nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Asigna el nombre de la persona.
     * 
     * @param nombre el nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el apellido de la persona.
     * 
     * @return apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }
    
     /**
     * Asigna el apellido de la persona.
     * 
     * @param apellido el apellido a asignar.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
     /**
     * Obtiene la cédula o identificación de la persona.
     * 
     * @return la cédula de la persona.
     */
    public String getCedula() {
        return cedula;
    }
    
    /**
     * Asigna la cédula o identificación de la persona.
     * 
     * @param cedula la cédula a asignar.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    /**
     * Obtiene el número telefónico o celular de la persona.
     * 
     * @return número de contacto de la persona.
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * Asigna el número telefónico o celular de la persona.
     * 
     * @param numero el número a asignar.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    /**
     * Obtiene el correo electrónico de la persona.
     * 
     * @return correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * Asigna el correo electrónico de la persona.
     * 
     * @param correo el correo a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
