package Epe3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservasHorasMedicas {
    private JFrame frame;

    public ReservasHorasMedicas() {
        frame = new JFrame("Reservas de horas medicas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Layout para centrar los botones
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Botón para abrir el JFrame "Medico"
        JButton btnMedico = new JButton("Medico");
        btnMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual e ir a la Interfaz Principal (ventana principal)
                frame.dispose(); // Cierra la ventana actual
                Medico.main(null);
            }
        });
        panel.add(btnMedico, gbc);

        // Botón para abrir el JFrame "Reserva"
        JButton btnReserva = new JButton("Reserva");
        btnReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Reserva.main(null);
            }
        });
        gbc.gridx++; // Mueve al siguiente componente en la misma fila
        panel.add(btnReserva, gbc);

        // Botón para cerrar la ventana
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        gbc.gridx++; // Mueve al siguiente componente en la misma fila
        panel.add(btnCerrar, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para abrir el JFrame "Medico"
    private void abrirMedico() {
        // Aquí puedes colocar el código para abrir el JFrame "Medico"
        // Por ejemplo, creando una instancia de Medico y mostrándola
        // Medico medicoFrame = new Medico();
        // medicoFrame.setVisible(true);
        System.out.println("Abriendo ventana 'Medico'");
    }

    // Método para abrir el JFrame "Reserva"
    private void abrirReserva() {
        // Aquí puedes colocar el código para abrir el JFrame "Reserva"
        // Por ejemplo, creando una instancia de Reserva y mostrándola
        // Reserva reservaFrame = new Reserva();
        // reservaFrame.setVisible(true);
        System.out.println("Abriendo ventana 'Reserva'");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ReservasHorasMedicas();
            }
        });
    }
}
