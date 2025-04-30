package com.example.teamproject25;

import java.util.Random;

public class MathQuestionGenerator {

    private Random random;
    private String currentQuestion;
    private int correctAnswer;

    public MathQuestionGenerator() {
        random = new Random();
    }

    public void generateNewQuestion(int level) {
        do {

            int a = random.nextInt(10); // 0–9
            int b = random.nextInt(10);
            int c = random.nextInt(10);

            if (level == 1) {
                int operation = random.nextInt(2); // 0 = +, 1 = -
                if (operation == 0) {
                    currentQuestion = a + " + " + b;
                    correctAnswer = a + b;
                } else {
                    if (a < b) {
                        int temp = a;
                        a = b;
                        b = temp;
                    }
                    currentQuestion = a + " - " + b;
                    correctAnswer = a - b;
                }
            } else if (level == 2) {
                currentQuestion = a + " x " + b;
                correctAnswer = a * b;
            } else if (level == 3) {
                int firstOp = random.nextInt(2); // 0 = +, 1 = -
                int secondOp = random.nextInt(2);
                String operator1 = (firstOp == 0) ? "+" : "-";
                String operator2 = (secondOp == 0) ? "+" : "-";

                currentQuestion = a + " " + operator1 + " " + b + " " + operator2 + " " + c;

                int temp = (firstOp == 0) ? a + b : a - b;
                correctAnswer = (secondOp == 0) ? temp + c : temp - c;
            }
        } while (correctAnswer < 0 || correctAnswer > 9);
    }

    public String getQuestion() {
        return currentQuestion;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
