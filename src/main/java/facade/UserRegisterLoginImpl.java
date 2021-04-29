package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;


public class UserRegisterLoginImpl implements UserRegisterLoginFacade {
    private UserService userService = UserServiceImpl.getInstance();

    private static UserRegisterLoginImpl instanceUserRegisterLoginImpl = null;

    public static UserRegisterLoginImpl getInstance(){
        if(instanceUserRegisterLoginImpl == null){
            instanceUserRegisterLoginImpl = new UserRegisterLoginImpl();
        }
        return instanceUserRegisterLoginImpl;
    }


    @Override
    public boolean registerUser(User user) {
return  userService.addUser(user);
    }

    @Override
    public boolean loginUser(String login, String password) {
        if(userService.isCorrectLoginAndPassword(login, password)){
            return true;
        }
        return false;
    }
}
