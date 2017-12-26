package com.madlab.poonsak.pomelo_x

import android.app.Application
import com.inthecheesefactory.thecheeselibrary.manager.Contextor

import com.madlab.poonsak.pomelo_x.activity.MainActivity

/**
 * Created by Poonsak on 12/25/2017.
 */

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Contextor.getInstance().init(applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}
