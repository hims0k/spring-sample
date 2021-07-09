package com.example.springsample.repository;

import com.example.springsample.repository.dto.World;
import com.example.springsample.repository.dto.tool.GeneralRowMapper;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WorldRepository {

    private final NamedParameterJdbcTemplate jdbc;

    private static final String SQL = "SELECT * FROM country WHERE Code = :code";

    public Optional<World> getByCode(String code) {
        if (code == null) {
            return Optional.empty();
        }

        Map<String, Object> params = Maps.newHashMap();
        params.put("code", code);
        List<World> worlds = jdbc.query(SQL, params, new GeneralRowMapper<>(World.class));
        if (worlds.size() > 1) {
            throw new IncorrectResultSizeDataAccessException(1, worlds.size());
        }
        return worlds.stream().findAny();
    }


}
