import java.util.Random;

public class MathQuestionGenerator {

    private Random random;
    private String currentQuestion;
    private int correctAnswer;

    public MathQuestionGenerator() {
        random = new Random();
    }

    public void generateNewQuestion(int level) {
        int a = random.nextInt(10); // Random number 0–9
        int b = random.nextInt(10);
        int c = random.nextInt(10); // Only needed for Level 3

        if (level == 1) {
            // Level 1: Only addition or subtraction
            int operation = random.nextInt(2); // 0 or 1
            if (operation == 0) {
                currentQuestion = a + " + " + b;
                correctAnswer = a + b;
            } else {
                // Make sure no negative result
                if (a < b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                currentQuestion = a + " - " + b;
                correctAnswer = a - b;
            }
        } else if (level == 2) {
            // Level 2: Only multiplication
            currentQuestion = a + " x " + b;
            correctAnswer = a * b;
        } else if (level == 3) {
            // Level 3: Combination (+ and -)
            int firstOp = random.nextInt(2); // 0 = +, 1 = -
            int secondOp = random.nextInt(2);

            String operator1 = (firstOp == 0) ? "+" : "-";
            String operator2 = (secondOp == 0) ? "+" : "-";

            currentQuestion = a + " " + operator1 + " " + b + " " + operator2 + " " + c;

            int tempAnswer;
            if (firstOp == 0) {
                tempAnswer = a + b;
            } else {
                tempAnswer = a - b;
            }

            if (secondOp == 0) {
                correctAnswer = tempAnswer + c;
            } else {
                correctAnswer = tempAnswer - c;
            }
        }
    }

    public String getQuestion() {
        return currentQuestion;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
