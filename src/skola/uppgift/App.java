package skola.uppgift;

import skola.uppgift.Account.User;


public class App {
    public static void start(){

        User Simon = new User(1,"greklish1","abc123","Simon","Gripencreutz","30000",20000,"Developer");
        User Leia = new User(2,"niek12","qwe321","Leia","Ravenclaw","35000",20000,"Youtuber");

        // adds users to the application before hand
        User.UserList.add(Simon);
        User.UserList.add(Leia);

        // starts the application
        AppStart.choice();
    }
}
