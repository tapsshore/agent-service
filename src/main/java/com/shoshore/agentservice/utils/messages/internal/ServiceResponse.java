package com.shoshore.agentservice.utils.messages.internal;

import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.domain.User;

import java.util.List;

import static com.shoshore.agentservice.utils.constants.Constants.FAILURE_INT_VALUE;
import static com.shoshore.agentservice.utils.constants.Constants.SUCCESS_INT_VALUE;

public class ServiceResponse<T> {

    private int statusCode;
    private boolean success;
    private String message;
    private User user;

    private Property property;
    private T result;
    private List<T> list;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

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

    public ServiceResponse<T> buildSuccessResponse(String message) {
        this.statusCode = SUCCESS_INT_VALUE;
        this.success = true;
        this.message = message;
        this.result = null;
        return this;

    }

    public ServiceResponse<T> buildSuccessResponse(String message, final List<T> result) {
        this.statusCode = SUCCESS_INT_VALUE;
        this.success = true;
        this.message = message;
        this.list = result;
        return this;
    }

    public ServiceResponse<T> buildSuccessResponse(String message, final T result) {
        this.statusCode = SUCCESS_INT_VALUE;
        this.success = true;
        this.message = message;
        this.result = result;
        return this;
    }


    public ServiceResponse<T> buildErrorResponse(String message) {
        this.statusCode = FAILURE_INT_VALUE;
        this.success = false;
        this.message = message;
        this.result = null;
        return this;
    }

    public ServiceResponse<T> buildErrorResponse(String message, final T result) {
        this.statusCode = FAILURE_INT_VALUE;
        this.success = false;
        this.message = message;
        this.result = result;
        return this;
    }

    public ServiceResponse<T> buildErrorResponse(String message, final List<T> result) {
        this.statusCode = FAILURE_INT_VALUE;
        this.success = false;
        this.message = message;
        this.list = result;
        return this;
    }
}
