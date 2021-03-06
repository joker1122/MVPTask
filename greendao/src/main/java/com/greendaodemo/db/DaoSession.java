package com.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.greendao.bean.Master;
import com.example.greendao.bean.Task;
import com.example.greendao.bean.User;

import com.greendaodemo.db.MasterDao;
import com.greendaodemo.db.TaskDao;
import com.greendaodemo.db.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig masterDaoConfig;
    private final DaoConfig taskDaoConfig;
    private final DaoConfig userDaoConfig;

    private final MasterDao masterDao;
    private final TaskDao taskDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        masterDaoConfig = daoConfigMap.get(MasterDao.class).clone();
        masterDaoConfig.initIdentityScope(type);

        taskDaoConfig = daoConfigMap.get(TaskDao.class).clone();
        taskDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        masterDao = new MasterDao(masterDaoConfig, this);
        taskDao = new TaskDao(taskDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Master.class, masterDao);
        registerDao(Task.class, taskDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        masterDaoConfig.clearIdentityScope();
        taskDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public MasterDao getMasterDao() {
        return masterDao;
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
