package co.udistrital.avanzada.tallerUno.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Clase que representa la ventana principal de la aplicacion RolaPet
 *
 * Extiende de JFrame para construir la interfaz gráfica.
 */
public class PantallaPrincipal extends JFrame {

    // Botones públicos para acceso desde el controlador
    public JButton btnUsuario;
    public JButton btnAdmin;
    public JButton btnProveedor;
    public JButton btnSalir;

    // Área de texto para mostrar mensajes del sistema
    public JTextArea txtOutput;

    /**
     * Constructor que recibe el título en la barra de la ventana
     *
     * @param tittle
     */
    public PantallaPrincipal(String tittle) {
        super(tittle); // Llama al constructor padre JFrame
    }

    /**
     * Inicializa los componentes del frame
     */
    @Override
    protected void frameInit() {
        super.frameInit(); 

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null); 

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(0, 102, 204)); // Azul principal

        JLabel lblTitulo = new JLabel("Bienvenido a RolaPet", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

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

        txtOutput = new JTextArea(5, 40);
        txtOutput.setEditable(false);
        txtOutput.setBackground(Color.WHITE);
        txtOutput.setBorder(BorderFactory.createTitledBorder("Mensajes del sistema"));
        panelPrincipal.add(new JScrollPane(txtOutput), BorderLayout.SOUTH);

        add(panelPrincipal);
    }
}
