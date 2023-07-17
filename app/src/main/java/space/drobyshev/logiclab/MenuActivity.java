package space.drobyshev.logiclab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import space.drobyshev.logiclab.GameAsteroid.GameAsteroidActivity;
import space.drobyshev.logiclab.GameBall.GameBallActivity;
import space.drobyshev.logiclab.GameMath.MathGameActivity;
import space.drobyshev.logiclab.GameMemory.MemoryGame;
import space.drobyshev.logiclab.GamePlusMinus.PlusMinusGameActivity;
import space.drobyshev.logiclab.util.MyPreferencesUtil;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuu);


        boolean game1 = MyPreferencesUtil.getBooleanValue(this, "GAME1", false);
        boolean game2 = MyPreferencesUtil.getBooleanValue(this, "GAME2", false);
        boolean game3 = MyPreferencesUtil.getBooleanValue(this, "GAME3", false);
        boolean game4 = MyPreferencesUtil.getBooleanValue(this, "GAME4", false);
        boolean game5 = MyPreferencesUtil.getBooleanValue(this, "GAME5", false);


        if (game1 == true){
            ImageView complete1 = findViewById(R.id.complete_game1);
            complete1.setVisibility(View.VISIBLE);
            Log.d("Test","" + game1);
        }

        if (game2 == true){
            ImageView complete2 = findViewById(R.id.complete_game2);
            complete2.setVisibility(View.VISIBLE);
            Log.d("Test","" + game2);
        }

        if (game3 == true){
            ImageView complete3 = findViewById(R.id.complete_game3);
            complete3.setVisibility(View.VISIBLE);
            Log.d("Test","" + game3);
        }

        if (game4 == true){
            ImageView complete4 = findViewById(R.id.complete_game4);
            complete4.setVisibility(View.VISIBLE);
            Log.d("Test","" + game4);
        }

        if (game5 == true){
            ImageView complete5 = findViewById(R.id.complete_game5);
            complete5.setVisibility(View.VISIBLE);
            Log.d("Test","" + game5);
        }



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

        Button game_ball = findViewById(R.id.game_ball);
        game_ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameBallActivity();
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

    public void openGameBallActivity() {
        Intent intent = new Intent(this, GameBallActivity.class);
        startActivity(intent);
    }



}