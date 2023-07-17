package space.drobyshev.logiclab.GameAsteroid;

import android.content.Context;

import space.drobyshev.logiclab.R;

public class Ship extends SpaceBody {
    public Ship(Context context) {
        bitmapId = R.drawable.ship; // определяем начальные параметры
        size = 5;
        x=7;
        y= GameView.maxY - size - 1;
        speed = (float) 0.2;

        init(context); // инициализируем корабль
    }

    @Override
    public void update() { // перемещаем корабль в зависимости от нажатой кнопки
        if(GameAsteroidActivity.isLeftPressed && x >= 0){
            x -= speed;
        }
        if(GameAsteroidActivity.isRightPressed && x <= GameView.maxX - 5){
            x += speed;
        }
    }
}