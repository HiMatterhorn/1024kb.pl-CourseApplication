package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;


public class UserRegisterLoginImpl implements UserRegisterLoginFacade {
    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginImpl instanceUserRegisterLoginImpl = null;

    public static UserRegisterLoginImpl getInstance() {
        if (instanceUserRegisterLoginImpl == null) {
            instanceUserRegisterLoginImpl = new UserRegisterLoginImpl();
        }
        return instanceUserRegisterLoginImpl;
    }

    private UserRegisterLoginImpl() {

    }

    @Override
    public String registerUser(User user) {
        try {
            userService.addUser(user);
            return "Registered successfully";
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public boolean loginUser(String login, String password) {

        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;

        }

        return false;
    }
}
