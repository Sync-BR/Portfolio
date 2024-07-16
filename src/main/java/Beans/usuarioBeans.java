
package Beans;

/**
 *
 * @author SYNC
 */
public class usuarioBeans {
    private String user;
    private String pass;
    private static String token;

    public usuarioBeans() {
    }
    
    public usuarioBeans(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String aToken) {
        token = aToken;
    }


    
    
    
}
