package space.drobyshev.logiclab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(email TEXT primary key, password TEXT)");
    }

//    private void CreateAdditionalTable(SQLiteDatabase db)
//    {
//        db.execSQL("DROP TABLE IF EXISTS attention_score");
//        db.execSQL("DROP TABLE IF EXISTS users_score");
//        db.execSQL("DROP TABLE IF EXISTS math_score");
//        db.execSQL("DROP TABLE IF EXISTS memory_score");
//        db.execSQL("DROP TABLE IF EXISTS speed_score");
//
//        db.execSQL("CREATE TABLE attention_score(id INTEGER, username TEXT, score INTEGER)");
//        db.execSQL("CREATE TABLE users_score(id INTEGER, math INTEGER, memory INTEGER, speed INTEGER, attention INTAGER)");
//        db.execSQL("CREATE TABLE math_score(id INTEGER, username TEXT, score INTEGER)");
//        db.execSQL("CREATE TABLE memory_score(id INTEGER, username TEXT, score INTEGER)");
//        db.execSQL("CREATE TABLE speed_score(id INTEGER, username TEXT, score INTEGER)");
//        //db.execSQL("CREATE TABLE sqlite_sequence(name, seq)");
//        //db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, email VARCHAR(50), password VARCHAR(50))");
//        //db.execSQL("CREATE TABLE users_data(nick TEXT, email TEXT, date TEXT, id INTEGER)");
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users");

    }

    public Boolean insertData(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email", email);
        values.put("password", password);

        long result = db.insert("users", null, values);

//        CreateAdditionalTable(db);

        if (result == -1) return false;
        else
            return true;
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