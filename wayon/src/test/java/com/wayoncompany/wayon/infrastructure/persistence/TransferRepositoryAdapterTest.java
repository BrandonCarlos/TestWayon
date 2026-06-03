package com.wayoncompany.wayon.infrastructure.persistence;

import com.wayoncompany.wayon.infrastructure.persistence.repository.JpaTransferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TransferRepositoryAdapterTest {
    @Autowired
    private JpaTransferRepository repository;

    @Test
    void shouldLoadRepository() {
        assertNotNull(repository);
    }
}
