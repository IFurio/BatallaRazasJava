package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitialConfigurations extends JFrame implements ActionListener {
    private String name;
    private int id;
    private JTextField fill;

    public InitialConfigurations() {
        setSize(500, 200);
        setTitle("Insert Your Name");
        setLocation(100, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (fill.getText().isBlank()) {
            fill.setText("");
        }
        else {
            setName(fill.getText());
            Query users = new Query();
            ResultSet rs;
            rs = users.makeSelect("jdbc:mysql://localhost/batalla_races?serverTimezone=UTC", "isaac", "1234", "select max(player_id) from players");
            try {
                rs.next();
                setId(rs.getInt(1) + 1);
                System.out.println(getId());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
            new GameFrame1();
        }
    }
}
