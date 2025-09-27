/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Representa un administrador del aplicativo de ROLA PET
 *
 * @author Alex
 * @version 1.0
 *
 */
public class Administrador extends Persona {
    
    /**
     * Constructor que asigna los atributos del administrador 
     * 
     * @param nombre Nombre del provedor
     * @param apellido Apellido del provedor
     * @param cedula Cedula del provedor
     * @param numero Numero del provedor
     * @param correo Correo del provedor
     */
    public Administrador(String nombre, String apellido, String cedula,
            String numero, String correo) {

        super.nombre = nombre;
        super.apellido = apellido;
        super.cedula = cedula;
        super.numero = numero;
        super.correo = correo;

    }

}
