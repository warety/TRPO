import accaunt.Accaunt;
import auth.Hash;
import auth.User;
import controll.Work;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import role.Role;
import role.Roles;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static int main(String[] args) throws ParseException, FileNotFoundException, SQLException {
        logger.trace("Application started");

        String login = "";
        String pass = "";
        String res = "";
        String rol = "READ";
        String ds = "";
        String de = "";
        String vol = "";
        int arg = 0;

        int result = 10;

        //String str = Hash.makeHash("sup3rpaZZ", "ololo");
       // System.out.println(str);



        Accaunt acc1 = new Accaunt();

        Options options = new Options()
                .addOption("h", false, "print this help message")
                .addOption("login", true, "login")
                .addOption("pass", true, "password")
                .addOption("res", true, "resource")
                .addOption("role", true, "permission")
                .addOption("ds", true, "date start")
                .addOption("de", true, "date end")
                .addOption("vol", true, "value");

        Work work = new Work();

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
                    return result = 3;
                    //System.exit(3);
                }

            }
            if (cmd.hasOption("ds")) {
                ds = cmd.getOptionValue("ds");
                if((result = work.checkDate(ds)) != 0){
                    return result;
                }
                logger.info("Date start:" + ds);
                arg++;

            }
            if (cmd.hasOption("de")) {
                de = cmd.getOptionValue("de");
                if((result = work.checkDate(de)) != 0){
                    return result;
                }
                logger.info("Date end:" + de);
                arg++;

            }
            if (cmd.hasOption("vol")) {
                vol = cmd.getOptionValue("vol");
                if((result = work.checkVolume(vol)) != 0){
                    return result;
                }
                logger.info("Volume:" + vol);
                arg++;
            }
        } catch (org.apache.commons.cli.ParseException e) {
            logger.info("Wrong arguments");
            printHelp(options);

        }

        if (arg == 2) {
            result = work.checkUser(login, pass);
            System.out.println(result);
            //
        } else if (arg == 4) {
            result = work.checkUser(login, pass);
            //System.out.println(work.getUser().getId() + " " + work.getUser().getLogin() + " " + work.getUser().getPassword());
            if (result == 0) {
                logger.info(login + " Entered");
                result = work.checkRights(work.getUser(), Roles.valueOf(rol), res );
                //System.out.println(role1.getId() + " " + role1.getUser_id() + " " + role1.getSourse() + " " + role1.getRights().toString());

            }

        } else if (arg == 7) {
            result = work.checkUser(login, pass);
            //System.out.println(work.getUser().getId() + " " + work.getUser().getLogin() + " " + work.getUser().getPassword());
            if (result == 0) {
                result = work.checkRights(work.getUser(), Roles.valueOf(rol), res );
                //System.out.println(role1.getId() + " " + role1.getUser_id() + " " + role1.getSourse() + " " + role1.getRights().toString());
            }
            if(result == 0) {
                acc1.setAcc(work.getUser(), work.getRole(), Date.valueOf(ds), Date.valueOf(de), Integer.valueOf(vol));
                logger.info(login + " Entered");
                logger.info(login + " Get access to " + res + " with role: " + rol);
                logger.info("Set ds " + ds + " and de " + de + " with vol " + vol);
            }



            //System.exit(0);
        }
        else{
            printHelp(options);
            result = 255;
        }
        System.out.println(result);
        return result;

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
