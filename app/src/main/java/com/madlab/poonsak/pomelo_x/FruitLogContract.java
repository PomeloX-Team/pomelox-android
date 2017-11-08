package com.madlab.poonsak.pomelo_x;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Poonsak on 11/1/2017.
 */

public final class FruitLogContract {
    public FruitLogContract(){}

    public static class FruitLog implements BaseColumns {
        public static final String TABLE_NAME = "pomelo_log";
        public static final String COLUMN_NAME_PATH = "path";
        public static final String COLUMN_NAME_DATE = "date";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FruitLog.TABLE_NAME + " (" +
                    FruitLog._ID + " INTEGER PRIMARY KEY," +
                    FruitLog.COLUMN_NAME_PATH + " TEXT," +
                    FruitLog.COLUMN_NAME_DATE + " DATE)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FruitLog.TABLE_NAME;
}
