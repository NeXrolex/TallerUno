package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.avanzada.tallerUno.vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * ControlVista maneja los eventos de la interfaz PantallaPrincipal.
 * 
 * @author Alex, Jeison
 * @version 1.0
 * 
 */
public class ControlVista implements ActionListener {

    private ControlGeneral controlGeneral;
    private PantallaPrincipal pantallaPrincipal;
    
    /**
     * 
     * @param controlGeneral inyección de dependencias desde el controlGeneral
     */
    public ControlVista(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
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
            // Crear proveedor desde el admin
            String nombre = JOptionPane.showInputDialog("Nombre proveedor:");
            String apellido = JOptionPane.showInputDialog("Apellido proveedor:");
            String cedula = JOptionPane.showInputDialog("Cédula:");
            String numero = JOptionPane.showInputDialog("Número:");
            String correo = JOptionPane.showInputDialog("Correo:");

            controlGeneral.crearProveedorServicios(nombre, apellido, cedula, numero, correo);
            pantallaPrincipal.txtOutput.append("Proveedor registrado: " + nombre + " " + apellido + "\n");

        } else if (src == pantallaPrincipal.btnProveedor) {
            String cedula = JOptionPane.showInputDialog("Ingrese su cédula:");
            pantallaPrincipal.txtOutput.append(controlGeneral.buscarPersona(cedula) + "\n");

        } else if (src == pantallaPrincipal.btnSalir) {
            pantallaPrincipal.txtOutput.append("Cerrando aplicación...\n");
            System.exit(0);
        }
    }

    private void menuUsuarioOpciones() {
        String[] opciones = {"Crear Cuenta", "Ingresar"};
        int opcion = JOptionPane.showOptionDialog(pantallaPrincipal,
            "Seleccione una opción",
            "Usuario",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]);

        if (opcion == 0) { // Crear cuenta
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String apellido = JOptionPane.showInputDialog("Apellido:");
            String cedula = JOptionPane.showInputDialog("Cédula:");
            String numero = JOptionPane.showInputDialog("Número:");
            String correo = JOptionPane.showInputDialog("Correo:");
            String pass = JOptionPane.showInputDialog("Contraseña:");

            controlGeneral.crearUsuario(nombre, apellido, cedula, numero, correo, pass);
            pantallaPrincipal.txtOutput.append("Usuario creado: " + nombre + " " + apellido + "\n");

        } else if (opcion == 1) { // Ingresar
            String cedula = JOptionPane.showInputDialog("Cédula:");
            String pass = JOptionPane.showInputDialog("Contraseña:");

            if (controlGeneral.validarUsuario(cedula, pass)) {
                pantallaPrincipal.txtOutput.append("Ingreso exitoso.\n");
                menuUsuario(cedula);
            } else {
                pantallaPrincipal.txtOutput.append("Credenciales incorrectas.\n");
            }
        }
    }

    private void menuUsuario(String cedulaUsuario) {
        String[] opciones = {"Añadir Vehículo", "Borrar Vehículo", "Agregar Amigo", "Cerrar Sesión"};
        boolean activo = true;

        while (activo) {
            int opcion = JOptionPane.showOptionDialog(pantallaPrincipal,
                "Seleccione una opción",
                "Menú Usuario",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);

            switch (opcion) {
                case 0 -> { // Añadir vehículo
                    String[] tipos = {"Scooter", "MotoElectrica"};
                    int tipoIndex = JOptionPane.showOptionDialog(pantallaPrincipal,
                        "Seleccione el tipo de vehículo",
                        "Tipo de Vehículo",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        tipos,
                        tipos[0]);

                    if (tipoIndex >= 0) {
                        String tipo = tipos[tipoIndex];
                        String id = JOptionPane.showInputDialog("ID del vehículo:");
                        String potencia = JOptionPane.showInputDialog("Potencia:");
                        String marca = JOptionPane.showInputDialog("Marca:");
                        String numChasis = JOptionPane.showInputDialog("Número de chasis:");
                        String referencia = JOptionPane.showInputDialog("Referencia:");

                        controlGeneral.crearVehiculo(tipo, id, potencia, marca, numChasis, referencia);
                        pantallaPrincipal.txtOutput.append(
                            tipo + " agregado correctamente con ID: " + id +
                            ", Marca: " + marca +
                            ", Potencia: " + potencia + "\n"
                        );
                    }
                }
                case 1 -> { // Borrar vehículo
                    String id = JOptionPane.showInputDialog("Ingrese ID del vehículo a eliminar:");
                    controlGeneral.eliminarVehiculo(id);
                    pantallaPrincipal.txtOutput.append("Vehículo con ID " + id + " eliminado.\n");
                }
                case 2 -> { // Agregar amigo
                    String cedulaAmigo = JOptionPane.showInputDialog("Ingrese la cédula del amigo:");
                    String resultado = controlGeneral.agregarAmigo(cedulaUsuario, cedulaAmigo);
                    pantallaPrincipal.txtOutput.append(resultado + "\n");
                }
                case 3 -> { // Cerrar sesión
                    activo = false;
                }
            }
        }
    }
}
