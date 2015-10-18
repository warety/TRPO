import Auth.User;
import Controll.Work;
import Role.Role;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by alex on 07.10.2015.
 */
public class Main {

    public static void main(String... args) throws ParseException {

        int j = -1;
        String login, password;
        login = "warety";
        password = "1234";
        Scanner in = new Scanner(System.in);
        User user[] = new User[2];
        for (int i = 0; i < 2; i++)
            user[i] = new User();
        user[0].setUser("warety", "1234");
        user[1].setUser("darkrain", "548");

        String auto = "warety 1234 7 wiki 1994.12.10 2007.11.23 8";




        Role role[] = new Role[5];
        for (int i = 0; i < role.length; i++ )
            role[i] = new Role();

        role[0].setRights(user[0], 7, "wiki");
        role[1].setRights(user[0], 1, "github");
        role[2].setRights(user[0], 3, "iais");
        role[3].setRights(user[0], 1, "bbc");
        role[4].setRights(user[0], 7, "src");

        Work.check(auto, user, role);

        //Work.check(user, login, password, role, 7, "wiki");

       // Work.checkRights(role, user[0], 7, "github");


    }


}
