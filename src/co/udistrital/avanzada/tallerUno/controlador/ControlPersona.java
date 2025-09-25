package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.avanzada.tallerUno.modelo.*;
import java.util.ArrayList;

/**
 * ControlPersona administra todas las personas del sistema:
 * Usuarios, Proveedores y el Administrador único.
 * 
 * @autor Santiago, Alex , Jeison
 * @version 1.0
 */
public class ControlPersona {

    private ControlGeneral controlGeneral;
    private ArrayList<Persona> personas;
    private Administrador administrador; // único administrador del sistema

    public ControlPersona(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
        this.personas = new ArrayList<>();
        crearAdministradorPorDefecto();
    }

    private void crearAdministradorPorDefecto() {
        administrador = new Administrador("Admin", "Sistema", "0000", "000000", "admin@rolapet.com");
        personas.add(administrador);
    }


    public void crearUsuario(String nombre, String apellido, String cedula, String numero, String correo, String password) {
        Usuario usuario = new Usuario(nombre, apellido, cedula, numero, correo, password);
        personas.add(usuario);
    }

    public void crearProveedorServicios(String nombre, String apellido, String cedula, String numero, String correo) {
        ProvedorServicio prov = new ProvedorServicio(nombre, apellido, cedula, numero, correo);
        personas.add(prov);
    }

    public String buscarPersona(String cedula) {
        for (Persona p : personas) {
            if (p.getCedula().equalsIgnoreCase(cedula)) {
                return "Persona encontrada: " + p.getNombre() + " " + p.getApellido() +
                       " [" + p.getClass().getSimpleName() + "]";
            }
        }
        return "Persona no encontrada";
    }


    public boolean validarUsuario(String cedula, String password) {
        for (Persona p : personas) {
            if (p instanceof Usuario usuario) {
                if (usuario.getCedula().equalsIgnoreCase(cedula) && usuario.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }


    public String agregarAmigo(String cedulaUsuario, String cedulaAmigo) {
        Usuario usuario = null, amigo = null;

        for (Persona p : personas) {
            if (p instanceof Usuario u) {
                if (u.getCedula().equalsIgnoreCase(cedulaUsuario)) usuario = u;
                if (u.getCedula().equalsIgnoreCase(cedulaAmigo)) amigo = u;
            }
        }

        if (usuario == null) return "El usuario no existe o no es válido.";
        if (amigo == null) return "El amigo no existe o no es válido.";

        if (!usuario.getAmigos().contains(amigo)) {
            usuario.getAmigos().add(amigo);
            return "Amigo agregado correctamente.";
        } else {
            return "El amigo ya estaba en la lista.";
        }
    }


    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

}

