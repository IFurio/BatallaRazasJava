package classes;

import java.sql.*;
import java.util.ArrayList;

public class Query {
    public void dataBaseLogin() { // it is used to connect to a database
        String url = "jdbc:mysql://localhost/batalla_races?serverTimezone=UTC";
        String user = "isaac"; // make sure these are your current credentials
        String pass = "1234";
        Query query = new Query();

        query.warrior_getdata(url,user,pass);
        query.weapon_getdata(url,user,pass);

    }
    public void warrior_getdata(String url, String user, String pass) {
        int id,life,force,defense,agility,speed,points;
        String name,race,image;
        ArrayList<Warrior> warrior_list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from warriors");

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
                Warrior warrior = new Warrior(id,name,race,life,force,defense,agility,speed,image,points);
                warrior_list.add(warrior);
                WarriorContainer main_warrior_list = new WarriorContainer(warrior_list);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("El driver no se ha caragdo correctamente");
        } catch (SQLException e) {
            System.out.println("Conexion no creada correctamente");
        }

    }

    public void weapon_getdata(String url, String user, String pass) {
        int id, force, speed, points;
        String name, image;
        ArrayList<Weapon> weapon_list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from weapons");

            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                image = rs.getString(3);
                force = rs.getInt(4);
                speed = rs.getInt(5);
                points = rs.getInt(6);
                Weapon weapon = new Weapon(id,name,speed,force,points,image);
                weapon_list.add(weapon);
                WeaponContainer main_warrior_list = new WeaponContainer(weapon_list);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("El driver no se ha caragdo correctamente");
        } catch (SQLException e) {
            System.out.println("Conexion no creada correctamente");
        }
    }
    public ResultSet makeSelect(String url, String user, String pass, String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            return stm.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

