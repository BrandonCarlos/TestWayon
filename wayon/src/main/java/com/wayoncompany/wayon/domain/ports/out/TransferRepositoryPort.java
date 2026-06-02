package com.wayoncompany.wayon.domain.ports.out;

import com.wayoncompany.wayon.domain.model.Transfer;

import java.util.List;

public interface TransferRepositoryPort {

    Transfer save(
            Transfer transfer);

    List<Transfer> findAll();
}
