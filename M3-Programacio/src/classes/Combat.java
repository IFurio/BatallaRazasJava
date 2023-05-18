package classes;

import javax.swing.*;
import java.util.Random;

public class Combat {
    private Warrior player1, player2;
    private JTextArea console;
    private JLabel lifeBar1, lifeBar2;

    Combat(Warrior player1, Warrior player2, JTextArea console, JLabel lifeBar1, JLabel lifeBar2) {
        this.player1 = player1;
        this.player2 = player2;
        this.console = console;
        this.lifeBar1 = lifeBar1;
        this.lifeBar2 = lifeBar2;
    }

    public String start() {
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
            console.setText(console.getText() + "\n" + player1.getName() + "s turn");
            player1.setDmgAttack(player1.doAtack());
            if (player1.getDmgAttack() == 0) {              //Attack failed
                console.setText(console.getText() + "\nAttack failed.");
            } else {                                        //Attack not failed
                player2.doDefense(player1.getDmgAttack());
                if (player2.getDmgReceived() == 0) {        //If it dodge the attack (if DmgReceived isnt 0 it didnt dodge it)
                    console.setText(console.getText() + "\n" + player2.getName() + " dodged the attack.");
                } else {
                    console.setText(console.getText() + "\n" + player2.getName() + " has received " + player2.getDmgReceived() + " of damage.");
                    // Sum the player 1 injures caused
                    player1.setInjuresCaused(player1.getInjuresCaused() + player1.getDmgAttack());

                    // Recalculate lifebar of player2
                    int lifePercentage = 100 * player2.getLife() / player2.getInitialLife();
                    int calLifeBarWidth = 250 * lifePercentage / 100;
                    lifeBar2.setBounds(340, 30, calLifeBarWidth, 10);
                    lifeBar2.setText(lifePercentage + "%");
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
            console.setText(console.getText() + "\n" + player2.getName() + "s turn");
            player2.setDmgAttack(player2.doAtack());
            if (player2.getDmgAttack() == 0) {               //Attack failed
                console.setText(console.getText() + "\nAttack failed.");
            } else {                                        //Attack not failed
                player1.doDefense(player2.getDmgAttack());
                if (player1.getDmgReceived() == 0) {        //If it dodge the attack (if DmgReceived isnt 0 it didnt dodge it)
                    console.setText(console.getText() + "\n" + player1.getName() + " dodged the attack.");
                } else {
                    console.setText(console.getText() + "\n" + player1.getName() + " has received " + player1.getDmgReceived() + " of damage.");
                    // Sum player injures sufered
                    player1.setInjuresSufered(player1.getInjuresSufered() + player2.getDmgAttack());

                    // Recalculate lifebar of player1
                    int lifePercentage = 100 * player1.getLife() / player1.getInitialLife();
                    int calLifeBarWidth = 250 * lifePercentage / 100;
                    lifeBar1.setBounds(0, 30, calLifeBarWidth, 10);
                    lifeBar1.setText(lifePercentage + "%");
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
            console.setText(console.getText() + "\nThe player lose, " + player2.getName() + " wins.");
            return "no";
        }
        else if (player2.getLife() <= 0) {
            console.setText(console.getText() + "\nBot lose, player with " + player1.getName() + " wins");
            return "yes";
        }
        return "";
    }
}
