package co.edu.poli.examen2_Lopez.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.poli.examen2_Lopez.controlador.ControladorInmueble;

public class App extends JFrame {

    private ControladorInmueble controlador;
    private JTextArea areaResultado;

    public App() {

        controlador = new ControladorInmueble();

        setTitle("Gestión de Inmuebles");
        setSize(500, 450); // Aumenté un poco el alto para mejor visualización
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        // =====================
        // PANEL CREAR
        // =====================
        // Usamos 7 filas para incluir el campo dinámico (Tipo, Num, Fecha, ID, Nombre, Extra, Botón)
        JPanel panelCrear = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField txtNumero = new JTextField();
        JTextField txtFecha = new JTextField();
        JTextField txtIdProp = new JTextField();
        JTextField txtNombreProp = new JTextField();
        JTextField txtExtra = new JTextField();
        
        JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Casa", "Apartamento"});
        
        // 1. Etiqueta dinámica (según tu imagen)
        JLabel lblExtra = new JLabel("Cantidad de pisos:");

        // 2. Listener para cambiar el texto según el tipo (según tu imagen)
        comboTipo.addActionListener(e -> {
            String tipo = comboTipo.getSelectedItem().toString();
            if (tipo.equals("Casa")) {
                lblExtra.setText("Cantidad de pisos:");
            } else {
                lblExtra.setText("Número de piso:");
            }
        });

        JButton btnCrear = new JButton("Crear");

        // Agregar componentes al panel
        panelCrear.add(new JLabel("Tipo:"));
        panelCrear.add(comboTipo);

        panelCrear.add(new JLabel("Número:"));
        panelCrear.add(txtNumero);

        panelCrear.add(new JLabel("Fecha:"));
        panelCrear.add(txtFecha);

        panelCrear.add(new JLabel("ID Propietario:"));
        panelCrear.add(txtIdProp);

        panelCrear.add(new JLabel("Nombre Propietario:"));
        panelCrear.add(txtNombreProp);

        // 3. Agregar los campos dinámicos al panel (según tu imagen)
        panelCrear.add(lblExtra);
        panelCrear.add(txtExtra);

        panelCrear.add(new JLabel(""));
        panelCrear.add(btnCrear);

        btnCrear.addActionListener(e -> {
            // Se asume que el controlador ahora recibe un parámetro extra
            String res = controlador.crear(
                comboTipo.getSelectedItem().toString(),
                txtNumero.getText(),
                txtFecha.getText(),
                txtIdProp.getText(),
                txtNombreProp.getText(),
                txtExtra.getText() // Se envía el valor del campo dinámico
            );

            JOptionPane.showMessageDialog(null, res);
        });

        tabs.add("Crear", panelCrear);

        // =====================
        // PANEL CONSULTAR
        // =====================
        JPanel panelConsultar = new JPanel(new BorderLayout());

        JPanel top = new JPanel();
        JTextField txtBuscar = new JTextField(10);
        JButton btnBuscar = new JButton("Consultar");

        top.add(new JLabel("Número:"));
        top.add(txtBuscar);
        top.add(btnBuscar);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaResultado);

        panelConsultar.add(top, BorderLayout.NORTH);
        panelConsultar.add(scroll, BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> {
            String res = controlador.consultar(txtBuscar.getText());
            areaResultado.setText(res);
        });

        tabs.add("Consultar", panelConsultar);

        add(tabs);
    }

    public static void main(String[] args) {
        // Asegurar que la GUI se ejecute en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}