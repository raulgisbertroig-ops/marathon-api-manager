package com.marathon.api.controller;

import com.marathon.api.model.Runner;
import com.marathon.api.repository.RunnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    private final RunnerRepository runnerRepository;

    // Inyección de Dependencias por Constructor (Buenas prácticas de Arquitectura Limpia)
    public RunnerController(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    // Endpoint POST para registrar un nuevo corredor
    @PostMapping
    public ResponseEntity<Runner> registerRunner(@RequestBody Runner newRunner) {
        // Guardamos el corredor en la base de datos (Complejidad O(1) de inserción)
        Runner savedRunner = runnerRepository.save(newRunner);

        // Devolvemos el corredor guardado (con su ID generado) y un código HTTP 201 (Created)
        return new ResponseEntity<>(savedRunner, HttpStatus.CREATED);
    }
}