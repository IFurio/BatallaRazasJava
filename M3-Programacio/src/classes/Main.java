package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // ENTER TO THE QUERY CLASS TO MAKE SURE YOU ARE USING YOUR CURRENT CREDENTIALS!!!!!
        new InitialConfigurations(); // This is used to config the player name

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
    private ArrayList<Weapon> weaponsList;
    private String username;
    GameFrame1(String username) {
        this.username = username;
        setSize(960, 680);
        setTitle("RacesBattle");
        setLocation(400, 100);
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

        // set an empty warrior for the player. Later the warrior will be chosen
        player1 = new Warrior(0, "", "", 0, 0, 0, 0, 0, "","", 0);


        Query query = new Query();
        query.warrior_getdata(); // set WarriorContainer class
        warriorsList = query.getMainWarriorContainer().getWarriors(); // get the warrior list
        player2 = warriorsList.get((int)(Math.random()*warriorsList.size())); // select a random bot warrior

        query.weapon_getdata();// set WeaponContainer class
        weaponsList = query.getMainWeaponContainer().getWeapons();

        // set an avaible weapon for the bot warrior
        ResultSet rs;
        rs = query.makeSelect("select * from weapons_available where warrior_id = " + player2.getId());
        try {
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();
            rs.absolute((int)(Math.random()*rowCount) + 1); // random weapon id from 1 to x
            player2.setWeaponID(rs.getInt(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // we modify the bot warrior force and speed depending on the weapon
        // we rest 1 because the bbdd goes from 1 to 9 and the arraylist from 0 to 8
        player2.setForce(player2.getForce() + weaponsList.get(player2.getWeaponID() - 1).getForce());
        player2.setSpeed(player2.getSpeed() + weaponsList.get(player2.getWeaponID() - 1).getSpeed());

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
        powerBar2.setBounds(390, 50, 250, 10); // max width 250
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
        if (e.getActionCommand().equals("Choose Character")) { // click to choose character button
            new CharactersWindow(player1, warriorsList, playerImg1);
        }
        else if (e.getActionCommand().equals("Choose Weapon")) { // click to choose weapon button
            if (player1.getName().equals("")) {
                JOptionPane.showMessageDialog(null, "Choose a character first!!!");
            }else {
                new WeaponsWindow(player1, weaponsList);
            }
        }
        else if (e.getActionCommand().equals("Ranking")) { // click to ranking button
            new Ranking();
        }
        else if (e.getActionCommand().equals("Fight")) { // click fight button
            System.out.println("Fight");
            button4.setEnabled(false);      //Set Enable to false so the player cant click it until the turn ends
            if (player1.getLife() > 0 && player2.getLife() > 0 && player1.getWeaponID() != 0 && player2.getWeaponID() != 0) {
                if (player1.getDealer() == 0 && player2.getDealer() == 0) { //If it get clicked for the first time
                    if (player1.getSpeed() >= player2.getSpeed()) {          //Set the attack order
                        player1.setDealer(1);                                //The player will attack first
                    } else {
                        player2.setDealer(2);                                //The BOT attack first
                    }
                }
                //Reset Stats
                player1.setDmgAttack(0);
                player2.setDmgAttack(0);
                player1.setDmgReceived(0);
                player2.setDmgReceived(0);
                if (player1.getDealer() == 1) {                     //If its Player1 turn
                    console.setText(console.getText() + "\n" + player1.getName()+"s turn");
                    player1.setDmgAttack(player1.doAtack());
                    if (player1.getDmgAttack() == 0) {              //Attack failed
                        console.setText(console.getText() + "\nAttack failed.");
                    } else {                                        //Attack not failed
                        player2.doDefense(player1.getDmgAttack());
                        if (player2.getDmgReceived() == 0) {        //If it dodge the attack (if DmgReceived isnt 0 it didnt dodge it)
                            console.setText(console.getText() + "\n" + player2.getName() + " dodged the attack.");
                        } else {
                            console.setText(console.getText() + "\n" + player2.getName() + " has received " + player2.getDmgReceived() + " of damage.");
                        }
                    }
                    if (player1.getSpeed() <= player2.getSpeed()) {          //If dealer speed is equal or less than the opponent, it cant attack again
                        player1.setDealer(0);
                        player2.setDealer(2);
                    } else {                                                //If it has more speed
                        Random r = new Random();
                        int ran = r.nextInt(100) + 1;
                        if ((player1.getSpeed() - player2.getSpeed()) * 10 < ran) {     //It can attack again
                            player1.setDealer(0);
                            player2.setDealer(2);
                        }
                    }
                } else if (player2.getDealer() == 2) {               //If its Player2 turn
                    console.setText(console.getText() + "\n" + player2.getName()+"s turn");
                    player2.setDmgAttack(player2.doAtack());
                    if (player2.getDmgAttack() == 0) {               //Attack failed
                        console.setText(console.getText() + "\nAttack failed.");
                    } else {                                        //Attack not failed
                        player1.doDefense(player2.getDmgAttack());
                        if (player1.getDmgReceived() == 0) {        //If it dodge the attack (if DmgReceived isnt 0 it didnt dodge it)
                            console.setText(console.getText() + "\n" + player1.getName() + " dodged the attack.");
                        } else {
                            console.setText(console.getText() + "\n" + player1.getName() + " has received " + player1.getDmgReceived() + " of damage.");
                        }
                    }
                    if (player2.getSpeed() <= player1.getSpeed()) {          //If dealer speed is equal or less than the opponent, it cant attack again
                        player2.setDealer(0);
                        player1.setDealer(1);
                    } else {                                                 //If it has more speed
                        Random r = new Random();
                        int ran = r.nextInt(100) + 1;
                        if ((player2.getSpeed() - player1.getSpeed()) * 10 < ran) {     //It can attack again
                            player2.setDealer(0);
                            player1.setDealer(1);
                        }
                    }
                }
                console.setText(console.getText() + "\n" + player1.getName() + "s HP: " + player1.getLife());
                console.setText(console.getText() + "\n" + player2.getName() + "s HP: " + player2.getLife());

                //When there is someone with no HP
                if (player1.getLife() <= 0) {
                    console.setText(console.getText() + "The player lose, " + player2.getName() + " wins.");
                } else if (player2.getLife() <= 0) {
                    console.setText(console.getText() + "Bot lose, player with " + player1.getName() + " wins");
                }

            }
            button4.setEnabled(true);
        }
        else if (e.getActionCommand().equals("Clear Console")) {
            System.out.println("Clear Console");
            console.setText("");
        }
    }
}
class CharactersWindow extends JDialog {
    private JPanel mainPanel;
    private Warrior player1;
    private ArrayList<Warrior> warriorsList;
    private JLabel playerImg1;

    CharactersWindow(Warrior player1, ArrayList<Warrior> warriorsList, JLabel playerImg1) {
        this.player1 = player1;
        this.warriorsList = warriorsList;
        this.playerImg1 = playerImg1;
        setSize(650, 680);
        setTitle("Select Character");
        setLocation(400, 100);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);

        mainPanel = new JPanel();

        int numRows = warriorsList.size() / 3; // the number of rows is calculated according to the number of warriors
        if (warriorsList.size() % 3 != 0) {
            numRows++;
        }

        mainPanel.setLayout(new GridLayout(numRows,3));

        for (int i = 0; i<warriorsList.size(); i++){ // we create a button for each of the warriors on the list
            WarriorButon warriorButon;
            Warrior currentWarrior = warriorsList.get(i);
            warriorButon = new WarriorButon(currentWarrior, player1, playerImg1, new ImageIcon(currentWarrior.getImgUrl()));
            mainPanel.add(warriorButon);
            warriorButon.addActionListener(warriorButon); // this will treat the action of the button
        }

        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());

        add(mainPanel);

        setVisible(true);
    }
}
class WarriorButon extends JButton implements ActionListener {
    private Warrior warrior, player1;
    private JLabel playerImg1;

