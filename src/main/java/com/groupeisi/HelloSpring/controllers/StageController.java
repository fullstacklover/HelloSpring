package com.groupeisi.HelloSpring.controllers;

import com.groupeisi.HelloSpring.entities.Stage;
import com.groupeisi.HelloSpring.services.StageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    private final StageService service;

    public StageController(StageService service) {
        this.service = service;
    }

    @GetMapping
    public List<Stage> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stage> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stage create(@RequestBody Stage stage) {
        return service.save(stage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stage> update(
            @PathVariable Long id,
            @RequestBody Stage stage) {

        Stage updated = service.update(id, stage);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (service.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}