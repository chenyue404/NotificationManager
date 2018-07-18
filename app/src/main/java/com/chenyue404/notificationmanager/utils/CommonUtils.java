package com.chenyue404.notificationmanager.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static boolean checkNotificationReadPermission(Activity activity) {
        String notiStr = Settings.Secure.getString(activity.getContentResolver(), "enabled_notification_listeners");
        if (notiStr != null && !TextUtils.isEmpty(notiStr)) {
            final String[] names = notiStr.split(":");
            for (String name : names) {
                ComponentName cn = ComponentName.unflattenFromString(name);
                if (cn != null) {
                    if (activity.getPackageName().equals(cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String getTimeStr(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return format.format(date);
    }

    public static String getApplicationNameByPackageName(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        String Name;
        try {
            Name = pm.getApplicationLabel(pm.getApplicationInfo(packageName, PackageManager.GET_META_DATA)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            Name = "";
        }
        return Name;
    }

}
