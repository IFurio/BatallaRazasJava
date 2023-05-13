package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ENTER TO THE QUERY CLASS TO MAKE SURE YOU ARE USING YOUR CURRENT CREDENTIALS!!!!!
        new InitialConfigurations(); // This is used to config the playername

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
    private ArrayList<Warrior> warriorsList;
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

        // set an empty warrior for the player. Later the warrior will be chosen
        player1 = new Warrior(0, "", "", 0, 0, 0, 0, 0, "","", 0);

        // select a random bot warrior
        Query query = new Query();
        query.warrior_getdata();
        warriorsList = query.getMainWarriorContainer().getWarriors();

        player2 = warriorsList.get((int)(Math.random()*warriorsList.size()));

        imgLabel2 = new JLabel(new ImageIcon("M3-Programacio/Images/VSlogo.png"));
        imgLabel = new JLabel(new ImageIcon("M3-Programacio/Images/animation.gif"));
        playerImg1 = new JLabel(); // this will later contain the warrior sprite image
        playerImg2 = new JLabel(new ImageIcon(player2.getSpriteUrl()));
        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());

        imgLabel2.setBounds(0, 300, getWidth(), getHeight());
        imgLabel2.setLocation(300,300);
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
            new CharactersWindow(player1, warriorsList, playerImg1);
            // hacer calculo de botones segun guerreros
            // hacer gridlayout con un for que recorra la arraylist de guerreros
            // crear una clase que extienda de boton y meterle un atributo que sea el warrior id
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
class CharactersWindow extends JFrame {
    private JPanel mainPanel;
    private WarriorButon warrior1, warrior2, warrior3, warrior4, warrior5, warrior6, warrior7, warrior8, warrior9;
    private Warrior pj1;
    private ArrayList<Warrior> warriorsList;
    private JLabel playerImg1;

    CharactersWindow(Warrior pj1, ArrayList<Warrior> warriorsList, JLabel playerImg1) {
        this.pj1 = pj1;
        this.warriorsList = warriorsList;
        this.playerImg1 = playerImg1;
        setSize(960, 680);
        setTitle("Select Character");
        setLocation(100, 600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(3,3));

        for (int i = 0; i<warriorsList.size() - 1; i++){ // we create a button for each of the warriors on the list
            WarriorButon warriorButon;
            Warrior currentWarrior = warriorsList.get(i);
            warriorButon = new WarriorButon(currentWarrior, pj1, playerImg1, new ImageIcon(currentWarrior.getImgUrl()));
            mainPanel.add(warriorButon);
            warriorButon.addActionListener(warriorButon);
        }

        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());

        add(mainPanel);

        setVisible(true);
    }
}
class WarriorButon extends JButton implements ActionListener {
    private Warrior warrior, pj1;
    private JLabel playerImg1;

    WarriorButon(Warrior warrior, Warrior pj1, JLabel playerImg1, ImageIcon img) {
        super(img);
        this.warrior = warrior;
        this.pj1 = pj1;
        this.playerImg1 = playerImg1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pj1 = warrior;
        playerImg1 = new JLabel(new ImageIcon(warrior.getSpriteUrl()));
    }
}
