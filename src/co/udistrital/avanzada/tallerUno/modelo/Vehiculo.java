/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

/**
 * Representa un vehiculo en el sistema
 *
 * @author Alex
 * @version 1.0
 */
public class Vehiculo {

    protected String tipo;
    protected String id;
    protected String potencia;
    protected String marca;
    protected String numChasis;
    protected String referencia;

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return El tipo de vehículo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de vehículo.
     *
     * @param tipo El nuevo tipo de vehículo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador único del vehículo.
     *
     * @return Identificador del vehículo.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del vehículo.
     *
     * @param id Identificador a asignar.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la potencia del vehículo.
     *
     * @return Potencia del vehículo.
     */
    public String getPotencia() {
        return potencia;
    }

    /**
     * Establece la potencia del vehículo.
     *
     * @param potencia Potencia a asignar.
     */
    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return Marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca Marca a asignar.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el número de chasis del vehículo.
     *
     * @return Número de chasis.
     */
    public String getNumChasis() {
        return numChasis;
    }

    /**
     * Establece el número de chasis del vehículo.
     *
     * @param numChasis Número de chasis a asignar.
     */
    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    /**
     * Obtiene la referencia o modelo específico del vehículo.
     *
     * @return Referencia del vehículo.
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Establece la referencia o modelo del vehículo.
     *
     * @param referencia Referencia a asignar.
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
