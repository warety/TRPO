package Accaunt;

import Auth.User;
import Role.Role;

import java.util.Date;

/**
 * Created by alex on 18.10.2015.
 */
public class Accaunt {
    User user;
    Role role;
    Date start_date;
    Date end_date;
    int vol;


    public void setAcc(User user, Role role, Date start_date, Date end_date, int vol){
        this.user = user;
        this.role = role;
        this.start_date = start_date;
        this.end_date = end_date;
        this.vol = vol;
    }

    public void showAcc(){
        System.out.println(start_date + " " + end_date + " " + vol);
    }

}
