package skola.uppgift.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import skola.uppgift.Account.User;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    // new test users
    static User testMan = new User(1,"test1","test123","leif","leifsson","20000",15000,"janitor");
    static User testWoman = new User(2,"test2","test321","johanna","johannasson","35000",42000,"designer");

    //adds user to UserList then checks if
    // UserList is has 1 user inside
    @Test
    void add_user_to_userList() {
        User.UserList.removeAll(User.UserList);
        User.UserList.add(testMan);
        assertEquals(1, User.UserList.size());
    }

    // removes all users then check if list is empty
    @Test
    void remove_users_from_UserList() {
        User.UserList.removeAll(User.UserList);
        assertEquals(0, User.UserList.size());
    }

    // adds testWoman to empty list then checks if only 1 user exist in UsrList
    @Test
    void one_user_in_UserList() {
        User.UserList.removeAll(User.UserList);
        User.UserList.add(testWoman);
        assertEquals(1, User.UserList.size());
    }

    //takes the first user then checks if
    // array place one is same has user id
    @Test
    void first_user_id() {
        User.UserList.add(testMan);
        assertEquals(1, User.UserList.get(0).getId());
    }

    // checks testMans balance
    @Test
    void user_check_balance(){
        assertEquals(15000,testMan.getBalance());
    }

    // checks if name leif exist in the array
    // gets place 0 in the array
    @Test
    void users_name_exist_in_array() {
        User.UserList.removeAll(User.UserList);
        User.UserList.add(testMan);
        assertTrue(User.UserList.get(0).getFirstName().contains("leif"));
    }
    // sends string to request array
    // checks if array contains 1 string
    @Test
    void one_request_item() {
        User.request.add("change job");
        assertEquals(1, User.request.size());
    }

    //tests if string can be changed in request array
    @Test
    void change_request_item() {
        User.request.add("change job");
        User.request.set(0,"developer");
        assertTrue(User.request.contains("developer"));
    }

    // tests if item can be removed from requests
    @Test
    void request_remove_item() {
        User.request.add("change job");
        User.request.remove(0);
        assertEquals(0, User.request.size());
    }

    // changes users balance value
    @Test
    void user_set_balance() {
        User.UserList.add(testWoman);
        User.UserList.get(0).setBalance(10000);
        System.out.println(User.UserList.get(0).getBalance());
        assertEquals(10000, User.UserList.get(0).getBalance());
    }

    // changes users job value
    @Test
    void user_change_job() {
        User.UserList.add(testWoman);
        System.out.println(User.UserList.get(0).getJob());
        User.UserList.get(0).setJob("chef");
        System.out.println(User.UserList.get(0).getJob());
        assertTrue(User.UserList.get(0).getJob().contains("chef"));
    }

    // checks if testMan can delete himself from UserList
    @Test
    void user_delete_account() {
        User.UserList.removeAll(User.UserList);
        User.UserList.add(testMan);
        System.out.println("Before: "+ "\n" + Arrays.toString(User.UserList.toArray()));

        String userName = User.UserList.get(0).getUserName();
        String password = User.UserList.get(0).getPassword();

            if (User.UserList.get(0).getUserName().equals(userName) && User.UserList.get(0).getPassword().equals(password)) {
                User.UserList.remove(0);
                System.out.println("After: "+ "\n" + User.UserList.size());
            }

        assertEquals(0, User.UserList.size());
    }

    //integration test
    // runs previous tests
    @Test
    void user_check_and_change_fields(){
        add_user_to_userList();
        first_user_id();
        user_check_balance();
        users_name_exist_in_array();
        user_set_balance();
        user_change_job();
    }


    // removes all users from list
    // then runs delete function
    @Test
    void delete_by_userName_password(){
        remove_users_from_UserList();
        user_delete_account();
    }

    // before test below create user simon
    // add simon to UserList
    @BeforeEach
    void Create_user(){
        int id = User.UserList.size()+1;
        User Simon = new User(id,"greklish1","abc123","Simon","Grip","45000",20000,"Developer");
        User.UserList.add(Simon);
    }
    //stress test
    //done after 1m 9sec 539ms
    // after 4000 repeats it went slower
    @RepeatedTest(5000)
    void userList_stress_test(){
        User.UserList.forEach(User ->{
            System.out.println(User.getFirstName() + " " + User.getId());
        });
    }
}

