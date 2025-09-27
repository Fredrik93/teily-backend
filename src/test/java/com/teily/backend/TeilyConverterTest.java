package com.teily.backend;

import com.teily.backend.converter.TeilyConverter;
import com.teily.backend.dto.TeilyDTO;
import com.teily.backend.model.Teily;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TeilyConverterTest
{
    private TeilyConverter teilyConverter;

    @BeforeEach
    void setUp(){
        teilyConverter = new TeilyConverter();
    }
    @Test
    void convertToModel(){
        TeilyDTO t1 = new TeilyDTO("1", "Clean", false,"1234", LocalDateTime.now(),LocalDateTime.now());
        Teily res = teilyConverter.convertToModel(t1);
        assertThat(res).isNotNull();
        assertThat(res.getId()).isEqualTo("1");
        assertThat(res.getTask()).isEqualTo("Clean");
    }
    @Test
    void convertToDTO(){
        Teily t = new Teily("1", "John", false, "1234",LocalDateTime.now(),LocalDateTime.now());
        TeilyDTO res = teilyConverter.convert(t);
        assertThat(res).isNotNull();
        assertThat(res.id()).isEqualTo("1");
        assertThat(res.task()).isEqualTo("John");
    }
}
