package com.example.teamproject25;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {

    private MediaPlayer gameOverSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        gameOverSound = MediaPlayer.create(this, R.raw.gameover);
        if (gameOverSound != null) {
            gameOverSound.start();
            gameOverSound.setOnCompletionListener(mp -> {
                mp.release();
                gameOverSound = null;
            });
        }



        Button tryAgainButton = findViewById(R.id.tryAgainButton);
        tryAgainButton.setOnClickListener(v -> {
            // Launch MainGame and finish GameOverActivity
            Intent intent = new Intent(GameOverActivity.this, MainGame.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (gameOverSound != null) {
            gameOverSound.release();
            gameOverSound = null;
        }
    }
}
