package classes;

import java.awt.image.BufferedImage;
public class Warrior {
    private int id;
    private String name;
    private String race;
    private int life;
    private int force;
    private int defense;
    private int agility;
    private int speed;
    private String imgUrl;
    private int points;

    public Warrior(int id, String name, String race, int life, int force, int defense, int agility, int speed, String imgUrl, int points) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.life = life;
        this.force = force;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
        this.imgUrl = imgUrl;
        this.points = points;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getForce() {
        return force;
    }
    public void setForce(int force) {
        this.force = force;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setimageUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}
