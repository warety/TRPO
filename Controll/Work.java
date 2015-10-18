package Controll;

import Accaunt.Accaunt;
import Auth.User;
import Role.Role;

import javax.annotation.processing.SupportedSourceVersion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex on 17.10.2015.
 */
public class Work {


    static public void check(String in, User[] user, Role[] role) throws ParseException {
        String[] str1 = in.split(" ");
        User user1 = new User();
        Role role1 = new Role();
        Accaunt acc1 = new Accaunt();
        if(str1.length == 2) {

            user1.setUser(str1[0], str1[1]);
            checkUser(user, user1);
        }
        if(str1.length == 4) {
            user1.setUser(str1[0], str1[1]);
            checkUser(user, user1);
            int rights = Integer.valueOf(str1[2]);
            role1.setRights(user1, rights, str1[3]);
            checkRights(role, user1, role1);
            System.out.println("Succses");
        }
        if(str1.length == 7){
            user1.setUser(str1[0], str1[1]);
            checkUser(user, user1);
            int rights = Integer.valueOf(str1[2]);
            role1.setRights(user1, rights, str1[3]);
            checkRights(role, user1, role1);
            checkDate(str1[4]);
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            Date date1 = format.parse(str1[4]);
            checkDate(str1[5]);
            //SimpleDateFormat format2 = new SimpleDateFormat("yyyy.MM.dd");
            Date date2 = format.parse(str1[5]);
            int vol = Integer.valueOf(str1[6]);
            acc1.setAcc(user1,role1,date1,date2,vol);
           // acc1.showAcc();
        }
        else
        {
            System.out.println();
        }

    }

    static public void checkUser(User[] user, User user1){

        int l = 0;
        int f = 0;
        for(int i = 0; i < user.length; i++) {
            if (user1.checkUser(user[i]) == 1) {
                System.out.println("Succes");
                f = 1;
            }
            if(user1.checkUser(user[i]) == 2){
                l = 2;
            }
        }
        if(f != 1) {
            if (l == 2) {
                System.out.println("Wrong password");
                System.exit(0);
            }
            if (l == 0) {
                System.out.println("Wrong login");
                System.exit(0);
            }
        }
        }

    static public void checkRights(Role[] role, User user, Role role1){
        int l = 0;
        for(int i = 0; i < role.length; i++)
        {
            if(user.checkUser(role[i].getUser()) == 1) {
                if (role[i].checkRights(role1) == 1) {
                    System.out.println("Succes");
                    l = 1;
                }
            }
        }
        if(l == 0)
        {
            System.out.println("No dostyp");
            System.exit(0);
        }
    }

    static public void checkDate(String str1)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date date = format.parse(str1);
        } catch (ParseException ex) {
            System.out.println("invalid date");
            System.exit(0);
        }


    }

    static public void checkVolume(int vol){
        if(vol <= 0)
        {
            System.out.println("invalid vol");
        }
    }
}
