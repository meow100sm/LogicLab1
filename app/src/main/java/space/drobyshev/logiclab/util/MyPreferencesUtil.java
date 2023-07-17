package space.drobyshev.logiclab.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPreferencesUtil {

    private static SharedPreferences myPreferences;
    private static SharedPreferences.Editor myEditor;

    public static void putBooleanValue(Context context, String key, boolean value) {
        if (myPreferences == null) {
            myPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            myEditor = myPreferences.edit();
        }
        if (myEditor != null) { // Добавить эту проверку
            myEditor.putBoolean(key, value);
            myEditor.apply();
        }
    }

    // Методы для других типов данных можно добавить по аналогии

    public static boolean getBooleanValue(Context context, String key, boolean defaultValue) {
        if (myPreferences == null) {
            myPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return myPreferences.getBoolean(key, defaultValue);
    }
}
