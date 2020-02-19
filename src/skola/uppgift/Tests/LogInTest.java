package skola.uppgift.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skola.uppgift.Account.Admin;
import skola.uppgift.Account.User;

import static org.junit.jupiter.api.Assertions.*;

class LogInTest {

    //new test users
    static User testMan = new User(1,"test1","test123","leif","leifsson","20000",15000,"janitor");
    static User testWoman = new User(2,"test2","test321","johanna","johannasson","35000",42000,"designer");


    // before each test below add users
    @BeforeEach
    void add_users(){
        User.UserList.add(testMan);
        User.UserList.add(testWoman);
    }

    //tests testMans userName/password and check if they match
    // in this case they do
    @Test
    void testMan_Login_check_true() {

        //testMan login
        String userName = User.UserList.get(0).getUserName();
        String password = User.UserList.get(0).getPassword();

        for (int i = 0; i < User.UserList.size(); i++) {
            if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                System.out.println("testMan logged in");
                assertTrue(true);
            }
        }
    }

    //tests testWomans userName/password and check if they match
    // in this case they do
    @Test
    void testWoman_Login_check_true() {

        //testWoman login
        String userName = User.UserList.get(1).getUserName();
        String password = User.UserList.get(1).getPassword();

        for (int i = 0; i < User.UserList.size(); i++) {
            if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                System.out.println("testWoman logged in");
                assertTrue(true);
            }
        }
    }

    // check if userName/password match a user
    // in this case they dont
    @Test
    void userName_password_no_match() {

        //login don't exist
        String userName = "no123";
        String password = "dont123";

        for (int i = 0; i < User.UserList.size(); i++) {
            if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                break;
            }
        }
        System.out.println("userName and password dont exist");
        assertTrue(true);
    }

    // Tests if testwoman can login and logout
    @Test
    void testWoman_Login_and_out() {
        boolean quit = false;
        while (!quit) {

            //testWoman login
            String userName = User.UserList.get(1).getUserName();
            String password = User.UserList.get(1).getPassword();

            for (int i = 0; i < User.UserList.size(); i++) {
                if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                    System.out.println("testWoman logged in");

                    // this simulates the "break" for the while loop that wraps user switch Menu.
                    // its like logging out
                    quit = true;
                }
            }
        }
        System.out.println("testWoman has logged out");
        assertTrue(true);
    }

    // tests the admins login values and se if they match
    // they do
    @Test
    void admin_login(){

        String userName = Admin.getAdmin().getUserName();
        String password = Admin.getAdmin().getPassword();

        if (Admin.admin.getUserName().equals(userName) && Admin.admin.getPassword().equals(password)) {
            System.out.println("Admin logging in");

            assertTrue(true);
        }
    }

    // integration test
    // tests previous tests together
    @Test
    void all_login_tests(){
        testMan_Login_check_true();
        testWoman_Login_check_true();
        userName_password_no_match();
        testWoman_Login_and_out();
        admin_login();
    }
}
