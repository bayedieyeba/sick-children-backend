package com.newton.childrensickbackend.services;

import com.newton.childrensickbackend.dtos.EnfantPageable;
import com.newton.childrensickbackend.dtos.EnfantRequestDTO;
import com.newton.childrensickbackend.dtos.EnfantResponseDTO;
import com.newton.childrensickbackend.dtos.TraitementResponseDTO;
import com.newton.childrensickbackend.entities.Enfant;
import com.newton.childrensickbackend.entities.Traitement;
import com.newton.childrensickbackend.mappers.EnfantMapper;
import com.newton.childrensickbackend.mappers.TraitementMapper;
import com.newton.childrensickbackend.repositories.EnfantRepository;
import com.newton.childrensickbackend.repositories.TraitementRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class EnfantServiceImpl implements EnfantService {
    private EnfantRepository enfantRepository;
    private TraitementRepository traitementRepository;
    private EnfantMapper enfantMapper;
    private TraitementMapper traitementMapper;
    @Override
    public EnfantResponseDTO saveEnfant(EnfantRequestDTO enfantRequestDTO) {
        Enfant enfant = enfantMapper.enfantRequestDtoToEnfant(enfantRequestDTO);
        Enfant savedEnfant = enfantRepository.save(enfant);
        return enfantMapper.enfantToEnfantResponseDto(savedEnfant);
    }

    @Override
    public EnfantResponseDTO saveEnfantConsultation(EnfantRequestDTO enfantRequestDTO) {
        enfantRequestDTO.setTypeConsultation("CONSULTATION");
        Enfant enfant = enfantMapper.enfantRequestDtoToEnfant(enfantRequestDTO);
        Enfant savedEnfant = enfantRepository.save(enfant);
        return enfantMapper.enfantToEnfantResponseDto(savedEnfant);
    }

    @Override
    public EnfantResponseDTO saveEnfantHospitalisation(EnfantRequestDTO enfantRequestDTO) {
        enfantRequestDTO.setTypeConsultation("HOSPITALISATION");
        Enfant enfant = enfantMapper.enfantRequestDtoToEnfant(enfantRequestDTO);
        Enfant savedEnfant = enfantRepository.save(enfant);
        return enfantMapper.enfantToEnfantResponseDto(savedEnfant);
    }

    @Override
    public void deleteEnfant(long id) {
        enfantRepository.deleteById(id);
    }

    @Override
    public List<EnfantResponseDTO> listEnfants() {
        List<Enfant> enfants = enfantRepository.findAll();
        List<EnfantResponseDTO> enfantResponseDTOS =enfants.stream()
                .map(enfant -> enfantMapper.enfantToEnfantResponseDto(enfant)).collect(Collectors.toList());
        return enfantResponseDTOS;
    }

    @Override
    public EnfantResponseDTO getEnfant(String enfantCode) {
        Enfant enfant = enfantRepository.findEnfantByCode(enfantCode);

        return enfantMapper.enfantToEnfantResponseDto(enfant);
    }

    @Override
    public List<EnfantResponseDTO> enfantsEnconsultation(String typeConsulatation) {
        List<Enfant> enfants = enfantRepository.enfantsEnConsultation(typeConsulatation);
        List<EnfantResponseDTO> enfantResponseDTOS =enfants.stream()
                .map(enfant -> enfantMapper.enfantToEnfantResponseDto(enfant)).collect(Collectors.toList());
        return enfantResponseDTOS;

    }

    @Override
    public List<TraitementResponseDTO> traitementHistory(long id) {
        List<Traitement> traitements = traitementRepository.findAllByEnfantId(id);
        return traitements.stream().map(traitement ->traitementMapper.traitementToTraitementResponseDto(traitement)).collect(Collectors.toList());
    }

    @Override
    public EnfantResponseDTO updateEnfant(long idEnfant,EnfantRequestDTO enfantRequestDTO) {
        Enfant enfant =enfantMapper.enfantRequestDtoToEnfant(enfantRequestDTO);
        enfant.setId(idEnfant);
        Enfant savedEnfant = enfantRepository.save(enfant);
        return enfantMapper.enfantToEnfantResponseDto(savedEnfant);
    }

    @Override
    public EnfantPageable getChildrenPageable(String typeConsultation, int page, int size) {
        Page<Enfant> enfants = enfantRepository.enfantsEnConsultationPageable(typeConsultation, PageRequest.of(page,size));
        EnfantPageable enfantPageable = new EnfantPageable();
        List<EnfantResponseDTO> enfantResponseDTOS =enfants.getContent().stream().map(enfant -> enfantMapper.enfantToEnfantResponseDto(enfant)).collect(Collectors.toList());
        enfantPageable.setEnfantResponseDTOS(enfantResponseDTOS);
        enfantPageable.setTotalPages(enfants.getTotalPages());
        enfantPageable.setCurrentPage(page);
        enfantPageable.setPageSize(size);
        return enfantPageable;
    }


}
