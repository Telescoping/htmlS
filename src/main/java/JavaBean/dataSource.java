package JavaBean;

public class dataSource {
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {   dataSource.username = username; }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        dataSource.password = password;
    }

    private static String username;
    private static String password;
}
