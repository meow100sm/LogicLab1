package space.drobyshev.logiclab.GameAsteroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import space.drobyshev.logiclab.AccountActivity;
import space.drobyshev.logiclab.R;
import space.drobyshev.logiclab.SettingActivity;

public class GameAsteroidActivity extends AppCompatActivity implements View.OnTouchListener {
    public static boolean isLeftPressed = false; // нажата левая кнопка
    public static boolean isRightPressed = false; // нажата правая кнопка

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_asteroid);
        GameView gameView = new GameView(this); // создаём gameView
        LinearLayout gameLayout = (LinearLayout) findViewById(R.id.gameLayout); // находим gameLayout
        gameLayout.addView(gameView); // и добавляем в него gameView
        Button leftButton = (Button) findViewById(R.id.leftButton); // находим кнопки
        Button rightButton = (Button) findViewById(R.id.rightButton);
        leftButton.setOnTouchListener(this); // и добавляем этот класс как слушателя (при нажатии сработает onTouch)
        rightButton.setOnTouchListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onTouch(View button, MotionEvent motion) {
        if (button.getId() == R.id.leftButton) { // определяем какая кнопка
            switch (motion.getAction()) { // определяем нажата или отпущена
                case MotionEvent.ACTION_DOWN:
                    isLeftPressed = true;
                    break;
                case MotionEvent.ACTION_UP:
                    isLeftPressed = false;
                    break;
            }
        } else {
            switch (motion.getAction()) { // определяем нажата или отпущена
                case MotionEvent.ACTION_DOWN:
                    isRightPressed = true;
                    break;
                case MotionEvent.ACTION_UP:
                    isRightPressed = false;
                    break;
            }
        }
        return true;
    }
}