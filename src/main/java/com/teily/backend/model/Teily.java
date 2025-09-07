package com.teily.backend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "teilys")
public record Teily (
    @Id String id,String name)
{




}
