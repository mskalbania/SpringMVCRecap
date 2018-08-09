package edu.mvc.ambiguousBeansExample.beans;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Icy {}
