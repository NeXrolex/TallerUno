/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Representa un provedor de insumos
 * 
 * @author Alex
 * @version 1.0
 */
public class ProveedorInsumo extends Proveedor {
    
    public ProveedorInsumo(String tipo, String nombre, String apellido, String cedula,
            String numero, String correo,String password) {
        super(tipo, nombre, apellido, cedula, numero, correo, password);
    }
    
}
