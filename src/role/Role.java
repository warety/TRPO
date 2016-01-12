package role;

import auth.User;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Objects;

/**
 * Created by alex on 07.10.2015.
 */
public class Role {
    String login;
    Roles rights;
    String sourse;

    public Role(){

    }

    public Role(User user, Roles rights, String sourse) {
        this.login = user.getLogin();
        this.rights = rights;
        this.sourse = sourse;
    }



    public void setRights(User user, Roles rights, String sourse) {
        this.login = user.getLogin();
        this.rights = rights;
        this.sourse = sourse;
    }

    public String getSourse(){return sourse;}

    public Roles getRights() {return  rights;}

    public String getLogin() {
        return this.login;
    }

    public int checkRights(Role role) {

        String parse[] = role.sourse.split("\\.");
        String[] atrStr = this.sourse.split("\\.");
        if (parse.length >= atrStr.length) {

            for (int i = 0; i < atrStr.length; i++) {
                if (parse[i].equals(atrStr[i])) {
                    continue;
                } else {
                    System.exit(4);
                }

            }


            if (role.rights == this.rights) {
                return 1;
            } else {
                return 2;
            }

        } else {
            return 3;
        }
    }
}
