package com.et.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ActionUser {

    private int userId;
    @NotNull
    @Pattern(regexp = "(0\\.[0-9]{1,2})|([1-9][0-9]*\\.[0-9]{1,2})|([1-9][0-9]*)", message = "Need double input without leading zeros")
    private String deltaVal;

    public ActionUser() {}

    public ActionUser (int userId) {
        this.userId = userId;
        this.deltaVal = "0";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeltaVal() {
        return deltaVal;
    }

    public void setDeltaVal(String deltaVal) {
        this.deltaVal = deltaVal;
    }
}
