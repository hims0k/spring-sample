package com.example.springsample.controller.world;

import com.example.springsample.controller.EndPoint;
import com.example.springsample.repository.dto.World;
import com.example.springsample.service.world.WorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(EndPoint.WorldEndPoint.WORLD_API_BASE_URL)
public class WorldController {

    private final WorldService worldService;


    @GetMapping(EndPoint.WorldEndPoint.GET)
    public ResponseEntity<World> getByCode(@PathVariable String code) {
        return worldService.getByCode(code)
                .map(ResponseEntity::ok)
                .orElse(null);
    }
}
