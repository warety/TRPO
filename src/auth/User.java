package auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class User {
    String login;
    String password;
    static String  salt = "ololo";


    public User() {

        this.login = "";
        this.password = "";
    }


    public User(String login, String password) {
        this.login = login;
        this.password = Hash.makeHash(password, salt);
    }


    public void setUser(String login, String password) {
        this.login = login;
        this.password = Hash.makeHash(password, salt);

    }

    public User getUser(User user) {
        return user;
    }

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
