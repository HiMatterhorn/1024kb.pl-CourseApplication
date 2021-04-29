package dao;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import entity.parse.UserParser;
import utils.FileUtils;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = null;
    private static String fileName = "users.data";

    public static UserDaoImpl getInstance(){
        if (instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    private UserDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            System.out.println("Error with file path");
            System.exit(-1);
        }
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> allUsers = getAllUsers();
        allUsers.add(user);
        saveUsersList(allUsers);
    }

    @Override
    public void saveUsersList(List<User> users) throws IOException {
        new FileWriter(fileName, false).close();
        FileWriter fileWriter = new FileWriter(fileName, true);

        for (User user : users) {
            fileWriter.write(user.toString());
        }

        fileWriter.close();
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> allUsers = new ArrayList<User>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String readLine = reader.readLine();
        while (readLine != null) {
            System.out.println("Nowa linia : " + reader.readLine());
            User readUser = UserParser.stringToUser(reader.readLine());
            if (readUser != null) {
                allUsers.add(readUser);
            }
        }
        reader.close();

        return allUsers;
    }


    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> listOfAllUsers = getAllUsers();

        for (User user : listOfAllUsers) {
            if (user.getUserLogin().equals(login)) {
                listOfAllUsers.remove(user);
            }
        }
    }

    @Override
    public void removeUserById(Long Id) throws IOException {
        List<User> listOfAllUsers = getAllUsers();

        for (User user : listOfAllUsers) {
            if (user.getUserId().equals(Id)) {
                listOfAllUsers.remove(user);
            }
        }
    }

}
