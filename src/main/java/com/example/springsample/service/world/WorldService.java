package com.example.springsample.service.world;

import com.example.springsample.repository.WorldRepository;
import com.example.springsample.repository.dto.World;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorldService {

    private final WorldRepository repo;

    public Optional<World> getByCode(String code) {
        return repo.getByCode(code);
    }
}
