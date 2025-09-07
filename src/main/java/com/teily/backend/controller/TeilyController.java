package com.teily.backend.controller;

import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.service.TeilyService;
import com.teily.backend.specification.TeilySpecificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/teilys")
public class TeilyController
{
    private final TeilyService service;

    public TeilyController(TeilyService service)
    {
        this.service = service;
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
}
