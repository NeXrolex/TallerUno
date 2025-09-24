/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.tallerUno.vista;

import co.udistrital.avanzada.tallerUno.controlador.ControlVista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Clase que representa la ventana principal de la aplicacion RolaPet
 *
 * @author Alex
 * @version 1.0
 *
 * Extiende deJFrame para construir una interfaz grafica
 */
public class PantallaPrincipal extends JFrame {

    //botones publicos para acceso desde la clase GestorVentana
    public JButton btnUsuario;
    public JButton btnAdmin;
    public JButton btnProveedor;
    public JButton btnSalir;

    //Area de texto para mostrar mensdajes en el sistema
    public JTextArea txtOutput;
    private ControlVista cVista;

    /**
     * Constructor que recibe el titulo en la barra de la ventana
     *
     * @param tittle
     */
    public PantallaPrincipal(ControlVista cVista) {

        super("rola pet"); //Llama al constructor padre JFrame para poner un titulo
        this.cVista = cVista;
        inicializar();
    }

    /**
     * Metodo protegido que inicializa los componentes del frame Se sobrescribe
     * para personalizar la configuracion de la ventana agrega los botones,
     * areas de texto y etiquetas
     */
    private void inicializar() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Termina al cerrar la ventana
        setSize(500, 350);  //Tamano fiho de la ventana
        setLocationRelativeTo(null);   //centrar la ventana en la pantalla
        setVisible(true);
    }
    
    @Override
    protected void frameInit() {
        super.frameInit(); //LLama a la inicializacion base del Jframe     

        //Crea el panel principal con diseno BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(0, 102, 204)); // Azul principal

        //Crea una etiqueta para encabezado con el texto centrado
        JLabel lblTitulo = new JLabel("Bienvenido a RolaPet", 
                SwingConstants.CENTER);
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
        
        //Agrega los botones al panel principal
        panelBotones.add(btnUsuario);
        panelBotones.add(btnAdmin);
        panelBotones.add(btnProveedor);
        panelBotones.add(btnSalir);
        
        //Agrega el panel de botones al centro del panel principal
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        //Crear el area de texto para mostrar el mensaje no editable
        txtOutput = new JTextArea(5, 40);
        txtOutput.setEditable(false);
        txtOutput.setBackground(Color.WHITE);
        txtOutput.setBorder(BorderFactory.createTitledBorder
        ("Mensajes del sistema"));
        panelPrincipal.add(new JScrollPane(txtOutput), BorderLayout.SOUTH);
        
        //Agrega el panel principal al Jframe
        add(panelPrincipal);
    }

}
