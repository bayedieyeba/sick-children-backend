package com.newton.childrensickbackend;

import com.newton.childrensickbackend.dtos.EnfantRequestDTO;
import com.newton.childrensickbackend.dtos.TraitementRequestDTO;
import com.newton.childrensickbackend.exceptions.EnfantNotFoundException;
import com.newton.childrensickbackend.services.EnfantService;
import com.newton.childrensickbackend.services.TraitementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ChildrenSickBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChildrenSickBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(EnfantService enfantService, TraitementService traitementService){
        return args ->{
            Stream.of("Aida","oumar","Cheikh","Demba","Aicha","Ndaye","Fatou","Koura","Faly").forEach(name->{
                EnfantRequestDTO enfantRequestDTO = new EnfantRequestDTO();
                enfantRequestDTO.setPrenom(name);
                enfantRequestDTO.setAdresse("Dakar");
                enfantRequestDTO.setAge(5);
                enfantRequestDTO.setTelephoneParent("77784765");
                enfantRequestDTO.setCode(enfantRequestDTO.getTelephoneParent()+name);
                enfantRequestDTO.setMontant(Math.random()*12000);
                enfantRequestDTO.setNom("BA");
                enfantRequestDTO.setTypeCancer("cancer");
                enfantRequestDTO.setTypeConsultation("CONSULTATION");
                enfantService.saveEnfant(enfantRequestDTO);
            });
            enfantService.listEnfants().forEach(enfant ->{
                try {
                    TraitementRequestDTO traitementRequestDTO = new TraitementRequestDTO();
                    traitementRequestDTO.setTypeTraitement("initial");
                    traitementRequestDTO.setDuree(3);
                    traitementService.saveTraitement(enfant.getId(),traitementRequestDTO);
                } catch (EnfantNotFoundException e) {
                     e.printStackTrace();
                }
            } );
        };
    }
}
