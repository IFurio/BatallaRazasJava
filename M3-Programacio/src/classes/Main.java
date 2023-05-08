package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        new gameFrame1();

    }
}
class gameFrame1 extends JFrame {
    private JPanel mainPanel, subPanel;
    private JLabel name1, name2, imgLabel;
    private BufferedImage image;

    gameFrame1() {
        setSize(700, 500);
        setTitle("RacesBattle");
        setLocation(50, 400);
        setResizable(false); // evitas que se pueda cambiar el tamanyo de esta ventana o no
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        try {
//            if (System.getProperty("os.name").equals("Linux")) {
//                image = ImageIO.read(new File("./Images/overlayArcade.jpg"));
//            }else {
//                image = ImageIO.read(new File(".\\Images\\overlayArcade.jpg"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        mainPanel = new JPanel();
        subPanel = new JPanel();
        if (System.getProperty("os.name").equals("Linux")) {
            imgLabel = new JLabel(new ImageIcon("./src/images/overlayArcade.png"));
            imgLabel.setBounds(0, 0, getWidth(), getHeight());
            mainPanel.add(imgLabel);

        }else {
            ImageIcon img = new ImageIcon(".\\src\\images\\overlayArcade.png");
            imgLabel = new JLabel(img);
            imgLabel.setBounds(0, 0, getWidth(), getHeight());
            mainPanel.add(imgLabel);
        }
        add(mainPanel);










        setVisible(true);
    }
}
