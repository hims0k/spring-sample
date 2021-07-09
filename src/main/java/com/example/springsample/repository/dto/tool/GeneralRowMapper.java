package com.example.springsample.repository.dto.tool;

import com.example.springsample.repository.dto.tool.adapter.TypeAdapter;
import com.example.springsample.repository.dto.tool.annotation.Column;
import com.example.springsample.utils.CaseFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneralRowMapper<T> implements RowMapper<T> {

    public GeneralRowMapper(Class<T> mappedClazz) {
        this.mappedClazz = mappedClazz;
    }

    private final Class<T> mappedClazz;

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        T dto = getNewInstance();
        Set<Field> fields = getColumnField();

        fields.forEach(field -> setColumnValueToDto(dto, field, rs));
        return dto;
    }

    private void setColumnValueToDto(T dto, Field field, ResultSet rs) {
        String columnName = getColumnName(field);
        try {
            Object columnValue = getColumnValue(rs, columnName);
            setValue(dto, field, columnValue);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot get from resultSet: ColumnName = " + columnName, e);
        }
    }

    private Set<Field> getColumnField() {
        return Arrays.stream(mappedClazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toSet());
    }

    private static String getColumnName(Field field) {
        Column column = getColumnI(field);
        return StringUtils.isEmpty(column.value())
                ? CaseFormatUtils.lCamelToLSnake(field.getName())
                : column.value();
    }

    private static Object getColumnValue(ResultSet rs, String columnName) throws SQLException {
        return rs.getObject(columnName);
    }

    private void setValue(T dto, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(dto, convertValToDtoType(field, value));
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Cannot set value to " + dto.getClass());
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private Object convertValToDtoType(Field field, Object value) {
        TypeAdapter adapter = getTypeAdapter(field);
        return adapter.toDtoValue(value);
    }

    private static TypeAdapter<?,?> getTypeAdapter(Field field) {
        Column column = getColumnI(field);
        Class<? extends TypeAdapter<?,?>> typeAdapterClazz = column.adapter();
        return BeanUtils.instantiateClass(typeAdapterClazz);
    }

    private static Column getColumnI(Field field) {
        return field.getAnnotation(Column.class);
    }

    private T getNewInstance() {
        return BeanUtils.instantiateClass(mappedClazz);
    }
}
