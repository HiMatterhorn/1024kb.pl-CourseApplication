package entity;

public class User {

    private Long id;
    private String login;
    private String password;
    public static final String userSeparator = "#";

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getUserId() {
        return this.id;
    }

    public String getUserLogin() {
        return this.login;
    }

    public String getUserPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return id + userSeparator + login + userSeparator + password +"\n";
    }
}
