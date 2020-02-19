package skola.uppgift.Account;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateUser{

    // is used to check if a string contains a number from 0-9
    private static boolean stringContainsNumber( String userName ) {
        return Pattern.compile( "[0-9]" ).matcher( userName).find();
    }

    public static void newUser(){
        Scanner sc = new Scanner(System.in);

        //values that will go in to a new user
        String salary;
        String userName;
        String password;
        int balance = 20000;
        int idGen = User.UserList.size()+1;

        System.out.println("-> Create new user <-" + "\n");
        while(true){
            System.out.print("User Name -> "+"\n");
            userName = sc.nextLine();

            System.out.print("Password -> "+"\n");
            password = sc.nextLine();

            // checks if the string have a number or not
            // if true, break loop
            if(stringContainsNumber(userName) && stringContainsNumber(password)){
                break;
            }
            System.out.println("Username and password needs to contain at least 1 number");
        }

        System.out.print("First Name -> "+"\n");
        String name = sc.nextLine();

        System.out.print("Last Name -> "+"\n");
        String lastName = sc.nextLine();

            // checks if string salary contains only integers
            // if not catch and deliver a error message
            while(true) {
                System.out.print("Salary -> " + "\n");
                salary = sc.nextLine();
                try {
                    Integer.valueOf(salary);
                    break;
                } catch (NumberFormatException ne) {
                    System.out.println("Enter numbers please");
                }
            }

            System.out.print("Job Position -> "+"\n");
            String job = sc.nextLine();

            //add values into a new user
            User user = new User(idGen,userName,password,name,lastName,salary,balance,job);

            //adds new user to arrayList
            User.UserList.add(user);

            //prints out the new user
            Object[] userList = {user};
            for(Object u : userList){
                System.out.println(u);
            }
        }

}
