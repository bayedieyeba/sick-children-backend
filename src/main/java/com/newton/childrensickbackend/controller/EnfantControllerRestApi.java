package com.newton.childrensickbackend.controller;
import com.newton.childrensickbackend.dtos.*;
import com.newton.childrensickbackend.exceptions.EnfantNotFoundException;
import com.newton.childrensickbackend.services.EnfantService;
import com.newton.childrensickbackend.services.TraitementService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping(path = "/api")
public class EnfantControllerRestApi {
    private EnfantService enfantService;
    private TraitementService traitementService;

    @GetMapping("/enfants")
    public List<EnfantResponseDTO> getChildren(){
        return enfantService.listEnfants();
    }

    @GetMapping("/enfants/consultation")
    public List<EnfantResponseDTO> getChildrenConsultation(@RequestParam(name = "typeConsulatation",defaultValue = "") String typeConsultation){
        return enfantService.enfantsEnconsultation(typeConsultation);
    }
    @GetMapping("/enfants/consultation/pageable")
    public EnfantPageable getChildrenConsultationPageable(@RequestParam(name = "typeConsulatation",defaultValue = "") String typeConsultation,@RequestParam(name="page",defaultValue = "0") int page,
                                                                @RequestParam(name="size",defaultValue = "5")int size){
        return enfantService.getChildrenPageable(typeConsultation,page,size);
    }

    @GetMapping("/enfants/{enfantCode}")
    public EnfantResponseDTO  getChild(@PathVariable("enfantCode") String enfantCode){

        return enfantService.getEnfant(enfantCode);
    }
    @PostMapping("/enfants")
    public EnfantResponseDTO saveChild(@RequestBody EnfantRequestDTO enfantRequestDTO){
        return enfantService.saveEnfant(enfantRequestDTO);
    }
    @PostMapping("/enfants/consulation")
    public EnfantResponseDTO saveChildConsultation(@RequestBody EnfantRequestDTO enfantRequestDTO){
        return enfantService.saveEnfantConsultation(enfantRequestDTO);
    }
    @PostMapping("/enfants/hospitalisation")
    public EnfantResponseDTO saveChildHospitalisation(@RequestBody EnfantRequestDTO enfantRequestDTO){
        return enfantService.saveEnfantHospitalisation(enfantRequestDTO);
    }
    @PutMapping("/enfants/{id}")
    public EnfantResponseDTO updateEnfant(@PathVariable("id") long id, @RequestBody EnfantRequestDTO enfantRequestDTO){
        return enfantService.updateEnfant(id,enfantRequestDTO);
    }
    @DeleteMapping("/enfants/{id}")
    public void deleteEnfant(@PathVariable Long id){
            enfantService.deleteEnfant(id);
    }
    @GetMapping("/enfants/{id}/traitements")
    public List<TraitementResponseDTO> getHistoryTraitement(@PathVariable long id){
        return enfantService.traitementHistory(id);
    }

    @PostMapping("/enfants/add-traitement/{id}")
    public TraitementResponseDTO saveTraitementChild(@PathVariable long id,@RequestBody TraitementRequestDTO traitementRequestDTO) throws EnfantNotFoundException {
        return traitementService.saveTraitement(id,traitementRequestDTO);
    }


}
