package com.chenyue404.notificationmanager.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    public static String getAppName(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        String Name;
        try {
            Name = pm.getApplicationLabel(pm.getApplicationInfo(packageName, PackageManager.GET_META_DATA)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            Name = "";
        }
        return Name;
    }

    public static Drawable getAppIcon(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            return pm.getApplicationIcon(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return ContextCompat.getDrawable(context, android.R.drawable.sym_def_app_icon);
        }
    }

    public List<ApplicationInfo> getInstallAppInfo(Context mContext) {
        PackageManager mypm = mContext.getPackageManager();
        List<ApplicationInfo> appInfoList = mypm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        Collections.sort(appInfoList, new ApplicationInfo.DisplayNameComparator(mypm));// 排序
        return appInfoList;
    }

}
