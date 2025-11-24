import java.util.Scanner;
import services.*;
import models.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        QuizEngine quizEngine = new QuizEngine();
        ReportManager reportManager = new ReportManager();

        User currentUser = null;

        while (true) {
            System.out.println("\n===== QUIZMASTER =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    currentUser = userService.register();
                    break;
                case 2:
                    currentUser = userService.login();
                    break;
                case 3:
                    System.out.println("Thank you for using QuizMaster!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if (currentUser != null) {
                System.out.println("Welcome " + currentUser.getUsername() + "!");

                boolean loggedIn = true;

                while (loggedIn) {
                    System.out.println("\n==== Main Menu ====");
                    System.out.println("1. Start Quiz");
                    System.out.println("2. View Report");
                    System.out.println("3. Logout");
                    System.out.print("Choose: ");
                    int option = sc.nextInt();

                    switch (option) {
                        case 1:
                            int score = quizEngine.startQuiz();
                            currentUser.addScore(score);
                            break;

                        case 2:
                            reportManager.viewReport(currentUser);
                            break;

                        case 3:
                            loggedIn = false;
                            System.out.println("Logged out.");
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            }
        }
    }
}
