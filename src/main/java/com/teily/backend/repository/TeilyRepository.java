package com.teily.backend.repository;
import com.teily.backend.model.Teily;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeilyRepository extends MongoRepository<Teily, String> {
}