package com.shoshore.agentservice.utils.commonResponse;

public class CommonResponse {
    private boolean success;
    private String narrative;

    public CommonResponse() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getNarrative() {
        return this.narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String toString() {
        return "CommonResponse{success=" + this.success + ", narrative='" + this.narrative + '\'' + '}';
    }
}
