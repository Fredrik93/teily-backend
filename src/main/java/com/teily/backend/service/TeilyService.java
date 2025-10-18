package com.teily.backend.service;

import com.teily.backend.converter.TeilyConverter;
import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.model.Teily;
import com.teily.backend.repository.TeilyRepository;
import com.teily.backend.specification.TeilySpecificationDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<TeilyDTO> getAllTeilys()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        List<Teily> src = repository.findByUserId(userId);
        return converter.convert(src);
    }

    public Optional<TeilyDTO> getTeilyById(String id)
    {
        Teily src = repository.findById(id).orElse(null);
        if(src == null) {return Optional.empty();}
        return Optional.ofNullable(converter.convert(src));
    }

    public TeilyDTO createTeily(TeilySpecificationDTO spec)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        String id = UUID.randomUUID().toString();
        LocalDateTime date = LocalDateTime.now();

        TeilyDTO dto = new TeilyDTO(id, spec.task(), false, userId, date, null);
        Teily teily = converter.convertToModel(dto);
        repository.save(teily);
        return new TeilyDTO(id, teily.getTask(), dto.isCompleted(), userId, date, null);
    }

    public void deleteAll()
    {
        repository.deleteAll();
    }

    public void deleteById(String id)
    {
        repository.deleteById(id);
    }

    /**
     * Toggle on or of the isCompleted box. Indicates if a teily is done or not.
     *
     * @param id
     * @return patched TeilyDTO
     */
    public TeilyDTO toggleIsCompleted(String id)
    {
        Optional<Teily> t = repository.findById(id);
        // Patch the dto and save to db. If its true, set it to false, and vice versa. i.e., toggle it to be the opposite.
        t.get().toggleCompleted();
        //Update the date that the task was completed to current date
        LocalDateTime date = t.get().isCompleted() ? LocalDateTime.now() : null;
        t.get().setDateOfCompletion(date);
        if(t.get().isCompleted())
        {
        }
        repository.save(t.get());
        return new TeilyDTO(t.get().getId(), t.get().getTask(), t.get().isCompleted(), t.get().getUserId(),
                t.get().getDateOfCreation(), t.get().getDateOfCompletion());
    }
}
