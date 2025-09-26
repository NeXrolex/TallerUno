package co.udistrital.avanzada.tallerUno.vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Vista principal del sistema RolaPet.
 * 
 * Es la encargada de mostrar la interfaz y proveer métodos para que
 * el controlador (ControlVista) interactúe con el usuario.
 *
 * @author Alex
 * @version 1.0
 */
public class PantallaPrincipal extends JFrame {

    // Botones públicos para el controlador
    public JButton btnUsuario;
    public JButton btnAdmin;
    public JButton btnProveedor;
    public JButton btnSalir;

    // Área de texto para mensajes del sistema
    public JTextArea txtOutput;

    public PantallaPrincipal(String tittle) {
        super(tittle);
    }

    @Override
    protected void frameInit() {
        super.frameInit();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(0, 102, 204)); // Azul principal

        // Encabezado
        JLabel lblTitulo = new JLabel("Bienvenido a RolaPet", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotones.setBackground(Color.WHITE);

        btnUsuario = new JButton("Ingresar como Usuario");
        btnAdmin = new JButton("Ingresar como Administrador");
        btnProveedor = new JButton("Ingresar como Proveedor");
        btnSalir = new JButton("Salir");

        panelBotones.add(btnUsuario);
        panelBotones.add(btnAdmin);
        panelBotones.add(btnProveedor);
        panelBotones.add(btnSalir);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Área de mensajes
        txtOutput = new JTextArea(5, 40);
        txtOutput.setEditable(false);
        txtOutput.setBackground(Color.WHITE);
        txtOutput.setBorder(new TitledBorder("Mensajes del sistema"));
        panelPrincipal.add(new JScrollPane(txtOutput), BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    // ---------------- Métodos de interacción ----------------

    /**
     * Pide un dato textual al usuario.
     * 
     * @param mensaje mensaje a mostrar
     * @return texto ingresado
     */
    public String pedirDato(String mensaje) {
        return JOptionPane.showInputDialog(this, mensaje);
    }

    /**
     * Muestra un mensaje en el área de texto y en un cuadro emergente.
     * 
     * @param mensaje mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        txtOutput.append(mensaje + "\n");
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * Muestra un menú de opciones y retorna la opción seleccionada.
     * 
     * @param titulo título del cuadro
     * @param opciones arreglo de opciones
     * @return índice de la opción seleccionada
     */
    public int mostrarOpciones(String titulo, String[] opciones) {
        return JOptionPane.showOptionDialog(
            this,
            "Seleccione una opción",
            titulo,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
    }
}
