package com.newton.childrensickbackend.mappers;

import com.newton.childrensickbackend.dtos.TraitementRequestDTO;
import com.newton.childrensickbackend.dtos.TraitementResponseDTO;
import com.newton.childrensickbackend.entities.Traitement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TraitementMapper {
    TraitementResponseDTO traitementToTraitementResponseDto(Traitement traitement);
    Traitement traitementRequestDtoToTraitement(TraitementRequestDTO traitementRequestDTO);
}
