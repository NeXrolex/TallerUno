package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.avanzada.tallerUno.modelo.*;
import java.util.ArrayList;

/**
 * ControlPersona administra todas las personas del sistema: Usuarios,
 * Proveedores y el Administrador único.
 *
 * @autor Santiago, Alex , Jeison
 * @version 1.0
 */
public class ControlPersona {

    private ControlGeneral controlGeneral;
    private ArrayList<Persona> personas; //Lista de personas registradas
    private ArrayList<Evento> eventos;
    private Persona administrador; // único administrador del sistema

    /**
     * Constructor principal
     *
     * @param controlGeneral control general inyectado para mantener el bajo
     * acoplamiento
     */
    public ControlPersona(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
        this.personas = new ArrayList<>();
        this.eventos = new ArrayList<>();
        crearAdministradorPorDefecto();
    }

    /**
     * crea un administrador unico por defecto(como menciono el profe podemos
     * por esta vez tener los parametros por codigo)
     */
    private void crearAdministradorPorDefecto() {
        administrador = new Administrador("Admin", "Sistema", "0000", "000000",
                "admin@rolapet.com");
        personas.add(administrador);
    }

    /**
     * Crea un usuario en el sistema
     *
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param cedula documento de identidad y de referencia
     * @param numero numero telefonico
     * @param correo correo electronico
     * @param password contrasena para la autentificacion
     */
    public void crearUsuario(String nombre, String apellido, String cedula,
            String numero, String correo, String password) {
        Persona usuario = new Usuario(nombre, apellido, cedula, numero,
                correo, password);
        personas.add(usuario);
    }

    /**
     * Busca una persona registrada en el sistema por su cedula
     *
     * @param cedula
     * @return mensaje con el resultado de la busqueda
     */
    public String buscarPersona(String cedula) {
        for (Persona p : personas) {
            if (p.getCedula().equalsIgnoreCase(cedula)) {
                //Devuelve la informacion de la persona encontrada 
                return "Persona encontrada: " + p.getNombre() + " "
                        + p.getApellido() + " [" + p.getClass().getSimpleName()
                        + "]";
            }
        }
        return "Persona no encontrada";
    }

    /**
     * Valida si existe un usuario con las credenciales dadas
     *
     * @param cedula documento de identidad
     * @param password contrasena
     * @return true si las credenciales son correctas,false en su caso contrario
     */
    public boolean validarUsuario(String cedula, String password) {
        for (Persona p : personas) {
            if (p instanceof Usuario usuario) {
                //verificamos si la cedula y contrasena son correctas
                if (usuario.getCedula().equalsIgnoreCase(cedula)
                        && usuario.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Valida si existe el provedor
     *
     * @param cedula identificador del provedor
     * @param password contrasena
     * @return true si es correccto o false si no existe el provedor
     */
    public boolean validarProveedor(String cedula, String password) {
        for (Persona p : personas) {
            if (p instanceof Provedor prov) {
                if (prov.getCedula().equalsIgnoreCase(cedula)
                        && prov.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param cedulaUsuario cedula del usuario que agrega
     * @param cedulaAmigo cedula del amigo a anadir
     * @return mensaje de confirmacion o error
     */
    public String agregarAmigo(String cedulaUsuario, String cedulaAmigo) {
        Usuario usuario = null, amigo = null;

        //Buscamos intancias de tipo Usuario en la lista de personas 
        for (Persona p : personas) {
            if (p instanceof Usuario u) {
                if (u.getCedula().equalsIgnoreCase(cedulaUsuario)) {
                    usuario = u;
                }
                if (u.getCedula().equalsIgnoreCase(cedulaAmigo)) {
                    amigo = u;
                }
            }
        }

        if (usuario == null) {
            return "El usuario no existe o no es válido.";
        }
        if (amigo == null) {
            return "El amigo no existe o no es válido.";
        }

        //Agregamos solo si no pertenecia en la lista
        if (!usuario.getAmigos().contains(amigo)) {
            usuario.getAmigos().add(amigo);
            return "Amigo agregado correctamente.";
        } else {
            return "El amigo ya estaba en la lista.";
        }
    }

    /**
     * Se encarga de agregar un producto de un provedor
     *
     * @param cedula cedula para asociar un provedor
     * @param producto producto del proveedor
     * @param precio precio del producto
     * @return
     */
    public String agregarProductoAProveedor(String cedula, String producto,
            double precio) {
        for (Persona p : personas) {
            if (p instanceof Provedor prov) {
                if (prov.getCedula().equalsIgnoreCase(cedula)) {
                    prov.getNombreProductos().add(producto);
                    prov.getPreciosProductos().add(precio);
                    return "Producto agregado correctamente.";
                }
            }
        }
        return "Proveedor no encontrado.";
    }

    /**
     * Busca un provedor por su cedula y lista sus productos
     *
     * @param cedula identificador del provedor
     * @return una cadena con el listado de productos y precios del provedor o
     * en su defecto el provedor no encontrado
     */
    public String listarProductosDeProveedor(String cedula) {
        for (Persona p : personas) {
            if (p instanceof Provedor prov) {
                if (prov.getCedula().equalsIgnoreCase(cedula)) {
                    StringBuilder sb = new StringBuilder("Productos de "
                            + prov.getNombre() + ":\n");
                    for (int i = 0; i < prov.getNombreProductos().size(); i++) {
                        sb.append("- ").append(prov.getNombreProductos().get(i))
                                .append(" ($").append(prov.getPreciosProductos()
                                .get(i)).append(")\n");
                    }
                    return sb.toString();
                }
            }
        }
        return "Proveedor no encontrado.";
    }

    public void adicionarEvento(String numeroEvento, String tipoEvento,
            String descripcionEvento, String fecha) {
        Evento aux = new Evento(numeroEvento, tipoEvento, descripcionEvento,
                fecha);
        eventos.add(aux);
    }

    public Evento buscarEvento(String numeroEvento) {
        Evento eventoRetorno =null;
        for (Evento evento : eventos) {
            // encontramos el objeto 
            if (evento.getNumeroEvento().equalsIgnoreCase(numeroEvento)) {
                eventoRetorno = evento;
            }
        }
        return eventoRetorno;
    }

    /**
     * Devuelve todas las perosnas registradas en el sistema
     *
     * @return lista de personas
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * retorna el unico Administdor en el sistema
     *
     * @return administrador
     */
    public Persona getAdministrador() {
        return administrador;
    }

}
