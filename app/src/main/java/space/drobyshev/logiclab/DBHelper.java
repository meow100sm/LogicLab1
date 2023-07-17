package space.drobyshev.logiclab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    public static final String USERS_TABLE = "users";
    public static final String USER_DATA_TABLE = "user_data";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USERS_TABLE + "(name TEXT, email TEXT primary key, password TEXT)");
        db.execSQL("CREATE TABLE " + USER_DATA_TABLE + "(id INTEGER primary key, user_id TEXT, game_data TEXT, score INTEGER, FOREIGN KEY (user_id) REFERENCES " + USERS_TABLE + "(email))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS users_data");
    }

    public Boolean insertData(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("email", email);
        values.put("password", password);

        long result = db.insert(USERS_TABLE, null, values);

        if (result == -1) return false;
        else
            return true;
    }

    public Boolean insertUserData(String email, String gameData, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("user_id", email);
        values.put("game_data", gameData);
        values.put("score", score);

        long result = db.insert(USER_DATA_TABLE, null, values);

        if (result == -1) return false;
        else return true;
    }


    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?", new String[] {email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?", new String[] {email, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}