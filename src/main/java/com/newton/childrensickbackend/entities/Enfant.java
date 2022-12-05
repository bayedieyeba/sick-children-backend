package com.newton.childrensickbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.newton.childrensickbackend.enums.EnumConsultation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Enfant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String prenom;
    private String nom;
    private int age;
    private String telephoneParent;
    private double montant;
    private String adresse;
    private String typeCancer;
    private String typeConsultation;
    @OneToMany(mappedBy = "enfant")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Traitement> traitements;

}
