package com.newton.childrensickbackend.mappers;


import com.newton.childrensickbackend.dtos.EnfantRequestDTO;
import com.newton.childrensickbackend.dtos.EnfantResponseDTO;
import com.newton.childrensickbackend.entities.Enfant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnfantMapper {

    EnfantResponseDTO enfantToEnfantResponseDto(Enfant enfant);
    Enfant enfantRequestDtoToEnfant(EnfantRequestDTO enfantRequestDTO);
}
