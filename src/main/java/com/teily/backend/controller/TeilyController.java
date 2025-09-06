package com.teily.backend.controller;

import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.service.TeilyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/teily")
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
}
