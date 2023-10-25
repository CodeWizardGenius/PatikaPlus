package week7.patikaClone.Model;

import week7.patikaClone.Helper.DBConnector;
import week7.patikaClone.Helper.Helper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String type;

    public User() {
    }

    public User(int id, String name, String username, String password, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User user;
        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                userList.add(user);
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public static boolean add(String name, String username, String password, String type) {
        String query = "INSERT INTO user (name, username, password, type) VALUES(" +
                "'" + name + "'," +
                "'" + username + "'," +
                "'" + password + "'," +
                "'" + type + "'" +
                ")";
        User findUser = User.getFetch(username, password);
        if (findUser != null) {
            Helper.showMessage("Bu kullanici zaten var", "UYARI", 2);
            System.out.println("User already exists");
            return false;
        }
        try {
            Statement statement = DBConnector.getConnection().createStatement();
            statement.close();
            return statement.executeUpdate(query) > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static User getFetch(String username, String password) {
        User user = null;
        String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
