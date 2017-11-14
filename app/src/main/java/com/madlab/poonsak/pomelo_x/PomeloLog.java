package com.madlab.poonsak.pomelo_x;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by Poonsak on 11/15/2017.
 */

@Entity
public class PomeloLog {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo
    private String capture_date;

    @ColumnInfo
    private String ripe_date;

    @ColumnInfo
    private String path;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRipe_date() {
        return ripe_date;
    }

    public void setRipe_date(String date) {
        ripe_date = date;
    }

    public String getCapture_date() {
        return capture_date;
    }

    public void setCapture_date(String date) {
        capture_date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
