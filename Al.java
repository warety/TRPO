import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Al {
	 int id = 0;
	 String name = "0";
	 String login;
	 String password;
	 static String salt = "ololo";

	 public void showUserDate() {
	 	System.out.println("id: " + this.id);
	 	System.out.println("login: " + this.login);
	 	if (!this.name.equals("0"))
	 	{
	 		System.out.println("name: " + this.name);
	    }

	 }

	 public void equil(String login, String password) { //Метод проверки логина и пароля
	 	
	 		if (login.equals(this.login))
	 		{
	 			if (makeHash(password).equals(this.password)) 
	 			{
	 				System.out.println("Enterd!!!");

	 			}
	 			else
	 			{
	 				System.out.println("Wrong password");
	 			}
	 		}
	 		else
	 		{
	 			System.out.println("Wrong login");
	 		}
	 	}

	 
	 public void setUser(String login, String password) {//Метод записи новго юзера
	 	this.login = login;
	 	this.password = makeHash(password);
	 	this.id++;
	 	//System.out.println("Welcome" + " " + this.login + " " + this.id);
	 }  
        
	 public String makeHash(String password) {//hash(hash(pass)+salt)
   		password = getHash(password);
   		password += salt;
   		password = getHash(password);
   		return password;
}

	 public void setOtherDate(String name) { //Метод записи доп. данных
	 	this.name = name;
	 	//System.out.println("Hello " + name);
	 }


	 public String getHash(String str) {//MD5 хэшировние. Пока не понял как работает       
        MessageDigest md5 ;        
        StringBuffer  hexString = new StringBuffer();
        
        try {
                                    
            md5 = MessageDigest.getInstance("md5");
            
            md5.reset();
            md5.update(str.getBytes()); 
                        
                        
            byte messageDigest[] = md5.digest();
                        
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
                                                                                        
        } 
        catch (NoSuchAlgorithmException e) {                        
            return e.toString();
        }
        
        return hexString.toString();
    }


    public int getUserId(int id) {
    	id = this.id;
    	return id;
    }

}