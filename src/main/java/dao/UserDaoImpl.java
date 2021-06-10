package dao;

import api.UserDao;
import entity.User;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = null;

    private static Connection connection;
    private static final String databaseName = "management";
    private static final String user = "root";
    private static final String password = "admin";

    private static String tableName = "users";


    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
            initCommunication();

        }
        return instance;
    }

    private static void initCommunication() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) {
        PreparedStatement statement = null;

        try {
            String query = "insert into " + tableName + " (login, password) values (?, ?)";
            statement = connection.prepareStatement(query);

 //           statement.setLong(1, user.getUserId());
            statement.setString(1, user.getUserLogin());
            statement.setString(2, user.getUserPassword());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(Long userId) {
        PreparedStatement statement = null;

        try {
            String query = "delete from " + tableName + " where ID = ?";
            statement = connection.prepareStatement(query);

            statement.setLong(1, userId);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserByLogin(String login) {
        PreparedStatement statement = null;

        try {
            String query = "delete from " + tableName + " where ID = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, login);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + ";";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long ID = resultSet.getLong("ID");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                users.add(new User(ID, login, password));
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (users.isEmpty()){
            return Collections.emptyList();}

        return users;
    }

    @Override
    public void updateUser(User user) {
        PreparedStatement statement = null;


        try {
            String query = "update " + tableName + " set login = ?, password = ?;";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getUserLogin());
            statement.setString(2, user.getUserPassword());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


