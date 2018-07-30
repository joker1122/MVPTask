package com.example.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.greendaodemo.db.DaoMaster;
import com.greendaodemo.db.DaoSession;
import com.greendaodemo.db.MasterDao;
import com.greendaodemo.db.TaskDao;
import com.greendaodemo.db.UserDao;


public class GreenDAO extends Application {
    private static final String DATABASE_NAME = "task.db";

    public GreenDAO() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DATABASE_NAME);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        DaoSession session = master.newSession();
        UserDao userDao = session.getUserDao();
        MasterDao masterDao = session.getMasterDao();
        TaskDao taskDao = session.getTaskDao();
    }
}
