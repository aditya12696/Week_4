package regex.basicregex;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        String[] testUsernames = {
                "user_123", "123user", "us", "Valid_User",
                "User12345", "this_is_a_very_long_username",
                "user!name", "_username"
        };

        for (String username : testUsernames) {
            System.out.println("Username: " + username + " → " +
                    (isValidUsername(username) ? "Valid" : "Invalid"));
        }
    }
}
