package com.example.springsample.repository.dto.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Continent {

    ASIA("Asia"),

    EUROPE("Europe"),

    NORTH_AMERICA("North America"),

    AFRICA("Africa"),

    OCEANIA("Oceania"),

    ANTARCTICA("Antarctica"),

    SOUTH_AMERICA("South America"),
    //
    ;

    @Getter
    private final String code;

    public static Continent of(@NonNull String code) {
        return Arrays.stream(values())
                .filter(val -> val.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Not found Continent: code " + code));
    }
}
