package co.udistrital.avanzada.tallerUno.controlador;

/**
 * ControlGeneral es el orquestador principal del sistema.
 * 
 * - Crea y mantiene los controladores de Persona, Vehículo y Vista.
 * - Expone métodos para delegar la lógica hacia los controladores especializados.
 * - Usa inyección de dependencias para bajo acoplamiento.
 */
public class ControlGeneral {

    private ControlVehiculo controlVehiculo;
    private ControlPersona controlPersona;
    private ControlVista controlVista;

    public ControlGeneral() {
        // Inyección: se pasa this para que cada controlador
        // pueda llamar de regreso a ControlGeneral si lo necesita
        this.controlPersona = new ControlPersona(this);
        this.controlVehiculo = new ControlVehiculo(this);
        this.controlVista = new ControlVista(this);

        // Arranca la vista principal
        this.controlVista.menu();
    }

    // =====================
    // Delegación a Persona
    // =====================
    public void crearUsuario(String nombre, String apellido, String cedula, String num, String correo, String pass) {
        controlPersona.crearUsuario(nombre, apellido, cedula, num, correo, pass);
    }

    public boolean validarUsuario(String cedula, String pass) {
        return controlPersona.validarUsuario(cedula, pass);
    }

    public String agregarAmigo(String cedulaU, String cedulaAmigo) {
        return controlPersona.agregarAmigo(cedulaU, cedulaAmigo);
    }

    public void crearProveedorServicios(String nombre, String apellido, String cedula, String num, String correo, String password) {
        controlPersona.crearProveedorServicios(nombre, apellido, cedula, num, correo, password);
    }
    
    public void crearProveedorInsumos(String nombre, String apellido, String cedula, String num, String correo, String password) {
        controlPersona.crearProveedorInsumos(nombre, apellido, cedula, num, correo, password);
    }

    public String buscarPersona(String cedula) {
        return controlPersona.buscarPersona(cedula);
    }

    // =====================
    // Delegación a Vehículo
    // =====================
    public void crearVehiculo(String tipo, String id, String potencia, String marca, String numChasis, String referencia) {
        controlVehiculo.crearVehiculo(tipo, id, potencia, marca, numChasis, referencia);
    }

    public void editarVehiculo(String id, co.udistrital.avanzada.tallerUno.modelo.Scooter scooter) {
        controlVehiculo.editarVehiculo(id, scooter);
    }

    public void eliminarVehiculo(String id) {
        controlVehiculo.eliminarVehiculo(id);
    }

    public co.udistrital.avanzada.tallerUno.modelo.Vehiculo buscarVehiculo(String id) {
        return controlVehiculo.buscarScooter(id);
    }

    // =====================
    // Getters
    // =====================
    public ControlVehiculo getControlVehiculo() {
        return controlVehiculo;
    }

    public ControlPersona getControlPersona() {
        return controlPersona;
    }

    public ControlVista getControlVista() {
        return controlVista;
    }
}
