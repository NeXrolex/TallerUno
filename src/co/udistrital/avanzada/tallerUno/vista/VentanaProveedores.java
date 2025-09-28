/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udistrital.avanzada.tallerUno.vista;

import co.udistrital.avanzada.tallerUno.modelo.Proveedor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * Vista Galeria de Proveedores
 * 
 * Muestra todos los provedores que se encuentran registrados en el aplicativo
 * Separando los de Insmos y los de Servicios 
 * El usuario puede interactuar pare ver que ofrece el proveedor
 *
 * @author santi
 */

public class VentanaProveedores {
        
    public static void mostrarProveedores(List<Proveedor> proveedores) {
        //Se crea la ventana
        JDialog dialog = new JDialog((Frame) null, "RolaPet - Lista de Proveedores", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        // Se integran logo y color del Aplicativo
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(new Color(0, 102, 204));
        ImageIcon iconoOriginal = new ImageIcon(VentanaProveedores.class.getResource("/co/udistrital/avanzada/tallerUno/resources/RolaPetLogo.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(imagenEscalada));
        encabezado.add(logo, BorderLayout.WEST);
        JLabel lblSubTitulo = new JLabel("Lista de Proveedores", SwingConstants.CENTER);
        lblSubTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblSubTitulo.setForeground(Color.WHITE);
        encabezado.add(lblSubTitulo, BorderLayout.CENTER);
        dialog.add(encabezado, BorderLayout.NORTH);
        //Panel para integrar Proveedores
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Servicios
        JLabel lblServicios = new JLabel("Proveedores de Servicios");
        lblServicios.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblServicios);

        for (Proveedor p : proveedores) {
            //Llama solo a los Prov. de servicios y los crea en botones
            if ("Servicios".equalsIgnoreCase(p.getTipo())) {
                JButton btn = new JButton(p.getNombre() + " " + p.getApellido());
                btn.addActionListener(e -> {
                    mostrarMensaje("Ofertas de " + p.getNombre() + " (Servicios)");
                    
                });
                panel.add(btn);
            }
        }

        // Espacio
        panel.add(Box.createVerticalStrut(15));

        //Insumos
        JLabel lblInsumos = new JLabel("Proveedores de Insumos");
        lblInsumos.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblInsumos);

        for (Proveedor p : proveedores) {
            //Llama solo a los Prov. de insumos y los crea en botones
            if ("Insumos".equalsIgnoreCase(p.getTipo())) {
                JButton btn = new JButton(p.getNombre() + " " + p.getApellido());
                btn.addActionListener(e -> {
                    mostrarMensaje("Ofertas de " + p.getNombre() + " (Insumos)");
                });
                panel.add(btn);
            }
        }
        
        JScrollPane scroll = new JScrollPane(panel);
        dialog.add(scroll, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dialog.dispose());
        JPanel footer = new JPanel();
        footer.add(btnVolver);
        dialog.add(footer, BorderLayout.SOUTH);

        dialog.setVisible(true);

    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "informacion", JOptionPane.INFORMATION_MESSAGE);
    }

}
