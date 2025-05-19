package com.ashik.pension.controller;
import org.springframework.http.ResponseEntity;


import com.ashik.pension.model.Pension;
import com.ashik.pension.service.PensionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pensions")
public class PensionController {
    private final PensionService service;

    public PensionController(PensionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pension> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Pension create(@RequestBody Pension pension) {
        return service.add(pension);
    }

    @PutMapping("/{id}")
public Pension update(@PathVariable Long id, @RequestBody Pension pension) {
    return service.update(id, pension);
}

    @DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    service.delete(id);
}
    @GetMapping("/{id}")
public Pension getById(@PathVariable Long id) {
    return service.getById(id);
}

    @DeleteMapping
public ResponseEntity<Void> deleteAll() {
    service.deleteAll();
    return ResponseEntity.noContent().build();  
}

    @GetMapping("/pension/{id}")
    public Pension getPensionById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/pension/{id}")
    public void deletePension(@PathVariable Long id) {
        service.delete(id);
    }

}

