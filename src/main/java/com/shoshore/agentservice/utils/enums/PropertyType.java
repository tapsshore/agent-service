package com.shoshore.agentservice.utils.enums;

public enum PropertyType {
    COTTAGE("COTTAGE"), FLAT("FLAT"), FULLHOUSE("FULLHOUSE");

    private String propertyType;

    PropertyType(String propertyType){
        this.propertyType = propertyType;
            }
            public String getPropertyType(){
        return propertyType;
            }
}
