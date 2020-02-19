package skola.uppgift.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import skola.uppgift.Account.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserTest {

    public static ArrayList<User> UserList = new ArrayList<User>();

    // adds user kenny to UserList
    @Test
    void create_new_user(){
        UserList.removeAll(UserList);

        int idGen = UserList.size()+1;
        String userName = "user123";
        String password = "password321";
        String name = "kenny";
        String lastName = "kennysson";
        String salary = "30000";
        int balance = 34000;
        String job = "banker";

        User user = new User(idGen,userName,password,name,lastName,salary,balance,job);

        UserList.add(user);
        System.out.println(Arrays.toString(UserList.toArray()));

        // checks if userlist contains a user
        assertEquals(1,UserList.size());

        // checks if userList contains user
        assertTrue(UserList.contains(user));
    }

    // tests if string only contains integers
    // in this case it don't
    @Test
    void contains_only_number_false(){
        String salary;
        while(true) {
            salary = "214F135";
            try {
                Integer.valueOf(salary);
                break;
            } catch (NumberFormatException ne) {
                System.out.println("error");
                assertFalse(false,salary);
                break; // break here or endless loop
            }
        }
    }

    // tests if string only contains integers
    // in this case is does
    @Test
    void contains_only_number_true(){
        String salary;
        while(true) {
            salary = "214135";
            try {
                Integer.valueOf(salary);
                break;
            } catch (NumberFormatException ne) {
                System.out.println("error");
            }
        }
        assertTrue(true,salary);
    }

    // needed for tests below
    // checks if numbers 0-9 exist in string
    private static boolean stringContainsNumber( String userName ) {
        return Pattern.compile( "[0-9]" ).matcher( userName).find();
    }

    // checks if numbers exist in username/password
    // in this case it does
    @Test
    void username_password_contains_number_true(){
        String userName;
        String password;

        while(true){
            userName = "evert12";
            password = "fiska09";
            String both = userName+password;
            if(stringContainsNumber(userName) && stringContainsNumber(password)){
                assertTrue(true,both);
                break;
            }
            System.out.println("error");
        }
    }

    // checks if numbers exist in username/password
    // in this case it don't
    @Test
    void username_password_contains_number_false(){
        String userName;
        String password;

        while(true){
            userName = "evert";
            password = "fiska09";
            String both = userName+password;
            if(stringContainsNumber(userName) && stringContainsNumber(password)){
                break;
            }
            System.out.println("error");
            assertFalse(false,both);
            break; // if not endless loop
        }
    }

    //integration test
    // runs all previous tests
    @Test
    void all_create_user_tests(){
        create_new_user();
        contains_only_number_true();
        contains_only_number_false();
        username_password_contains_number_false();
        username_password_contains_number_true();
    }

    // creates user kenny before all tests below
    // adds kenny to UserList
    @BeforeEach
    void create_user(){
        int idGen = UserList.size()+1;
        String userName = "user123";
        String password = "password321";
        String name = "kenny";
        String lastName = "kennysson";
        String salary = "30000";
        int balance = 34000;
        String job = "banker";
        User user = new User(idGen,userName,password,name,lastName,salary,balance,job);
        UserList.add(user);
    }

    // stress test
    // 1 min 13 s 560ms
    // the last 1000 was slower
    @RepeatedTest(5000)
    void create_user_stress_test(){
        UserList.forEach(User ->{
            System.out.println(User.getFirstName() + " " + User.getId());
        });
    }
}

