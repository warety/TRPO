package accaunt;

import auth.User;
import controll.Work;
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

        ResultSet resultSet = null;
        Work connection = new Work();
        this.start_date = start_date;
        this.end_date = end_date;
        this.vol = vol;

        PreparedStatement ps = connection.getConnection().prepareStatement("insert into ACCOUNTING (ROLES_ID, START_DATE, END_DATE, VOLUME) values (?,?,?,?)");
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

        Work connection = new Work();
        ResultSet resultSet = null;

        System.out.println(" START SHOW");
        PreparedStatement ps = connection.getConnection().prepareStatement("SELECT * FROM ACCOUNTING");
        resultSet = ps.executeQuery();
        while (resultSet.next())
            System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5));
        System.out.println("END");

}}
