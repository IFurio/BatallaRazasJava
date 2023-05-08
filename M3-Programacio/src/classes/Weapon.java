package classes;

import java.awt.image.BufferedImage;
public class Weapon {
    private int id;
    private String name;
    private int speed;
    private int force;
    private int points;
    private BufferedImage image;


    public Weapon(int id, String name, int speed, int force, int points, BufferedImage image) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.force = force;
        this.points = points;
        this.image = image;
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
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getForce() {
        return force;
    }
    public void setForce(int force) {
        this.force = force;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
