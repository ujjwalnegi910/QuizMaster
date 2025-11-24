package services;

import models.User;
import java.util.HashMap;
import java.util.Scanner;

public class UserService {
    private HashMap<String, User> users = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public User register() {
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();

        User newUser = new User(u, p);
        users.put(u, newUser);

        System.out.println("Registration successful!");
        return newUser;
    }

    public User login() {
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();

        if (users.containsKey(u) && users.get(u).validatePassword(p)) {
            System.out.println("Login successful!");
            return users.get(u);
        } else {
            System.out.println("Invalid login!");
            return null;
        }
    }
}
