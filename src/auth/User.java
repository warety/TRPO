package auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class User {
    int id;
    String name;
    String login;
    String password;
    String  salt = "ololo";


    public User() {
        this.id = 0;
        this.name = "";
        this.login = "";
        this.password = "";
        this.salt = "ololo";
    }


    public User(String login, String password) {
        this.login = login;
        this.password = Hash.makeHash(password, salt);
    }

    public User(int id, String name, String login, String password, String salt) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = Hash.makeHash(password, salt);
        this.salt = salt;
    }


    public void setUser(String login, String password) {
        this.login = login;
        this.password = Hash.makeHash(password, salt);

    }

    public User getUser(User user) {
        return user;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword(){
        return password;
    }

    public int getId(){return  id;}



    public int checkUser(User user) {
        if (user.login.equals(this.login)) {
            if (user.password.equals(this.password)) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

}
