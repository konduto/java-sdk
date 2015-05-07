package com.konduto.sdk.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * This annotation is used to mark fields that should have their values validated against a Java regex
 * in {@link com.konduto.sdk.models.KondutoModel} instances.
 * @see com.konduto.sdk.models.KondutoModel#isValid()
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateFormat {
    String format();
}

