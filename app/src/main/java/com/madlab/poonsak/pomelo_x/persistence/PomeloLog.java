package com.madlab.poonsak.pomelo_x.persistence;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by Poonsak on 11/15/2017.
 */

@Entity
public class PomeloLog {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String capture_date;
//    private String ripe_date;
    private String path;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCapture_date() {
        return capture_date;
    }

    public void setCapture_date(String capture_date) {
        this.capture_date = capture_date;
    }

//    public String getRipeDate() {
//        return this.ripe_date;
//    }
//
//    public void setRipe_date(String ripe_date) {
//        this.ripe_date = ripe_date;
//    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
