package models;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Integer> scores = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String pass) {
        return this.password.equals(pass);
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }
}
