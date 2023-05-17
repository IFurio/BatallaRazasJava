package classes;

import java.util.ArrayList;
public class WarriorContainer {
    private final ArrayList<Warrior> warriors;

    public WarriorContainer(ArrayList<Warrior> warriors) {
        this.warriors = warriors;
    }
    public ArrayList<Warrior> getWarriors() {
        return warriors;
    }
}
