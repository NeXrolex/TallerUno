/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.controlador;

import co.udistrital.tallerUno.vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controlador de Vista - SOLO coordinación entre ControlGeneral y PantallaPrincipal
 * 
 * RESPONSABILIDAD ÚNICA (SRP): 
 * - Coordinar eventos entre vista y lógica de negocio
 * - Configurar la interfaz gráfica
 * - Capturar eventos de usuario
 * - Delegar operaciones al ControlGeneral
 * 
 * NO tiene:
 * - System.out.println (eso es responsabilidad de la VISTA)
 * - Lógica de negocio (eso es responsabilidad del ControlGeneral)
 * - Acceso directo al modelo (debe ir por ControlGeneral)
 * 
 * @author Alex
 * @version 7.0 - SRP puro, sin System.out
 */
public class ControlVista implements ActionListener {
    
    // Dependencia inyectada (coordinador de lógica de negocio)
    private final ControlGeneral controlGeneral;
    
    // Vista que este controlador coordina
    private final PantallaPrincipal vista;
    
    /**
     * Constructor con inyección de ControlGeneral
     * CREA la vista y configura la interfaz SIN salida de consola
     */
    public ControlVista(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
        
        // Crear la vista
        this.vista = new PantallaPrincipal("RolaPet - Sistema de Gestión de Movilidad Eléctrica");
        
        // Configurar la interfaz
        configurarInterfaz();
    }
    
    /**
     * Configura la interfaz gráfica
     * Solo configuración, sin salida de consola
     */
    private void configurarInterfaz() {
        // Configurar look and feel
        configurarLookAndFeel();
        
        // Configurar propiedades de ventana
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        vista.setResizable(false);
        
        // Configurar event listeners
        vista.btnUsuario.addActionListener(this);
        vista.btnAdmin.addActionListener(this);
        vista.btnProveedor.addActionListener(this);
        vista.btnSalir.addActionListener(this);
        
        // Mensaje inicial en la VISTA (no System.out)
        vista.txtOutput.append("=== Sistema RolaPet Iniciado ===\n");
        vista.txtOutput.append("Seleccione su tipo de usuario para continuar.\n\n");
        
        // Mostrar estadísticas iniciales en la VISTA
        mostrarEstadisticasEnVista();
    }
    
