package validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;

import java.io.IOException;
import java.util.List;

public class UserValidator {
    int password_MIN_LENGTH = 6;
    int login_MIN_LENGTH = 4;

    private UserDao userDaoInstance = UserDaoImpl.getInstance();

    private UserValidator() {
    }
    private static UserValidator userValidator = null;

    public static UserValidator getInstance() {
        if (userValidator == null) {
            userValidator = new UserValidator();
        }
        return userValidator;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException {

        if (!userValidator.isPasswordLengthCorrect(user.getUserPassword())) {
            throw new UserShortLengthPasswordException("User password is too short : " + user.getUserId() + ". " + user.getUserLogin());
        }

        if (!userValidator.isLoginLengthCorrect(user.getUserLogin())) {
            throw new UserShortLengthLoginException("User login is too short : " + user.getUserId() + ". " + user.getUserLogin());
        }

        return true;
    }


    private boolean isPasswordLengthCorrect(String password) {
        return (password.length() >= password_MIN_LENGTH);
    }

    private boolean isLoginLengthCorrect(String login) {
        return (login.length() >= login_MIN_LENGTH);
    }




}


