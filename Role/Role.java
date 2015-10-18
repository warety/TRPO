package Role;

import Auth.User;

/**
 * Created by alex on 07.10.2015.
 */
public class Role {
    int id = 0;
    User user;
    int rights;
    String sourse;


    public void setRights(User user, int rights, String sourse) {

        id++;
        this.user = user;
        this.rights = rights;
        this.sourse = sourse;
    }

    public User getUser()
    {
        return this.user;
    }

    public int  checkRights(Role role){
        if(role.sourse.equals(this.sourse)){
            if(role.rights == this.rights)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
        else
        {
            return 3;
        }
    }
}
