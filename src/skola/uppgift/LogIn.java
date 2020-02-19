package skola.uppgift;

import skola.uppgift.Account.Admin;
import skola.uppgift.Account.User;
import java.util.Scanner;

public class LogIn {
    public static void menu() {

        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("\n"+"||Login||" + "\n");
            System.out.print("User Name: ");
            String userName = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            // loops through UsersList and check if userName/password match
            // if it do. login that user
            for (int i = 0; i < User.UserList.size(); i++) {
                if (User.UserList.get(i).getUserName().equals(userName) && User.UserList.get(i).getPassword().equals(password)) {
                    System.out.println("success!");
                    User.UserList.get(i).menu();
                    quit = true;
                    break;
                }
            }
            // checks if admins userName/password is written
            // if it is, login admin
            if (Admin.admin.getUserName().equals(userName) && Admin.admin.getPassword().equals(password)) {
                System.out.println("Success!");
                Admin.admin.menu();
                quit = true;
            } else {
                    System.out.println("Username and password do not match");
            }
        }
    }
}

