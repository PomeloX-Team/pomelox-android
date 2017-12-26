package com.madlab.poonsak.pomelo_x.manager.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Poonsak on 11/15/2017.
 */

@Database(entities = {PomeloLog.class}, version = 1)
public abstract class PomeloLogDb extends RoomDatabase {
    private static PomeloLogDb INSTANCE;

    public abstract PomeloLogDao pomeloLogDao();

    public static PomeloLogDb getPomeloLogDb(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(), PomeloLogDb.class,
                    "pomelo-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
