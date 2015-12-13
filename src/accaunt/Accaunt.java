package accaunt;

import auth.User;
import role.Role;

import java.util.Date;


public class Accaunt {
    User user;
    Role role;
    Date start_date;
    Date end_date;
    int vol;


    public void setAcc(User user, Role role, Date start_date, Date end_date, int vol) {
        this.user = user;
        this.role = role;
        this.start_date = start_date;
        this.end_date = end_date;
        this.vol = vol;
    }

    public void showAcc() {
        System.out.println(start_date + " " + end_date + " " + vol);
    }

}
