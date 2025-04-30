package com.example.teamproject25;

import android.graphics.*;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.nex3z.fingerpaintview.FingerPaintView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView levelTextView, questionTextView, timerTextView, feedbackTextView;
    private Button submitButton, clearButton;
    private FingerPaintView drawView;

    private MathQuestionGenerator generator;
    private DigitClassifier digitClassifier;
    private CountDownTimer countDownTimer;

    private int currentLevel = 1;
    private int correctAnswers = 0;
    private final int questionsPerLevel = 3;
    private final int timeLimitSeconds = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all views
        levelTextView = findViewById(R.id.levelTextView);
        questionTextView = findViewById(R.id.questionTextView);
        timerTextView = findViewById(R.id.timerTextView);
        feedbackTextView = findViewById(R.id.feedbackTextView);
        submitButton = findViewById(R.id.submitButton);
        drawView = findViewById(R.id.drawView);
        Button clearButton = findViewById(R.id.clearButton);

        try {
            digitClassifier = new DigitClassifier(this);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to load digit classifier.", Toast.LENGTH_LONG).show();
            return;
        }

        startNewLevel();

        submitButton.setOnClickListener(v -> checkDrawnAnswer());
        clearButton.setOnClickListener(v -> drawView.clear());
    }

    private void startNewLevel() {
        correctAnswers = 0;
        levelTextView.setText("Level " + currentLevel);
        nextQuestion();
    }

    private void nextQuestion() {
        drawView.post(() -> drawView.clear());
        generator = new MathQuestionGenerator();
        generator.generateNewQuestion(currentLevel);

        questionTextView.setText(generator.getQuestion());
        feedbackTextView.setText("");

        startTimer();
    }

    private void checkDrawnAnswer() {
        if (countDownTimer != null) countDownTimer.cancel();

        Bitmap drawn = Bitmap.createBitmap(drawView.getMeasuredWidth(),drawView.getMeasuredHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(drawn);
        drawView.draw(canvas);

        int predictedDigit = digitClassifier.classify(drawn);
        int correctAnswer = generator.getCorrectAnswer();
        System.out.println("Predicted: " + predictedDigit + ", Correct: " + correctAnswer);

        if (predictedDigit == correctAnswer) {
            feedbackTextView.setText("Correct!");
            correctAnswers++;

            if (correctAnswers >= questionsPerLevel) {
                currentLevel++;
                if (currentLevel > 3) {
                    endGame("You completed all levels!");
                } else {
                    Toast.makeText(this, "Level Up!", Toast.LENGTH_SHORT).show();
                    startNewLevel();
                }
            } else {
                nextQuestion();
            }
        } else {
            feedbackTextView.setText("Wrong!");
            endGame("Game Over. You must get 3 in a row.");
        }
    }

    private void startTimer() {
        if (countDownTimer != null) countDownTimer.cancel();

        countDownTimer = new CountDownTimer(timeLimitSeconds * 1000L, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                feedbackTextView.setText("Time's up!");
                endGame("You ran out of time!");
            }
        }.start();
    }

    private void endGame(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        submitButton.setEnabled(false);
        clearButton.setEnabled(false);
        if (countDownTimer != null) countDownTimer.cancel();
    }
}