    WarriorButon(Warrior warrior, Warrior player1, JLabel playerImg1, ImageIcon img) {
        super(img);
        this.warrior = warrior;
        this.player1 = player1;
        this.playerImg1 = playerImg1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // set the clicked warrior to the player1 warrior
        player1.setId(warrior.getId());
        player1.setName(warrior.getName());
        player1.setAgility(warrior.getAgility());
        player1.setDefense(warrior.getDefense());
        player1.setForce(warrior.getForce());
        player1.setInitialForce(warrior.getForce());
        player1.setImgUrl(warrior.getImgUrl());
        player1.setLife(warrior.getLife());
        player1.setInitialLife(warrior.getLife());
        player1.setPoints(warrior.getPoints());
        player1.setRace(warrior.getRace());
        player1.setSpeed(warrior.getSpeed());
        player1.setInitialSpeed(warrior.getInitialSpeed());
        player1.setSpriteUrl(warrior.getSpriteUrl());
        ImageIcon img = new ImageIcon(warrior.getSpriteUrl());
        playerImg1.setIcon(img);
        // This prevents a weapon from being chosen for the wrong warrior when changing it back
        player1.setWeaponID(0);

    }

}
class WeaponsWindow extends JDialog {
    private JPanel mainPanel;
    private Warrior player1;
    private ArrayList<Weapon> weaponsList;
    WeaponsWindow(Warrior player1, ArrayList<Weapon> weaponsList) {
        setSize(650, 680);
        setTitle("Select Weapon");
        setLocation(400, 100);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());

