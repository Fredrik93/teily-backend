package com.teily.backend.service;

import com.teily.backend.converter.TeilyConverter;
import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.model.Teily;
import com.teily.backend.repository.TeilyRepository;
import com.teily.backend.specification.TeilySpecificationDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeilyService
{
    private final TeilyRepository repository;
    private final TeilyConverter converter;
    public TeilyService(TeilyRepository repository, TeilyConverter converter)
    {
        this.repository = repository;
        this.converter = converter;
    }

    public TeilyDTO getTeilyById(String id){
        Optional<Teily> src = repository.findById(id);
        return converter.convert(src);
    }
    public TeilyDTO createTeily(TeilySpecificationDTO spec){
        Teily teily = converter.convertToRepository(spec);
        repository.save(teily);
        return new TeilyDTO(spec.id(), spec.name());
    }
}
