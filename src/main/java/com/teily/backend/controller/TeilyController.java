package com.teily.backend.controller;

import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.service.TeilyService;
import com.teily.backend.specification.TeilySpecificationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/teilys")
public class TeilyController
{
    private final TeilyService service;

    public TeilyController(TeilyService service)
    {
        this.service = service;
    }

    @Operation(summary = "Get all tasks for a user", description = "Returns all tasks.")
    @GetMapping()
    List<TeilyDTO> getAllTeilys(){
        return service.getAllTeilys();
    }

    @Operation(summary = "Get a task by id")
    @GetMapping("/{id}")
    public ResponseEntity<TeilyDTO> getTeilyById(@PathVariable String id) {
        return service.getTeilyById(id)
                .map(ResponseEntity::ok)            // 200 OK with body
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 if not found
    }

    @Operation(summary = "Create a new task")
    @PostMapping()
    ResponseEntity<TeilyDTO> createTeily(@RequestBody TeilySpecificationDTO spec){
        TeilyDTO dto = service.createTeily(spec);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Delete a task")
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Delete one task by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeily(@PathVariable String id){
        service.deleteById(id);
        String message = "Task with id " + id + " was deleted successfully.";
        return ResponseEntity.ok(message);
    }


    @Operation(summary = "Toggle the checkbox showing if a task is completed")
    @PatchMapping("/{id}")
    public TeilyDTO toggleIsCompleted(@PathVariable String id){
        return  service.toggleIsCompleted(id);
    }
}
