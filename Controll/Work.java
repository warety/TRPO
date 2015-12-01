package Controll;

import Accaunt.Accaunt;
import Auth.User;
import Role.Role;
import Role.Roles;

import javax.annotation.processing.SupportedSourceVersion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by alex on 17.10.2015.
 */
public class Work {


    static public void check(String in, User[] user, Role[] role) throws ParseException {


    }

    static public void checkUser(User[] user, User user1){

        int l = 0;
        int f = 0;
        for(int i = 0; i < user.length; i++) {
            if (user1.checkUser(user[i]) == 1) {
                f = 1;
            }
            if(user1.checkUser(user[i]) == 2){
                l = 2;
            }
        }
        if(f != 1) {
            if (l == 2) {
                //System.out.println("Wrong password(2)");
                System.exit(2);
            }
            if (l == 0) {
               // System.out.println("Wrong login(1)");
                System.exit(1);
            }
        }
        }

    static public void checkRights(Role[] role, User user, Role role1){
        int l = 0;
        for(int i = 0; i < role.length; i++)
        {
            if(user.checkUser(role[i].getUser()) == 1) {
                if (role[i].checkRights(role1) == 1) {
                    l = 1;
                    break;
                }
            }
        }
        if(l == 0)
        {
            //System.out.println("No dostyp(4)");
            System.exit(4);
        }
    }

    static public void checkDate(String str1)
    {
        try {
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            formatter.setLenient(false);
            calendar.setTime(formatter.parse(str1));



        }
        catch (Exception e) {
            //System.out.print("Invalid date(5)");
            System.exit(5);
        }



    }

    static public void checkVolume(String vol){
        try {
            Integer.parseInt(vol);
            if(Integer.valueOf(vol) < 0)
            {
                //System.out.println("invalid vol(5)");
                System.exit(5);
            }
        }
        catch (NumberFormatException e) {
            //System.out.println("invalid vol(5)");
            System.exit(5);
        }

    }



    static public void printHelp( ) {
        System.out.print("lol");

        System.out.println("[-h] - Show help\n" +
                "[-login login] - Enter login\n" +
                "[-pass password] - Enter password\n" +
                "Login may be entered just with the password" +
                "[-res resource] - Enter resource\n" +
                "[-role role] - Enter role\n" +
                "Resource may be entered just with the role" +
                "[-ds date] - Enter date1\n" +
                "[-df date] - Enter date2\n" +
                "[-vol volume] - Enter volume\n" +
                "Dates and volume may be entered just together");
        System.exit(0);
    }
}
