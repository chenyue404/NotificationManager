package com.chenyue404.notificationmanager.bean;

import java.util.ArrayList;

public class RuleBean {

    private String name;
    private boolean allApp = false;
    private boolean live = false;
    ArrayList<String> blackList;
    ArrayList<String> keyWordList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAllApp() {
        return allApp;
    }

    public void setAllApp(boolean allApp) {
        this.allApp = allApp;
    }

    public ArrayList<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(ArrayList<String> blackList) {
        this.blackList = blackList;
    }

    public ArrayList<String> getKeyWordList() {
        return keyWordList;
    }

    public void setKeyWordList(ArrayList<String> keyWordList) {
        this.keyWordList = keyWordList;
    }


    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
