package Role;

import Auth.User;
import javax.annotation.processing.SupportedSourceVersion;
import java.util.Objects;

/**
 * Created by alex on 07.10.2015.
 */
public class Role {
    int id = 0;
    User user;
    Roles rights;
    String sourse;


    public void setRights(User user, Roles rights, String sourse) {

        id++;
        this.user = user;
        this.rights = rights;
        this.sourse = sourse;
    }

    public User getUser()
    {
        return this.user;
    }

    public int  checkRights(Role role){

        String parse[] = role.sourse.split("\\.");
        String[] atrStr = this.sourse.split("\\.");
        if (parse.length >= atrStr.length) {

            for (int i = 0; i < atrStr.length; i++) {
                if (parse[i].equals(atrStr[i])) {
                    continue;
                } else {
                    System.out.println("No Dostup(4)");
                    System.exit(4);
                }

            }




                if (role.rights == this.rights) {
                    return 1;
                } else {
                    return 2;
                }

        }
        else {
            return 3;
        }
    }
}
