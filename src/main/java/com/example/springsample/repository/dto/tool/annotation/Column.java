package com.example.springsample.repository.dto.tool.annotation;

import com.example.springsample.repository.dto.tool.adapter.NoopAdapter;
import com.example.springsample.repository.dto.tool.adapter.TypeAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * DBのカラムを表現するアノテーションです
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    /**
     * カラム名を表現します.未指定の場合は、フィールドプロパティ名のスネークケースを利用します
     */
    String value() default "";

    /**
     * DBのカラム値からDtoへの型への変換をになうAdapterを指定します
     */
    Class<? extends TypeAdapter<?,?>> adapter() default NoopAdapter.class;
}
