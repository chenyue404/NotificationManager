package com.chenyue404.notificationmanager.service;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.chenyue404.notificationmanager.MyApp;
import com.chenyue404.notificationmanager.bean.NotificationBean;
import com.chenyue404.notificationmanager.greendao.DaoSession;
import com.chenyue404.notificationmanager.greendao.NotificationBeanDao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressLint("OverrideAbstract")
public class NotificationListenerService extends android.service.notification.NotificationListenerService {

    private static final String TAG = "NLS";

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        Notification notification = sbn.getNotification();

        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            cancelNotification(sbn.getKey());
        } else {
            cancelNotification(sbn.getPackageName(), sbn.getTag(), sbn.getId());
        }

        MyApp myApp = (MyApp) getApplication();
        DaoSession daoSession = myApp.getDaoSession();
        NotificationBeanDao notificationBeanDao = daoSession.getNotificationBeanDao();

        NotificationBean notificationBean = new NotificationBean();
        notificationBean.setPostTime(sbn.getPostTime());
        String title = notification.extras.getString(Notification.EXTRA_TITLE);
        String text = notification.extras.getString(Notification.EXTRA_TEXT);
        String packageName = sbn.getPackageName();
        notificationBean.setText(text);
        notificationBean.setTitle(title);
        notificationBean.setPackageName(packageName);

        notificationBeanDao.insert(notificationBean);
    }

    public Intent getIntent(PendingIntent pendingIntent) throws IllegalStateException {
        try {
            Method getIntent = PendingIntent.class.getDeclaredMethod("getIntent", new Class[0]);
            getIntent.setAccessible(true);
//            return (Intent) getIntent.invoke(pendingIntent, null);
            return (Intent) getIntent.invoke(pendingIntent);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

}
