package com.chenyue404.notificationmanager;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.chenyue404.notificationmanager.greendao.DaoMaster;
import com.chenyue404.notificationmanager.greendao.DaoSession;

public class MyApp extends Application {

    private Context mContext;
    private DaoSession daoSession;
    private static MyApp sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notificationManager.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        this.daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static MyApp getInstance() {
        return sInstance;
    }

}
