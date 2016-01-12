package accaunt;

import auth.User;
import role.Role;

import java.sql.*;
import java.util.Date;


public class Accaunt {

    int id;
    int ROLES_ID;
    Date start_date;
    Date end_date;
    int vol;




    public void setAcc(User user, Role role, Date start_date, Date end_date, int vol) throws SQLException {

        Connection connection = null;
        ResultSet resultSet = null;

        this.start_date = start_date;
        this.end_date = end_date;
        this.vol = vol;
        connection = DriverManager.getConnection("jdbc:h2:./aaa", "sa", "");
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/create_db.sql"));
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/fill_db.sql"));
        //Statement statement = connection.createStatement();
//        PreparedStatement statement = connection.prepareStatement("SELECT count(*) FROM ACCOUNTING");
//        id+=resultSet.getInt(1);

        PreparedStatement ps = connection.prepareStatement("insert into ACCOUNTING (ROLES_ID, START_DATE, END_DATE, VOLUME) values (?,?,?,?)");
//        ps.setInt(1, id);
        ps.setInt(1, role.getId() );
        ps.setDate(2, java.sql.Date.valueOf(String.valueOf(start_date)));
        ps.setDate(3, java.sql.Date.valueOf(String.valueOf(end_date)));
        ps.setInt(4, vol);
        ps.execute();
//        System.out.println("FUCK YEA");


    }

    public void showAcc() {
        System.out.println(start_date + " " + end_date + " " + vol);
    }


    public  void show () throws SQLException {

        Connection connection = null;
        ResultSet resultSet = null;

        System.out.println(" START SHOW");
        connection = DriverManager.getConnection("jdbc:h2:./aaa", "sa", "");
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/create_db.sql"));
        //org.h2.tools.RunScript.execute(connection, new FileReader("dbase/fill_db.sql"));
        //Statement statement = connection.createStatement();

        String query = "select * from AUTH";
        boolean flag = false;
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ACCOUNTING");


        //ps.setString(1, user1.getLogin());
        resultSet = ps.executeQuery();
        while (resultSet.next())
            System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5));
//        System.out.println(resultSet.getInt(1)+" "+ resultSet.getInt(2)+ " "+ resultSet.getDate(3)+ " "+ resultSet.getDate(4)+ " "+ resultSet.getInt(5));
        System.out.println("END");

}}
