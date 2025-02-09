package hexlet.code;

import java.util.Scanner;

public class User {

    private String name;

    public void setName() {
        var scanner = new Scanner(System.in);
        var userName = scanner.nextLine();
        this.name = userName;
    }

    public String getName() {
        return name;
    }

    public void sendWelcomMessag() {
        System.out.println("Welcome to the Brain Games!");
    }

    public void sendGreetingMessag() {
        System.out.println("Hello, " + name + "'");
    }

}
