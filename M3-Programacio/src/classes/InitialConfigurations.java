package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitialConfigurations extends JFrame implements ActionListener {
    private JTextField fill;

    public InitialConfigurations() {
        setSize(500, 200);
        setTitle("Insert Your Name");
        setLocation(400, 100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());

        JPanel mainPanel = new JPanel();
        JLabel text = new JLabel("Insert your name:");
        fill = new JTextField(20);
        JButton save = new JButton("Save");

        setLayout(new BorderLayout());
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(text, BorderLayout.CENTER);
        mainPanel.add(fill, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.CENTER);

        add(mainPanel);

        save.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (fill.getText().isBlank()) {
            fill.setText("");
        }
        else {
            dispose();
            new GameFrame1(fill.getText());
        }
    }
}
