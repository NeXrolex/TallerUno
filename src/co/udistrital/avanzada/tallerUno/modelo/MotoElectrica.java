/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 *  Representa una moto electrica en el sistema
 * 
 * @author santi
 * @version 1.0
 * 
 */
public class MotoElectrica extends Vehiculo {
    
     public MotoElectrica(String potencia, String marca, String numChasis, String referencia) {
        
        super.potencia = potencia;
        super.marca = marca;
        super.numChasis = numChasis;
        super.referencia = referencia;
    }
    
}
