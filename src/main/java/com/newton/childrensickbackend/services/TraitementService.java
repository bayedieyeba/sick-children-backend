package com.newton.childrensickbackend.services;

import com.newton.childrensickbackend.dtos.TraitementRequestDTO;
import com.newton.childrensickbackend.dtos.TraitementResponseDTO;
import com.newton.childrensickbackend.exceptions.EnfantNotFoundException;

import java.util.List;

public interface TraitementService {
    TraitementResponseDTO saveTraitement(long idEnfant ,TraitementRequestDTO traitementRequestDTO) throws EnfantNotFoundException;
    List<TraitementResponseDTO> listTraitement();
}
