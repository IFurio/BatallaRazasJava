package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        gameFrame1 mainFrame = new gameFrame1();
        mainFrame.setVisible(true);
    }
}
class gameFrame1 extends JFrame {
    private JPanel mainPanel, leftPanel, rightPanel, centerPanel;
    private JLabel imgLabel, imgLabel2, lifeBar1, lifeBar2, powerBar1, powerBar2, agilityBar1, agilityBar2, speedBar1,
            speedBar2, defenseBar1, defenseBar2, name1, name2;
    private JButton button1, button2, button3, button4, button5;
    private BufferedImage image, image2;
    private JScrollPane scrollPane;
    private JTextArea console;
    gameFrame1() {
        setSize(960, 680);
        setTitle("RacesBattle");
        setLocation(100, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        centerPanel = new JPanel();

        button1 = new JButton("Choose Character");
        button2 = new JButton("Choose Weapon");
        button3 = new JButton("Ranking");
        button4 = new JButton("Fight");
        button5 = new JButton("Clear Console");

        console = new JTextArea(5, 70);
        console.setEditable(false);
        console.setLineWrap(false);

        scrollPane = new JScrollPane(console);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        lifeBar1 = new JLabel("100%");
        lifeBar1.setBackground(Color.GREEN);
        lifeBar1.setBounds(50, 30, 250, 10);
        lifeBar1.setOpaque(true);
        lifeBar1.setHorizontalAlignment(SwingConstants.RIGHT);

        lifeBar2 = new JLabel("100%");
        lifeBar2.setBackground(Color.GREEN);
        lifeBar2.setBounds(390, 30, 250, 10);
        lifeBar2.setOpaque(true);

        powerBar1 = new JLabel("Power");
        powerBar1.setBackground(Color.RED);
        powerBar1.setBounds(50, 50, 250, 10);
        powerBar1.setOpaque(true);
        powerBar1.setHorizontalAlignment(SwingConstants.RIGHT);

        powerBar2 = new JLabel("Power");
        powerBar2.setBackground(Color.RED);
        powerBar2.setBounds(390, 50, 250, 10);
        powerBar2.setOpaque(true);

        agilityBar1 = new JLabel("Agility");
        agilityBar1.setBackground(Color.YELLOW);
        agilityBar1.setBounds(50, 70, 250, 10);
        agilityBar1.setOpaque(true);
        agilityBar1.setHorizontalAlignment(SwingConstants.RIGHT);

        agilityBar2 = new JLabel("Agility");
        agilityBar2.setBackground(Color.YELLOW);
        agilityBar2.setBounds(390, 70, 250, 10);
        agilityBar2.setOpaque(true);


        speedBar1 = new JLabel("Speed");
        speedBar1.setBackground(Color.CYAN);
        speedBar1.setBounds(50, 90, 250, 10);
        speedBar1.setOpaque(true);
        speedBar1.setHorizontalAlignment(SwingConstants.RIGHT);

        speedBar2 = new JLabel("Speed");
        speedBar2.setBackground(Color.CYAN);
        speedBar2.setBounds(390, 90, 250, 10);
        speedBar2.setOpaque(true);

        defenseBar1 = new JLabel("Defense");
        defenseBar1.setBackground(Color.WHITE);
        defenseBar1.setBounds(50, 110, 250, 10);
        defenseBar1.setOpaque(true);
        defenseBar1.setHorizontalAlignment(SwingConstants.RIGHT);

        defenseBar2 = new JLabel("Defense");
        defenseBar2.setBackground(Color.WHITE);
        defenseBar2.setBounds(390, 110, 250, 10);
        defenseBar2.setOpaque(true);

        button1.setBackground(Color.PINK);
        button2.setBackground(Color.PINK);
        button3.setBackground(Color.PINK);
        button4.setBackground(Color.PINK);
        button5.setBackground(Color.PINK);

        mainPanel.setLayout(new BorderLayout());

        if (System.getProperty("os.name").equals("Linux")) {
            imgLabel2 = new JLabel(new ImageIcon("M3-Programacio/Images/VSlogo.png"));
            imgLabel = new JLabel(new ImageIcon("M3-Programacio/Images/animation.gif"));
            setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());
        }else {
            imgLabel2 = new JLabel(new ImageIcon("M3-Programacio\\Images\\VSlogo.png"));
            imgLabel = new JLabel(new ImageIcon("M3-Programacio\\Images\\animation.gif"));
            setIconImage(new ImageIcon("M3-Programacio\\Images\\fightIcon.jpg").getImage());
        }
        imgLabel2.setBounds(0, 300, getWidth(), getHeight());
        imgLabel2.setLocation(300,300);
        imgLabel2.setBackground(Color.RED);
        imgLabel2.setOpaque(true);
        imgLabel.setBounds(0, -70, getWidth(), getHeight());

        mainPanel.add(imgLabel);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        centerPanel.setOpaque(false);
        mainPanel.setOpaque(false);

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BorderLayout());

        leftPanel.add(button1);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 15))); // add a blank box
        leftPanel.add(button2);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanel.add(button3);

        rightPanel.add(button4);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(button5);

        centerPanel.add(lifeBar1, BorderLayout.NORTH);
        centerPanel.add(lifeBar2, BorderLayout.NORTH);
        centerPanel.add(powerBar1, BorderLayout.NORTH);
        centerPanel.add(powerBar2, BorderLayout.NORTH);
        centerPanel.add(agilityBar1, BorderLayout.NORTH);
        centerPanel.add(agilityBar2, BorderLayout.NORTH);
        centerPanel.add(speedBar1, BorderLayout.NORTH);
        centerPanel.add(speedBar2, BorderLayout.NORTH);
        centerPanel.add(defenseBar1, BorderLayout.NORTH);
        centerPanel.add(defenseBar2, BorderLayout.NORTH);
        centerPanel.add(imgLabel2, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        mainPanel.setComponentZOrder(imgLabel, mainPanel.getComponentCount() - 1);

        add(mainPanel);
    }
}
