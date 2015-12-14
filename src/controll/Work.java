package controll;

import accaunt.Accaunt;
import auth.User;
import role.Role;
import role.Roles;

import javax.annotation.processing.SupportedSourceVersion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Work {


    static public void checkUser(User[] user, User user1) {
        boolean f = false;

        for (int i = 0; i < user.length; i++) {
            if (user1.checkUser(user[i]) == 1) {
                f = true;
                break;
            }
            else if(user1.checkUser(user[i]) == 2)
                System.exit(2);
            }
            if (f == false){
                System.exit(1);
        }


    }

    static public void checkRights(Role[] role, User user, Role role1) {
        boolean l = false;
        for (int i = 0; i < role.length; i++) {
            if (user.checkUser(role[i].getUser()) == 1) {
                if (role[i].checkRights(role1) == 1) {
                    l = true;
                    break;
                }
            }
        }
        if (l == false) {

            System.exit(4);
        }
    }

    static public void checkDate(String str1) {
        try {
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            formatter.setLenient(false);
            calendar.setTime(formatter.parse(str1));


        } catch (Exception e) {

            System.exit(5);
        }


    }

    static public void checkVolume(String vol) {
        try {
            Integer.parseInt(vol);
            if (Integer.valueOf(vol) < 0) {

                System.exit(5);
            }
        } catch (NumberFormatException e) {

            System.exit(5);
        }

    }



}
