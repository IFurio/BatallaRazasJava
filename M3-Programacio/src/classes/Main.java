package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Query ddbb = new Query();
        ddbb.dataBaseLogin();
        Player p1 = new Player();
    }
}
class GameFrame1 extends JFrame implements ActionListener {
    private JPanel mainPanel, leftPanel, rightPanel, centerPanel, subPanelPlayers;
    private JLabel imgLabel, imgLabel2, lifeBar1, lifeBar2, powerBar1, powerBar2, agilityBar1, agilityBar2, speedBar1,
            speedBar2, defenseBar1, defenseBar2, playerImg1, playerImg2;
    private Warrior player1, player2;
    private JButton button1, button2, button3, button4, button5;
    private JScrollPane scrollPane;
    private JTextArea console;
    GameFrame1() {
        setSize(960, 680);
        setTitle("RacesBattle");
        setLocation(100, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        centerPanel = new JPanel();
        subPanelPlayers = new JPanel();

        button1 = new JButton("Choose Character");
        button2 = new JButton("Choose Weapon");
        button3 = new JButton("Ranking");
        button4 = new JButton("Fight");
        button5 = new JButton("Clear Console");

        console = new JTextArea("Welcome to the game!",5, 70);
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

        button1.setBackground(Color.YELLOW);
        button2.setBackground(Color.YELLOW);
        button3.setBackground(Color.YELLOW);
        button4.setBackground(Color.YELLOW);
        button5.setBackground(Color.YELLOW);

        mainPanel.setLayout(new BorderLayout());

        player2 = new Warrior(1, "Link", "Elf", 40, 4, 2, 7, 7, "M3-Programacio/Images/warrior1.png",19);
        player1 = new Warrior(2, "Head Hunter", "Human", 50, 5, 3, 6, 6, "M3-Programacio/Images/warrior2.png",20);
        imgLabel2 = new JLabel(new ImageIcon("M3-Programacio/Images/VSlogo.png"));
        imgLabel = new JLabel(new ImageIcon("M3-Programacio/Images/animation.gif"));
        playerImg1 = new JLabel(new ImageIcon(player2.getImgUrl()));
        playerImg2 = new JLabel(new ImageIcon(player1.getImgUrl()));
        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());

        imgLabel2.setBounds(0, 300, getWidth(), getHeight());
        imgLabel2.setLocation(300,300);
        //imgLabel2.setBackground(Color.RED);
        //imgLabel2.setOpaque(true);
        imgLabel.setBounds(0, -70, getWidth(), getHeight());

        mainPanel.add(imgLabel);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        centerPanel.setOpaque(false);
        mainPanel.setOpaque(false);
        subPanelPlayers.setOpaque(false);

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BorderLayout());
        subPanelPlayers.setLayout(new FlowLayout());

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
        centerPanel.add(subPanelPlayers, BorderLayout.SOUTH);

        subPanelPlayers.add(playerImg1);
        subPanelPlayers.add(playerImg2);

        mainPanel.setComponentZOrder(imgLabel, mainPanel.getComponentCount() - 1);

        add(mainPanel);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Choose Character")) {
            new CharactersWindow(player1);
        }
        else if (e.getActionCommand().equals("Choose Weapon")) {
            System.out.println("Choose weapon");
        }
        else if (e.getActionCommand().equals("Ranking")) {
            System.out.println("Ranking");
        }
        else if (e.getActionCommand().equals("Fight")) {
            System.out.println("Fight");
        }
        else if (e.getActionCommand().equals("Clear Console")) {
            System.out.println("Clear Console");
            console.setText("");
        }
    }
}
class CharactersWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton warrior1, warrior2, warrior3, warrior4, warrior5, warrior6, warrior7, warrior8, warrior9;
    private Warrior pj1;
    CharactersWindow(Warrior pj1) {
        this.pj1 = pj1;
        setSize(960, 680);
        setTitle("Select Character");
        setLocation(100, 600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mainPanel = new JPanel();

        warrior1 = new JButton(new ImageIcon("M3-Programacio/Images/warrior11.png"));
        warrior2 = new JButton(new ImageIcon("M3-Programacio/Images/warrior21.jpg"));
        warrior3 = new JButton(new ImageIcon("M3-Programacio/Images/warrior31.png"));
        warrior4 = new JButton(new ImageIcon("M3-Programacio/Images/warrior41.png"));
        warrior5 = new JButton(new ImageIcon("M3-Programacio/Images/warrior51.jpg"));
        warrior6 = new JButton(new ImageIcon("M3-Programacio/Images/warrior61.jpg"));
        warrior7 = new JButton(new ImageIcon("M3-Programacio/Images/warrior71.png"));
        warrior8 = new JButton(new ImageIcon("M3-Programacio/Images/warrior81.jpg"));
        warrior9 = new JButton(new ImageIcon("M3-Programacio/Images/warrior91.jpg"));
        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());

        warrior1.setText("Legolas");
        warrior2.setText("Isildur");
        warrior3.setText("Eru");
        warrior4.setText("Arthur Pendragon");
        warrior5.setText("Siegfried");
        warrior6.setText("Sir William Wallace");
        warrior7.setText("Brokk");
        warrior8.setText("Guldrak");
        warrior9.setText("Krumgrom");

        mainPanel.setLayout(new GridLayout(3,3));

        mainPanel.add(warrior1);
        mainPanel.add(warrior2);
        mainPanel.add(warrior3);
        mainPanel.add(warrior4);
        mainPanel.add(warrior5);
        mainPanel.add(warrior6);
        mainPanel.add(warrior7);
        mainPanel.add(warrior8);
        mainPanel.add(warrior9);

        add(mainPanel);

        warrior1.addActionListener(this);
        warrior2.addActionListener(this);
        warrior3.addActionListener(this);
        warrior4.addActionListener(this);
        warrior5.addActionListener(this);
        warrior6.addActionListener(this);
        warrior7.addActionListener(this);
        warrior8.addActionListener(this);
        warrior9.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Selecciono personaje");
        if (e.getActionCommand().equals("Legolas")) {
            System.out.println("Click on warrior1, legolas");

        }
        else if (e.getActionCommand().equals("Isildur")) {
            System.out.println("Click on warrior2, Isildur");
        }
        else if (e.getActionCommand().equals("Eru")) {
            System.out.println("Click on warrior3, Eru");
        }
        else if (e.getActionCommand().equals("Arthur Pendragon")) {
            System.out.println("Click on warrior4, Arthur Pendragon");
        }
        else if (e.getActionCommand().equals("Siegfried")) {
            System.out.println("Click on warrior5, Siegfried");
        }
        else if (e.getActionCommand().equals("Sir William Wallace")) {
            System.out.println("Click on warrior6, Sir William Wallace");
        }
        else if (e.getActionCommand().equals("Brokk")) {
            System.out.println("Click on warrior7, Brokk");
        }
        else if (e.getActionCommand().equals("Guldrak")) {
            System.out.println("Click on warrior8, Guldrak");
        }
        else if (e.getActionCommand().equals("Krumgrom")) {
            System.out.println("Click on warrior9, Krumgrom");
        }
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
