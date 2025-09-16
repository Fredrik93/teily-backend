package com.teily.backend.repository;
import com.teily.backend.model.Teily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeilyRepository extends MongoRepository<Teily, String> {
    // the uid create by spring security / firebase
    public List<Teily> findByUserId(String userId);

}