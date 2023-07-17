package space.drobyshev.logiclab.GamePlusMinus;

import android.content.Context;
import android.util.AttributeSet;

public class MyButton extends androidx.appcompat.widget.AppCompatButton {

    private MyOnClickListener mClickListener;//наш интерфейс учета кликов для PlusMinusGameActivity
    int idX = 0;
    int idY = 0;

    //конструктор, в котором будем задавать координаты кнопки в матрице
    public MyButton(Context context, int x, int y) {
        super(context);
        idX = x;
        idY = y;
    }

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override //метод View для отлавливания кликов
    public boolean performClick() {
        super.performClick();

        mClickListener.OnTouchDigit(this);//будем дергать метод интерфейса
        return true;
    }

    public void setOnClickListener(MyOnClickListener listener){
        mClickListener = listener;
    }

    public int getIdX(){
        return idX;
    }

    public int getIdY(){
        return idY;
    }


    //Интерфейс для PlusMinusGameActivity
    //************************************
    public interface MyOnClickListener {
        void OnTouchDigit(MyButton v);
    }
}