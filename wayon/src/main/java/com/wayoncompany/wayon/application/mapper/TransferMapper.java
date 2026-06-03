package com.wayoncompany.wayon.application.mapper;

import com.wayoncompany.wayon.application.dto.TransferResponse;
import com.wayoncompany.wayon.domain.model.Transfer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    TransferResponse toResponse(
            Transfer transfer);

    List<TransferResponse> toResponseList(
            List<Transfer> transfers);
}
