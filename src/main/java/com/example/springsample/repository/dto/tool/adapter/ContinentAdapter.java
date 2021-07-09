package com.example.springsample.repository.dto.tool.adapter;

import com.example.springsample.repository.dto.types.Continent;
import org.apache.commons.lang3.StringUtils;

public class ContinentAdapter implements TypeAdapter<Continent, String> {

    @Override
    public Continent toDtoValue(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return Continent.of(s);
    }
}
