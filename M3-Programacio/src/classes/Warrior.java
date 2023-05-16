package classes;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Warrior {
    private int id;
    private String name;
    private String race;
    private int life;
    private int initialLife;
    private int force;
    private int initialForce;
    private int defense;
    private int agility;
    private int speed;
    private int initialSpeed;
    private String imgUrl;
    private String spriteUrl;
    private int points;
    private int dealer = 0, dmgAttack = 0, dmgReceived = 0, weaponID = 0;

    public Warrior(int id, String name, String race, int life, int force, int defense, int agility, int speed, String imgUrl, String spriteUrl, int points) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.life = life;
        this.initialLife = life;
        this.force = force;
        this.initialForce = force;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
        this.initialSpeed = speed;
        this.imgUrl = imgUrl;
        this.spriteUrl = spriteUrl;
        this.points = points;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRace() { return race; }
    public void setRace(String race) { this.race = race; }
    public int getLife() { return life; }
    public void setLife(int life) { this.life = life; }
    public int getForce() { return force; }
    public void setForce(int force) { this.force = force; }
    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }
    public int getAgility() { return agility; }
    public void setAgility(int agility) { this.agility = agility; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }
    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
    public String getSpriteUrl() { return spriteUrl; }
    public void setSpriteUrl(String spriteUrl) { this.spriteUrl = spriteUrl; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public int getInitialLife() { return initialLife; }

    public void setInitialLife(int initialLife) { this.initialLife = initialLife; }

    public int getInitialForce() { return initialForce; }

    public void setInitialForce(int initialForce) { this.initialForce = initialForce; }

    public int getInitialSpeed() { return initialSpeed; }

    public void setInitialSpeed(int initialSpeed) { this.initialSpeed = initialSpeed; }

    public int getDealer(){return dealer;}
    public void setDealer(int d){this.dealer = d;}
    public void setDmgAttack(int dmg){this.dmgAttack = dmg;}
    public int getDmgAttack(){return dmgAttack;}
    public int getDmgReceived(){return dmgReceived;}
    public void setDmgReceived(int dmg) {this.dmgReceived = dmg;}
    public int getWeaponID(){return weaponID;}
    public void setWeaponID(int w) {this.weaponID = w;}

    public int doAtack() {
        Random r = new Random();
        int dmg = 0;
        int randomInt = r.nextInt(100)+1;
        if (this.getAgility()*10 > randomInt) {
            dmg = this.getForce();
        }
        return dmg;
    }

    public void doDefense(int dmg){
        dmg -= this.getDefense();
        Random r = new Random();
        int randomInt = r.nextInt(50)+1;
        if (this.getAgility() <= randomInt) {
            this.setLife(this.getLife()-dmg);
            this.setDmgReceived(dmg);
        }
    }
}
