import java.util.Scanner;

public class Main {

	public static void main(String... args) {

		String login, password;
		Scanner in = new Scanner(System.in);
		Al one = new Al();
		one.setUser("warety","1234");
		one.setOtherDate("Alex");
		one.showUserDate();
		System.out.println("Login:");
		login = in.nextLine();
		System.out.println("Password:");
		password = in.nextLine();
		one.equil(login,password);

	}


}