package com.newton.childrensickbackend.services;

import com.newton.childrensickbackend.dtos.EnfantPageable;
import com.newton.childrensickbackend.dtos.EnfantRequestDTO;
import com.newton.childrensickbackend.dtos.EnfantResponseDTO;
import com.newton.childrensickbackend.dtos.TraitementResponseDTO;
import com.newton.childrensickbackend.entities.Enfant;

import java.util.List;

public interface EnfantService {
    EnfantResponseDTO saveEnfant(EnfantRequestDTO enfantRequestDTO);
    EnfantResponseDTO saveEnfantConsultation(EnfantRequestDTO enfantRequestDTO);
    EnfantResponseDTO saveEnfantHospitalisation(EnfantRequestDTO enfantRequestDTO);
    void deleteEnfant(long id);
    List<EnfantResponseDTO> listEnfants();
    EnfantResponseDTO getEnfant(String enfantCode);
    List<EnfantResponseDTO> enfantsEnconsultation(String typeConsulatation);
    List<TraitementResponseDTO> traitementHistory(long id);
    EnfantResponseDTO updateEnfant(long idEnfant,EnfantRequestDTO enfantRequestDTO);
    EnfantPageable getChildrenPageable(String typeConsultation, int page, int size);

}
