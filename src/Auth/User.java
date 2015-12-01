package Auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alex on 07.10.2015.
 */
public class User {
    int id = 0;
    //String name = "0";
    public String login;
    public String password;
    String salt = "ololo";





    public void setUser(String login, String password) {
        this.login = login;
        this.password = Hash.makeHash(password, salt);
        this.id++;

    }

    public User getUser(User user) {
        user.id = this.id;
        user.password = this.password;
        return user;
    }

    public int checkUser(User user) {
        if (user.login.equals(this.login)) {
            if (user.password.equals(this.password)) {
                return 1;
            }
            else{
                return 2;
            }
        }
        return 3;
    }

}
