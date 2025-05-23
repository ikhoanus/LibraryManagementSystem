
package project1;

public class User extends Person {
    private String password;

    public User(String username, String password) {
        super(username); 
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.name.equals(inputUsername) && this.password.equals(inputPassword);
    }
}
