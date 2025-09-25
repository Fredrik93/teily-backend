package com.teily.backend.dto;

import java.time.LocalDateTime;

public record TeilyDTO(String id, String task, boolean isCompleted, String userId, LocalDateTime dateOfCreation, LocalDateTime dateOfCompletion)
{
}
