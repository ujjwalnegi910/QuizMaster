package services;

import models.User;

public class ReportManager {

    public void viewReport(User user) {
        System.out.println("\n===== SCORE REPORT =====");
        System.out.println("User: " + user.getUsername());
        System.out.println("Previous Scores:");

        for (int s : user.getScores()) {
            System.out.println(" → " + s + "/3");
        }
    }
}
