package zoojava.gui;

import zoojava.elefante;
import zoojava.db.ElefanteDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ElefanteForm extends JFrame {
    private JTextField txtId, txtNombre, txtEdad, txtHabitat, txtZona, txtPeso, txtTamano, txtAltura, txtGenero;
    private JTextField txtPeriodo, txtPelaje, txtLactancia, txtOrejaIzq, txtOrejaDer, txtColmilloIzq, txtColmilloDer, txtTrompa;
    private JTable table;
    private DefaultTableModel tableModel;
    private ElefanteDAO dao = new ElefanteDAO();

    public ElefanteForm() {
        setTitle("Gestión de Elefantes");
        setSize(1000, 700);
        setLayout(new BorderLayout());

        // Panel de entrada (Izquierda)
        JPanel panelInput = new JPanel(new GridLayout(18, 2));
        panelInput.setBorder(BorderFactory.createTitledBorder("Datos del Elefante"));
        
        panelInput.add(new JLabel("ID:")); txtId = new JTextField(); panelInput.add(txtId);
        panelInput.add(new JLabel("Nombre:")); txtNombre = new JTextField(); panelInput.add(txtNombre);
        panelInput.add(new JLabel("Edad:")); txtEdad = new JTextField(); panelInput.add(txtEdad);
        panelInput.add(new JLabel("Habitat:")); txtHabitat = new JTextField(); panelInput.add(txtHabitat);
        panelInput.add(new JLabel("Zona Origen:")); txtZona = new JTextField(); panelInput.add(txtZona);
        panelInput.add(new JLabel("Peso:")); txtPeso = new JTextField(); panelInput.add(txtPeso);
        panelInput.add(new JLabel("Tamaño:")); txtTamano = new JTextField(); panelInput.add(txtTamano);
        panelInput.add(new JLabel("Altura:")); txtAltura = new JTextField(); panelInput.add(txtAltura);
        panelInput.add(new JLabel("Género:")); txtGenero = new JTextField(); panelInput.add(txtGenero);
        panelInput.add(new JLabel("Gestation:")); txtPeriodo = new JTextField(); panelInput.add(txtPeriodo);
        panelInput.add(new JLabel("Pelaje:")); txtPelaje = new JTextField(); panelInput.add(txtPelaje);
        panelInput.add(new JLabel("Lactancia:")); txtLactancia = new JTextField(); panelInput.add(txtLactancia);
        panelInput.add(new JLabel("Oreja Izq:")); txtOrejaIzq = new JTextField(); panelInput.add(txtOrejaIzq);
        panelInput.add(new JLabel("Oreja Der:")); txtOrejaDer = new JTextField(); panelInput.add(txtOrejaDer);
        panelInput.add(new JLabel("Colmillo Izq:")); txtColmilloIzq = new JTextField(); panelInput.add(txtColmilloIzq);
        panelInput.add(new JLabel("Colmillo Der:")); txtColmilloDer = new JTextField(); panelInput.add(txtColmilloDer);
        panelInput.add(new JLabel("Trompa:")); txtTrompa = new JTextField(); panelInput.add(txtTrompa);

        // Botones
        JPanel panelButtons = new JPanel();
        JButton btnInsert = new JButton("Insertar");
        JButton btnUpdate = new JButton("Modificar");
        JButton btnDelete = new JButton("Eliminar");
        JButton btnList = new JButton("Listar");
        JButton btnClear = new JButton("Limpiar");
        
        panelButtons.add(btnInsert); panelButtons.add(btnUpdate);
        panelButtons.add(btnDelete); panelButtons.add(btnList);
        panelButtons.add(btnClear);

        // Tabla (Centro/Derecha)
        String[] columns = {"ID", "Nombre", "Edad", "Habitat", "Peso", "Trompa"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelInput, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        // Eventos
        btnInsert.addActionListener(e -> { insertar(); listar(); });
        btnUpdate.addActionListener(e -> { modificar(); listar(); });
        btnDelete.addActionListener(e -> { eliminar(); listar(); });
        btnList.addActionListener(e -> listar());
        btnClear.addActionListener(e -> limpiar());

        listar(); // Cargar al iniciar
        setVisible(true);
    }

    private void listar() {
        try {
            tableModel.setRowCount(0);
            List<elefante> list = dao.getAll();
            for (elefante e : list) {
                tableModel.addRow(new Object[]{e.getId(), e.getName(), e.getAge(), e.getHabitat(), e.getWeight(), e.tamanhoTrompa()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + ex.getMessage());
        }
    }

    private void insertar() {
        try {
            dao.insert(getElefante());
            JOptionPane.showMessageDialog(this, "Guardado");
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage()); }
    }

    private void modificar() {
        try {
            dao.update(getElefante());
            JOptionPane.showMessageDialog(this, "Modificado");
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage()); }
    }

    private void eliminar() {
        try {
            dao.delete(Integer.parseInt(txtId.getText()));
            JOptionPane.showMessageDialog(this, "Eliminado");
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage()); }
    }

    private void limpiar() {
        txtId.setText(""); txtNombre.setText(""); // ... limpiar el resto
    }

    private elefante getElefante() {
        elefante e = new elefante(Double.parseDouble(txtPeriodo.getText()), txtPelaje.getText(), Integer.parseInt(txtLactancia.getText()), 
                     Double.parseDouble(txtOrejaIzq.getText()), Double.parseDouble(txtOrejaDer.getText()), Double.parseDouble(txtColmilloIzq.getText()), 
                     Double.parseDouble(txtColmilloDer.getText()), Double.parseDouble(txtTrompa.getText()));
        e.setId(Integer.parseInt(txtId.getText())); e.setName(txtNombre.getText()); e.setAge(Integer.parseInt(txtEdad.getText()));
        e.setHabitat(txtHabitat.getText()); e.setZonaOrigen(txtZona.getText()); e.setWeight(Double.parseDouble(txtPeso.getText()));
        e.setSize(Double.parseDouble(txtTamano.getText())); e.setHeight(Double.parseDouble(txtAltura.getText())); e.setGender(txtGenero.getText());
        return e;
    }
}
