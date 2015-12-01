import Accaunt.Accaunt;
import Auth.User;
import Controll.Work;
import Role.Role;
import Role.Roles;
import org.apache.commons.cli.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by alex on 07.10.2015.
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        String login = "";
        String pass = "";
        String res = "";
        String rol = "READ";
        String ds = "";
        String de = "";
        String vol = "";
        int arg = 0;

        User user1 = new User();
        Role role1 = new Role();
        Accaunt acc1 = new Accaunt();





        User user[] = new User[2];
        for (int i = 0; i < 2; i++)
            user[i] = new User();
        user[0].setUser("jdoe", "sup3rpaZZ");
        user[1].setUser("jrow", "Qweqrty12");





        Role role[] = new Role[5];
        for (int i = 0; i < role.length; i++ )
            role[i] = new Role();

        role[0].setRights(user[0], Roles.READ, "a");
        role[1].setRights(user[0], Roles.WRITE, "a.b");
        role[2].setRights(user[1], Roles.EXEC, "a.b.c");
        role[3].setRights(user[0], Roles.EXEC, "a.bc");
        role[4].setRights(user[0], Roles.READ, "src");
        String auto = "";

        Options options = new Options()
                .addOption("h",false,"print this help message")
                .addOption("login",true,"login")
                .addOption("pass",true,"password")
                .addOption("res",true,"resource")
                .addOption("role",true,"permission")
                .addOption("ds",true,"date start")
                .addOption("de",true,"date end")
                .addOption("vol",true,"value");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h"))
            {
                Work.printHelp();
            }
            if (cmd.hasOption("login")) {
               login = cmd.getOptionValue("login");
                arg++;

            }
            if (cmd.hasOption("pass")) {
                pass = cmd.getOptionValue("pass");
                arg++;
            }
            if (cmd.hasOption("res")) {
                res = cmd.getOptionValue("res");
                arg++;

            }
            if (cmd.hasOption("role")) {
                if(cmd.getOptionValue("role").equals("EXEC") || cmd.getOptionValue("role").equals("WRITE") || cmd.getOptionValue("role").equals("READ")) {
                    rol = cmd.getOptionValue("role");
                    arg++;
                }
                else{
                    System.out.print("Wrong role(3)");
                    System.exit(3);
                }

            }
            if (cmd.hasOption("ds")) {
                ds = cmd.getOptionValue("ds");
                Work.checkDate(ds);
                arg++;

            }
            if (cmd.hasOption("de")) {
                de = cmd.getOptionValue("de");
                Work.checkDate(de);
                arg++;

            }
            if (cmd.hasOption("vol")) {
                vol = cmd.getOptionValue("vol");
                arg++;
            }
        }
        catch (org.apache.commons.cli.ParseException e) {
            Work.printHelp();
            //System.exit(255);
        }

        user1.setUser(login, pass);
        role1.setRights(user1, Roles.valueOf(rol), res);
        if (arg == 2){
            Work.checkUser(user, user1);
            //System.out.println("Success");
            System.exit(0);
        }
        else if (arg == 4){
            Work.checkUser(user, user1);
            Work.checkRights(role, user1, role1);
            //System.out.println("Success");
            System.exit(0);
        }
        else if (arg == 7)
        {
            Work.checkUser(user, user1);
            Work.checkRights(role, user1, role1);
            Work.checkVolume(vol);
            acc1.setAcc(user1, role1, Date.valueOf(ds), Date.valueOf(de), Integer.valueOf(vol));
            //System.out.println("Success");
            System.exit(0);
        }
        else
        {
            Work.printHelp();
        }

    }




}
