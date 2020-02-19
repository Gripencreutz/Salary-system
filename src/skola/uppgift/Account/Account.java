package skola.uppgift.Account;

public class Account {

    //variables that all children inherit
    private String userName;
    private String password;

    //constructor
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //getters
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
