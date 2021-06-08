package dao;

import api.UserDao;
import entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = null;

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
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

        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}


