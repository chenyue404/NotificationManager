package com.chenyue404.notificationmanager.bean;

import android.app.Notification;

import com.chenyue404.notificationmanager.utils.ParcelableUtil;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.converter.PropertyConverter;

import org.greenrobot.greendao.annotation.Generated;


@Entity
public class NotificationBean {
    @Id(autoincrement = true)
    private Long id;
    private Long postTime;
    private String title, text;

    @Generated(hash = 2091058283)
    public NotificationBean(Long id, Long postTime, String title, String text) {
        this.id = id;
        this.postTime = postTime;
        this.title = title;
        this.text = text;
    }

    @Generated(hash = 1804399548)
    public NotificationBean() {
    }

    public Long getPostTime() {
        return postTime;
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
