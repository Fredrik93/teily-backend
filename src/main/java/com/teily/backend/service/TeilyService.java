package com.teily.backend.service;

import com.teily.backend.converter.TeilyConverter;
import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.model.Teily;
import com.teily.backend.repository.TeilyRepository;
import com.teily.backend.specification.TeilySpecificationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    /**
     * @return all teilys from a user
     */
    //TODO Should get alla teilys from a userId, not all ALL teilys
    public List<TeilyDTO> getAllTeilys(){
        List <Teily> src = repository.findAll();
       return converter.convert(src);
    }

    public TeilyDTO getTeilyById(String id){
        Optional<Teily> src = repository.findById(id);
        return converter.convert(src);
    }
    public TeilyDTO createTeily(TeilySpecificationDTO spec){
        String id = UUID.randomUUID().toString();
        TeilyDTO dto = new TeilyDTO(id, spec.task(), false);
        Teily teily = converter.convertToModel(dto);
        repository.save(teily);
        return new TeilyDTO(id, teily.getTask(), dto.isCompleted());
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    /**
     * Toggle on or of the isCompleted box.
     * Indicates if a teily is done or not.
     * @param id
     * @return patched TeilyDTO
     */
    public TeilyDTO toggleIsCompleted(String id){
        Optional<Teily> t = repository.findById(id);
        // Patch the dto and save to db. If its true, set it to false, and vice versa. i.e., toggle it to be the opposite.
        t.get().toggleCompleted();

        repository.save(t.get());
        return new TeilyDTO(t.get().getId(), t.get().getTask(), t.get().isCompleted());
    }
}
