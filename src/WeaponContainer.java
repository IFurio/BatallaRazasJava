import java.util.ArrayList;

public class WeaponContainer {
    private ArrayList<Weapon> weapons;

    public WeaponContainer(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
}
