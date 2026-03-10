package zoojava.gui;

import zoojava.elefante;
import zoojava.db.ElefanteDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainForm extends JFrame {
    private JTextField txtId, txtNombre, txtEdad, txtHabitat, txtZona, txtPeso, txtTamano, txtAltura, txtGenero;
    private JTextField txtPeriodo, txtPelaje, txtLactancia, txtOrejaIzq, txtOrejaDer, txtColmilloIzq, txtColmilloDer, txtTrompa;
    private JButton btnInsertar, btnModificar, btnEliminar, btnConsultar, btnLimpiar;
    
    private ElefanteDAO dao = new ElefanteDAO();

    public MainForm() {
        setTitle("CRUD Elefantes - Oracle Cloud");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(20, 2));

        // Adding components
        add(new JLabel("ID:")); txtId = new JTextField(); add(txtId);
        add(new JLabel("Nombre:")); txtNombre = new JTextField(); add(txtNombre);
        add(new JLabel("Edad:")); txtEdad = new JTextField(); add(txtEdad);
        add(new JLabel("Habitat:")); txtHabitat = new JTextField(); add(txtHabitat);
        add(new JLabel("Zona Origen:")); txtZona = new JTextField(); add(txtZona);
        add(new JLabel("Peso:")); txtPeso = new JTextField(); add(txtPeso);
        add(new JLabel("Tamaño:")); txtTamano = new JTextField(); add(txtTamano);
        add(new JLabel("Altura:")); txtAltura = new JTextField(); add(txtAltura);
        add(new JLabel("Género:")); txtGenero = new JTextField(); add(txtGenero);
        add(new JLabel("Periodo Gestación:")); txtPeriodo = new JTextField(); add(txtPeriodo);
        add(new JLabel("Tipo Pelaje:")); txtPelaje = new JTextField(); add(txtPelaje);
        add(new JLabel("Lactancia:")); txtLactancia = new JTextField(); add(txtLactancia);
        add(new JLabel("Oreja Izq:")); txtOrejaIzq = new JTextField(); add(txtOrejaIzq);
        add(new JLabel("Oreja Der:")); txtOrejaDer = new JTextField(); add(txtOrejaDer);
        add(new JLabel("Colmillo Izq:")); txtColmilloIzq = new JTextField(); add(txtColmilloIzq);
        add(new JLabel("Colmillo Der:")); txtColmilloDer = new JTextField(); add(txtColmilloDer);
        add(new JLabel("Trompa:")); txtTrompa = new JTextField(); add(txtTrompa);

        btnInsertar = new JButton("Insertar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnConsultar = new JButton("Consultar");
        btnLimpiar = new JButton("Limpiar");

        add(btnInsertar); add(btnModificar);
        add(btnEliminar); add(btnConsultar);
        add(btnLimpiar);

        // Event Listeners
        btnInsertar.addActionListener(e -> insertar());
        btnModificar.addActionListener(e -> modificar());
        btnEliminar.addActionListener(e -> eliminar());
        btnConsultar.addActionListener(e -> consultar());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        setVisible(true);
    }

    private void insertar() {
        try {
            elefante el = getElefanteFromFields();
            dao.insert(el);
            JOptionPane.showMessageDialog(this, "Insertado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void modificar() {
        try {
            elefante el = getElefanteFromFields();
            dao.update(el);
            JOptionPane.showMessageDialog(this, "Modificado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void eliminar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            dao.delete(id);
            JOptionPane.showMessageDialog(this, "Eliminado con éxito");
            limpiarCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void consultar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            elefante el = dao.getById(id);
            if (el != null) {
                fillFields(el);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el elefante con ID " + id);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtId.setText(""); txtNombre.setText(""); txtEdad.setText(""); txtHabitat.setText("");
        txtZona.setText(""); txtPeso.setText(""); txtTamano.setText(""); txtAltura.setText("");
        txtGenero.setText(""); txtPeriodo.setText(""); txtPelaje.setText(""); txtLactancia.setText("");
        txtOrejaIzq.setText(""); txtOrejaDer.setText(""); txtColmilloIzq.setText("");
        txtColmilloDer.setText(""); txtTrompa.setText("");
    }

    private elefante getElefanteFromFields() {
        elefante e = new elefante(
            Double.parseDouble(txtPeriodo.getText()),
            txtPelaje.getText(),
            Integer.parseInt(txtLactancia.getText()),
            Double.parseDouble(txtOrejaIzq.getText()),
            Double.parseDouble(txtOrejaDer.getText()),
            Double.parseDouble(txtColmilloIzq.getText()),
            Double.parseDouble(txtColmilloDer.getText()),
            Double.parseDouble(txtTrompa.getText())
        );
        e.setId(Integer.parseInt(txtId.getText()));
        e.setName(txtNombre.getText());
        e.setAge(Integer.parseInt(txtEdad.getText()));
        e.setHabitat(txtHabitat.getText());
        e.setZonaOrigen(txtZona.getText());
        e.setWeight(Double.parseDouble(txtPeso.getText()));
        e.setSize(Double.parseDouble(txtTamano.getText()));
        e.setHeight(Double.parseDouble(txtAltura.getText()));
        e.setGender(txtGenero.getText());
        return e;
    }

    private void fillFields(elefante e) {
        txtId.setText(String.valueOf(e.getId()));
        txtNombre.setText(e.getName());
        txtEdad.setText(String.valueOf(e.getAge()));
        txtHabitat.setText(e.getHabitat());
        txtZona.setText(e.getZonaOrigen());
        txtPeso.setText(String.valueOf(e.getWeight()));
        txtTamano.setText(String.valueOf(e.getSize()));
        txtAltura.setText(String.valueOf(e.getHeight()));
        txtGenero.setText(e.getGender());
        txtPeriodo.setText(String.valueOf(e.period()));
        txtPelaje.setText(e.coatType());
        txtLactancia.setText(String.valueOf(e.lactation()));
        txtOrejaIzq.setText(String.valueOf(e.tamanhoOrejaIzquierda()));
        txtOrejaDer.setText(String.valueOf(e.tamanhoOrejaDerecha()));
        txtColmilloIzq.setText(String.valueOf(e.tamanhoColmilloIzquierda()));
        txtColmilloDer.setText(String.valueOf(e.tamanhoColmilloDerecha()));
        txtTrompa.setText(String.valueOf(e.tamanhoTrompa()));
    }

    public static void main(String[] args) {
        new MainForm();
    }
}
