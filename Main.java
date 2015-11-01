import Auth.User;
import Controll.Work;
import Role.Role;
import Role.Roles;
import org.apache.commons.cli.*;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by alex on 07.10.2015.
 */
public class Main {

    public static void main(String[] args) throws ParseException {

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






        Role role[] = new Role[5];
        for (int i = 0; i < role.length; i++ )
            role[i] = new Role();

        role[0].setRights(user[0], Roles.READ, "AB.C");
        role[1].setRights(user[1], Roles.EXEC, "AB.C");
        role[2].setRights(user[0], Roles.READ, "iais");
        role[3].setRights(user[0], Roles.READ, "bbc");
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

            if (cmd.hasOption("login")) {
                auto += cmd.getOptionValue("login");
            }
            if (cmd.hasOption("pass")) {
                auto += cmd.getOptionValue("pass");
            }
            if (cmd.hasOption("res")) {
                auto += cmd.getOptionValue("res");
            }
            if (cmd.hasOption("role")) {
                auto += cmd.getOptionValue("role");
            }
            if (cmd.hasOption("ds")) {
                auto += cmd.getOptionValue("ds");
            }
            if (cmd.hasOption("de")) {
                auto += cmd.getOptionValue("de");
            }
            if (cmd.hasOption("vol")) {
                auto += cmd.getOptionValue("vol");
            }
        }
        catch (org.apache.commons.cli.ParseException e) {
            printHelp(options);
            System.exit(255);
        }

        /*if ( commandLine.hasOption("h") ) {
            //arguments.add(commandLine.getOptionValue("h"));

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
        }*/


        //String auto = "warety 1234 READ AB.C.D";


       // Work.check(auto, user, role);

        //Work.check(user, login, password, role, 7, "wiki");

       // Work.checkRights(role, user[0], 7, "github");


    }

    static void printHelp(Options options) {

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
