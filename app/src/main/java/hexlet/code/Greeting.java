package hexlet.code;

public class Greeting {
    public static void greet(User user) {
        user.sendWelcomMessag();
        user.setName();
        user.sendGreetingMessag();
    }
}
