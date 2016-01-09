package controll;

import accaunt.Accaunt;
import auth.User;
import org.flywaydb.core.Flyway;
import role.Role;
import role.Roles;

import javax.annotation.Resource;
import javax.annotation.processing.SupportedSourceVersion;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.logging.log4j.*;



public class Work {
    private static final Logger logger = LogManager.getLogger(Work.class);
    Connection connection;

    Resource resource;

    public Work() throws SQLException {

        connection = getConnection();
        //df.setLenient(false);


        logger.debug("Migration");

        // Create the Flyway instance
        Flyway flyway = new Flyway();

        // Point it to the database
        flyway.setDataSource("jdbc:h2:./aaa", "sa", "");

        // Start the migration
        flyway.migrate();

    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:h2:./aaa", "sa", "");

    }

    static public void checkUser(User user1) throws SQLException, FileNotFoundException {


        /*for (int i = 0; i < user.length; i++) {
            if (user1.checkUser(user[i]) == 1) {
                f = true;
                break;
            }
            else if(user1.checkUser(user[i]) == 2)
                logger.error("Wrong Password: " + user1.getPassword() + " to " + user1.getLogin());
                System.exit(2);
            }
            if (f == false){
                logger.error("Wrong login!!!");
                System.exit(1);
        }*/

        Connection connection = null;
        ResultSet resultSet = null;


        connection = DriverManager.getConnection("jdbc:h2:./aaa", "sa", "");
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/create_db.sql"));
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/fill_db.sql"));
        //Statement statement = connection.createStatement();

        String query = "select * from AUTH";
        boolean flag = false;
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM Auth");


        //ps.setString(1, user1.getLogin());
        resultSet = ps.executeQuery();
        while (resultSet.next()) {

            String login = resultSet.getString("login");
            String password = resultSet.getString("hash");
            if (user1.getLogin().equals(login)) {
                flag = true;

                if (user1.getPassword().equals(password)) {

                    break;
                } else
                    System.exit(2);
            }
        }

        if (flag == false)
            System.exit(1);


    }




    static public void checkRights( User user, Role role1) throws SQLException {

        Connection connection = null;
        ResultSet resultSet = null;


        connection = DriverManager.getConnection("jdbc:h2:./aaa", "sa", "");
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/create_db.sql"));
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/fill_db.sql"));
        //Statement statement = connection.createStatement();

        //String query = "select * from AUTH";
        boolean flag = false;
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ROLES");


        //ps.setString(1, user1.getLogin());
        resultSet = ps.executeQuery();


        boolean l = false;
        /*for (int i = 0; i < role.length; i++) {
            if (user.getLogin().equals(role[i].getLogin())) {
                if (role[i].checkRights(role1) == 1) {
                    l = true;
                    break;
                }
            }
        }
        if (l == false) {

            System.exit(4);
        }*/
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
