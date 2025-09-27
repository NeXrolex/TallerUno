package co.udistrital.avanzada.tallerUno.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Vista principal del sistema RolaPet.
 *
 * Es la encargada de mostrar la interfaz y proveer métodos para que el
 * controlador (ControlVista) interactúe con el usuario.
 *
 * @author Alex,Santiago
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
        // Configuraciones básicas de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350);// Tamaño fijo de la ventana
        setLocationRelativeTo(null);// Centrar la ventana al abrir

        // Creacion Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        // Creacion subPanel encabezado
        JPanel panelEncabezado = new JPanel(new BorderLayout());
        panelEncabezado.setBackground(new Color(0, 102, 204)); // Azul principal
        
        // integracion Logo de la Empresa
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/co/udistrital/avanzada/tallerUno/resources/RolaPetLogo.png"));
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(imagenEscalada));
        panelEncabezado.add(logo, BorderLayout.WEST);
        
        // integracion nombre de la empresa
        JLabel lblTitulo = new JLabel("Bienvenido a RolaPet");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        panelEncabezado.add(lblTitulo, BorderLayout.CENTER);
        
        // Add encabezado a panel principal
        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));
        panelBotones.setBackground(Color.WHITE);
        
        //botones del menu principal
        btnUsuario = new JButton("Ingresar como Usuario");
        btnAdmin = new JButton("Ingresar como Administrador");
        btnProveedor = new JButton("Ingresar como Proveedor");
        btnSalir = new JButton("Salir");
        
        //Anadimos los botones al panel
        panelBotones.add(btnUsuario);
        panelBotones.add(btnAdmin);
        panelBotones.add(btnProveedor);
        panelBotones.add(btnSalir);
        
        // Agregar panel de botones al centro del panel principal
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Área de mensajes
        txtOutput = new JTextArea(5, 40);
        txtOutput.setEditable(false);
        txtOutput.setBackground(Color.WHITE);
        txtOutput.setBorder(new TitledBorder("Mensajes del sistema"));
        panelPrincipal.add(new JScrollPane(txtOutput), BorderLayout.SOUTH);
        
        // Agregar panel principal a la ventana JFrame
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
