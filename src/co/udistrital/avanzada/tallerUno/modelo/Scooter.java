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
    
    /**
     * Constructor que inicializa un scooter con sus características básicas.
     * 
     * @param tipo Tipo de vehículo (usualmente "scooter" o similar).
     * @param id Identificador único del scooter.
     * @param potencia Potencia del scooter.
     * @param marca Marca del scooter.
     * @param numChasis Número de chasis del scooter.
     * @param referencia Modelo o referencia del scooter.
     */
    public Scooter(String tipo, String id,String potencia, String marca, String numChasis,
            String referencia) {
        // Inicialización de atributos heredados de Vehiculo
        super.tipo=tipo;
        super.id=id;
        super.potencia = potencia;
        super.marca = marca;
        super.numChasis = numChasis;
        super.referencia = referencia;
    }
    
    
    
}
