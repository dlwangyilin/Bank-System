package com.et.user;

public class ActionUser {

    private int userId;
    private double deltaVal;

    public ActionUser() {}

    public ActionUser (int userId) {
        this.userId = userId;
        this.deltaVal = 0;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getDeltaVal() {
        return deltaVal;
    }

    public void setDeltaVal(double deltaVal) {
        this.deltaVal = deltaVal;
    }
}
