package space.drobyshev.logiclab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import space.drobyshev.logiclab.GameAsteroid.GameAsteroidActivity;
import space.drobyshev.logiclab.GameMath.MathGameActivity;
import space.drobyshev.logiclab.GameMemory.MemoryGame;
import space.drobyshev.logiclab.GamePlusMinus.PlusMinusGameActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button memory_game = findViewById(R.id.memory_game);
        memory_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMemoryGameActivity();
            }
        });

        Button math_game = findViewById(R.id.math_game);
        math_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMathGameActivity();
            }
        });

        Button plusminus_game = findViewById(R.id.plusminus_game);
        plusminus_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlusMinusGameActivity();
            }
        });

        Button asteroid_game = findViewById(R.id.asteroid_game);
        asteroid_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameAsteroidActivity();
            }
        });
    }
    public void openMemoryGameActivity() {
        Intent intent = new Intent(this, MemoryGame.class);
        startActivity(intent);
    }

    public void openMathGameActivity() {
        Intent intent = new Intent(this, MathGameActivity.class);
        startActivity(intent);
    }
    public void openPlusMinusGameActivity() {
        Intent intent = new Intent(this, PlusMinusGameActivity.class);
        startActivity(intent);
    }

    public void openGameAsteroidActivity() {
        Intent intent = new Intent(this, GameAsteroidActivity.class);
        startActivity(intent);
    }


}