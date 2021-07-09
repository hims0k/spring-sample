package com.example.springsample.repository.dto.tool.adapter;

public interface TypeAdapter<DTO, DB> {

    public DTO toDtoValue(DB db);


}
