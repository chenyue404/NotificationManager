package com.chenyue404.notificationmanager.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.chenyue404.notificationmanager.MyApp;

public class ViewUtils {
    private static long lastClickTime = 0;

    public synchronized static boolean isFastClick() {
        long curTime = System.currentTimeMillis();
        long timeSpace = curTime - lastClickTime;
        if (timeSpace < 400 && timeSpace > 0) {
            return true;
        }
        lastClickTime = curTime;
        return false;
    }

    public static int getInteger(int resId) {
        Resources res = MyApp.getInstance().getResources();
        return res.getInteger(resId);
    }

    public static String getString(int resId) {
        Resources res = MyApp.getInstance().getResources();
        return res.getString(resId);
    }

    public static String[] getStringArray(int resId) {
        Resources res = MyApp.getInstance().getResources();
        return res.getStringArray(resId);
    }

    public static String getString(int resId, Object... items) {
        Resources res = MyApp.getInstance().getResources();
        return String.format(res.getString(resId), items);
    }

    public static int getColor(int resId) {
        return ContextCompat.getColor(MyApp.getInstance(), resId);
    }


    public static Drawable getDrawable(int resId) {
        return ContextCompat.getDrawable(MyApp.getInstance(), resId);
    }

    public static int getDimensionPixelSize(int resId) {
        return MyApp.getInstance().getResources().getDimensionPixelSize(resId);
    }
}
