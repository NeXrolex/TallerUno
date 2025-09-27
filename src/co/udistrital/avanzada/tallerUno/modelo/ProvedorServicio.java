/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Representa un provedor de Servicios
 * Extiende de provedor
 *
 * @author Alex
 * @version 1.0
 */
public class ProvedorServicio extends Provedor {
    
    /**
     * Constructor que crea el provedor se servicios con sus atributos
     * 
     * @param nombre Nombre del provedor
     * @param apellido Apellido del provedor
     * @param cedula Cedula del provedor
     * @param numero Numero telefonico del provedor
     * @param correo Correo Electronico del provedor
     * @param password Contrasena del provedor
     */
    public ProvedorServicio(String nombre, String apellido, String cedula,
            String numero, String correo, String password) {
        //Invoca al constructor de la superClase provedor
        super(nombre, apellido, cedula, numero, correo, password);
    }

}
