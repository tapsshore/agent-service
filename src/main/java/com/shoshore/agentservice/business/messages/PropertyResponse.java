package com.shoshore.agentservice.business.messages;

import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;

import java.util.List;

public class PropertyResponse<T> {

    private boolean success;
    private String narrative;
    private String message;
    private Property property;
    private PropertyDto propertyDto;
    private List<PropertyDto> propertyDtoList;
    private T result;
    private List<T> list;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PropertyDto getPropertyDto() {
        return propertyDto;
    }

    public void setPropertyDto(PropertyDto propertyDto) {
        this.propertyDto = propertyDto;
    }

    public List<PropertyDto> getPropertyDtoList() {
        return propertyDtoList;
    }

    public void setPropertyDtoList(List<PropertyDto> propertyDtoList) {
        this.propertyDtoList = propertyDtoList;
    }

    @Override
    public String toString() {
        return "PropertyResponse{" +
                "success=" + success +
                ", narrative='" + narrative + '\'' +
                ", message='" + message + '\'' +
                ", property=" + property +
                ", propertyDto=" + propertyDto +
                ", propertyDtoList=" + propertyDtoList +
                ", result=" + result +
                ", list=" + list +
                '}';
    }
}
