package com.shoshore.agentservice.utils.common.i18.api;

import java.util.Locale;

public interface MessageService {
    String getMessage(String propertyName, String[] placeholders, Locale locale);


}
