package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    void saveUser (User user);
//    void saveUsersList (List<User> users) throws IOException;

    void removeUserById (Long userId);
    void removeUserByLogin (String login);

    List<User> getAllUsers () throws IOException;

    void updateUser(User user);
}
