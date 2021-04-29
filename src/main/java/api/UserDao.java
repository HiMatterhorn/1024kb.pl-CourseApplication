package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    void saveUser (User user) throws IOException;
    void saveUsersList (List<User> users) throws IOException;

    void removeUserByLogin (String login) throws IOException;
    void removeUserById (Long Id) throws IOException;

    List<User> getAllUsers () throws IOException;
}
