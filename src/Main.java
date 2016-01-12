import accaunt.Accaunt;
import auth.User;
import controll.Work;
import role.Role;
import role.Roles;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import org.apache.logging.log4j.*;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParseException, FileNotFoundException, SQLException {
        logger.trace("Application started");

        String login = "";
        String pass = "";
        String res = "";
        String rol = "READ";
        String ds = "";
        String de = "";
        String vol = "";
        int arg = 0;



        Accaunt acc1 = new Accaunt();


        User user[] = new User[2];
        for (int i = 0; i < 2; i++)
            user[i] = new User();
        user[0].setUser("jdoe", "sup3rpaZZ");
        user[1].setUser("jrow", "Qweqrty12");
        String str = user[0].getPassword();
        str = user[1].getPassword();
        System.out.print(str);
        //User user1 = new User("jdoe", "sup3rpaZZ");
       // Work.checkUser(user1);


        Role role[] = new Role[5];
        for (int i = 0; i < role.length; i++)
            role[i] = new Role();

        role[0].setRights(user[0], Roles.READ, "a");
        role[1].setRights(user[0], Roles.WRITE, "a.b");
        role[2].setRights(user[1], Roles.EXEC, "a.b.c");
        role[3].setRights(user[0], Roles.EXEC, "a.bc");
        role[4].setRights(user[0], Roles.READ, "src");
        String auto = "";



        Options options = new Options()
                .addOption("h", false, "print this help message")
                .addOption("login", true, "login")
                .addOption("pass", true, "password")
                .addOption("res", true, "resource")
                .addOption("role", true, "permission")
                .addOption("ds", true, "date start")
                .addOption("de", true, "date end")
                .addOption("vol", true, "value");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if(cmd.hasOption("h")) {
                logger.info("Print Help");
                printHelp(options);
            }
            if (cmd.hasOption("login")) {
                login = cmd.getOptionValue("login");
                logger.info("Login:" + login);
                arg++;

            }
            if (cmd.hasOption("pass")) {
                pass = cmd.getOptionValue("pass");
                logger.info("Password:" + pass);
                arg++;
            }
            if (cmd.hasOption("res")) {
                res = cmd.getOptionValue("res");
                logger.info("Resourse:" + res);
                arg++;

            }
            if (cmd.hasOption("role")) {
                if (cmd.getOptionValue("role").equals("EXEC") || cmd.getOptionValue("role").equals("WRITE") || cmd.getOptionValue("role").equals("READ")) {
                    rol = cmd.getOptionValue("role");
                    logger.info("Role:" + rol);
                    arg++;
                } else {
                    logger.error("Unknown role:"+ cmd.getOptionValue("role"));
                    System.exit(3);
                }

            }
            if (cmd.hasOption("ds")) {
                ds = cmd.getOptionValue("ds");
                Work.checkDate(ds);
                logger.info("Date start:" + ds);
                arg++;

            }
            if (cmd.hasOption("de")) {
                de = cmd.getOptionValue("de");
                Work.checkDate(de);
                logger.info("Date end:" + de);
                arg++;

            }
            if (cmd.hasOption("vol")) {
                vol = cmd.getOptionValue("vol");
                Work.checkVolume(vol);
                logger.info("Volume:" + vol);
                arg++;
            }
        } catch (org.apache.commons.cli.ParseException e) {
            logger.info("Wrong arguments");
            printHelp(options);

        }

        User user1 = new User(login, pass);
        Role role1 = new Role(user1, Roles.valueOf(rol), res);
        if (arg == 2) {
            Work.checkUser(user1);
            logger.info(login + " Entered");

            System.exit(0);
        } else if (arg == 4) {
            Work.checkUser(user1);
            Work.checkRights(user1, role1);
            logger.info(login + " Entered");
            logger.info(login + " Get access to " + res + " with role: " + rol);

            System.exit(0);
        } else if (arg == 7) {
            Work.checkUser(user1);
            Work.checkRights(user1, role1);
            Work.checkVolume(vol);
            acc1.setAcc(user1, role1, Date.valueOf(ds), Date.valueOf(de), Integer.valueOf(vol));
            logger.info(login + " Entered");
            logger.info(login + " Get access to " + res + " with role: " + rol);
            logger.info("Set ds " + ds + " and de " + de + " with vol " + vol);


            System.exit(0);
        }
        else{
            printHelp(options);
        }

    }

    static void printHelp(Options options) {
        final PrintWriter writer = new PrintWriter(System.out);
        final HelpFormatter helpFormatter = new HelpFormatter();

        helpFormatter.printHelp(
                writer,
                80,
                "[program]",
                "Options:",
                options,
                3,
                5,
                "-- HELP --",
                true);

        writer.flush();
        System.exit(0);
    }


}
