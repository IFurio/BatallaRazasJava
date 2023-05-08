import java.awt.image.BufferedImage;
public class Warrior {
    private int id;
    private String name;
    private int life;
    private int force;
    private int defense;
    private int agility;
    private int speed;
    private BufferedImage image;
    private int points;

    public Warrior(int id, String name, int life, int force, int defense, int agility, int speed, BufferedImage image, int points) {
        this.id = id;
        this.name = name;
        this.life = life;
        this.force = force;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
        this.image = image;
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
    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}
