package com.shoshore.agentservice.utils.enums;

public enum UserStatus {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    private String userStatus;

    UserStatus (String userStatus){
        this.userStatus = userStatus;
    }

    public String getUserStatus() {
        return userStatus;
    }
}
