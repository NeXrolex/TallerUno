/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Representa un scooter en el sistema
 * 
 * @author Alex
 * @version 1.0
 * 
 */
public class Scooter extends Vehiculo {

    public Scooter(String tipo, String id,String potencia, String marca, String numChasis,
            String referencia) {
        super.tipo=tipo;
        super.id=id;
        super.potencia = potencia;
        super.marca = marca;
        super.numChasis = numChasis;
        super.referencia = referencia;
    }
    
    
    
}
