package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main {
    public static void main(String[] args) {
        gameFrame1 mainFrame = new gameFrame1();
        mainFrame.setVisible(true);
    }
}
class gameFrame1 extends JFrame {
    private JPanel mainPanel, leftPanel, rightPanel, centerPanel;
    private JLabel imgLabel, imgLabel2, name1, name2;
    private JButton button1, button2, button3, button4, button5;
    private BufferedImage image, image2;
    private JTextArea console;
    gameFrame1() {
        setSize(960, 680);
        setTitle("RacesBattle");
        setLocation(100, 600);
        setResizable(false); // evitas que se pueda cambiar el tamanyo de esta ventana o no
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

        console = new JTextArea();

        button1.setBackground(Color.PINK);
        button2.setBackground(Color.PINK);
        button3.setBackground(Color.PINK);
        button4.setBackground(Color.PINK);
        button5.setBackground(Color.PINK);

        mainPanel.setLayout(new BorderLayout());

        if (System.getProperty("os.name").equals("Linux")) {
            imgLabel = new JLabel(new ImageIcon("M3-Programacio/Images/overlayArcade2(1).png"));
            imgLabel2 = new JLabel(new ImageIcon("M3-Programacio/Images/background.gif"));
        }else {
            imgLabel = new JLabel(new ImageIcon("M3-Programacio\\Images\\overlayArcade2(1).png"));
            imgLabel2 = new JLabel(new ImageIcon("M3-Programacio\\Images\\background.gif"));
        }
        imgLabel.setBounds(0, -70, getWidth(), getHeight());
        imgLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        imgLabel2.setVerticalAlignment(SwingConstants.TOP);

        imgLabel2.setOpaque(false);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(imgLabel);
        mainPanel.add(imgLabel2);

        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        // centerPanel.setOpaque(false);

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BorderLayout());

        leftPanel.add(button1);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 15))); // anyade un espacio en blanco
        leftPanel.add(button2);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanel.add(button3);
        rightPanel.add(button4);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(button5);

        centerPanel.add(console, BorderLayout.SOUTH);

        add(mainPanel);
    }
    public void paint(Graphics g) {
        super.paint(g); // simepre hay que poner esto
        System.out.println("Entramos en el metodo paint");
        Graphics2D g2d = (Graphics2D)g; // casteamos
        System.out.println(g2d.getBackground());
        System.out.println(g2d.getColor());
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.GREEN);
        g2d.drawLine(300, 50, 50, 500);

    }
}
