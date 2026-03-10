package zoojava.gui;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Sistema de Gestión del Zoológico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Zoo Java - Oracle Cloud", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new GridLayout(2, 1, 10, 10));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton btnElefantes = new JButton("Gestionar Elefantes");
        JButton btnLeones = new JButton("Gestionar Leones (Próximamente)");

        btnElefantes.addActionListener(e -> new ElefanteForm());
        // btnLeones.addActionListener(e -> new LeonForm()); // Similar a ElefanteForm

        panelButtons.add(btnElefantes);
        panelButtons.add(btnLeones);

        add(panelButtons, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
