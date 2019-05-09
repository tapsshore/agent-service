package com.shoshore.agentservice.business.messages;

import com.shoshore.agentservice.utils.messages.external.UserDto;

import java.util.List;

public class UserResponse {

    private boolean success;
    private String narrative;
    private String message;
    private UserDto userDto;
    private List<UserDto> userDtoList;

    public List<UserDto> getUserDtoList() {
        return userDtoList;
    }

    public void setUserDtoList(List<UserDto> userDtoList) {
        this.userDtoList = userDtoList;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "success=" + success +
                ", narrative='" + narrative + '\'' +
                ", message='" + message + '\'' +
                ", userDto=" + userDto +
                ", userDtoList=" + userDtoList +
                '}';
    }
}
