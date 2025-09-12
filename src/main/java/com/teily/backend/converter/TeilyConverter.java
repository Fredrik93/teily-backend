package com.teily.backend.converter;

import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.model.Teily;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TeilyConverter
{
    /**
     * Convert a teily from db to a teilyDTO
     *
     * @param src
     * @return
     */
    public TeilyDTO convert(Optional<Teily> src)
    {
        return src.map(teily -> new TeilyDTO(teily.getId(), teily.getTask(), teily.isCompleted())).orElse(null);
    }

    /**
     * Convert a list of teilys into list of teilyDTOs
     */
    public List<TeilyDTO> convert(List<Teily> src)
    {
        return src.stream().map(t -> new TeilyDTO(t.getId(), t.getTask(), t.isCompleted())).toList();
    }

    /**
     * In order to save a teily we need to convert it from a specification to a model
     *
     * @param src
     *         teily
     */
    public Teily convertToModel(TeilyDTO src)
    {
        return new Teily(src.id(), src.task(),src.isCompleted());
    }
}
