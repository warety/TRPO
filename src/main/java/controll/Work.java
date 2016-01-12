package controll;

import accaunt.Accaunt;
import auth.Hash;
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
    User user;
    Role role;
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

    public User getUser() {return user;}

    public Role getRole() {return role;}

    public int checkUser(String login, String password) throws SQLException, FileNotFoundException {



        ResultSet resultSet = null;


        String query = "select * from AUTH";
        boolean flag = false;
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM Auth");



        resultSet = ps.executeQuery();
        while (resultSet.next()) {

            String loginbd = resultSet.getString("login");
            String passwordbd = resultSet.getString("hash");
            if (login.equals(loginbd)) {
                password = Hash.makeHash(password, resultSet.getString("salt"));
                System.out.println(password);

                flag = true;

                if (password.equals(passwordbd)) {
                    user = new User(resultSet.getInt("id"), resultSet.getString("name"), loginbd, passwordbd, resultSet.getString("salt"));
                    break;
                } else{
                    logger.error("Wrong pass");
                    return 2;
                    //System.exit(2);
                }


            }
        }

        if (flag == false) {
            logger.error("Wrong login");
            return 1;
            //System.exit(1);
        }

        return 0;



    }




    public int checkRights(User user, Roles rights, String sourse) throws SQLException {


        ResultSet resultSet = null;

        boolean flag1 = false;
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ROLES R, AUTH A where r.auth_id = a.id and a.id = ?");

        ps.setString(1, String.valueOf(user.getId()));
        resultSet = ps.executeQuery();


        boolean l = false;
        while(resultSet.next())
        {
            Roles rightsbd = Roles.valueOf(resultSet.getString("ROLE"));
            String soursebd = resultSet.getString("RESOURCE");

            String parse[] = sourse.split("\\.");
            String[] atrStr = soursebd.split("\\.");
            if (parse.length >= atrStr.length) {
                flag1 = false;

                for (int i = 0; i < atrStr.length; i++) {
                    if (parse[i].equals(atrStr[i])) {
                        flag1= true;
                        continue;

                    } else {
                        flag1 = false;
                        break;
                    }

                }


                if ((rights == rightsbd) && (flag1 == true)) {

                    role = new Role(resultSet.getInt("id"), resultSet.getInt("auth_id"), rights, sourse);

                    break;
                }
                else{
                    flag1 = false;
                }

            }

        }
        if (flag1 != true)
        {
            logger.error("No access");
            return 4;
            //System.exit(4);
        }

        return 0;

    }

    public int checkDate(String str1) {
        try {
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            formatter.setLenient(false);
            calendar.setTime(formatter.parse(str1));
            return 0;


        } catch (Exception e) {
            logger.error("Wrong date formate");
            return 5;
            //System.exit(5);
        }


    }

    public int checkVolume(String vol) {
        try {
            Integer.parseInt(vol);
            if (Integer.valueOf(vol) < 0) {
                logger.error("Wrong value of volume");
                return 5;
                //System.exit(5);
            }
            else
            {
                return 0;
            }
        } catch (NumberFormatException e) {
            logger.error("Wrong value of volume");
            return 5;
            //System.exit(5);
        }

    }



}
