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

class Ranking extends JFrame {
    private JPanel panel_principal, panel1, panel2;
    private JTextArea ranking;
    private JLabel title;

    public Ranking() {
        panel_principal = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel_principal.setLayout(new BoxLayout(panel_principal, BoxLayout.Y_AXIS));
        ranking = new JTextArea();
        title = new JLabel("<html><u>Ranking</u></html>");
        title.setFont(new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 20));
        ranking.setOpaque(false);
        Query query = new Query();
        ResultSet rs;
        rs = query.makeSelect("select * from players order by global_points desc");

        try {
            int cont = 0;
            String data = "";
            while (rs.next() && cont < 10) {
                data = "ID: " + rs.getInt(1) + " Name: " + rs.getString(2) + " Points: " + rs.getInt(3) + "\n\n";
                ranking.setText(ranking.getText() + data);
                cont++;
            }
            query.closeConnections();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Conexion no creada correctamente");
        }
        panel1.add(title);
        panel2.add(ranking);
        panel_principal.add(panel1);
        panel_principal.add(panel2);
        add(panel_principal, BorderLayout.CENTER);
        setTitle("Ranking");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
