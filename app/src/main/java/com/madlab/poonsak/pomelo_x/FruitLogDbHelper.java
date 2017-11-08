package com.madlab.poonsak.pomelo_x;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Poonsak on 11/7/2017.
 */

public class FruitLogDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FruitLog.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FruitLogContract.FruitLog.TABLE_NAME + " (" +
                    FruitLogContract.FruitLog._ID + " INTEGER PRIMARY KEY," +
                    FruitLogContract.FruitLog.COLUMN_NAME_PATH + " TEXT," +
                    FruitLogContract.FruitLog.COLUMN_NAME_DATE + " DATE)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FruitLogContract.FruitLog.TABLE_NAME;

    public FruitLogDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
