/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Representa una moto electrica en el sistema
 *
 * @author Alex
 * @version 1.0
 *
 */
public class MotoElectrica extends Vehiculo {
    
    /**
     * Constructor que inicializa una moto eléctrica con sus características básicas.
     * 
     * @param tipo Tipo de vehículo (normalmente "moto eléctrica").
     * @param id Identificador único de la moto eléctrica.
     * @param potencia Potencia del vehículo.
     * @param marca Marca de la moto.
     * @param numChasis Número de chasis.
     * @param referencia Modelo o referencia del vehículo.
     */
    public MotoElectrica(String tipo, String id,String potencia, String marca, String numChasis,
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
