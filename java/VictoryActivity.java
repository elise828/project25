package com.example.teamproject25;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teamproject25.MainGame;
import com.example.teamproject25.R;

public class VictoryActivity extends AppCompatActivity {

    private MediaPlayer victorySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victory_screen);

        victorySound = MediaPlayer.create(this, R.raw.victory);
        if (victorySound != null) {
            victorySound.setOnPreparedListener(mp -> mp.start());
            victorySound.setOnCompletionListener(mp -> {
                mp.release();
                victorySound = null;
            });
        }

        Button tryAgainButton = findViewById(R.id.tryAgainButton);
        tryAgainButton.setOnClickListener(v -> {
            // Launch MainGame and finish GameOverActivity
            Intent intent = new Intent(VictoryActivity.this, MainGame.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(VictoryActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }

@Override
    protected void onDestroy() {
        super.onDestroy();
        if (victorySound != null) {
            victorySound.release();
            victorySound = null;
        }
    }
}
