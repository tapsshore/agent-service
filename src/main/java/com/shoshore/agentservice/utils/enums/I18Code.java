package com.shoshore.agentservice.utils.enums;

public enum I18Code {
    MESSAGE_JOB_EDITED_SUCCESSFULLY("messages.job.edited.successfully"),
    MESSAGE_JOB_NOT_EDITED("messages.job.not.edited"),
    MESSAGE_JOB_SUCCESSFULLY_RETRIEVED("messages.job.successfully.retrieved"),
    MESSAGE_JOBS_SUCCESSFULLY_RETRIEVED("messages.jobs.successfully.retrieved"),
    MESSAGE_JOBS_NOT_FOUND("messages.jobs.not.found"),
    MESSAGE_JOB_DELETE_SUCCESS("messages.job.delete.success"),
    MESSAGE_JOB_NOT_CREATED("messages.job.not.created"),
    MESSAGE_JOB_NOT_FOUND("messages.job.not.found"),
    MESSAGE_JOB_CREATED_SUCCESSFULLY("messages.job.created.successfully"),



    MESSAGE_PROPERTY_NOT_FOUND("messages.property.not.found"),
    MESSAGE_PROPERTY_DELETE_SUCCESS("messages.property.delete.success"),
    MESSAGE_PROPERTY_CREATED_SUCCESSFULLY("messages.property.created.successfully"),
    MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED("messages.property.successfully.retrieved"),
    MESSAGE_PROPERTY_NOT_CREATED("messages.property.not.created"),
    MESSAGE_PROPERTY_EDITED_SUCCESSFULLY("messages.property.edited.successfully"),
    MESSAGE_PROPERTY_NOT_EDITED("messages.property.not.edited"),


    MESSAGE_USER_CREATED_SUCCESSFULLY("messages.user.created.successfully"),
    MESSAGE_USER_NOT_CREATED("messages.user.not.created"),
    MESSAGE_USER_NOT_FOUND("messages.user.not.found"),
    MESSAGE_USER_EDITED_SUCCESSFULLY("messages.user.edited.successfully"),
    MESSAGE_USER_NOT_EDITED("messages.user.not.edited"),
    MESSAGE_USER_DELETE_SUCCESS("messages.user.delete.success"),
    MESSAGE_USER_SUCCESSFULLY_RETRIEVED("messages.user.successfully.retrieved"),



    MESSAGE_VEHICLE_SUCCESSFULLY_RETRIEVED("messages.vehicle.successfully.retrieved"),
    MESSAGE_VEHICLE_NOT_FOUND("messages.vehicle.not.found"),
    MESSAGE_VEHICLE_DELETE_SUCCESS("messages.vehicle.delete.success"),
    MESSAGE_VEHICLE_NOT_EDITED("messages.vehicle.not.edited"),
    MESSAGE_VEHICLE_EDITED_SUCCESSFULLY("messages.vehicle.edited.successfully"),
    MESSAGE_VEHICLE_NOT_CREATED("messages.vehicle.not.created"),
    MESSAGE_VEHICLE_CREATED_SUCCESSFULLY("messages.vehicle.created.successfully"),


    MESSAGE_ERROR_ENCOUNTERED("messages.error.encountered"),
    MESSAGE_REQUEST_FAILED("messages.request.failed"),




    MESSAGE_REQUEST_NOT_SUPPORTED("messages.request.not.supported"),
    MESSAGE_JOB_EXISTS("messages.job.exists"),
    MESSAGE_PROPERTY_EXISTS("messages.property.exits"),
    MESSAGE_USER_EXISTS("messages.user.exists"),
    MESSAGE_VEHICLE_EXISTS("messages.vehicle.exists"),
    MESSAGE_VALIDATION_SUCCESS("messages.validation.success");




    private String code;

    private I18Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }



}
