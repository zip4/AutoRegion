package com.kovalenko.paul.autoregion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pashulya on 22.05.2016.
 */
public class DB {

    public static final int[] regionsImageArray = new int[] {
            R.drawable.ak, R.drawable.ab, R.drawable.ac, R.drawable.ae, R.drawable.ah,
            R.drawable.am, R.drawable.ao, R.drawable.ap, R.drawable.at, R.drawable.ai,
            R.drawable.ba, R.drawable.bb, R.drawable.bc, R.drawable.be, R.drawable.bh,
            R.drawable.bi, R.drawable.bk, R.drawable.bm, R.drawable.bo, R.drawable.ax,
            R.drawable.bt, R.drawable.bx, R.drawable.ca, R.drawable.cb, R.drawable.ce,
            R.drawable.aa, R.drawable.ch
    };

    public static final int[] regionsMapArray = new int[]{
            R.drawable.crimea, R.drawable.vinnytsia, R.drawable.volyn,
            R.drawable.dnipropetrovsk, R.drawable.donetsk, R.drawable.zhytomyr,
            R.drawable.zakarpattia, R.drawable.zaporizhia, R.drawable.ivanofrankivsk,
            R.drawable.kievska, R.drawable.kirovohrad, R.drawable.luhansk, R.drawable.lviv,
            R.drawable.mykolaiv, R.drawable.odessa, R.drawable.poltava, R.drawable.rivne,
            R.drawable.sumy, R.drawable.ternopil, R.drawable.kharkiv, R.drawable.kherson,
            R.drawable.khmelnytskyi, R.drawable.cherkasy, R.drawable.chernihiv,
            R.drawable.chernivtsi, R.drawable.kyiv, R.drawable.sevastopol
    };

    public static final String[] regions = {
            "Автономна республіка Крим", "Вінницька область", "Волинська область",
            "Дніпропетровська область", "Донецька область", "Житомирська область",
            "Закарпатська область", "Запорізька область", "Івано-Франківська область",
            "Київська область", "Кіровоградська область", "Луганська область",
            "Львівська область", "Миколаївська область", "Одеська область",
            "Полтавська область", "Рівненська область", "Сумська область",
            "Тернопільська область", "Харківська область", "Херсонська область",
            "Хмельницька область", "Черкаська область", "Чернігівська область",
            "Чернівецька область", "місто Київ", "місто Севастополь"
    };

    private static final String DB_NAME = "mydb";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "mytab";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IMG_LOGO = "imgReg";
    public static final String COLUMN_IMG_MAP = "imgMap";
    public static final String COLUMN_REGION = "region";

    private static final String DB_CREATE =
            "create table " + DB_TABLE + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_IMG_LOGO + " integer, " +
                    COLUMN_IMG_MAP + " integer, " +
                    COLUMN_REGION + " text" +
                    ");";

    private final Context mCtx;


    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx) {
        mCtx = ctx;
    }

    // открыть подключение
    public void open() {
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    // закрыть подключение
    public void close() {
        if (mDBHelper != null) mDBHelper.close();
    }

    // получить все данные из таблицы DB_TABLE
    public Cursor getAllData() {
        return mDB.query(DB_TABLE, null, null, null, null, null, null);
    }

    // добавить запись в DB_TABLE
    public void addRec(String txt, int imgLogo, int imgMap) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_REGION, txt);
        cv.put(COLUMN_IMG_LOGO, imgLogo);
        cv.put(COLUMN_IMG_MAP, imgMap);
        mDB.insert(DB_TABLE, null, cv);
    }

    // удалить запись из DB_TABLE
    public void delRec(long id) {
        mDB.delete(DB_TABLE, COLUMN_ID + " = " + id, null);
    }

    // класс по созданию и управлению БД
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);

            ContentValues cv = new ContentValues();
            for (int i = 0; i < regions.length; i++) {
                cv.put(COLUMN_REGION, regions[i]);
                cv.put(COLUMN_IMG_LOGO, regionsImageArray[i]);
                cv.put(COLUMN_IMG_MAP, regionsMapArray[i]);
                db.insert(DB_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
