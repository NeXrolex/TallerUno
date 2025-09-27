package co.udistrital.avanzada.tallerUno.controlador;

/**
 * ControlGeneral es el orquestador principal del sistema.
 *
 * @autor Alex
 * @version 1.0
 */
import co.udistrital.avanzada.tallerUno.modelo.*;

public class ControlGeneral {

    //atributos para manejar las otras clases
    private ControlVehiculo controlVehiculo;
    private ControlPersona controlPersona;
    private ControlVista controlVista;
    private ControlProveedor controlProveedor;

    /**
     * Constructor encarcado de instanciar los objetos e inyectarse a las otras
     * clases
     *
     */
    public ControlGeneral() {
        // Inyección: se pasa this para que cada controlador
        // pueda llamar de regreso a ControlGeneral si lo necesita
        this.controlPersona = new ControlPersona(this);
        this.controlVehiculo = new ControlVehiculo(this);
        this.controlVista = new ControlVista(this, this.controlProveedor);
        this.controlProveedor = new ControlProveedor(this);
        inicializarProveedores();
        // Arranca la vista principal
        this.controlVista.menu();
    }

    private void inicializarProveedores() {
        controlProveedor.crearProveedor("servicios", "Bike & Scooters Serv"
                + ". tecnico", "Jose", "785", "3013334444",
                "jose@servicios.com", "password");
        controlProveedor.crearProveedor("insumos", "Protecciones y Accesorios",
                "Laura", "598", "3001112222", "laura@insumos.com", "password");
    }

    public void crearProveedorServicios(String nombre, String apellido,
            String cedula, String num, String correo, String password) {
        controlProveedor.crearProveedor("servicios", nombre, apellido,
                cedula, num, correo, password);
    }

    public void crearProveedorInsumos(String nombre, String apellido,
            String cedula, String num, String correo, String password) {
        controlProveedor.crearProveedor("insumos", nombre, apellido,
                cedula, num, correo, password);
    }

    public ControlProveedor getControlProveedor() {
        return controlProveedor;
    }

    /**
     * Crea un usuario llamando a controlPersona
     *
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param cedula cedula del usuario
     * @param num numero del usuario
     * @param correo correo del usuario
     * @param pass contrasena del usuario
     */
    public void crearUsuario(String nombre, String apellido, String cedula,
            String num, String correo, String pass) {
        controlPersona.crearUsuario(nombre, apellido, cedula, num,
                correo, pass);
    }

    /**
     * encargado de dar la orden a ControlPersona para validar un usuario
     *
     * @param cedula cedula del usuario
     * @param pass contrasena del usuario
     * @return si existe un usuario o no
     */
    public boolean validarUsuario(String cedula, String pass) {
        return controlPersona.validarUsuario(cedula, pass);
    }

    /**
     * Agrega un amigo
     *
     * @param cedulaU cedula del usuario
     * @param cedulaAmigo cedula del amigo a agregar
     * @return amigo agregado o la existencia de un amigo
     */
    public String agregarAmigo(String cedulaU, String cedulaAmigo) {
        return controlPersona.agregarAmigo(cedulaU, cedulaAmigo);
    }

    /**
     * Busca una persona en la lista de personas
     *
     * @param cedula cedlula del usuario
     * @return atributos de la persona o en su dfecto persona no encontrda
     */
    public String buscarPersona(String cedula) {
        return controlPersona.buscarPersona(cedula);
    }

    /**
     * Encargado de crear un vehiculo
     *
     * @param tipo tipo de vehiculo
     * @param id identificar del vehiculo
     * @param potencia potencia nominal
     * @param marca marca de; vehiculo
     * @param numChasis numero del chasis del vehiculo
     * @param referencia referencia dentro de la marca
     */
    public void crearVehiculo(String tipo, String id, String potencia,
            String marca, String numChasis, String referencia) {
        controlVehiculo.crearVehiculo(tipo, id, potencia, marca, numChasis,
                referencia);
    }

    /**
     * Se encarga de validar si existe un provedor para ingresar
     *
     * @param cedula cedula del provedor
     * @param password contrasena del provedor
     * @return true si existe los datos o false si no existe
     */
    public boolean validarProveedor(String cedula, String password) {
        return controlPersona.validarProveedor(cedula, password);
    }

    public void adicionarVehiculo(String numeroEvento, String tipoEvento,
            String descripcionEvento, String fecha) {
        controlPersona.adicionarEvento(numeroEvento, tipoEvento,
                descripcionEvento, fecha);
    }

    /**
     * Se encarga de editar un vehiculo
     *
     * @param vehiculo vehiculo
     * @param scooter scooter electrico
     */
    public void editarVehiculo(Vehiculo vehiculo) {
        controlVehiculo.editarVehiculo(vehiculo);
    }

    public void eliminarVehiculo(String id) {
        controlVehiculo.eliminarVehiculo(id);
    }

    public co.udistrital.avanzada.tallerUno.modelo.Vehiculo
            buscarVehiculo(String id) {
        return controlVehiculo.buscarVehiculo(id);
    }

    public co.udistrital.avanzada.tallerUno.modelo.Evento
            buscarEvento(String numeroEvento) {
        return controlPersona.buscarEvento(numeroEvento);
    }

}
