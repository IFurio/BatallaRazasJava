package classes;

import java.util.ArrayList;

public class WeaponContainer {
    private final ArrayList<Weapon> weapons;

    public WeaponContainer(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

}
