import java.util.Scanner;

public class Main {

	public static void main(String... args) {

		String login, password;
		Scanner in = new Scanner(System.in);
		Al one = new Al();
		one.setUser("warety","1234");
		one.setOtherDate("Alex");
		one.showUserDate();
		//System.out.println("Login:");
		//login = in.nextLine();
		//System.out.println("Password:");
		//password = in.nextLine();
		//one.equil(login,password);




		Role two[] = new Role[2];
			for (int j = 0; j < 2; j++ )
     				two[j] = new Role();

		two[0].setRights(one, 7, "wiki");
		two[1].setRights(one, 1, "github");
		//two[0].getUserRights(one, "wiki");
		one.getRights("github", two);



	}


}