package skola.uppgift.Account;

import skola.uppgift.AppStart;
import java.util.Arrays;
import java.util.Scanner;

public class Admin extends Account implements IMenu {

    // hardcoded admin in to the application
    public static Admin admin = new Admin("admin1", "admin1234");

    //variables for inputs
    static Scanner sc = new Scanner(System.in);
    static String actions;
    static String userChange;
    static String raise;

    //variables
    int adminBalance = 30000;
    String job = "Boss";
    int adminSalary = 60000;

    //constructor
    public Admin(String userName, String password) {
        super(userName, password);
    }

    //menu interface
    //for admin only
    @Override
    public void menu() {
        System.out.println(
                "\n" + "|| Herakles Corp ||" + "\n" + "\n" +
                        "User: " + admin.getUserName() + "\n" + "\n" +
                        "1: Account Balance" + "\n" +
                        "2: Salary" + "\n" +
                        "3: Job Position" + "\n" +
                        "4: View Users" + "\n" +
                        "5: Salary/Job position requests" + "\n" +
                        "6: Pay Salary" + "\n" +
                        "7: Create a User" + "\n" +
                        "8: Delete a User" + "\n" +
                        "9: Logout" + "\n" +
                        "Please enter your choice:");

        boolean quit = false;
        while (!quit) {

            // switch menu with 10 cases to choose from
            String action = sc.nextLine();
            switch (action) {
                case "1":
                    System.out.print("Your Account balance is -> " + adminBalance + " Sek\n");
                    menu();
                    break;
                case "2":
                    System.out.print("Your current salary is -> " + adminSalary + " Sek/month\n");
                    menu();
                    break;
                case "3":
                    System.out.print("Your current job position is -> " + job + "\n");
                    menu();
                    break;
                case "4":
                    allUsers();
                    menu();
                    break;
                case "5":
                    requests();
                    menu();
                    break;
                case "6":
                    paySalary();
                    menu();
                    break;
                case "7":
                    CreateUser.newUser();
                    menu();
                    break;
                case "8":
                    delete();
                    menu();
                    break;
                case "9":
                    System.out.println("Logging out...");
                    quit = true;
                    AppStart.choice();
                    break;
                default:
                    System.out.println("Not a valid choice, please choose an option from 0-9");
                    break;
            }
        }
    }

    //admin can change a users job or salary through a switch menu
    private static void requests() {
        System.out.println("\n" + "||Requests||" + "\n");

        //prints out all requests from request array
        System.out.println(Arrays.toString(User.request.toArray()) + "\n");
        boolean quit = false;

        //the loop makes sure to restart if the input is invalid
        while (!quit) {
            System.out.println("Accept request yes or no? (y/n)");
            actions = sc.nextLine();

            // ends loop
            if (actions.toLowerCase().equals("n")) {
                quit = true;
            }

            if (actions.toLowerCase().equals("y")) {
                System.out.println("which user?");
                userChange = sc.nextLine();

                //loops through UserList after input from admin
                for (int i = 0; i < User.UserList.size(); i++) {

                    // if input is equal to a name in the list
                    // admin will get a new choice
                    if (User.UserList.get(i).getFirstName().toLowerCase().equals(userChange)) {
                        System.out.println("What request do you want to change?" + "\n" + "1: Job 2: salary");
                        actions = sc.nextLine();

                        //changes job
                        if (actions.equals("1")) {
                            System.out.println("Change " + User.UserList.get(i).getJob() + " job to?");
                            String jobChange = sc.nextLine();
                            System.out.println(" ");

                            // checks if the userName and password match
                            boolean quit2 = false;
                            while (!quit2) {

                                System.out.println("Users Username: ");
                                String userName = sc.nextLine();

                                System.out.println("\n"+"password: ");
                                String password = sc.nextLine();


                                // if the userName/password match
                                // change job
                                if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                                    System.out.println(User.UserList.get(i).getJob() + " Has been changed to ");
                                    User.UserList.get(i).setJob(jobChange);
                                    User.request.remove(i-1);
                                    System.out.println(jobChange);
                                    quit = true;
                                    quit2 = true;
                                }
                            }
                        }

                        //change salary
                        if (actions.equals("2")) {
                            boolean quit3 = false;
                            while (!quit3) {
                                System.out.println("Raise salary to?");

                                // checks if string only contains integers
                                while (true) {
                                    raise = sc.nextLine();
                                    try {
                                        Integer.valueOf(raise);
                                        break;
                                    } catch (NumberFormatException ne) {
                                        System.out.println("Enter only numbers please");
                                    }
                                }
                                System.out.println("Users Username: ");
                                String userName = sc.nextLine();

                                System.out.println("password: ");
                                String password = sc.nextLine();

                                // if the userName/password match
                                // change salary
                                if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                                    System.out.println(User.UserList.get(i).getSalary() + " Sek Has been changed to -> ");
                                    User.UserList.get(i).setSalary(raise);
                                    System.out.println(" "+raise+" Sek");
                                    quit = true;
                                    quit3 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // takes balance and adds salary to all users in UserList
    private void paySalary(){
        System.out.println("Pay has been sent");

        for (int i = 0; i <User.UserList.size() ; i++) {
            String salary = User.UserList.get(i).getSalary();
            int balance = User.UserList.get(i).getBalance();
            int pay = Integer.parseInt(salary);
            User.UserList.get(i).setBalance(balance+pay);
        }
    }
    //admin deletes a user through a desired user userName/password
    private void delete(){
        boolean quit = false;
        while(!quit){
            System.out.println("Account termination? yes or no (y/n)");
            actions = sc.nextLine();
            switch(actions){
                case "y":
                    System.out.println("Users Username: ");
                    String userName = sc.nextLine();

                    System.out.println("password: ");
                    String password = sc.nextLine();

                    // if the userName/password match
                    // remove from array list
                    for (int i = 0; i < User.UserList.size(); i++) {
                        if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                            User.UserList.remove(i);
                            System.out.println("Account Deleted!");
                            break;
                        }
                    }

                case "n":
                    break;
            }

            quit = true;
        }
    }

    //prints all users using a loop
    public void allUsers() {
        for (int i = 0; i <User.UserList.size() ; i++) {
        System.out.println("\nUser{ " + "\n" +
                " userName= " + User.UserList.get(i).getUserName() + '\n' +
                " password= " + User.UserList.get(i).getPassword() + '\n' +
                " id= " + User.UserList.get(i).getId() + '\n' +
                " firstName= " + User.UserList.get(i).getFirstName() + '\n' +
                " lastName= " + User.UserList.get(i).getLastName() + '\n' +
                " salary= " + User.UserList.get(i).getSalary()+ '\n' +
                " balance= " + User.UserList.get(i).getBalance() + '\n' +
                " job= " + User.UserList.get(i).getJob() + '\n' +
                '}');
        }
    }

    public static Admin getAdmin() {
        return admin;
    }
}