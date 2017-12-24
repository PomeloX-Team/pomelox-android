package com.madlab.poonsak.pomelo_x.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Poonsak on 11/15/2017.
 */

@Dao
public interface PomeloLogDao {
    @Query("SELECT * FROM pomeloLog")
    List<PomeloLog> getAll();

    @Query("SELECT * FROM pomelolog WHERE uid IN (:uids)")
    List<PomeloLog> loadAllByuIds(int[] uids);

//    @Insert
//    void insertAll(PomeloLog... pomeloLogs);

    @Insert
    void insert(PomeloLog pomeloLog);

    @Delete
    void delete(PomeloLog pomeloLog);
}
