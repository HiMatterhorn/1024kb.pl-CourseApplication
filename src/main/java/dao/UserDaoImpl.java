package dao;

import api.UserDao;
import entity.User;

import java.sql.*;
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

    private static void initCommunication (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void removeUserById(Long userId) {

    }

    @Override
    public void removeUserByLogin(String login) {

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;

        try {
            String query = "select * from " + tableName + ";";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()){
                Long ID = resultSet.getLong("ID");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                users.add(new User(ID,login,password));
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void updateUser(User user) {

    }
}


