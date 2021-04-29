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
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long userId) throws IOException {
        List<User> listOfAllUsers = getAllUsers();

        for (User user : listOfAllUsers) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
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
        return false;
    }

    @Override
    public boolean addUser(User user) {
        System.out.println("Przekazany user");
        System.out.println(user.getUserId());
        System.out.println(user.getUserLogin());
        System.out.println(user.getUserPassword());


        try {
            if (isLoginExist(user.getUserLogin())) {
                throw new UserLoginAlreadyExistException();
            }
        } catch (UserLoginAlreadyExistException e) {
            System.out.println(e);
        }


        try {
            if (userValidator.isValidate(user)) {
                System.out.println("User valid");
                userDao.saveUser(user);
                return true;
            }
        } catch (UserShortLengthPasswordException e) {
            System.out.println(e);
        } catch (UserShortLengthLoginException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return false;
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    private boolean isLoginExist(String login) throws UserLoginAlreadyExistException {
        User user = null;
       try {
            user = userServiceInstance.getUserByLogin(login);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (user == null) {
            return false;
        }

        return true;
    }
}
