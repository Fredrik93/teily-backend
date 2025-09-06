package com.teily.backend.service;

import com.teily.backend.dto.TeilyDTO;
import org.springframework.stereotype.Service;

@Service
public class TeilyService
{
    public TeilyDTO getTeilyById(String id){
        return new TeilyDTO(id, "John");
    }
}
