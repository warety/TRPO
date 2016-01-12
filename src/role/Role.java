package role;

import auth.User;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Objects;

/**
 * Created by alex on 07.10.2015.
 */
public class Role {
    int id;
    int user_id;
    Roles rights;
    String sourse;

    public Role(){

    }

    public Role(int id, int user_id, Roles rights, String sourse) {
        this.id = id;
        this.user_id = user_id;
        this.rights = rights;
        this.sourse = sourse;
    }

    public Role(Roles rights, String sourse) {
        this.rights = rights;
        this.sourse = sourse;
    }



    public void setRights(User user, Roles rights, String sourse) {
        this.user_id = user.getId();
        this.rights = rights;
        this.sourse = sourse;
    }

    public int getId(){return id;}

    public String getSourse(){return sourse;}

    public Roles getRights() {return  rights;}

    public int getUser_id() {
        return this.user_id;
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
