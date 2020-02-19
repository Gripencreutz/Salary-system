package skola.uppgift.Account;

import skola.uppgift.AppStart;
import java.util.ArrayList;
import java.util.Scanner;

//implements the menu interface
public class User extends Account implements IMenu{

    // 2 arrayLists
    // one for Users, other for requests
    public static ArrayList<User> UserList = new ArrayList<User>();
    public static ArrayList<String> request = new ArrayList<String>();

    static Scanner sc = new Scanner(System.in);
    static String actions;

    //Values a user needs to have
    private int id;
    private String firstName;
    private String lastName;
    private String salary;
    private int balance = 20000;
    private String job;


    //constructor
    public User(int id, String userName, String password, String firstName, String lastName, String salary, int balance, String job) {
        super(userName, password);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.balance = balance;
        this.job = job;
    }


    // interface menu changed for the use of Users
    @Override
    public void menu() {
        System.out.println(
                "\n"+"|| Herakles Corp ||" + "\n" + "\n" +
                        "Welcome " +getFirstName()+"\n" + "\n" +
                        "1: Account Balance" + "\n" +
                        "2: Salary" + "\n" +
                        "3: Job Position" + "\n" +
                        "4: Request raise or job change" + "\n" +
                        "5: Delete account" + "\n" +
                        "6: Logout" + "\n" +
                        "Please enter your choice:");

        boolean quit = false;
        while(!quit){
            actions = sc.nextLine();
            switch(actions){
                case "1":
                    System.out.println("Your Balance is -> " + balance +" Sek <-");
                    menu();
                    break;
                case "2":
                    System.out.println("Your monthly salary is -> " + salary +" Sek/month <-");
                    menu();
                    break;
                case "3":
                    System.out.println("Your current job position is: " +"-> "+ job +" <-");
                    menu();
                    break;
                case "4":
                    userRequestToAdmin();
                    menu();
                    break;
                case "5":
                    delete();
                    break;
                case "6":
                    System.out.println("Logging out...");
                    quit = true;
                    AppStart.choice();
                    break;
                default:
                    System.out.println("Not a valid choice, please choose an option from 0-6");
            }
        }
    }
    // sends requests from user to request arrayList
    private void userRequestToAdmin(){
        System.out.println("||Request||" +"\n"+"\n"+
                "1: New Job Position" + "\n" +
                "2: Raise");

        boolean quit = false;
        while(!quit){
            actions = sc.nextLine();
            switch (actions){
                case "1":
                    jobPos();
                    quit = true;
                    break;
                case "2":
                    raise();
                    quit = true;
                    break;
                case "3":
                    quit = true;
            }
        }
    }
    // sends users id/name and message to request array
    private void jobPos(){
       System.out.println("A request for job position has been sent");
       String userRequest ="id: "+ id + " Name: " +firstName + " Requests: a new job";
       request.add(userRequest);
    }

    // sends users id/name and message to request array
    private void raise(){
        System.out.println("A request for job raise has been sent");
        String userRequest ="id: "+ id + " Name: " +firstName+ " Requests: a new raise";
        request.add(userRequest);
    }

    // a User can delete his/her account
    // inputting userName and password
    private void delete(){
        System.out.println("Delete your account? yes or no (y/n)");

        boolean quit = false;
        while(!quit){
            actions = sc.nextLine();
            switch(actions){
                case "y":
                    System.out.println("Username: ");
                    String userName = sc.nextLine();

                    System.out.println("password: ");
                    String password = sc.nextLine();

                    // if userName/password match
                    // delete that user from UsersList
                    for (int i = 0; i < User.UserList.size(); i++) {
                        if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                            User.UserList.remove(i);
                            System.out.println("Account Deleted!");
                            AppStart.choice();
                        }
                    }
                    quit = true;
                    break;
                case "n":
                    quit = true;
                    menu();
                    break;
            }
            System.out.println("invalid");
            menu();
        }
    }

    @Override
    public String toString() {
        return "\nUser{ " +
                " userName='" + getUserName() + '\'' +
                " password='" + getPassword() + '\'' +
                " id=" + id + '\'' +
                " firstName='" + firstName + '\'' +
                " lastName='" + lastName + '\'' +
                " salary='" + salary + '\'' +
                " balance='" + balance + '\'' +
                ", job='" + job + '\'' +
                '}';
    }


    /*Getter and Setters*/
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}




