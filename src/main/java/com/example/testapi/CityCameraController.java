package com.example.testapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/cityCameras")
@RequiredArgsConstructor
public class CityCameraController {
    private final ObjectMapper mapper;

    @Value("classpath:cityCamera.json")
    Resource cityCameraFile;

    @GetMapping("/get")
    public ResponseEntity<Object> get() throws IOException {
        Object cityCameraList = this.mapper.readValue(cityCameraFile.getFile()
                , Object.class);
        return ResponseEntity.ok(cityCameraList);
    }
}
