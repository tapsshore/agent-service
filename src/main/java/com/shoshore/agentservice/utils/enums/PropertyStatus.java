package com.shoshore.agentservice.utils.enums;

public enum PropertyStatus {
    VACANT("VACANT"), TAKEN("TAKEN");

    private String propertyStatus;

    PropertyStatus(String propertyStatus){
        this.propertyStatus = propertyStatus;
    }
    public String getPropertyStatus(){
        return propertyStatus;
    }

}
