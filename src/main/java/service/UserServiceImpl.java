package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    //Singleton
    private static UserServiceImpl userServiceInstance = null;

    public static UserServiceImpl getInstance() {
        if (userServiceInstance == null) {
            userServiceInstance = new UserServiceImpl();
        }
        return userServiceInstance;
    }

    private UserServiceImpl() {

    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long userId) {
        List<User> listOfAllUsers = getAllUsers();

        for (User user : listOfAllUsers) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> listOfAllUser = getAllUsers();

            for (User user : listOfAllUser) {
                if (user.getUserLogin().equals(login)) {
                    return user;
                }
        }

        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) {

        User foundUser = getUserByLogin(login);

        if (foundUser == null) {
            return false;
        }

        boolean isCorrectLogin = foundUser.getUserLogin().equals(login);
        boolean isCorrectPass = foundUser.getUserPassword().equals(password);

        return isCorrectLogin && isCorrectPass;
    }

    @Override
    public boolean addUser(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {

            if (isLoginExist(user.getUserLogin())) {
                throw new UserLoginAlreadyExistException();
        }

            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }

        return false;
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    private boolean isLoginExist(String login) {
        User user = userServiceInstance.getUserByLogin(login);


            return (user != null);
    }
}
