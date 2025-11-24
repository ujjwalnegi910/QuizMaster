package services;

import models.Question;
import java.util.Scanner;

public class QuizEngine {
    private Question[] questions;

    public QuizEngine() {
        loadQuestions();
    }

    public void loadQuestions() {
        questions = new Question[] {
            new Question("What is the capital of India?",
                new String[]{"Delhi", "Mumbai", "Chennai", "Kolkata"}, 1),

            new Question("Java is ___?",
                new String[]{"Compiled", "Interpreted", "Both", "None"}, 3),

            new Question("Which keyword creates an object?",
                new String[]{"this", "class", "new", "object"}, 3)
        };
    }

    public int startQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("\n===== QUIZ STARTED =====");

        for (Question q : questions) {
            q.display();
            System.out.print("Your answer: ");
            int ans = sc.nextInt();

            if (q.isCorrect(ans)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong!\n");
            }
        }

        System.out.println("Quiz Completed! Your score: " + score);
        return score;
    }
}
