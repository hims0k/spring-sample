package com.example.springsample.repository.dto.tool.adapter;

import java.lang.reflect.Type;

public class NoopAdapter implements TypeAdapter<Object, Object> {

    @Override
    public Object toDtoValue(Object o) {
        return o;
    }
}
