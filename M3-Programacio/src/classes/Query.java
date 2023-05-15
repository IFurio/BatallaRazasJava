package classes;

import java.sql.*;
import java.util.ArrayList;

public class Query {
    // MAKE SURE THESE ARE YOUR CURRENT CREDENTIALS!!!!!!!
    private final String url = "jdbc:mysql://localhost/batalla_races?serverTimezone=UTC";
    private final String user = "isaac";
    private final String pass = "1234";
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private WarriorContainer mainWarriorContainer;
    private WeaponContainer mainWeaponContainer;

    public void warrior_getdata() { // this is used to get all the warriors from the database
        int id,life,force,defense,agility,speed,points;
        String name,race,image, sprite;
        ArrayList<Warrior> warrior_list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            rs = stm.executeQuery("select * from warriors");

            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                image = rs.getString(3);
                race = rs.getString(4);
                life = rs.getInt(5);
                force = rs.getInt(6);
                speed = rs.getInt(7);
                defense = rs.getInt(8);
                agility = rs.getInt(9);
                points = rs.getInt(10);
                sprite = rs.getString(11);
                Warrior warrior = new Warrior(id,name,race,life,force,defense,agility,speed,image,sprite,points);
                warrior_list.add(warrior);
            }
            mainWarriorContainer = new WarriorContainer(warrior_list);
            closeConnections();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not loaded correctly");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection not created correctly");
            e.printStackTrace();
        }

    }
    public void weapon_getdata() { // this is used to get all the weapons from the database
        int id, force, speed, points;
        String name, image;
        ArrayList<Weapon> weapon_list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            rs = stm.executeQuery("select * from weapons");

            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                image = rs.getString(3);
                force = rs.getInt(4);
                speed = rs.getInt(5);
                points = rs.getInt(6);
                Weapon weapon = new Weapon(id, name, speed, force, points, image);
                weapon_list.add(weapon);
            }
            mainWeaponContainer = new WeaponContainer(weapon_list);
            closeConnections();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not loaded correctly");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection not created correctly");
            e.printStackTrace();
        }
    }
    public ResultSet makeSelect(String query) { // this is used to do selects on the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            return stm.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Connection not created correctly");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not loaded correctly");
            return null;
        }
    }
    public void closeConnections() { // this is used to close all the unnecessary resources
        try {
            if (rs != null) { rs.close();}
            if (stm != null) { stm.close();}
            if (con != null) { con.close();}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public WarriorContainer getMainWarriorContainer() {
        return mainWarriorContainer;
    }
    public WeaponContainer getMainWeaponContainer() {
        return mainWeaponContainer;
    }
}

