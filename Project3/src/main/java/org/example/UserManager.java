package org.example;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static UserManager instance;
    private Map<String, User> userMap;

    private UserManager() {
        userMap = new HashMap<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public boolean registerUser(String username, String password) {
        if (!userMap.containsKey(username)) {
            User newUser = new User(username, password);
            userMap.put(username, newUser);
            return true;
        }
        return false;
    }

    public boolean authenticateUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).authenticate(password);
        }
        return false;
    }

    public User getUser(String username) {
        return userMap.get(username);
    }
}
