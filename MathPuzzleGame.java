import java.util.Scanner;

public class MathPuzzleGame {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Math Puzzle Challenge!");

        int currentLevel = 1;
        boolean gameActive = true;

        while (gameActive) {
            System.out.println("\n--- Level " + currentLevel + " ---");
            boolean passedLevel = playLevel(currentLevel);

            if (passedLevel) {
                currentLevel++;
                if (currentLevel > 3) {
                    System.out.println("\n🏆 Congratulations! You completed all levels!");
                    gameActive = false;
                } else {
                    System.out.println("\n✅ Level passed! Moving to Level " + currentLevel);
                }
            } else {
                System.out.println("\n❌ Time's up or wrong answer. Game Over!");
                gameActive = false;
            }
        }
        System.out.println("Thanks for playing!");
    }

    public static boolean playLevel(int level) {
        int questionsToPass = 3;
        int correctAnswers = 0;
        int timeLimitSeconds = 30;

        for (int i = 0; i < questionsToPass; i++) {
            MathQuestionGenerator generator = new MathQuestionGenerator();
            generator.generateNewQuestion(level);

            System.out.println("\nSolve: " + generator.getQuestion());
            System.out.println("(You have " + timeLimitSeconds + " seconds)");

            long startTime = System.currentTimeMillis();

            int userAnswer = scanner.nextInt();

            long endTime = System.currentTimeMillis();
            long timeTakenSeconds = (endTime - startTime) / 1000;

            if (timeTakenSeconds > timeLimitSeconds) {
                System.out.println("⏰ You took too long! (" + timeTakenSeconds + " seconds)");
                return false;
            }

            if (userAnswer == generator.getCorrectAnswer()) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Wrong answer. Correct was: " + generator.getCorrectAnswer());
                return false;
            }
        }
        return true; // Level passed
    }
}
