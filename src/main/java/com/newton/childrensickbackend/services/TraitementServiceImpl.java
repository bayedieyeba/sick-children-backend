package com.newton.childrensickbackend.services;

import com.newton.childrensickbackend.dtos.TraitementRequestDTO;
import com.newton.childrensickbackend.dtos.TraitementResponseDTO;
import com.newton.childrensickbackend.entities.Enfant;
import com.newton.childrensickbackend.entities.Traitement;
import com.newton.childrensickbackend.exceptions.EnfantNotFoundException;
import com.newton.childrensickbackend.mappers.TraitementMapper;
import com.newton.childrensickbackend.repositories.EnfantRepository;
import com.newton.childrensickbackend.repositories.TraitementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TraitementServiceImpl implements TraitementService {
    private EnfantRepository enfantRepository;
    private TraitementRepository traitementRepository;
    private TraitementMapper traitementMapper;
    @Override
    public TraitementResponseDTO saveTraitement(long idEnfant, TraitementRequestDTO traitementRequestDTO) throws EnfantNotFoundException {
        Enfant enfant = enfantRepository.findById(idEnfant).orElse(null);
        if(enfant == null)
            throw new EnfantNotFoundException("Enfant n'est pa trouvé");
        Traitement traitement = new Traitement();
        traitement.setTypeTraitement(traitementRequestDTO.getTypeTraitement());
        traitement.setDuree(traitementRequestDTO.getDuree());
        traitement.setEnfant(enfant);
        traitement.setDateCommancement(new Date());
        Traitement savedTraitement = traitementRepository.save(traitement);

        return traitementMapper.traitementToTraitementResponseDto(savedTraitement) ;
    }

    @Override
    public List<TraitementResponseDTO> listTraitement() {
        return null;
    }
}
