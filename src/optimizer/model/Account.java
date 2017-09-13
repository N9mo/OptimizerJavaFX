package optimizer.model;

public class Account {
    private static String login;
    private static String password;

    public static void setLogin(String login) {
        Account.login = login;
    }

    public static void setPassword(String password) {
        Account.password = password;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
}
