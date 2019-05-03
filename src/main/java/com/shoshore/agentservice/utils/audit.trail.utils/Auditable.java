package com.shoshore.agentservice.utils.audit.trail.utils;

import com.shoshore.agentservice.utils.enums.DataStoreType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Auditable {
    String idFieldName() default "id";

    Class idFieldType() default Long.class;

    String entityFindByIdMethod() default "findById";

    Class repositoryClass();

    Class entityClass();

    DataStoreType dataStoreType() default DataStoreType.DB;
}