    /**
     * Configura el look and feel del sistema
     */
    private void configurarLookAndFeel() {
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeel()
            );
        } catch (Exception e) {
            // Solo mostrar error en la VISTA, no System.out
            vista.txtOutput.append("Error configurando interfaz: " + e.getMessage() + "\n");
        }
    }
    
    /**
     * Inicia la interfaz gráfica
     * Solo hace visible la ventana
     */
    public void iniciarInterfaz() {
        vista.setVisible(true);
    }
    
    /**
     * Muestra estadísticas iniciales en la VISTA (no System.out)
     */
    private void mostrarEstadisticasEnVista() {
        // Obtener datos del ControlGeneral
        String estadisticasRaw = controlGeneral.obtenerEstadisticasGenerales();
        
        // Mostrar en la VISTA, no en consola
        vista.txtOutput.append("=== ESTADÍSTICAS INICIALES ===\n");
        String[] datos = estadisticasRaw.split("\\|");
        for (String dato : datos) {
            vista.txtOutput.append("• " + dato + "\n");
        }
        vista.txtOutput.append("===========================\n\n");
    }
    
    // ============================================================================
    // MANEJO DE EVENTOS - Solo coordinación
    // ============================================================================
    
    /**
     * Coordina eventos de la interfaz
     * Captura eventos y coordina con ControlGeneral
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        try {
            switch (comando) {
                case "Ingresar como Usuario":
                    coordinarEventoUsuario();
                    break;
                case "Ingresar como Administrador":
                    coordinarEventoAdministrador();
                    break;
                case "Ingresar como Proveedor":
                    coordinarEventoProveedor();
                    break;
                case "Salir":
                    coordinarEventoSalida();
                    break;
                default:
                    mostrarEnVista("ERROR: Comando no reconocido: " + comando);
            }
        } catch (Exception ex) {
            mostrarEnVista("ERROR: Error procesando evento: " + ex.getMessage());
        }
    }
    
    /**
     * Coordina eventos de usuario
     */
    private void coordinarEventoUsuario() {
        mostrarEnVista("=== INGRESO DE USUARIO ===");
        
        String[] opciones = {"Registrarse", "Iniciar Sesión", "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(
            vista, "¿Qué desea hacer?", "Ingreso de Usuario",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, opciones, opciones[1]
        );
        
        switch (opcion) {
            case 0: coordinarRegistroUsuario(); break;
            case 1: coordinarLoginUsuario(); break;
            case 2: mostrarEnVista("Operación cancelada.\n"); break;
        }
    }
    
    /**
     * Coordina registro de usuario
     * Recolecta datos de la UI y coordina con ControlGeneral
     */
    private void coordinarRegistroUsuario() {
        try {
            // Recolectar datos de la interfaz
            String nombre = solicitarDatoEnVista("Ingrese su nombre:");
            if (nombre == null) return;
            
            String apellido = solicitarDatoEnVista("Ingrese su apellido:");
            if (apellido == null) return;
            
            String cedula = solicitarDatoEnVista("Ingrese su cédula:");
            if (cedula == null) return;
            
            String numero = solicitarDatoEnVista("Ingrese su número de teléfono:");
            if (numero == null) return;
            
            String correo = solicitarDatoEnVista("Ingrese su correo electrónico:");
            if (correo == null) return;
            
            String password = JOptionPane.showInputDialog(vista, "Ingrese su contraseña:");
            if (password == null || password.trim().isEmpty()) return;
            
            // COORDINAR con ControlGeneral (sin lógica de negocio aquí)
            boolean exito = controlGeneral.registrarUsuario(nombre, apellido, cedula, numero, correo, password);
            
            // Mostrar resultado en la VISTA
            if (exito) {
                mostrarEnVista("¡Usuario registrado exitosamente!");
                mostrarEnVista("Cédula: " + cedula + " - Ya puede iniciar sesión.\n");
            } else {
                mostrarErrorEnVista("Error en el registro. Verifique los datos.");
            }
            
        } catch (Exception e) {
            mostrarErrorEnVista("Error durante el registro: " + e.getMessage());
        }
    }
    
    /**
     * Coordina login de usuario
     */
    private void coordinarLoginUsuario() {
        try {
            String cedula = solicitarDatoEnVista("Ingrese su cédula:");
            if (cedula == null) return;
            
            String password = JOptionPane.showInputDialog(vista, "Ingrese su contraseña:");
            if (password == null) return;
            
            // COORDINAR con ControlGeneral
            String resultado = controlGeneral.autenticarUsuario(cedula, password);
            
            // Procesar resultado y mostrar en VISTA
            if (resultado.startsWith("EXITO")) {
                mostrarEnVista(resultado.substring(6));
                mostrarMenuUsuarioEnVista();
            } else {
                mostrarErrorEnVista(resultado.substring(6));
            }
            
        } catch (Exception e) {
            mostrarErrorEnVista("Error en autenticación: " + e.getMessage());
        }
    }
    
    /**
     * Coordina eventos de administrador
     */
    private void coordinarEventoAdministrador() {
        mostrarEnVista("=== INGRESO DE ADMINISTRADOR ===");
        
        try {
            String cedula = solicitarDatoEnVista("Ingrese su cédula de administrador:");
            if (cedula == null) return;
            
            // COORDINAR con ControlGeneral
            String resultado = controlGeneral.autenticarAdministrador(cedula);
            
            if (resultado.startsWith("EXITO")) {
                mostrarEnVista(resultado.substring(6));
                mostrarMenuAdministradorEnVista();
            } else {
                mostrarErrorEnVista(resultado.substring(6));
            }
            
        } catch (Exception e) {
            mostrarErrorEnVista("Error en autenticación de administrador: " + e.getMessage());
        }
    }
    
    /**
     * Coordina eventos de proveedor
     */
    private void coordinarEventoProveedor() {
        mostrarEnVista("=== INGRESO DE PROVEEDOR ===");
        
        try {
            String cedula = solicitarDatoEnVista("Ingrese su cédula de proveedor:");
            if (cedula == null) return;
            
            // COORDINAR con ControlGeneral
            String resultado = controlGeneral.autenticarProveedor(cedula);
            
            if (resultado.startsWith("EXITO")) {
                mostrarEnVista(resultado.substring(6));
                mostrarMenuProveedorEnVista();
            } else {
                mostrarErrorEnVista(resultado.substring(6));
            }
            
        } catch (Exception e) {
            mostrarErrorEnVista("Error en autenticación de proveedor: " + e.getMessage());
        }
    }
    
    /**
     * Coordina eventos de salida
     */
    private void coordinarEventoSalida() {
        int confirmacion = JOptionPane.showConfirmDialog(
            vista, "¿Está seguro que desea salir del sistema?",
            "Confirmar Salida", JOptionPane.YES_NO_OPTION
        );
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            mostrarEnVista("¡Gracias por usar RolaPet!");
            
            // COORDINAR cierre con ControlGeneral
            controlGeneral.cerrarSistema();
            
            // Cerrar la vista
            vista.dispose();
            System.exit(0);
        }
    }
    
    // ============================================================================
    // MÉTODOS DE COORDINACIÓN CON LA VISTA - Formatean y delegan a la vista
    // ============================================================================
    
    /**
     * Muestra menú de usuario en la VISTA
     */
    private void mostrarMenuUsuarioEnVista() {
        mostrarEnVista("\n--- MENÚ DE USUARIO ---");
        
        // Obtener datos del ControlGeneral y formatear para la VISTA
        String estadisticasRaw = controlGeneral.obtenerEstadisticasUsuario();
        String[] datos = estadisticasRaw.split("\\|");
        
        mostrarEnVista("Opciones disponibles:");
        mostrarEnVista("• Gestionar vehículos (" + datos[0] + ")");
        if (datos.length > 1) {
            mostrarEnVista("• Buscar amigos (" + datos[1] + ")");
        }
        mostrarEnVista("• Ver proveedores disponibles");
        mostrarEnVista("• Actualizar perfil\n");
    }
    
    /**
     * Muestra menú de administrador en la VISTA
     */
    private void mostrarMenuAdministradorEnVista() {
        mostrarEnVista("\n--- MENÚ DE ADMINISTRADOR ---");
        
        String estadisticasRaw = controlGeneral.obtenerEstadisticasAdministrador();
        String[] datos = estadisticasRaw.split("\\|");
        
        mostrarEnVista("Opciones disponibles:");
        mostrarEnVista("• Gestionar proveedores");
        mostrarEnVista("• Ver estadísticas del sistema");
        mostrarEnVista("• Administrar usuarios");
        for (String dato : datos) {
            mostrarEnVista("• " + dato);
        }
        mostrarEnVista("");
    }
    
    /**
     * Muestra menú de proveedor en la VISTA
     */
    private void mostrarMenuProveedorEnVista() {
        mostrarEnVista("\n--- MENÚ DE PROVEEDOR ---");
        mostrarEnVista("Opciones disponibles:");
        mostrarEnVista("• Gestionar productos/servicios");
        mostrarEnVista("• Ver clientes");
        mostrarEnVista("• Publicar ofertas");
        mostrarEnVista("• Actualizar información\n");
    }
    
    // ============================================================================
    // MÉTODOS UTILITARIOS - Coordinan con la VISTA
    // ============================================================================
    
    /**
     * Solicita dato al usuario a través de la VISTA
     */
    private String solicitarDatoEnVista(String mensaje) {
        String dato = JOptionPane.showInputDialog(vista, mensaje);
        if (dato != null && dato.trim().isEmpty()) {
            mostrarErrorEnVista("El campo no puede estar vacío.");
            return null;
        }
        return dato;
    }
    
    /**
     * Muestra mensaje en la VISTA (no System.out)
     */
    private void mostrarEnVista(String mensaje) {
        vista.txtOutput.append(mensaje + "\n");
        vista.txtOutput.setCaretPosition(vista.txtOutput.getDocument().getLength());
    }
    
    /**
     * Muestra error en la VISTA (no System.out)
     */
    private void mostrarErrorEnVista(String mensaje) {
        JOptionPane.showMessageDialog(vista, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        vista.txtOutput.append("ERROR: " + mensaje + "\n");
        vista.txtOutput.setCaretPosition(vista.txtOutput.getDocument().getLength());
    }
    
    // ============================================================================
    // GETTERS PARA ACCESO CONTROLADO
    // ============================================================================
    
    /**
     * Obtiene la vista coordinada por este controlador
     */
    public PantallaPrincipal getVista() {
        return vista;
    }
    
    /**
     * Verifica si la interfaz está visible
     */
    public boolean estaVisible() {
        return vista.isVisible();
    }
}

