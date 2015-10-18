package Auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alex on 07.10.2015.
 */
public class Hash {

    public static String makeHash(String password, String salt) {//hash(hash(pass)+salt)
        password = getHash(password);
        password += salt;
        password = getHash(password);
        return password;
    }

    public static String getHash(String str) {//MD5 хэшировние. Пока не понял как работает
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
}
