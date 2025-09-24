package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.avanzada.tallerUno.modelo.Persona;
import co.udistrital.avanzada.tallerUno.modelo.ProvedorInsumo;
import co.udistrital.avanzada.tallerUno.modelo.ProvedorServicio;
import java.util.ArrayList;

/**
 * 
 * @author Alex, Jeison, Santiago
 * 
 * 
 */
public class ControlPersona {
    private ArrayList<Persona> personas;
    private int id;
    
    public ControlPersona() {
        personas = new ArrayList<>();
        id = 0;
        
    }
    public void crearUsuario(String nombre, String apellido, String cedula,
                             String numero, String correo) {
        int asignarId = ++id;
        Persona usuario = new Persona(asignarId, nombre, apellido, cedula, numero, correo);
        personas.add(usuario);
    }
    
    
    public void crearProveedorInsumos(int asignarId,String nombre, String apellido, String cedula,
                                      String numero, String correo) {
        ProvedorInsumo proveedor = new ProvedorInsumo(asignarId,nombre, apellido, cedula, numero, correo);
        personas.add(proveedor);
    }

    // Crear proveedor de servicios
    public void crearProveedorServicios(int asignarId,String nombre, String apellido, String cedula,
                                        String numero, String correo) {
        ProvedorServicio proveedor = new ProvedorServicio(asignarId,nombre, apellido, cedula, numero, correo);
        personas.add(proveedor);
    } 
   
}
