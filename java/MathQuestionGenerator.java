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
                int form = random.nextInt(3); // choose between different forms of equation
                int x;

                switch (form) {
                    case 0:
                        // Form: X + a = b
                        x = random.nextInt(10);
                        a = random.nextInt(10);
                        b = x + a;
                        currentQuestion = "X + " + a + " = " + b;
                        correctAnswer = x;
                        break;
                    case 1:
                        // Form: a + X = b
                        x = random.nextInt(10);
                        a = random.nextInt(10);
                        b = a + x;
                        currentQuestion = a + " + X = " + b;
                        correctAnswer = x;
                        break;
                    case 2:
                        // Form: X - a = b
                        x = random.nextInt(10) + 5; // ensure x >= a
                        a = random.nextInt(x); // a < x
                        b = x - a;
                        currentQuestion = "X - " + a + " = " + b;
                        correctAnswer = x;
                        break;
                }
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
