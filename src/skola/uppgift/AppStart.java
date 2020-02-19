package skola.uppgift;

import java.util.Scanner;


public class AppStart {

    // a method that checks if you want to login or close the application
    public static void choice(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" + "|| Herakles Corp ||" + "\n" + "\n");
        System.out.println("1: Login" +"\n"+ "2: Quit");

        boolean quit = false;
        while(!quit){
            String actions = sc.nextLine();
            switch (actions){
                case "1":
                    LogIn.menu();
                    quit = true;
                    break;
                case "2":
                    System.out.println("Application closing...");
                    quit = true;
                    System.exit(1);
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
    }
}
