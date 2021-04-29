package entity.parse;

import entity.User;

public class UserParser {

    public static User stringToUser(String readLine) {

        String[] readData = readLine.split(User.userSeparator);
        Long id = Long.parseLong(readData[0]);
        String login = readData[1];
        String password = readData[2];

        return new User(id, login, password);
    }


}