        mainPanel = new JPanel();

        int numRows = weaponsList.size() / 3; // the number of rows is calculated according to the number of weapons
        if (weaponsList.size() % 3 != 0) {
            numRows++;
        }

        mainPanel.setLayout(new GridLayout(numRows, 3));

        // We only need to show the weapons avaible for the current warrior so first of all we make a query to select
        // all the weapons needed
        Query query = new Query();
        ResultSet rs;
        rs = query.makeSelect("select * from weapons_available where warrior_id = " + player1.getId());
        try {
            while (rs.next()) {
                Weapon currentWeapon;
                WeaponButton weaponButton;
                // We rest 1 because the bbdd goes from 1 to 9 and the arraylist from 0 to 8
                // The weaponButton constructor have 1 new ImageIcon because this will be displayed on the button
                currentWeapon = weaponsList.get(rs.getInt(2) - 1);
                weaponButton = new WeaponButton(player1, new ImageIcon(currentWeapon.getImage()), currentWeapon);
                mainPanel.add(weaponButton);
                weaponButton.addActionListener(weaponButton); // this will treat the action of the button
            }
            query.closeConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        add(mainPanel);

        setVisible(true);
    }
}
class WeaponButton extends JButton implements ActionListener {
    private Warrior player1;
    private Weapon player1Weapon;

    WeaponButton(Warrior player1, ImageIcon weaponImg, Weapon player1Weapon) {
        super(weaponImg);
        this.player1 = player1;
        this.player1Weapon = player1Weapon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player1.setWeaponID(player1Weapon.getId());
        // Set the force and the speed to the initial force and intial speed prevents to sum weapons damages and speed
        player1.setForce(player1.getInitialForce());
        player1.setSpeed(player1.getInitialSpeed());
        player1.setForce(player1.getForce() + player1Weapon.getForce());
        player1.setSpeed(player1.getSpeed() + player1Weapon.getSpeed());
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
        ranking.setEditable(false);
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
            e.printStackTrace();
        }
        panel1.add(title);
        panel2.add(ranking);
        panel_principal.add(panel1);
        panel_principal.add(panel2);
        setIconImage(new ImageIcon("M3-Programacio/Images/fightIcon.jpg").getImage());
        add(panel_principal, BorderLayout.CENTER);
        setTitle("Ranking");
        setSize(350, 400);
        setLocation(60,100);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
