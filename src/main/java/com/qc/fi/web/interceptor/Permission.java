package com.qc.fi.web.interceptor;

import com.qc.fi.model.UserType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    UserType userType();
}
