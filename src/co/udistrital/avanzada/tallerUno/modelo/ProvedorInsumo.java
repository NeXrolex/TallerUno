/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Representa un provedor de insumos
 * Extiende de provedor
 * 
 * @author Alex
 * @version 1.0
 */
public class ProvedorInsumo extends Provedor {
    
    /**
     * Constructor que crea un provedor de insumos
     * 
     * @param nombre Nombre del provedor
     * @param apellido Apellido del provedor
     * @param cedula Cedula del provedor
     * @param numero Numero telefonico del provedor
     * @param correo Correo electronico del provedor
     * @param password Constrasena del provedor
     */
    public ProvedorInsumo(String nombre, String apellido, String cedula,
            String numero, String correo,String password) {
        //Invoca al constructor de la superClase provedor
        super(nombre, apellido, cedula, numero, correo, password);
    }
    
}
