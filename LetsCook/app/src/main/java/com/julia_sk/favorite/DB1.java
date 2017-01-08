package com.julia_sk.favorite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Random;

/**
 * Created by Test on 20.12.2016.
 */
public class DB1 {
    private static final String DB_NAME = "DB_Recipes";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "table_Recipes";

    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_RECIPETEXT = "recipeText";
    public static final String KEY_COMPLEXITY = "complexity";
    public static final String KEY_COOKINGTIMEMIN = "cookingTime";
    public static final String KEY_PRODUCTS = "products";

    private static final String DB_CREATE = "create table " + DB_TABLE + "(" + KEY_ID + " integer primary key autoincrement, " + KEY_TITLE + " text, " +
            KEY_RECIPETEXT + " text, " + KEY_COMPLEXITY + " text, " + KEY_COOKINGTIMEMIN + " text, " + KEY_PRODUCTS + " text" + ");";

    private final Context mCtx;

    private DBHelper mDBHelper;
    public SQLiteDatabase mDB;

    public DB1(Context ctx) {
        mCtx = ctx;
    }



    public void open() {
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    public void close() {
        if (mDBHelper!=null) mDBHelper.close();
    }

    public Cursor getAllData() {
        return mDB.query(DB_TABLE, null, null, null, null, null, null);
    }

    public void addRec(SQLiteDatabase db, ContentValues cv, String txt, String txt2, String txt3, String txt4, String txt5) {
        cv.put(KEY_TITLE, txt);
        cv.put(KEY_RECIPETEXT, txt2);
        cv.put(KEY_COMPLEXITY, txt3);
        cv.put(KEY_COOKINGTIMEMIN, txt4);
        cv.put(KEY_PRODUCTS, txt5);
        db.insert(DB_TABLE, null, cv);
    }

    public Cursor rawQuery(String query) {
        return mDB.rawQuery(query, null);
    }

    public Cursor getRandom() {
        Random random = new Random();
        Integer randomNumber = random.nextInt(4);
        String position = Integer.toString(randomNumber);
        return mDB.query(DB_TABLE, null, null, null, null, null, null, position + ",1");
    }

    public Cursor getANDFilter(String[] filter) {
        String select = KEY_PRODUCTS + " LIKE '%" + filter[0] + "%'" ;
        for (int i=1;i<filter.length;i++)
        {
            select= select + (" AND " + KEY_PRODUCTS + " LIKE " + "'%" + filter[i] + "%'");

        }
        Log.d("log",select);
        return mDB.query(true, DB_TABLE, null,
                select, null, null, null, null, null);
    }

    public Cursor getORFilter(String[] filter) {
        String select = KEY_PRODUCTS + " LIKE '%" + filter[0] + "%'" ;
        for (int i=1;i<filter.length;i++)
        {
            select= select + (" OR " + KEY_PRODUCTS + " LIKE " + "'%" + filter[i] + "%'");

        }
        Log.d("log",select);
        return mDB.query(true, DB_TABLE, null,
                select, null, null, null, null, null);
    }
//return mDB.query(true, DB_TABLE, new String[] { KEY_ID,KEY_TITLE, KEY_RECIPETEXT },
//    KEY_PRODUCTS + " LIKE '%картошка%'" + " AND " + KEY_PRODUCTS + " LIKE '%мясо%' ", null, null, null, null, null);
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);
            ContentValues cv = new ContentValues();

            String title = "Суп";
            String recipe = "Варить суп, пока не приготовится";
            String complexity = "Сложность: 6/10";
            String time = "50 минут";
            String products = "картошка, мясо, макароны";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Борщ";
            recipe = "Варить борщ, пока не приготовится";
            complexity = "Сложность: 6/10";
            time = "50 минут";
            products = "картошка, мясо, капуста";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Жареная рыбы";
            recipe = "Жарить рыбу, пока не приготовится";
            complexity = "Сложность: 4/10";
            time = "20 минут";
            products = "рыба";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Макароны по-флотски";
            recipe = "Сварить макароны, пожарить фарш с томатной пастой, все смешать";
            complexity = "Сложность: 6/10";
            time = "30 минут";
            products = "макароны, мясо, томатная паста";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Голубцы";
            recipe = "Завернуть фарш в капусту, жарить до готовности";
            complexity = "Сложность: 8/10";
            time = "40 минут";
            products = "мясо, капуста";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Паста";
            recipe = "Сварить макароны, сделать соус из томатной пасты и сыра, смешать соус с макаронами";
            complexity = "Сложность: 5/10";
            time = "35 минут";
            products = "макароны, томатная паста, сыр";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Бичпакет";
            recipe = "Приготовить бичпакет по инструкции";
            complexity = "Сложность: 1/10";
            time = "10 минут";
            products = "бичпакет";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Жареные яйца";
            recipe = "Пожарить яйца";
            complexity = "Сложность: 2/10";
            time = "5 минут";
            products = "яйцо";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Омлет";
            recipe = "Взбить яйца с молоком, пожарить на сковороде";
            complexity = "Сложность: 2/10";
            time = "5 минут";
            products = "яйцо, молоко";
            addRec(db, cv, title, recipe, complexity, time, products);

            title = "Салат летний";
            recipe = "Нарезать помидоры, огурцы, смешать все со сметаной";
            complexity = "Сложность: 2/10";
            time = "5 минут";
            products = "помидор, огурец, сметана";
            addRec(db, cv, title, recipe, complexity, time, products);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
