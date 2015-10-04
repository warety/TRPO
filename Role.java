public class Role {
	 int id = 0;
	 Al user;
	 int rights;
	 String sourse;


	 public void setRights(Al user, int rights, String sourse) {

	 	id++;
	 	this.user = user;
	 	this.rights = rights;
	 	this.sourse = sourse;
	 }

	/*public void getUserRights(Al user, String sourse) {

		if(user == this.user)
		{
			if(sourse == this.sourse)
			{
				System.out.println(this.rights);
			}
			else
			{
				System.out.println("No Rights NIGGA");
			}
		}
		else
		{
			System.out.println("No Rights NIGGA");
		}
	}
*/
	 


	}