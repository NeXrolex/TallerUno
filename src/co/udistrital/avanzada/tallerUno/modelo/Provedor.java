/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un provedor en el sistema
 *
 * @author Alex
 * @version 1.0
 * 
 * Se extiende a ProvedorServicios e ProvedorInsumos
 */
public class Provedor extends Persona {
    
    protected List<String> nombreProductos;
    protected List<Double> preciosProductos;

    public Provedor(String nombre, String apellido, String cedula,
            String numero, String correo) {

        super.nombre = nombre;
        super.apellido = apellido;
        super.cedula = cedula;
        super.numero = numero;
        super.correo = correo;
        this.nombreProductos = new ArrayList<>();
        this.preciosProductos = new ArrayList<>();

    }

    public List<String> getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(List<String> nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public List<Double> getPreciosProductos() {
        return preciosProductos;
    }

    public void setPreciosProductos(List<Double> preciosProductos) {
        this.preciosProductos = preciosProductos;
    }
    
    

}
