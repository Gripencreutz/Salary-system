package skola.uppgift.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skola.uppgift.Account.Admin;
import skola.uppgift.Account.User;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    //admin values
    int adminBalance = 30000;
    String job = "Boss";
    int adminSalary = 60000;

    // 2 test users created
    static User testMan = new User(1,"test1","test123","leif","leifsson","20000",15000,"janitor");
    static User testWoman = new User(2,"test2","test321","johanna","johannasson","35000",40000,"designer");

    // checks if admin balance is 30000
    @Test
    void get_admin_balance() {
        Assertions.assertEquals(30000, adminBalance);
    }

    // checks if admin salary is 60000
    @Test
    void get_admin_salary() {
        assertEquals(60000, adminSalary);
    }

    // checks if admin username is admin1
    @Test
    void get_admin_name() {
       assertEquals("admin1",Admin.getAdmin().getUserName());
    }

    // checks if admin password is admin1234
    @Test
    void get_admin_password() {
        assertEquals("admin1234",Admin.getAdmin().getPassword());
    }

    // checks if admin job is Boss
    @Test
    void get_admin_job() {
        assertEquals("Boss", job);
    }

    // before each test below
    // add testMan and testWoman to UserList
    @BeforeEach
    void add_users(){
        User.UserList.add(testMan);
        User.UserList.add(testWoman);
    }

    //test the user change job feature
    @Test
    void request_change_user_job(){

        // sends request to request array
        String userSend = "request from user " + testMan.getFirstName();
        User.request.add(userSend);

        //prints out request array
        System.out.println(Arrays.toString(User.request.toArray()) + "\n");

        String usersName = testMan.getFirstName();
        String newJob = "pilot";

        // userName/password check
        System.out.println("looping usersList");
        for (int i = 0; i < User.UserList.size(); i++) {
            if (User.UserList.get(i).getFirstName().equals(usersName)){
                User.UserList.get(i).setJob(newJob);
                System.out.println("job changed");
                System.out.println(testMan.getJob());

                // checks if new job is the value of testMan job
                assertEquals(newJob, testMan.getJob());
            }
        }
    }

    //test the user change job feature
    @Test
    void request_change_user_raise(){
        String userSend = "request from user " + testWoman.getFirstName();
        User.request.add(userSend);

        // sends request to request array
        System.out.println(Arrays.toString(User.request.toArray()) + "\n");

        String usersName = testWoman.getFirstName();
        String newSalary = "1337";

        // userName/password check
        System.out.println("looping usersList");
        for (int i = 0; i < User.UserList.size(); i++) {
            if (User.UserList.get(i).getFirstName().equals(usersName)){
                User.UserList.get(i).setSalary(newSalary);
                System.out.println("salary changed");
                System.out.println(testWoman.getSalary());

                // checks if new salary is the value of testWomans salary
                assertEquals(newSalary, testWoman.getSalary());
            }
        }
    }

    // tests pay salary features
    @Test
    void pay_Salary(){

        //loops through UserList
        //for every user take their balance and add salary
        for (int i = 0; i <User.UserList.size() ; i++) {
            String salary = User.UserList.get(i).getSalary();
            int balance = User.UserList.get(i).getBalance();
            int pay = Integer.parseInt(salary);
            User.UserList.get(i).setBalance(balance+pay);
        }

        System.out.println(Arrays.toString(User.UserList.toArray()));
        System.out.println("Pay has been sent");

        //checks if Users got their pay
        assertEquals(35000,testMan.getBalance());
        assertEquals(75000,testWoman.getBalance());
    }

    // tests delete feature
    @Test
    void delete_user(){
        String userName = testMan.getUserName();
        String password = testMan.getPassword();

        //loops through UserList and checks if username/password match a user
        // if it does, remove user from list
        for (int i = 0; i < User.UserList.size(); i++) {
            if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                User.UserList.remove(i);
                System.out.println("Testman deleted");

                System.out.println(Arrays.toString(User.UserList.toArray()));

                //checks if user is deleted
                assertEquals(1,User.UserList.size());
            }
        }
    }

}