package com.shoshore.agentservice.api.messages;

import com.shoshore.agentservice.utils.messages.external.JobDto;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.external.VehicleDto;

import java.util.List;

public class Response {
    private boolean success;

    private String narrative;

    private String message;

    private int statusCode;

    private List<UserDto> userDtoList;

    private UserDto userDto;

    private  List<VehicleDto> vehicleDtoList;

    private VehicleDto vehicleDto;

    private List<PropertyDto> propertyDtoList;

    private PropertyDto propertyDto;

    private List<JobDto> jobDtoList;

    private JobDto jobDto;

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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<UserDto> getUserDtoList() {
        return userDtoList;
    }

    public void setUserDtoList(List<UserDto> userDtoList) {
        this.userDtoList = userDtoList;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<VehicleDto> getVehicleDtoList() {
        return vehicleDtoList;
    }

    public void setVehicleDtoList(List<VehicleDto> vehicleDtoList) {
        this.vehicleDtoList = vehicleDtoList;
    }

    public VehicleDto getVehicleDto() {
        return vehicleDto;
    }

    public void setVehicleDto(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
    }

    public List<PropertyDto> getPropertyDtoList() {
        return propertyDtoList;
    }

    public void setPropertyDtoList(List<PropertyDto> propertyDtoList) {
        this.propertyDtoList = propertyDtoList;
    }

    public PropertyDto getPropertyDto() {
        return propertyDto;
    }

    public void setPropertyDto(PropertyDto propertyDto) {
        this.propertyDto = propertyDto;
    }

    public List<JobDto> getJobDtoList() {
        return jobDtoList;
    }

    public void setJobDtoList(List<JobDto> jobDtoList) {
        this.jobDtoList = jobDtoList;
    }

    public JobDto getJobDto() {
        return jobDto;
    }

    public void setJobDto(JobDto jobDto) {
        this.jobDto = jobDto;
    }
}
