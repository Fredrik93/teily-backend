package com.teily.backend.converter;

import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.model.Teily;
import com.teily.backend.specification.TeilySpecificationDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeilyConverter
{
    public TeilyDTO convert(Optional<Teily> src){
        return new TeilyDTO(src.get().id(), src.get().name());
    }

    /**
     * In order to save a teily we need to convert it from a specification to a model
     * @param src teily
     */
    public Teily convertToRepository(TeilySpecificationDTO src){
        return new Teily(src.id(), src.name());
    }
}
