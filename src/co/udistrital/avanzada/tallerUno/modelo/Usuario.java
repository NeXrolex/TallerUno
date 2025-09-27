/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.modelo;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa un usuario del aplicativo de ROLA PET
 * 
 * @author Alex
 * @version 1.0
 */
public class Usuario extends Persona {
    
    private String password; //criterio para el paso de usuarios
    private List<Vehiculo> vehiculos; //vehiculos del usuario
    private List<Usuario> amigos; // amigos del usuario
    
    /**
     * Constructor que inicializa un usuario con sus datos personales
     * 
     * @param nombre nombre del usuario
     * @param apellido Apellido del usuario
     * @param cedula Cedula del usuario
     * @param numero Numero de telefono del usuario
     * @param correo Correo electronico del usuario
     * @param password Constrasena del usuario
     */
    public Usuario(String nombre, String apellido, String cedula, String numero,
            String correo, String password) {
        
        super.nombre = nombre;
        super.apellido = apellido;
        super.cedula = cedula;
        super.numero = numero;
        super.correo = correo;
        this.password = password;
        this.vehiculos = new ArrayList<>();/*inicializa una lista vacia de 
        vehiculos*/
        this.amigos = new ArrayList<>();/*inicializa una lista vacia de 
        amigos*/
        
    }
    
    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Establece o actualiza la contraseña del usuario.
     * 
     * @param password Nueva contraseña a asignar.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Obtiene la lista de vehículos asociados al usuario.
     * 
     * @return Lista de objetos Vehiculo.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    /**
     * Asigna o actualiza la lista de vehículos del usuario.
     * 
     * @param vehiculos Lista de vehículos a asignar.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    /**
     * Obtiene la lista de amigos del usuario.
     * 
     * @return Lista de usuarios que son amigos.
     */
    public List<Usuario> getAmigos() {
        return amigos;
    }
    
    /**
     * Asigna o actualiza la lista de amigos del usuario.
     * 
     * @param amigos Lista de usuarios amigos a asignar.
     */
    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }
    
    
    
}
