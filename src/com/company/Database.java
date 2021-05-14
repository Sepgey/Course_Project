package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String connectionString = "jdbc:mysql://localhost:3306/course_project?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String login = "root";
    private static final String password = "root";
    private static Connection connection;

    private static boolean initiated = false;


    public static void connect() {
        try {
            connection = DriverManager.getConnection(connectionString, login, password);
            initiated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isInitiated() {
        return initiated;
    }

    public static Client selectClientByLoginAndPassword(String login, String password) {
        if (!isInitiated()) {
            throw new IllegalStateException("Not Connected");
        }
        try {
            Client client = null;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM clients WHERE login='%s' AND password='%s'", login, password));
            if (results.next()) {
                int db_id = results.getInt("id");
                String db_name = results.getString("name");
                String db_login = results.getString("login");
                String db_password = results.getString("password");
                client = new Client(db_id, db_name, db_login, db_password);
            }
            statement.close();
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertClient(Client c) {
        if (!isInitiated()) {
            throw new IllegalStateException("Not Connected");
        }
        try {

            Statement statement = connection.createStatement();
            statement.execute(String.format(
                    "INSERT INTO course_project.clients (name, login, password) VALUE ('%s', '%s', '%s')",
                    c.getName(), c.getLogin(), c.getPassword())
            );

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        if (initiated) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void deleteClient(Client client) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(
                    String.format("DELETE FROM course_project.clients WHERE id='%d'", client.getId()));
            statement.close();

        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public static void updateClient(Client client) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(
                    String.format("UPDATE course_project.clients SET name='%s', login='%s', password='%s' WHERE id='%d'", client.getName(), client.getLogin(), client.getPassword(), client.getId()));
            statement.close();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public static List<Character> selectCharactersByClass(String _class) {
        List<Character> characters = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM course_project.characters AS c JOIN features AS f ON c.id=f.id_characters WHERE class='%s'", _class));

            while (resultSet.next()) {
                int db_id = resultSet.getInt("id");
                String db_name = resultSet.getString("name");
                String db_class = resultSet.getString("class");
                int db_feature = resultSet.getInt("feature");
                Character character = null;
                if ("Agility".equals(db_class)) {
                    character = new Agility(db_id, db_name, db_class, db_feature);
                } else if ("Magic".equals(db_class)) {
                    character = new Magic(db_id, db_name, db_class, db_feature);
                } else if ("Strength".equals(db_class)) {
                    character = new Strength(db_id, db_name, db_class, db_feature);
                }
                characters.add(character);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public static List<Character> selectAllCharacters() {
        List<Character> characters = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM course_project.characters AS c JOIN features AS f ON c.id=f.id_characters  "));

            while (resultSet.next()) {
                int db_id = resultSet.getInt("id");
                String db_name = resultSet.getString("name");
                String db_class = resultSet.getString("class");
                int db_feature = resultSet.getInt("feature");
                Character character = null;
                if ("Agility".equals(db_class)) {
                    character = new Agility(db_id, db_name, db_class, db_feature);
                } else if ("Magic".equals(db_class)) {
                    character = new Magic(db_id, db_name, db_class, db_feature);
                } else if ("Strength".equals(db_class)) {
                    character = new Strength(db_id, db_name, db_class, db_feature);
                }
                characters.add(character);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public void test() {

    }

}
