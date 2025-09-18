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
@CrossOrigin(origins = { "http://localhost:5173", "https://teily-nt8mwq96x-fredriks-projects-2fe616bb.vercel.app",  "https://teily-knz98tl5b-fredriks-projects-2fe616bb.vercel.app" ,"https://teily-j2qlc7hix-fredriks-projects-2fe616bb.vercel.app"})
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
    TeilyDTO getTeilyById(@PathVariable String id){
        return service.getTeilyById(id);
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
    public ResponseEntity<Void> deleteTeily(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Toggle the checkbox showing if a task is completed")
    @PatchMapping("/{id}")
    public TeilyDTO toggleIsCompleted(@PathVariable String id){
        return  service.toggleIsCompleted(id);
    }
}
