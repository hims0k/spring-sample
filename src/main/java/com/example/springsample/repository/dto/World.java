package com.example.springsample.repository.dto;

import com.example.springsample.repository.dto.tool.adapter.ContinentAdapter;
import com.example.springsample.repository.dto.tool.annotation.Column;
import com.example.springsample.repository.dto.types.Continent;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class World {

    @Column("Code")
    private String code;
    @Column("Name")
    private String name;
    @Column(
            value = "Continent",
            adapter = ContinentAdapter.class)
    private Continent continent;
    @Column("Region")
    private String region;
    @Column("SurfaceArea")
    private BigDecimal surfaceArea;
    @Column("IndepYear")
    private Integer indepYear;
    @Column("Population")
    private int population;
    @Column("LifeExpectancy")
    private BigDecimal lifeExpectancy;
    @Column("GNP")
    private BigDecimal gNP;
    @Column("GNPOld")
    private BigDecimal gNPOld;
    @Column("LocalName")
    private String localName;
    @Column("GovernmentForm")
    private String governmentForm;
    @Column("HeadOfState")
    private String headOfState;
    @Column("Capital")
    private Integer capital;
    @Column("Code2")
    private String code2;
}
