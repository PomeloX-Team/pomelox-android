package com.madlab.poonsak.pomelo_x;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Poonsak on 11/1/2017.
 */

public final class FruitLogContract {
    private FruitLogContract(){}
    FruitLogDbHelper fruitLogDbHelper;
    public static class FruitLog implements BaseColumns {
        public static final String TABLE_NAME = "pomelo_log";
        public static final String COLUMN_NAME_PATH = "path";
        public static final String COLUMN_NAME_DATE = "date";
    }

}
