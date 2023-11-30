package Epe3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Medico extends JFrame {
    private JLabel labelNombreMedico, labelNombrePaciente, labelEspecialidad, labelHorasDisponibles, labelValorHora;
    private JComboBox<String> comboNombreMedico, comboEspecialidad, comboHorasDisponibles;
    private JTextField txtNombrePaciente;
    private JButton btnGuardar, btnCancelar;
    private ArrayList<String> datosGuardados;

    public Medico() {
        super("Ventana del Medico");
        datosGuardados = new ArrayList<>();

        // Creación de los componentes
        labelNombreMedico = new JLabel("Nombre del Medico: ");
        comboNombreMedico = new JComboBox<>(new String[] { "Juan Meza", "Pedro Pascal", "Juan Fernandez" }); // Ejemplo
                                                                                                             // de
                                                                                                             // opciones
        labelNombrePaciente = new JLabel("Nombre del Paciente: ");
        txtNombrePaciente = new JTextField(20);
        labelEspecialidad = new JLabel("Especialidad: ");
        comboEspecialidad = new JComboBox<>(new String[] { "Medicina General", "Pediatria", "Traumatologia" }); // Ejemplo
                                                                                                                    // de
                                                                                                                    // opciones
        labelHorasDisponibles = new JLabel("Horas Disponibles: ");
        comboHorasDisponibles = new JComboBox<>(new String[] { "09:00", "10:00", "11:00" }); // Ejemplo de opciones
        labelValorHora = new JLabel("Valor hora: $7.000");
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        // Configuración del diseño del JFrame
        setLayout(new GridLayout(6, 2));
        add(labelNombreMedico);
        add(comboNombreMedico);
        add(labelNombrePaciente);
        add(txtNombrePaciente);
        add(labelEspecialidad);
        add(comboEspecialidad);
        add(labelHorasDisponibles);
        add(comboHorasDisponibles);
        add(labelValorHora);
        add(new JLabel()); // Espacio en blanco para mantener la disposición
        add(btnGuardar);
        add(btnCancelar);

        // Acción del botón "Guardar"
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
                // Creo un mensaje con los datos guardados
                StringBuilder mensaje = new StringBuilder();
                
                for (String dato : datosGuardados) {
                    mensaje.append(dato).append("\n");
                }

                // Muestro un diálogo emergente con los datos guardados
                JOptionPane.showMessageDialog(rootPane, mensaje);
                Reserva.main(null);
            }
        });

        // Acción del botón "Cancelar"
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual e ir a la Interfaz Principal (ventana principal)
                dispose(); // Cierra la ventana actual
                ReservasHorasMedicas.main(null); // Abre la Interfaz Principal (suponiendo que se llama
                                                 // InterfazPrincipal)
            }
        });

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true); // Hacer visible la ventana
    }

    
    // Método para guardar los datos en el ArrayList
    private void guardarDatos() {
        String nombreMedico = (String) comboNombreMedico.getSelectedItem();
        String nombrePaciente = txtNombrePaciente.getText();
        String especialidad = (String) comboEspecialidad.getSelectedItem();
        String horaDisponible = (String) comboHorasDisponibles.getSelectedItem();

        // Ejemplo de cómo guardar los datos en el ArrayList
        datosGuardados.add("Nombre del Médico: " + nombreMedico);
        datosGuardados.add("Paciente: " + nombrePaciente);
        datosGuardados.add("Especialidad: " + especialidad);
        datosGuardados.add("Hora Asignada: " + horaDisponible);

        // Puedes hacer más con estos datos guardados, como enviarlos a una base de datos o usarlos en otra parte de tu aplicación
        System.out.println("Datos guardados: " + datosGuardados);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Medico();
            }
        });
    }
}