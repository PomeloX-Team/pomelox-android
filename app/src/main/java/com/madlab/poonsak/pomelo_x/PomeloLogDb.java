package com.madlab.poonsak.pomelo_x;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Poonsak on 11/15/2017.
 */

@Database(entities = {PomeloLog.class}, version = 1)
public abstract class PomeloLogDb extends RoomDatabase {
    public abstract PomeloLogDao pomeloLogDao();
}
