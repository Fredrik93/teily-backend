package com.teily.backend.controller;

import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.service.TeilyService;
import com.teily.backend.specification.TeilySpecificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/teilys")
@CrossOrigin(origins = "http://localhost:5173")
public class TeilyController
{
    private final TeilyService service;

    public TeilyController(TeilyService service)
    {
        this.service = service;
    }

    /**
     * return All teilys
     */
    @GetMapping()
    List<TeilyDTO> getAllTeilys(){
        return service.getAllTeilys();
    }
    /**
     * Get teily by id
     * @param id e.g., 1
     */
    @GetMapping("/{id}")
    TeilyDTO getTeilyById(@PathVariable String id){
        return service.getTeilyById(id);
    }
    /**
     * Create a teily
     */
    @PostMapping("")
    ResponseEntity<TeilyDTO> createTeily(@RequestBody TeilySpecificationDTO spec){
        TeilyDTO dto = service.createTeily(spec);
        return ResponseEntity.ok(dto);
    }
    /**
     * Delete all teilys
     */
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Delete one teily
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeily(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
