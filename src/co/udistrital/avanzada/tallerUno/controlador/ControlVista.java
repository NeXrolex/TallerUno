package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.avanzada.tallerUno.vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControlVista escucha eventos de PantallaPrincipal y coordina la interacción
 * entre la vista y ControlGeneral.
 *
 * @author Alex, Jeison
 * @version 1.0
 */
public class ControlVista implements ActionListener {

    private final ControlProveedor controlProveedor;
    private final ControlGeneral controlGeneral;
    private final PantallaPrincipal pantallaPrincipal;

    public ControlVista(ControlGeneral controlGeneral,ControlProveedor controlProveedor) {
        
        this.controlGeneral = controlGeneral;
        this.controlProveedor = controlProveedor;
        this.pantallaPrincipal = new PantallaPrincipal("RolaPet");
        agregarListeners();
    }

    private void agregarListeners() {
        pantallaPrincipal.btnUsuario.addActionListener(this);
        pantallaPrincipal.btnAdmin.addActionListener(this);
        pantallaPrincipal.btnProveedor.addActionListener(this);
        pantallaPrincipal.btnSalir.addActionListener(this);
    }

    public void menu() {
        pantallaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == pantallaPrincipal.btnUsuario) {
            menuUsuarioOpciones();

        } else if (src == pantallaPrincipal.btnAdmin) {
            menuAdmin();

        } else if (src == pantallaPrincipal.btnProveedor) {
            String cedula = pantallaPrincipal.pedirDato("Ingrese su cédula:");
            pantallaPrincipal.mostrarMensaje(controlGeneral
                    .buscarPersona(cedula));

        } else if (src == pantallaPrincipal.btnSalir) {
            pantallaPrincipal.mostrarMensaje("Cerrando aplicación...");
            System.exit(0);
        }
    }

    // ---------------- Menús específicos ----------------
    private void menuUsuarioOpciones() {
        String[] opciones = {"Crear Cuenta", "Ingresar"};
        int opcion = pantallaPrincipal.mostrarOpciones("Usuario", opciones);
        String nombre = "";
        String cedula = "";
        String pass = "";
        String apellido = "";
        String numero = "";
        String correo = "";
        switch (opcion) {
            case 0:
                // Crear cuenta
                nombre = pantallaPrincipal.pedirDato("Nombre:");
                if (nombre == null) {
                    break;
                }
                apellido = pantallaPrincipal.pedirDato("Apellido:");
                if (apellido == null) {
                    break;
                }
                cedula = pantallaPrincipal.pedirDato("Cédula:");
                if (cedula == null) {
                    break;
                }
                numero = pantallaPrincipal.pedirDato("Número:");
                if (numero == null) {
                    break;
                }

                correo = pantallaPrincipal.pedirDato("Correo:");
                if (correo == null) {
                    break;
                }

                pass = pantallaPrincipal.pedirDato("Contraseña:");
                if (pass == null) {
                    break;
                }
                controlGeneral.crearUsuario(nombre, apellido, cedula, numero, correo, pass);
                pantallaPrincipal.mostrarMensaje("Usuario creado: " + nombre + " " + apellido);
                break;
            case 1:

                cedula = pantallaPrincipal.pedirDato("Cédula:");
                if (cedula == null) {
                    break;
                }
                pass = pantallaPrincipal.pedirDato("Contraseña:");
                if (pass == null) {
                    break;
                }
                if (controlGeneral.validarUsuario(cedula, pass)) {
                    pantallaPrincipal.mostrarMensaje("Ingreso exitoso.");
                    menuUsuario(cedula);
                } else {
                    pantallaPrincipal.mostrarMensaje("Credenciales incorrectas.");
                }
                break;
        }
    }

    private void menuUsuario(String cedulaUsuario) {
        String[] opciones = {"Añadir Vehículo", "Borrar Vehículo",
            "Agregar Amigo", "Cerrar Sesión"};
        boolean activo = true;

        while (activo) {
            int opcion = pantallaPrincipal.mostrarOpciones("Menú Usuario",
                    opciones);

            switch (opcion) {
                case 0 -> { // Añadir vehículo
                    String[] tipos = {"Scooter", "MotoElectrica"};
                    int tipoIndex = pantallaPrincipal
                            .mostrarOpciones("Tipo de Vehículo", tipos);

                    if (tipoIndex >= 0) {
                        String tipo = tipos[tipoIndex];
                        String id = pantallaPrincipal
                                .pedirDato("ID del vehículo:");
                        String potencia = pantallaPrincipal
                                .pedirDato("Potencia:");
                        String marca = pantallaPrincipal
                                .pedirDato("Marca:");
                        String numChasis = pantallaPrincipal.pedirDato("Número "
                                + "de chasis:");
                        String referencia = pantallaPrincipal
                                .pedirDato("Referencia:");

                        controlGeneral.crearVehiculo(tipo, id, potencia, marca,
                                numChasis, referencia);
                        pantallaPrincipal.mostrarMensaje(
                                tipo + " agregado correctamente con ID: " + id
                        );
                    }
                }
                case 1 -> { // Borrar vehículo
                    String id = pantallaPrincipal.pedirDato("Ingrese ID del"
                            + " vehículo a eliminar:");
                    controlGeneral.eliminarVehiculo(id);
                    pantallaPrincipal.mostrarMensaje("Vehículo con ID "
                            + id + " eliminado.");
                }
                case 2 -> { // Agregar amigo
                    String cedulaAmigo = pantallaPrincipal.pedirDato("Ingrese"
                            + " la cédula del amigo:");
                    String resultado = controlGeneral
                            .agregarAmigo(cedulaUsuario, cedulaAmigo);
                    pantallaPrincipal.mostrarMensaje(resultado);
                }
                case 3 -> { // Cerrar sesión
                    activo = false;
                }
            }
        }
    }

    private void menuAdmin() {
        
        String[] opciones = {"Crear Proveedor","Publicar evento", "Salir"};
        
        int opcion = pantallaPrincipal.mostrarOpciones("Administrador", opciones);
        if (opcion == 0) {
            String tipo = pantallaPrincipal.pedirDato("Especifique el tipo proveedor: (insumos o servicios)");
            String nombre = pantallaPrincipal.pedirDato("Nombre proveedor:");
            String apellido = pantallaPrincipal.pedirDato("Apellido "
                    + "proveedor:");
            String cedula = pantallaPrincipal.pedirDato("Cédula:");
            String numero = pantallaPrincipal.pedirDato("Número:");
            String correo = pantallaPrincipal.pedirDato("Correo:");
            String password = pantallaPrincipal.pedirDato("Contraseña:");
            
            controlProveedor.crearProveedor(tipo, nombre, apellido,
                    cedula, numero, correo, password);
            pantallaPrincipal.mostrarMensaje("Proveedor registrado: "
                    + nombre + " " + apellido);
        } else if (opcion == 1) {
            
        }

    }
    
}
