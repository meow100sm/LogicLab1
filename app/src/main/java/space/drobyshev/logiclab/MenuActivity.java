package space.drobyshev.logiclab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
    public void openMemoryGameActivity() {
        Intent intent = new Intent(this, MemoryGame.class);
        startActivity(intent);
    }

    public void openMathGameActivity() {
        Intent intent = new Intent(this, MathGameActivity.class);
        startActivity(intent);
    }


}