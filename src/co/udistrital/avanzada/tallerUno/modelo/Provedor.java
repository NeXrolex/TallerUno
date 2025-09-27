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

    protected String password;
    protected List<String> nombreProductos;
    protected List<Double> preciosProductos;

    /**
     * Constructor que asigna los valores de un provedor
     *
     * @param nombre Nombre del provedor
     * @param apellido Apellido del provedor
     * @param cedula Cedula del provedor
     * @param numero Numero telefonico del provedor
     * @param correo Correo electronico del proveedor
     * @param password Contrasena del provedor
     */
    public Provedor(String nombre, String apellido, String cedula,
            String numero, String correo, String password) {

        super.nombre = nombre;
        super.apellido = apellido;
        super.cedula = cedula;
        super.numero = numero;
        super.correo = correo;
        this.nombreProductos = new ArrayList<>();
        this.preciosProductos = new ArrayList<>();
        this.password = password;

    }

    /**
     * Obtiene la lista de nombres de productos ofrecidos por el proveedor.
     *
     * @return Lista de nombres de productos.
     */
    public List<String> getNombreProductos() {
        return nombreProductos;
    }

    /**
     * Asigna una lista de nombres de productos ofrecidos por el proveedor.
     *
     * @param nombreProductos Lista de nombres de productos.
     */
    public void setNombreProductos(List<String> nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    /**
     * Obtiene la lista de precios correspondientes a los productos ofrecidos.
     *
     * @return Lista de precios de productos.
     */
    public List<Double> getPreciosProductos() {
        return preciosProductos;
    }
    
    /**
     * Asigna una lista de precios correspondientes a los productos ofrecidos.
     * 
     * @param preciosProductos Lista de precios de productos.
     */
    public void setPreciosProductos(List<Double> preciosProductos) {
        this.preciosProductos = preciosProductos;
    }
    
    /**
     * Obtiene la contraseña del proveedor.
     * 
     * @return Contraseña del proveedor.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Asigna la contraseña para el proveedor.
     * 
     * @param password Nueva contraseña a asignar.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
