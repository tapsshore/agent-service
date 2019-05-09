package com.shoshore.agentservice.utils.enums;

public enum I18Code {


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



    MESSAGE_ERROR_ENCOUNTERED("messages.error.encountered"),
    MESSAGE_REQUEST_FAILED("messages.request.failed"),


    MESSAGE_REQUEST_NOT_SUPPORTED("messages.request.not.supported"),
    MESSAGE_PROPERTY_EXISTS("messages.property.exits"),
    MESSAGE_USER_EXISTS("messages.user.exists"),
    MESSAGE_VALIDATION_SUCCESS("messages.validation.success");


   private String code;

    private I18Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
